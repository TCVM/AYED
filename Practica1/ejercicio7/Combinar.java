package ejercicio7;
import java.util.List;
import java.util.ArrayList;


public class Combinar {
	
	public List combinarOrdenado(List<Integer> lista1,List<Integer> lista2) {
		ArrayList<Integer> aux = new ArrayList<>() ;
		int i=0;
		int j=0;
		
		while (i<lista1.size() && j<lista2.size())
			if(lista1.get(i) < lista2.get(j)) {
				aux.add(lista1.get(i));
				i++;
			}
			else
			{
				aux.add(lista2.get(j));
				j++;
			}
		
		while(i<lista1.size()) {
			aux.add(lista1.get(i));
			i++;
		}
		while(j<lista2.size()) {
			aux.add(lista2.get(j));
			j++;
		}
		return aux;
	}
}
