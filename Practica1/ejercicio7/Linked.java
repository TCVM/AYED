package ejercicio7;
import java.util.List;
import java.util.LinkedList;


public class Linked {
	
	public int sumarLinkedList(LinkedList<Integer> lista) {
		if(lista.isEmpty())
			return 0;
		else
			{
				int elemento=lista.removeFirst();
				return elemento + sumarLinkedList(lista);
			}
	}
}
