package ejercicio4;

import java.util.List;
import java.util.LinkedList;
import ejercicio1.Edge;
import ejercicio1.Vertex;
import ejercicio1.Graph;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares,String destino,int maxTiempo,List<String> lugaresRestringidos){
		List<String> camino= new LinkedList<>();
		if(!(lugaresRestringidos.contains("Ayuntamiento"))&&!(lugaresRestringidos.contains(destino))) {
		boolean[] marca=new boolean[lugares.getSize()];
		List<String> lista= new LinkedList<>();
		List<Vertex<String>> aux= lugares.getVertices();
		int i=0;
		boolean ok=false;
		Vertex<String> v;
		while((i<=aux.size())&&!(ok)) {
			v=aux.get(i);
			if(v.getData()=="Ayuntamiento") {
				ok=true;
				i=v.getPosition();
				lista.add(v.getData());
			}
			else
				i++;
		}
		if(ok)
			paseoEnBici(i,marca,camino,lista,lugares,destino,maxTiempo,lugaresRestringidos);
	}
	return camino;
	}

	
	private List<String> paseoEnBici(int i,boolean[] marca, List camino, List lista,Graph<String> lugares,String destino,int maxTiempo,List<String> lugaresRestringidos) {
		marca[i]=true;
		Vertex<String> v=lugares.getVertex(i);
		if(v.getData()==destino) {
			camino=new LinkedList<>(lista);
		}
		if(camino.isEmpty()) {
			List<Edge<String>> adyacentes=lugares.getEdges(v);
			for (Edge<String> ady : adyacentes) {
				int j=ady.getTarget().getPosition();
				if((!marca[j])&&(!lugaresRestringidos.contains(ady.getTarget().getData()))) {
					maxTiempo-=ady.getWeight();
					if(maxTiempo>0) {
						lista.add(ady.getTarget().getData());
						paseoEnBici(i,marca,camino,lista,lugares,destino,maxTiempo,lugaresRestringidos);
						lista.remove(lista.size());
					}
					maxTiempo+=ady.getWeight();
					marca[j]=false;
				}
			}
		}
		return camino;
	}
}
