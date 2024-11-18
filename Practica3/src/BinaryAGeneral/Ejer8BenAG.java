package BinaryAGeneral;

import java.util.ArrayList;
import java.util.List;

import ejercicio1.GeneralTree;

public class Ejer8BenAG {
	
	private boolean private_esPrefijo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
		if(arbol1 != null && arbol1.getData()!= arbol2.getData())
			return false;
		if(arbol1.hasChildren())
				if(arbol2.hasChildren()) {
					List<GeneralTree<Integer>>children=new ArrayList<>(arbol1.getChildren());
					List<GeneralTree<Integer>>children2=new ArrayList<>(arbol2.getChildren());
					if(children.size()>children2.size()) return false;
					for (int i = 0; i < children.size(); i++) {
						if(!private_esPrefijo(children.get(i),children2.get(i)))
							return false;
					}
				}
		return true;
		}
	
	public boolean esPrefijo(GeneralTree<Integer> arbol1, GeneralTree<Integer>arbol2) {
		if((arbol1 == null || arbol1.isEmpty()) || (arbol2==null || arbol2.isEmpty()))
			return false;
		return private_esPrefijo(arbol1,arbol2);
		
	}
	
}
