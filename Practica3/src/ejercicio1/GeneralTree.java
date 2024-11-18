package ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
			int alt=-1;
			if(this.isLeaf())return 0;
			if(this.hasChildren()) {
				List<GeneralTree<T>>children=this.getChildren();
				for(GeneralTree<T> child:children)
					alt=Math.max(alt, child.altura());
			}
		return alt + 1;
	}//supuestamente esta bien. No creo que me tomen estas implementaciones

	public int nivel(T dato){
		List<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		
		queue.enqueue(this);
		queue.enqueue(null);
		
		int lvl=0;
		
		while(!queue.isEmpty()){
			aux=queue.dequeue();
			if(aux!=null){
				if(aux.getData()== dato)
					return lvl;
				if(aux.hasChildren()) {
					List<GeneralTree<T>>children=this.getChildren();
					for(GeneralTree<T> child:children)
						queue.enqueue(child);
				}
			}
			else
				if(!queue.isEmpty()) {
					queue.enqueue(null);
					lvl++;
				}
		}
		return -1;
	  }
	
	public int ancho(){
		List<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		
		queue.enqueue(this);
		queue.enqueue(null);
		
		int lvl=0;
		int cantidad=0;
		int max=-1;
		
		while(!queue.isEmpty()){
			aux=queue.dequeue();
			if(aux!=null){
				cantidad++;
				if(aux.hasChildren()) {
					List<GeneralTree<T>>children=this.getChildren();
					for(GeneralTree<T> child:children)
						queue.enqueue(child);
				}
			}
			else
				if(max<cantidad)
					max=cantidad;
				cantidad=0;
				if(!queue.isEmpty()) {
					queue.enqueue(null);
					lvl++;
				}
		}
		return max;
	}
	
	public boolean esAncestro(T a,T b) {
		return buscarA(a,b,this);
	}
	
	private boolean buscarA(T a,T b,GeneralTree<T> arbol) {
		boolean ok=false;
		if(arbol.getData()== a) {
			if(arbol.hasChildren()) {
				List<GeneralTree<T>> l= arbol.getChildren();
				int i=0;
				while ((i <l.size())&&(!ok)) {
					ok=buscarB(a,b,l.get(i+1));
					i++;
				}
			}
		}
		if(arbol.hasChildren()) {
			List<GeneralTree<T>> l=arbol.getChildren();
			int i=0;
			while ((i <l.size())&&(!ok)) {
				ok=buscarA(a,b,l.get(i+1));
				i++;
			}
		}
		return ok;
	}
	
	private boolean buscarB(T a, T b, GeneralTree<T> arbol) {
		Boolean ok=false;
		if(arbol.getData()==b){
			return true;
		}
		if(arbol.hasChildren()){
			List<GeneralTree<T>> l=arbol.getChildren();
			int i=0;
			while ((i <l.size())&&(!ok)) {
				ok=buscarB(a,b,l.get(i+1));
				i++;
			}
			
		}
		return ok;
	}
	
}
