package objets;
import java.util.Vector;

/**
* La classe inventaire contient un Vector d'objets, 
*/
public class Inventaire {

	public Vector<AObjet> listeObjets;

	public Inventaire() {
		listeObjets = new Vector<AObjet>();
	}

	public void ajouterObjet(AObjet objet) {
		listeObjets.add(objet);
	}

	public void retirerObjet(AObjet objet) {
		if (listeObjets.contains(objet)) {
			listeObjets.remove(objet);
		}
	}

	public int getTaille() {
		return listeObjets.size();
	}


}