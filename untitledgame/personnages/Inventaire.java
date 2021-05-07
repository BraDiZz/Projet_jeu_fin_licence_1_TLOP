package untitledgame.personnages;

import untitledgame.objets.AObjet;
import java.util.Vector;

/**
* La classe inventaire contient un Vector d'objets, 
*/
public class Inventaire {
	private Vector<AObjet> listeObjets;
	private int tailleMax = 10;

	public Inventaire() {
		listeObjets = new Vector<AObjet>();
	}

	public Vector<AObjet> getInventaire() {
		return listeObjets;
	}

	public void ajouterObjet(AObjet objet) {
		if (listeObjets.size() < 10) {
			listeObjets.add(objet);
		}
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