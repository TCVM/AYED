package ejercicio6;
import java.util.Queue;
import java.util.List;
import ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> arbol;
	public RedDeAguaPotable() {};
	
	private double minimoCaudal(GeneralTree<Character> a, double caudal, int childs){
		double min=9999;
		if(a.isLeaf()){
			return caudal;
		}
		else {
			caudal= caudal/childs;
			List<GeneralTree<Character>> children=a.getChildren();
			for (GeneralTree<Character> child : children) {
				double aux= minimoCaudal(child,caudal,children.size());
				if(min>aux)
					min=aux; 
			}
		}	
		return min;
	}
	
	public double minimoCaudal(double caudal) {
		return minimoCaudal(arbol,caudal,1);
	}
}
