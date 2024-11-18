
package ejercicio5;

import java.util.List;
import java.util.LinkedList;
import ejercicio1.Edge;
import ejercicio1.Vertex;
import ejercicio1.Graph;

public class Itau {
	
	public List<T> carteraDeJubilados(Graph<T> grafo,T e,int distancia){
		Vertex<T> v= grafo.Search(e);
		List<T> jubis= new LinkedList<>(); 
		if(v!= null) {
			boolean[] marca= new boolean[grafo.getSize()];
			for(int i= 1; i<= marca.length; i++)
				if(!marca[i])
					this.bfs(i,grafo,e,distancia,jubis,marca);
		}
		return jubis;
	}
	
	private List<T> bfs(int i,Graph<T> grafo, T e, int distancia,List j,boolean[] marca){
		Queue<Vertex<T>> q= new Queue<>();
		marca[i]=true;
		q.enqueue(grafo.getVertex(i));
		q.enqueue(null);
		while(!q.isEmpty()){
			Vertex<T> v= q.dequeue();
			if(v != null) {
				List<Edge<T>>adyacentes=grafo.getEdges(v);
				for (Edge<T> ady : adyacentes) {
					if(!marca[ady.getTarget.getPosition()]) {
						marca[ady.getTarget.getPosition()]= true;
						q.dequeue();
					}
				}
			}else if(!q.isEmpty()) {
				q.enqueue(null);
			}
				
		}
		return ;
	}
}
