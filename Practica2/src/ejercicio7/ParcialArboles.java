package ejercicio7;
import ejercicio2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> a;
	
	private int count(BinaryTree arbol) {
		if((arbol==null)||(arbol.isEmpty()))
			return -1;
		int counter=0;
		if((arbol.hasLeftChild())&&(arbol.hasRightChild())){
			return count(a.getLeftChild())+count(a.getRightChild());
		}else
			if(arbol.hasLeftChild())
				return count(a.getLeftChild()) + 1;
			else
				if(arbol.hasRightChild())
					return count(a.getRightChild()) + 1;
				else
					return 0;
		//if((arbol.hasLeftChild())&& !(arbol.hasRightChild()) || 
			//!(a.hasLeftChild()&&(a.hasRightChild())))
			//counter++;
		if(!arbol.isLeaf())
			counter+=count(a.getRightChild())+count(a.getLeftChild());
		return counter;
	}
	
	public boolean isLeftTree(int num) {
		return isLeftTree(a,num);
	}
	
	public boolean isLeftTree(BinaryTree a,int num) {
		if((a==null)||(a.isEmpty()))
			return false;
		if(a.getData()==num) {
			int izq=count(a.getLeftChild());
			int der=count(a.getRightChild());
			return izq>der;
		}
		else
			return isLeftTree(a.getLeftChild(),num)||isLeftTree(a.getRightChild(),num);
			
	}
}
