package ejercicio4;
import java.util.List;
import ejercicio1.GeneralTree;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		List<GeneralTree<AreaEmpresa>> queue=new Queue<GeneralTree<AreaEmpresa>>();
		GeneralTree<AreaEmpresa> aux;
		
		int tardanzas=0;
		int nodo=0;
		int lvl=0;
		double max=-1;
		
		queue.enqueue(null);
		queue.enqueue(arbol);
		
		while(!queue.isEmpty()){
			aux=queue.dequeue();
			if(aux!=null) {
				tardanzas+=aux.getData().getTardanza();
				nodo++;
				//aca es la suma
				if(aux.hasChildren()){
					List<GeneralTree<AreaEmpresa>> children= aux.getChildren();
					for(GeneralTree<AreaEmpresa> child:children)
						queue.enqueue(child);
				}
			}
			else//aca se compara
				if(!queue.isEmpty()) {
					double promedio;
					if(nodo!=0)
						promedio=tardanzas/nodo;
					if(max<promedio)
						max=promedio;
					tardanzas=0;
					nodo=0;
					queue.enqueue(null);
				}
				
		}
		return max;
	}
	
}
