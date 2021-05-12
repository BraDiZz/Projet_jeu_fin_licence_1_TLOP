package personnages;

import objets.*;
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
		addObjetToInv(new Pomme(1));
		addObjetToInv(new Pomme(16));
		updateDisplay();
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
	public void updateDisplay() {
		this.removeAll();

		for (int i = 0; i < listeObjets.size(); i++) {
			if (listeObjets.get(i).getCount() == 0) {
				listeObjets.remove(i);
			}
		}

		GridBagConstraints test = new GridBagConstraints();
		test.gridx = 0;
		test.gridy = 0;
		test.insets = new Insets(5, 5, 5, 5);
		
		for (int x = 0; x < listeObjets.size(); x++) {
			test.gridx = x%4;
			test.gridy = (int)(x/4);
			this.add(listeObjets.get(x), test);
		}

		validate();
		repaint();
	}
	/**
	 * Methode pour retirer un objet de l'inventaire du personnage
	 * @param objet AObjet
	 */
	public boolean retirerObjet(AObjet objet) {
		// Si aucune occurence de l'objet n'est trouvée, on renvoie false
		int[] indexInInv = searchInInv(objet);
		if (indexInInv == null) {
			return false;
		}
		
		// Si la somme du compte de tous les objets correspondants dans l'inventaire est inférieure à celle de l'objet passée en paramètre, on renvoie false
		int sumOfAll = 0;
		for (int i = 0; i < indexInInv.length; i++) {
			sumOfAll += listeObjets.get(indexInInv[i]).getCount();
		}
		if (objet.getCount() > sumOfAll) {
			return false;
		}

		// Tant que le compteur d'objet en paramètre n'est pas égal à 0, on itère sur l'objet correspondant suivant et on lui retire le possible
		int iRem = 0;
		while(objet.getCount() != 0) {
			listeObjets.get(indexInInv[iRem]).removeFromStack(objet);
			iRem++;
		}

		// Si des objets ont atteint 0, on met à jour le panel
		if (iRem != 0) {
			updateDisplay();
		}
		
		return true;
	}

	public int getTaille() {
		return listeObjets.size();
	}

	public void addObjetToInv(AObjet objet) {
		int[] indexInInv = whichAreNotFull(searchInInv(objet));

		if (indexInInv != null) {
			int firstStackPos = indexInInv[0];
			AObjet firstStackItem = listeObjets.get(firstStackPos);
			if (firstStackItem.addToStack(objet) != 0) {
				if (listeObjets.size() < 16) {
					addObjetToInv(objet);
				}
			}
		} else {
			if (listeObjets.size() < 16) {
				listeObjets.add(objet);
			}
		}
		updateDisplay();
	}

	public boolean isStackFull(AObjet objet) {
		return objet.getCount() >= 16;
	}

	public int[] whichAreNotFull(int[] indexInInv) {
		if (indexInInv == null) {
			return null;
		}
		int count = 0;
		int[] whichAreNotFull;
		for (int i = 0; i < indexInInv.length; i++) {
			if (!(isStackFull(listeObjets.get(indexInInv[i])))) {
				count++;
			}
		}
		
		if (count == 0) {
			whichAreNotFull = null;
		} else {
			whichAreNotFull = new int[count];
			int y = 0;
			for (int i = 0; i < indexInInv.length; i++) {
				if (!(isStackFull(listeObjets.get(indexInInv[i])))) {
					whichAreNotFull[y] = indexInInv[i];
					y++;
				}
			}
		}

		return whichAreNotFull;
	}

	public int[] searchInInv(AObjet objet) {
		// Recherche du nombre d'occurences de l'objet dans le vecteur
		int timesInInv = 0;
		int[] indexInInv;
		for (int i = 0; i < listeObjets.size(); i++) {
			if (listeObjets.get(i).getType() == objet.getType()) {
				timesInInv++;
			}
		}

		// Si il n'y a aucune occurence, le tableau est null. Autrement, on liste toutes les occurences dans le tableau.
		if (timesInInv == 0) {
			indexInInv = null;
		} else {
			int y = 0;
			indexInInv = new int[timesInInv];
			for (int i = 0; i < listeObjets.size(); i++) {
				if (listeObjets.get(i).getType() == objet.getType()) {
					indexInInv[y] = i;
					y++;
				}
			}
		}

		return indexInInv;
	}

	public int[] vectorToIntTable(Vector<Integer> vector) {
		int[] table = new int[vector.size()];
		for (int i = 0; i < vector.size(); i++) {
			table[i] = vector.get(i);
		}
		return table;
	}
}