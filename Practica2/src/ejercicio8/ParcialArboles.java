package ejercicio8;
import ejercicio2.BinaryTree;
public class ParcialArboles {
	
	private boolean private_esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if(arbol1.getData()!= arbol2.getData())return false;
		boolean aux1=true;
		boolean aux2=true;
		if(arbol1.hasLeftChild())
				if(arbol2.hasLeftChild())
					aux1=private_esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild());
				else
					aux1=false;
		if(arbol1.hasRightChild())
				if(arbol2.hasRightChild())
					aux2=private_esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
				else
					aux2=false;
		return aux1 && aux2;
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer>arbol2) {
		if((arbol1 == null || arbol1.isEmpty()) || (arbol2==null || arbol2.isEmpty()))
			return false;
		return private_esPrefijo(arbol1,arbol2);
		
	}
	
}
