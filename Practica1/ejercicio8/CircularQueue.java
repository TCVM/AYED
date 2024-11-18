package ejercicio8;
import java.util.List;
import java.util.ArrayList;

public class CircularQueue extends Queue{
	public Object shift() {
		//get
		return this.data.remove(0);
		//add
	}
}
