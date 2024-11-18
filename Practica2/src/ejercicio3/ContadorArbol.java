package ejercicio3;
import ejercicio2.BinaryTree;
import java.util.List;
import java.util.ArrayList;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree A) {
		this.arbol=A;
	}
	
	private List recursionPostOrden(List<Integer> L,BinaryTree a) {
		
		if(arbol.isLeaf()) {
			return L;
		}else
			if(arbol.hasLeftChild()) {
				recursionPostOrden(L,a.getLeftChild());
			}
			if(arbol.hasRightChild())
				recursionPostOrden(L,a.getRightChild());
		if(arbol.getData()%2==0) {
			L.add(arbol.getData());
		}
		return L;
	}
	
private List recursionPostOrden(List<Integer> L,BinaryTree a) {
		
		if(arbol.isLeaf()) {
			return L;
		}else
			if(arbol.hasLeftChild()) {
				recursionPostOrden(L,a.getLeftChild());
			}
			if(arbol.getData()%2==0) {
				L.add(arbol.getData());
			}	
			if(arbol.hasRightChild())
				recursionPostOrden(L,a.getRightChild());
		
		return L;
	}


	public List numerosPares(){
		List L= new ArrayList<>();
		BinaryTree<Integer> a=arbol;
		return recursionPostOrden(L,a);
	}

}
