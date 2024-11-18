package ejercicio2;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Contador {
	public static List CrearListaMultiplos() {
		System.out.println("Ingrese numero");
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		List<Integer> multiplos= new ArrayList<>();
		for (int i = 1; i <= num ; i++) {
			multiplos.add(i*num);
		}
		return multiplos;
	}
}
