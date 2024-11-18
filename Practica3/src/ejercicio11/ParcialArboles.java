package ejercicio11;
import ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class ParcialArboles {

	public static boolean resolver(GeneralTree<Integer> arbol) {
		List<GeneralTree<Integer>> queue= new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux;
		int nodos=1;
		queue.enqueue(arbol);
		queue.enqueue(null);
		while(!queue.isEmpty()) {
			aux=queue.dequeue();
			if(aux!= null) {
				if(aux.hasChildren()) {
					int cont=0;
					for (GeneralTree<Integer> child : aux.getChildren()) {
						queue.enqueue(child);
						cont++;
					}
					if(cont==nodos+1)
						nodos=cont;
					else
						return false;
				}
			}else
				if(!queue.isEmpty()) {
					queue.enqueue(null);
				}
		}
		return true; 
	}
	
}
