package ejercicio4;

public class Caperucita {
	
	public list<list<string>> recorridoMasSeguro(){
		list<list<string>> seguro= new LinkedList<>();
		boolean [] marca= new boolean[this.bosque.getSize()]; 
 		if(!this.bosque.isEmpty()) {
			vertex ver1=bosque.search('casa caperucita');
			vertex ver2=bosque.search('casa abuelita');
			if(ver1 != null && ver2 != null)
				List<List<string>> caminos= new LinkedList<>(); 	
				dfs(ver1,seguro,caminos,marca);
		}
	}
	
	private void dfs(Vertex origen, list<list<string>> seguro,list<list<string>> caminos, boolean [] marcas) {
		marcas[origen.getPosition()];
		caminos.add(origen.getData());
		if(origen.getData().equals('casa abuelita')) {
			seguro.add(new LinkedList(caminos));
		}
		else {
			List<Edge<string>> adys= this.bosque.getEdges(origen);
			for(Edge<string> a:adys) {
				vertex<string> destino= a.getTarget();
				if(!marcas[destino.getPosition()]&&destino.getWeight()<5)
					dfs(destino,seguro,caminos,marcas);
			}
		}
		marcas[origen.getPosition()]=false;
		caminos.remove(caminos.size()-1);
	}
}
