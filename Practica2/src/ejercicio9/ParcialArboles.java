package ejercicio9;
import ejercicio2.BinaryTree;

public class ParcialArboles { 
	private BinaryTree<Integer> a;
	
	public ParcialArboles(BinaryTree a) {
		this.a=a;
	}
	
	private BinaryTree<Integer[]> p_sumAndDif(BinaryTree a,int aux,int sum){
		if(a==null||a.isEmpty()) return null;
		BinaryTree<Integer[] >b=new BinaryTree<>();
			sum =sum + a.getData();
			b[0].setData()=sum;
			b[1].setData()=a.getData()-aux;
			aux=a.getData();
			if(a.hasLeftChild())
				b.addLeftChild(p_sumAndDif(a.getLeftChild(),aux,sum)); 
			if(a.hasRightChild())
				b.addRightChild(p_sumAndDif(a.getRightChild(),aux,sum));
			return b;
	}
	public BinaryTree<Integer[]> sumAndDif(BinaryTree<Integer> a){
		if(a != null && !a.isEmpty()) {
			int aux=0;
			int suma=0;
			BinaryTree<Integer[]> b; //BinaryTree vector[2] 
			return p_sumAndDif(a,aux,suma);		
		}
		else
			return null;
	}
}
