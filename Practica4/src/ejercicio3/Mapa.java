package ejercicio3;

import java.util.List;
import java.util.LinkedList;
import ejercicio1.Edge;
import ejercicio1.Vertex;
import ejercicio1.Graph;

public class Mapa {

	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> m) {
		mapaCiudades=m;
	}
	
	public List<String> devolverCamino(String ciudad1,String ciudad2){
		boolean[] marca= new boolean[mapaCiudades.getSize()];
		List<String> camino=new LinkedList<String>(); 
		List<String> lista=new LinkedList<>();
		List<Vertex<String>> aux= mapaCiudades.getVertices(); //creo lista de vertices y busco el que tenga el primer dato
		Vertex<String> v;
		boolean ok1=false;
		boolean ok2=false;
		int i=0;
		while((i<=aux.size())&&(!(ok1)||!(ok2))) { 
			v=aux.get(i);
			if(!(ok1)&&(v.getData().equals(ciudad1)))
				ok1=true;
			if(!(ok2)&&(v.getData().equals(ciudad2)))
				ok2=true;
			if((ok1)&&(ok2)) {
				i=v.getPosition();
				lista.add(v.getData());//Si lo encuentra agrega el dato al final de la lista
			}else
				i++;
		}
		if((ok1)&&(ok2))//si es encontrado se ejecuta el bucle buscando al segundo parametro
			devolverCamino(marca,camino,lista,i,ciudad2);
		return camino;
	}
	
	private List<String> devolverCamino(boolean[] marca, List camino,List lista,int i,String c2){
		marca[i]=true;
		Vertex<String> v=mapaCiudades.getVertex(i);
		if(v.getData().equals(c2)) { //si se encuentra el segundo parametro se guarda el camino
			camino.addAll(lista);
		}
		if(camino.isEmpty()) {//si no es vacia es porque hay un camino ya encontrado
			List<Edge<String>> adyacentes= mapaCiudades.getEdges(v);
			for (Edge<String> ady : adyacentes) {
				int j= ady.getTarget().getPosition();
				if(!marca[j]) {
					lista.add(ady.getTarget().getData());//agrego a la lista y pruebo el dato y sus adayecentes
					devolverCamino(marca,camino,lista,i,c2);
					lista.remove(lista.size()); //si no corresponde a un camino valido se elimina la ultima entrada agregada recursivamente
				}
			}
		}
		marca[v.getPosition()]=false;
		return camino;
	}
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino=new LinkedList<>();
		List<String> lista= new LinkedList<>();
		boolean [] marca= new boolean[mapaCiudades.getSize()];
		if(!ciudades.contains(ciudad1)&&!ciudades.contains(ciudad2)) {
			List<Vertex<String>> aux= mapaCiudades.getVertices();
			Vertex<String> v;
			boolean ok1=false;
			boolean ok2=false;
			int i=0;
			while((i<=aux.size())&&(!(ok1)||!(ok2))) { 
				v=aux.get(i);
				if(!(ok1)&&(v.getData().equals(ciudad1)))
					ok1=true;
				if(!(ok2)&&(v.getData().equals(ciudad2)))
					ok2=true;
				if((ok1)&&(ok2)) {
					=v.getPosition();
					lista.add(v.getData());//Si lo encuentra agrega el dato al final de la lista
				}else
					i++;
			}
			if((ok1)&&(ok2))//si es encontrado se ejecuta el bucle buscando al segundo parametro
				devolverCaminoExceptuando(i,marca,camino,lista,ciudad2,ciudades);
		}
		return camino;
	}
	
	private List<String> devolverCaminoExceptuando(int i,boolean[] marca,List<String> camino, List<String> lista,String ciudad2,List ciudades){
		marca[i]=true;
		Vertex<String> v= mapaCiudades.getVertex(i);
		if(v.getData()==ciudad2)
			camino=new LinkedList<>(lista);
		if(camino.isEmpty()) {
				List<Edge<String>> adyacentes= mapaCiudades.getEdges(v);
				for (Edge<String> ady : adyacentes) {
					int j=ady.getTarget().getPosition();
					if((!marca[j])&&(!(ciudades.contains(ady.getTarget().getData())))) {
						lista.add(ady.getTarget().getData());
						devolverCaminoExceptuando(j,marca,camino,lista,ciudad2,ciudades);
						lista.remove(lista.size());
					}
					marca[j]=false;
				}
		}
		return camino;
	}
	
	public List<String> caminoMasCorto(String ciudad1,String ciudad2){
		boolean[] marca=new boolean[mapaCiudades.getSize()];
		List<String> camino=new LinkedList<>();
		List<String> lista=new LinkedList<>();
		List<Vertex<String>> aux=mapaCiudades.getVertices();
		Vertex<String> v;
		boolean ok1=false;
		boolean ok2=false;
		int i=0;
		while((i<=aux.size())&&(!(ok1)||!(ok2))) { 
			v=aux.get(i);
			if(!(ok1)&&(v.getData().equals(ciudad1)))
				ok1=true;
			if(!(ok2)&&(v.getData().equals(ciudad2)))
				ok2=true;
			if((ok1)&&(ok2)) {
				i=v.getPosition();
				lista.add(v.getData());//Si lo encuentra agrega el dato al final de la lista
			}else
				i++;
		}
		if((ok1)&&(ok2))//si es encontrado se ejecuta el bucle buscando al segundo parametro
			caminoMasCorto(i,marca,camino,lista,ciudad2);
		return camino;
	}
	
	private List<String> caminoMasCorto(int i, boolean[] marca,List camino, List lista,String c2){
		marca[i]=true;
		Vertex<String> v= mapaCiudades.getVertex(i);
		if(v.getData()==c2)
			if(camino.size()>lista.size()) {
				camino.clear();
				camino=new LinkedList<>(lista);
				marca[i]=false;
			}
		else {
			List<Edge<String>> adyacentes=mapaCiudades.getEdges(v);
			for (Edge<String> ady : adyacentes) {
				int j=ady.getTarget().getPosition();
				if(!marca[j]) {
					lista.add(ady.getTarget().getData());
					caminoMasCorto(j,marca,camino,lista,c2);
					lista.remove(lista.size());
				}
				marca[j]=false;
			}
		}
		return camino;
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		boolean[] marca= new boolean[mapaCiudades.getSize()];
		List<String> camino=new LinkedList<String>();
		List<String> lista= new LinkedList<String>();
		List<Vertex<String>> aux= mapaCiudades.getVertices();
		boolean ok1=false;
		boolean ok2=false;
		int i=0;
		while((i<=aux.size())&&(!(ok1)||!(ok2))) { 
			v=aux.get(i);
			if(!(ok1)&&(v.getData().equals(ciudad1)))
				ok1=true;
			if(!(ok2)&&(v.getData().equals(ciudad2)))
				ok2=true;
			if((ok1)&&(ok2)) {
				i=v.getPosition();
				lista.add(v.getData());//Si lo encuentra agrega el dato al final de la lista
			}else
				i++;
		}
		if((ok1)&&(ok2))//si es encontrado se ejecuta el bucle buscando al segundo parametro
		
			caminoSinCargarCombustible(i,marca,camino,lista,ciudad2,tanqueAuto);
		return camino;
	}
	
	private List<String> caminoSinCargarCombustible(int i, boolean[] marca, List camino, List lista, String c2, int tank){
		marca[i]=true;
		Vertex<String> v=mapaCiudades.getVertex(i);
		if(v.getData()==c2) 
				camino=new LinkedList<String>(lista);
		if(camino.isEmpty()) {
				List<Edge<String>> adyacentes= mapaCiudades.getEdges(v);
				for (Edge<String> ady : adyacentes) {
					int j=ady.getTarget().getPosition();
					if(marca[j]) 
						tank--;
						if(tank>0) {
							lista.add(ady.getTarget().getPosition());
							caminoSinCargarCombustible(j,marca,camino,lista,c2,tank);
							lista.remove(lista.size());
						}else
							marca[j]=false;
							tank++;
				}
		}	
		return camino;
	}
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1,String ciudad2,int tanqueAuto){
		int min=9999;
		boolean[] marca= new boolean[mapaCiudades.getSize()];
		List<String> camino=new LinkedList<>();
		List<String> lista=new LinkedList<>();
		List<Vertex<String>> aux=mapaCiudades.getVertices();
		int i=0;
		boolean ok1=false;
		boolean ok2=false;
		int i=0;
		while((i<=aux.size())&&(!(ok1)||!(ok2))) { 
			v=aux.get(i);
			if(!(ok1)&&(v.getData().equals(ciudad1)))
				ok1=true;
			if(!(ok2)&&(v.getData().equals(ciudad2)))
				ok2=true;
			if((ok1)&&(ok2)) {
				i=v.getPosition();
				lista.add(v.getData());//Si lo encuentra agrega el dato al final de la lista
			}else
				i++;
		}
		if((ok1)&&(ok2))//si es encontrado se ejecuta el bucle buscando al segundo parametro
		 {
			int carga=tanqueAuto;
			int cant=0;
			caminoConMenorCargaDeCombustible(i,marca,camino,lista,ciudad2,tanqueAuto,min,carga,cant);
		}
		return camino;
	}
	
	private List<String> caminoConMenorCargaDeCombustible(int i,boolean[] marca,List camino, List lista, String c2, int tank,int min,int carga,int cant){
		Vertex<String> v=mapaCiudades.getVertex(i);
		if(v.getData()==c2) {
			if(cant<min) {
				camino=new LinkedList<>(lista);
				min=cant;
			}
		}else {
			if(tank==0) {
				tank+=carga-tank;
				cant++;
			}
			marca[i]=true;
			List<Edge<String>> adyacentes=mapaCiudades.getEdges(v);
			for (Edge<String> ady : adyacentes) {
				int j=ady.getTarget().getPosition();
				if(!marca[j]) {
					tank--;
					if(tank>=0) {
						lista.add(ady.getTarget().getData());
						caminoConMenorCargaDeCombustible(i,marca,camino,lista,c2,tank,min,carga,cant);
						lista.remove(lista.size());
					}
					else
						marca[j]=false;
						tank++;
				}
			}
		}
		return camino;
	}
 }
