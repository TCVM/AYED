package Parciales;

import ejercicio1.Edge;
import ejercicio1.Vertex;
import ejercicio1.Graph;
import java.util.List;
import java.util.LinkedList;

public class Parcial1 {
	
	public List<Tupla> invitacionMasterClass(Graph<Tupla>red,String usuario,int distancia,int limite){
		List<Tupla> invitados= new LinkedList<>();
		if(red.isEmpty()) {
			Queue<Graph<Tupla>> q = new Queue<>();
			boolean[] marca= new boolean[red.getSize()];
			Vertex aux= red.search(usuario);
			if(aux!=null) {
				int lvl=0;
				marca[aux.getPosition()]=true;//preguntar
				q.enqueue(aux);
				q.enqueue(null);
				while(!q.isEmpty() && invitados.size()>limite && lvl>distancia) {
					aux=q.dequeue();
					if(aux!=null){
						if(!marca[aux.getPosition()]) {
							Tupla t=new Tupla(aux.getData(),lvl);
							invitados.add(t);
							marca[aux.getPosition()]=true;
						}
						List<Edge<String>>adyacentes= red.getEdges(aux);
						for (Edge<String> ady : adyacentes) {
							Vertex<String> v= ady.getTarget();
							if(!marca[v.getPosition()]) {
								q.enqueue(v);
							}
						}
					}
					else
						if(!q.isEmpty()) {
							q.enqueue(null);
							lvl++;
						}
				}	
			}
		}
		
		
	}

}
