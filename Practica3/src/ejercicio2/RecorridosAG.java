package ejercicio2;
import ejercicio1.GeneralTree;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class RecorridosAG {

	
	private void preOrden(GeneralTree <Integer> a,Integer n, List<Integer> l)
	{
			if((a.getData() % 2 != 0)&&(a.getData()>n)) l.add(a.getData());
			List<GeneralTree<Integer>>children=a.getChildren();
			for(GeneralTree<Integer> child:children) {
			 preOrden(child,n,l);
			}
	}
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,
			Integer n){
		List<Integer> l= new ArrayList<>();
		preOrden(a,n,l);
		return l;
	}
	
	private void inOrden(GeneralTree <Integer> a, Integer n, List<Integer> l) {
		List<GeneralTree<Integer>>children=a.getChildren();
		if(!children.isEmpty())
			inOrden(a,n,l);
		if((a.getData() % 2 != 0)&&(a.getData()>n)) l.add(a.getData());
		for(GeneralTree<Integer> child:children) {
		 inOrden(child,n,l);
		}
	}
	
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,
			Integer n){
		
		List<Integer> l= new ArrayList<>();
		return l;
	}
/*
 private void numerosImparesMayoresQueInOrden (Integer n,ListaGenerica<Integer> l,ArbolGeneral<Integer> arbol){
		ListaGenerica <ArbolGeneral<Integer>> lhijos = arbol.getHijos();
		lhijos.comenzar(); (devuelve el puntero de una linkedList de vuelta al comienzo)
		if (!lhijos.esVacia())
			numerosImparesMayoresQueInOrden(n,l,lhijos.proximo());
		if (((arbol.getDato() % 2) == 1) && (arbol.getDato() > n )) 
			l.agregarFinal(arbol.getDato());
		while (!lhijos.fin() && !lhijos.esVacia()) {
			numerosImparesMayoresQueInOrden(n,l,lhijos.proximo());
		}
	}*/
	
	private void postOrden(GeneralTree <Integer> a,Integer n,List<Integer> l) {
		List<GeneralTree<Integer>>children=a.getChildren();
		for(GeneralTree<Integer> child:children) {
		 postOrden(child,n,l); 
		}
		if((a.getData() % 2 != 0)&&(a.getData()>n)) l.add(a.getData());
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
			Integer n){
		List<Integer> l= new ArrayList<>();
		postOrden(a,n,l);
		return l;
	}
	
	
	
	private void porNiveles(GeneralTree <Integer> a,Integer n,List<Integer> l) {
		GeneralTree<Integer> aux;
		
		Queue<GeneralTree<Integer>> queue= new Queue<GeneralTree<Integer>>();
		queue.enqueue(a);
		while(!queue.isEmpty()) {
			aux=queue.dequeue();
			if((a.getData() % 2 != 0)&&(a.getData()>n)) l.add(a.getData());
			List<GeneralTree<Integer>>children=a.getChildren();
			for(GeneralTree<Integer> child:children) 
				 porNiveles(child,n,l);
		
	}
}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,
			Integer n){
		List<Integer> l= new ArrayList<>();
		porNiveles(a,n,l);
		return l;
	}
	
}
