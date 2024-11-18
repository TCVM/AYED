package ejercicio7;
import java.util.List;
import java.util.ArrayList;

public class Estudiante {
	private String dato;
	
	public Estudiante() {
		this.dato="0";
	}
	
	public void setDato(String a) {
		dato=a;
	}
	
	public String getDato() {
		return this.dato;
	}
	
	public static void puntoDyMas() {
		Estudiante aux;
		List <Estudiante> estudiantes= new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			aux= new Estudiante();
			estudiantes.add(aux);
		}
		
		List <Estudiante> estudioo= new ArrayList<>(estudiantes);
		
		for (int i = 0; i < estudiantes.size(); i++) {
			System.out.println(estudiantes.get(i).getDato());
			System.out.println(estudioo.get(i).getDato());
		} 
		estudiantes.get(0).setDato("3");
		for (int i = 0; i < estudiantes.size(); i++) {
			System.out.println(estudiantes.get(i).getDato());
			System.out.println(estudioo.get(i).getDato());
		} 
			
		}
	}

