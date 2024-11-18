package ejercicio1;


public class Auxiliar {
	
	public static void  imprimirFor(int a, int b) {
			if(a<b)
				for (int i = a; i <= b;i ++) 
					System.out.println(i);
			else
				if(a!=b)
					for (int i = b; i <= a;i ++) 
							System.out.println(i);
				else System.out.println("Sos gracioso, eh");
	}
	
	public static void imprimirWhile(int a, int b) {
		if(a<b)
			while (a <= b) {
				System.out.println(a);
				a+=1;
				
			}
		else 
			if(a != b)
			while (b <= a) {
				System.out.println(b);
				b+=1;
			}
			else System.out.println("Sos gracioso, eh");
			
	}
	
	public static void imprimir(int a, int b) {
		if(a<=b) {
			System.out.println(a);
			a+=1;
			imprimir(a,b);
		}
	}
}
