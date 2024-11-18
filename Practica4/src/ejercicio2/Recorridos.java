package ejercicio2;
import java.util.List;
import ejercicio1.Edge;
import ejercicio1.Vertex;
import ejercicio1.Graph;
import java.util.LinkedList;
public class Recorridos {

// Retorna una lista con los datos de los vértices, con el recorrido en
//profundidad del grafo recibido como parámetro.
/*
	public class Recorridos<T> {
		
		public void dfs(Graph<T> grafo) {
			boolean[] marca = new boolean[grafo.getSize()];
			for (int i = 0; i < grafo.getSize(); i++) {
				if (!marca[i]) {		
					System.out.println("largo con: "+grafo.getVertex(i).getData());
					dfs(i, grafo, marca);
				}
			}
		}
		private void dfs(int i, Graph<T> grafo, boolean[] marca) {
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		System.out.println(v);
		List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
		for (Edge<T> e: adyacentes){
			 int j = e.getTarget().getPosition();
			 if (!marca[j]) {
				dfs(j, grafo, marca);
 */
	
	
	
public List<T> dfs(Graph<T> grafo){
	boolean [] marca= new boolean[grafo.getSize()];
	List<T> datos= new LinkedList<T>(); 
	for(int i=0;i<grafo.getSize();i++)
		if(!marca[i]) {
			dfs(i,grafo,marca,datos);
		}
	return datos;
}

private List<T> dfs(int i,Graph<T> grafo,boolean[] marca, List<T> datos){
	marca[i]=true;
	Vertex<T> v=grafo.getVertex(i);
	datos.add(v.getData());
	List<Edge<T>> adyacentes= grafo.getEdges(v);
	for (Edge<T> e : adyacentes) {
		int j=e.getTarget().getPosition();
		if(!marca[j])
			dfs(j,grafo,marca,datos);
	}
	return datos;
}




//Retorna una lista con los datos de vértices, con el recorrido en amplitud 
//del grafo recibido como parámetro.

public List<T> bfs(Graph<T> grafo){
	boolean [] marca=new boolean[grafo.getSize()];
	List<T> datos= new LinkedList<T>();
	for(int i;i<grafo.getSize();i++)
		if(!marca[i])
			bfs(i,grafo,marca,datos);
	return datos;
}

private List<T> bfs(int i,Graph<T> grafo,boolean[] marca,List datos){
	Queue<Vertex<T>> q=new Queue<>();
	q.enqueue(grafo.getVertex(i));
	marca[i]=true;
	while(!q.isEmpty()) {
		Vertex<T> w=q.dequeue();
		datos.add(w.getData());
		List<Edge<T>>adyacentes=grafo.getEdges(w);
		for (Edge<T> e : adyacentes) {
			int j=e.getTarget().getPosition();
			if(!marca[j]) {
				marca[j]=true;
				q.enqueue(e.getTarget());
			}
		}
	}
	return datos;
}
/*
 public class Recorridos {
	public void bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[new boolean[grafo.getSize()];
		for (int i = 1; i <= marca.length; i++) {
			if (!marca[i]){
				this.bfs(i, grafo, marca); //las listas empiezan en la pos 1
			}
		}
	}
	
private void bfs(int i, Graph<T> grafo, boolean[] marca) {
	Queue<Vertex<T>> q = new Queue<Vertex<T>>();
	q.enqueue(grafo.getVertex(i));
	marca[i] = true;
	while (!q.isEmpty()) {
		Vertex<T> w = q.dequeue();
		System.out.println(w);
		// para todos los vecinos de w:
		List<Edge<T>> adyacentes = grafo.getEdges(w);
		for (Edge<T> e: adyacentes) {
			int j = e.getTarget().getPosition();
			if (!marca[j]) {
				marca[j] = true;
				//Vertex<T> v = e.getTarget();
				q.enqueue(e.getTarget());
			}
		}
	}
} 
 */

/*	
	public List<T> dfs(Graph<T> grafo){
		boolean [] visitados= new boolean[grafo.getSize()];
		List<T> datos=new LinkedList<T>();
		for(int i=0;i<grafo.getSize();i++) {
			if(!visitados[i]) {
				dfs(grafo,i,visitados,datos);
			}
		return datos;
		}
	}
	
	private void dfs(Graph<T> grafo, int i,boolean[] visitados ,List datos){
		visitados[i] = true;
		Vertex<T> v= grafo.getVertex(i);
		datos.add(v.getData());
		List<Edge<T>> adyacentes=grafo.getEdge(v);
		for(Edge<T> e: adyacentes ) {
			if(!visitados[e.getTarget.getPosition()]) {
				dfs(grafo,j,visitados,datos);
			}
		}
		
	}	
	
	public List<T> bfs(Graph<T> grafo){
		boolean [] visitados=new boolean[grafo.getSize()];
		List<T> datos=new LinkedList<>();	
		for(int i=0;i<grafo.getSized();i++) {
			if(!visitados[i]) {
				bfs(grafo,i,visitados,datos);
			}
		}
		return datos;
	}
	
	private void bfs(Graph<T> grafo,int i,boolean [] visitados, List datos) {
		Queue<Vertex<T>> q= new Queue<Vertex<T>>();
		q.enqueue(grafo.getVertex(i));
		visitados[i]=true;
		while(!q.isEmpty()) {
			Vertex<T> w=q.dequeue();
			datos.add(w.getData());
			List<Edge<T>> adyacentes= grafo.getEdges(w);
			for(Edge<T> e:adyacentes) {
				int j=e.getTarget().getPosition();
				if(!visitados[j]) {
					visitados[j]=true;
					q.enqueue(e.getTarget());
					
				}
			}
		}
		
	} 
*/
}
