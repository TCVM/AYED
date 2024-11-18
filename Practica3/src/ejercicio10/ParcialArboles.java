package ejercicio10;
import ejercicio1.GeneralTree;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ParcialArboles {

	/*public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> camino= new LinkedList<>();
		GeneralTree<Integer>aux;
		int max=0;
		
		Queue<GeneralTree<Integer>> queue= new Queue<GeneralTree<Integer>>();
		queue.enqueue(arbol);
		cola.enqueue(null);
		while(!queue.isEmpty()) {
			aux= queue.dequeue();
			if(aux!=null) {
				if(aux.getData()== 1)
					camino.add(aux.getData());
				if(arbol.hasChildren()) {
					List<GeneralTree<Integer>> children = aux.getChildren();
					for(GeneralTree<Integer> child:children) {
						queue.enqueue(child);
					}
					for (Integer item : camino) {
						max=max + item;
					}
				}
			}
			else {
				if(!queue.isEmpty())
					queue.enqueue(null);
			}
		}
		return camino;
	}
*/
	
	private static int recursion(GeneralTree<Integer> arbol, int nivel, List<Integer> camino,List<Integer> lista, int max) {
        if (arbol.isLeaf()) {
            int suma = 0;
            for (Integer aux : lista) {
                suma += aux * nivel;//se esta multiplicando todo por el mismo nivel
            }
            if (suma > max) {
                camino.clear();
                camino.addAll(lista);
                return suma;
            }
            return max;
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children) {
                if (child.getData() == 1) {
                    lista.add(child.getData());
                    max = recursion(child, nivel + 1, camino,lista, max);
                    lista.remove(lista.size() - 1);
                }
            }
            return max;
        }
    }

	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		int nivel=0;
		int max=0;
		List<Integer> camino= new LinkedList<>();
		List<Integer> lista= new LinkedList<>();
		recursion(arbol,nivel,camino,lista,max);
		return camino;
 	}	
}
