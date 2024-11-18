package ejercicio2;
import Practica1.queue;
public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	private int recorrer_private(int aux) {
		if(this.hasLeftChild() && this.getLeftChild().isLeaf())
			aux++;
		else
			this.getLeftChild().recorrer_private(aux);
		if(this.hasRightChild()&& this.getRightChild().isLeaf())
			aux++;
		else
				this.getRightChild().recorrer_private(++aux);
		return aux;
	}
	
	
	public  int contarHojas() {
		int aux=1;
		if (this.isLeaf()) return aux;
		else
			return recorrer_private(aux);
	}
		
	private BinaryTree<T> espejo_private(BinaryTree<T> ab){
		BinaryTree<T> aux;
    	if(ab == null)
 	   		return ab;
 	   	aux= new BinaryTree<T>(ab.getData());
 	   aux.rightChild=espejo_private(ab.getLeftChild());
       aux.leftChild=espejo_private(ab.getRightChild());
 	   //mejor con setters	
       return aux;
	}
    	 
    public BinaryTree<T> espejo(){    		  
    	return this.espejo_private(this);
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> ab=null;
		int nivel=0;
		Queue<BinaryTree<T>> cola= new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			ab= cola.dequeue();
			if(ab != null ) {
				System.out.print(ab.getData());
				if(ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if(ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
				
			} else if(!cola.isEmpty()) {
				System.out.println();
				cola.enqueue(null);
				++nivel;
			}
		}
	}
		
}

