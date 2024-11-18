package ejercicio7;
import java.util.List;
import java.util.LinkedList;
import ejercicio1.GeneralTree;

public class Caminos{
	
	private GeneralTree<Integer> arbol;
	
	public Caminos(GeneralTree<Integer> a) {
		this.arbol=a;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> camino= new LinkedList<Integer>();
		List<Integer> Lista=new LinkedList<Integer>();
		Lista.add(this.arbol.getData());
		caminoAHojaMasLejana(arbol,camino,Lista);
		return camino;
	}
	
	private void caminoAHojaMasLejana(GeneralTree<Integer> a , List<Integer> camino,List<Integer> Lista){
		if(a.isLeaf()) {
			if(Lista.size()>camino.size()) camino=new LinkedList<>(Lista);
		}
		else {
			List<GeneralTree<Integer>> children=a.getChildren();
			for (GeneralTree<Integer> child : children) {
				Lista.add(child.getData());
				caminoAHojaMasLejana(child,camino,Lista);
				Lista.remove(Lista.size()-1);
			}
			
		}
	}

}