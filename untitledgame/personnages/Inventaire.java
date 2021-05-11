package untitledgame.personnages;

import untitledgame.objets.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;

/**
* La classe inventaire contient un Vector d'objets, 
*/
public class Inventaire extends JPanel {
	/**
	 * Un Vector d'AObjet pour avoir la liste de tous les objets que le personnage possede
	 */
	private Vector<AObjet> listeObjets;
	/**
	 * Un int pour le nombre maximum que le personnage peut transporter
	 */
	private int tailleMax = 10;
	/**
	 * Constructeur par defaut
	 */
	public Inventaire() {
		super(new GridBagLayout());
		listeObjets = new Vector<AObjet>();
		addItemsToInv();
	}
	/**
	 * Getter pour la liste des objets dans l'inventaire du personnage
	 * @return Vector<AObjet>
	 */
	public Vector<AObjet> getInventaire() {
		return listeObjets;
	}
	/**
	 * Methode pour ajouter plusieurs objets dans l'inventaire
	 */
	public void addItemsToInv() {
		listeObjets.add(new Poulet());
		listeObjets.add(new Potion());
		listeObjets.add(new Pain());
		listeObjets.add(new Pomme());
		listeObjets.add(new Superpotion());
		listeObjets.add(new Buche());
		/*listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());
		listeObjets.add(new Pain());*/
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
	/**
	 * Methode pour ajouter un objet dans l'inventaire du personnage
	 * @param objet AObjet
	 */
	public void ajouterObjet(AObjet objet) {
		if (listeObjets.size() < 10) {
			listeObjets.add(objet);
		}
	}
	/**
	 * Methode pour retirer un objet de l'inventaire du personnage
	 * @param objet AObjet
	 */
	public void retirerObjet(AObjet objet) {
		if (listeObjets.contains(objet)) {
			listeObjets.remove(objet);
		}
	}

	public int getTaille() {
		return listeObjets.size();
	}
}