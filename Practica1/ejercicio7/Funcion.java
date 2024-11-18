package ejercicio7;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcion {
	
	public List aplicarFuncion() {
		List secuencia= new ArrayList<>();
		Scanner s= new Scanner(System.in);
		int aux= s.nextInt();
		this.recursion(aux,secuencia);
		return secuencia;
	}
	
	private void recursion(int num, List S) {
		if(num != 1) {
			if(num % 2 == 0) {
				num=num/2;
			}
			else {
				num=3*num+1;
			}
			S.add(S);
			this.recursion(num,S);
		}
				
	}
}
