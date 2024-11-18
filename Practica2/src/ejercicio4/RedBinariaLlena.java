package ejercicio4;
import ejercicio2.BinaryTree;
import java.util.List;
import java.util.ArrayList;


public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree A) {
		this.arbol=A;
	}
	private int retardoReenvio(BinaryTree a) {
		if(a.isLeaf()) {
			return a.getData();
		} else {
			int valorHD=0, valorHI=0;
			if(a.hasLeftChild()) {
				valorHI=retardoReenvio(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				valorHD=retardoReenvio(a.getRightChild());
			}
			if(valorHI>valorHD) {
				return valorHI + a.getData();
			}else {
				return valorHD + a.getData();
			}
		}
	}
	
}
