package ejercicio9;
import ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class ParcialArboles {
	
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		if(arbol.hasChildren()) {
			List<GeneralTree<Integer>> children= arbol.getChildren();
			int min=9999;
			for (GeneralTree<Integer> child : children) {
				if(min>child.getData())
					if(!esDeSeleccion(child))
						return false;
					min=child.getData();
			}
			if(min!=arbol.getData())
				return false;
		}
		return true;		
	}
	
}
