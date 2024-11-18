package ejercicio5;

import ejercicio2.BinaryTree;

public class profundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public int sumaElementosProfundidad(int p) {
		int aux=0;
		int contador=0;
		Queue<BinaryTree<Integer>> cola= new Queue<BinaryTree<Integer>>();
		cola.enqueue(null); //null como principio de lvl1
		cola.enqueue(arbol);// /null/-/arbol/.
		while(!cola.isEmpty()) { //si no esta vacio
			BinaryTree<Integer> valor=cola.dequeue();//desencolo el elemento /null/.
			if(valor==null) {//si el elemento es null
				contador++;//significa que se alcanzo el final del nivel 
				if(!cola.isEmpty())//si quedan elementos
					cola.enqueue(null);//se encola null atras como fin de lvl
			}
			else{
				if(valor.hasLeftChild())
					cola.enqueue(valor.getLeftChild());
				if(valor.hasRightChild())
					cola.enqueue(valor.getRightChild());
				if(contador == p)
					aux+=valor.getData(); //suma todos los nodos del mismo nivel
			}
		return aux;
		}
	}
}	