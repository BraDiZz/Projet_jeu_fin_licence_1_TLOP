package untitledgame.personnages;

import untitledgame.objets.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;

/**
* La classe inventaire contient un Vector d'objets, 
*/
public class Inventaire extends JPanel {
	private Vector<AObjet> listeObjets;
	private int tailleMax = 10;

	public Inventaire() {
		super(new GridBagLayout());
		listeObjets = new Vector<AObjet>();
		addItemsToInv();
	}

	public Vector<AObjet> getInventaire() {
		return listeObjets;
	}

	public void addItemsToInv() {
		listeObjets.add(new Poulet());
		listeObjets.add(new Potion());
		listeObjets.add(new Pain());
		listeObjets.add(new Pomme());
		listeObjets.add(new Superpotion());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		GridBagConstraints test = new GridBagConstraints();
		test.gridx = 0;
		test.gridy = 0;
		test.insets = new Insets(5, 5, 5, 5);
		
		for (int x = 0; x < listeObjets.size(); x++) {
			test.gridx = x%4;
			test.gridy = (int)(x/4);
			this.add(listeObjets.get(x), test);
		}
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