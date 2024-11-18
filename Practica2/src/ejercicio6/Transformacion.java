package ejercicio6;
import ejercicio2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol; 

	private int suma(BinaryTree a) {
		int aux=0;
		if(a<>null) {
			return 0;
		}
		else
			if(a.isLeaf()) {
				aux+=a.getData();
				a.setData(0);
				return aux;
			}
			else {
				if(a.hasLeftChild())
					aux=suma(a.getLeftChild());
				if(a.hasRightChild())
					aux=suma(a.getRightChild());
				int x=a.getData()
				a.setData(aux);
				return x + aux;
			}
	}
}

private int sum(BinaryTree a){
	int suma=0;
	if(a.isLeaf()) {
		suma=a.getData();
		a.setData(0);
		return suma;
	}else {
		if(a.hasLeftChild()) {
			suma+=(this.sum(a.getLeftChild()));
		}
		if (a.hasRightChild()) {
			suma+=(this.sum(a.getRightChild()));
		}
		int x=a.getData();
		a.setData(suma);
		return(suma+x);
	}
}

public BinaryTree suma(){
	this.sum(this.getTree());
	return(this.getTree());
