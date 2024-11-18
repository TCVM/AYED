package ejercicio8;
import ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;

//Llamaremos abeto a un arbol si cada vertice no hoja tiene al menos 3 hijos hoja

public class Navidad {
	private GeneralTree<String> arbol;
	
	private boolean esAbetoNavideño(GeneralTree<String> a) {
		if(a.hasChildren()){
			List<GeneralTree<String>> Lista=a.getChildren();
			if(Lista.size()>=3) {
				for (GeneralTree<String> child : Lista) {
					if(child.getChildren().size()<3) {
						return false;
					}
					else {
						if(!esAbetoNavideño(child))
						return false;
					}
				}
			}
			return false;
		}
		return true;
	}
	public String esAbetoNavideño() {
		if(esAbetoNavideño(arbol))
			return "ES ABETO" ;
		else
			return "NO ES ABETO";
	}
	
	/*
	 private boolean esAbetoNavideño(GeneralTree<String> a) {
    if(a.hasChildren()){
        List<GeneralTree<String>> Lista=a.getChildren();
        if(Lista.size()>=3) {
            for (GeneralTree<String> child : Lista) {
                if(child.isLeaf()) {
                    if(child.getChildren().size() < 3) {
                        return false;
                    }
                }
                else {
                    if(!esAbetoNavideño(child)) {
                        return false;
                    }
                }
            }
        }
        else
            return false;
    }
    return true;
	 */
}
