package ejercicio8;
import java.util.List;
import java.util.ArrayList;

public class Queue {
	protected List<Object> data;

	public Queue() {
		data= new ArrayList<>();
	}
	
	public void enqueue(Object dato) {
		data.add(data.lastIndexOf(dato)+1, dato);
	}
	
	public Object dequeue() {
		if(data.isEmpty()) 
		{ 
			System.out.println("error");
			return null;
		}
		else
			{
				Object aux=data.get(0);
				data.remove(0);
				return aux;
			}
	}
	
	public Object head() {
		if(data.isEmpty()) 
		{	
			System.out.println("error");
			return null;
		}
		else return data.get(0);
	}
	
	public boolean isEmpty() {
		if(data.size() == 0)return true;
		else return false;
	}
	
	public int size() {
		int count=0;
		for (Object object : data) {
			count++;
		}
		return count;
	}
	
	public String toString() {
		
		return foreach(object d: data)
			d.toString();
	}
}
