package ejercicio7;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList {  
	
	
	public static List main() {
		List <Integer> numeros;
		numeros= new ArrayList<>();
		char digC;
		int dig;
		Scanner s= new Scanner(System.in);
		System.out.println("Ingrese un numero");
		String aux=s.nextLine();
		for (int i = 0; i < aux.length(); i++) {
			digC= aux.charAt(i);
			dig=Character.getNumericValue(digC);
			numeros.add(dig);
		}
		for (Integer integer : numeros) {
			System.out.println(integer);
		}
		return numeros;
	} 
	
	public boolean capicua(List numeros) {
			for (int i = 0; i < numeros.size()/2; i++) {
				if(numeros.get(i) != numeros.get(numeros.size()- 1 - i)) return false;
			}
		return true;
	}
}
