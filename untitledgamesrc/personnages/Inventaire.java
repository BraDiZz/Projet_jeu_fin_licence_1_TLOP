package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
import objets.*;
import main.Game;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* La classe inventaire contient un Vector d'objets, 
*/
public class Inventaire extends JPanel implements java.io.Serializable {
	/**
	 * Un Vector d'AObjet pour avoir la liste de tous les objets que le personnage possede
	 */
	private Vector<AObjet> listeObjets;
	private AHero hero;
	private AObjet currentSelected = null;
	/**
	 * Constructeur par defaut
	 */
	public Inventaire(AHero hero) {
		super(new GridBagLayout());
		this.hero = hero;
		this.setPreferredSize(new Dimension(252, 252));
		this.setOpaque(false);
		listeObjets = new Vector<AObjet>();
		addObjetToInv(new Buche(32));
		addObjetToInv(new Pomme(10));
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
			if (listeObjets.get(x).getMouseListeners().length != 0) {
				listeObjets.get(x).removeMouseListener(listeObjets.get(x).getMouseListeners()[0]);
			}
			test.gridx = x%4;
			test.gridy = (int)(x/4);
			this.add(listeObjets.get(x), test);
			listeObjets.get(x).addMouseListener(new SelectObjet());
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
		if (indexInInv == null) return false;
		
		// Si la somme du compte de tous les objets correspondants dans l'inventaire est inférieure à celle de l'objet passée en paramètre, on renvoie false
		int sumOfAll = 0;
		for (int i = 0; i < indexInInv.length; i++) {
			sumOfAll += listeObjets.get(indexInInv[i]).getCount();
		}
		if (objet.getCount() > sumOfAll) return false;

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
	/**
	 * Methode qui ajoute un objet a l'inventaire
	 * @param objet AObjet
	 */
	public void addObjetToInv(AObjet objet) {
		int[] indexInInv = whichAreNotFull(searchInInv(objet));

		if (indexInInv == null && listeObjets.size() != 16) {
			listeObjets.add(objet.createClone(0));
			indexInInv = new int[1];
			indexInInv[0] = listeObjets.size()-1;
		}

		if (indexInInv != null) {
			for (int i = 0; i < indexInInv.length; i++) {
				listeObjets.get(indexInInv[i]).addToStack(objet);
			}
			if (objet.getCount() != 0) {
				int countIteration = (int)(objet.getCount()/16);
				while (countIteration != 0 && listeObjets.size() != 16) {
					listeObjets.add(objet.createClone(16));
					objet.removeFromStack(16);
					countIteration--;
				}
				if (objet.getCount() != 0 && listeObjets.size() != 16) listeObjets.add(objet);
			}
			updateDisplay();
		}
	}
	/**
	 * Methode qui verifie si le nombre d'objet depasse 16 ou non
	 * @paramobjet AObjet
	 * @return boolean
	 */
	public boolean isStackFull(AObjet objet) {
		return objet.getCount() >= 16;
	}
	/**
	 * Methode qui verifie quels objets ont atteint la capacite maximum sur un emplacement et ceux qui ne l'ont pas encore atteinte
	 * @param indexInInv int[]
	 * @return int[]
	 */
	public int[] whichAreNotFull(int[] indexInInv) {
		if (indexInInv == null) return null;
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

	public void setSelectedItem(AObjet objet, boolean isSelected) {
        objet.setIsSelected(isSelected);
		objet.repaint();
    }

	/**
	 * Methode qui recherche le nombre de fois qu'il y a un objet dans l'inventaire
	 * @param objet AObjet
	 * @return int[]
	 */
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
	/**
	 * Methode pour 
	 * @param vector Vector<Integer>
	 * @return int[]
	 */
	public int[] vectorToIntTable(Vector<Integer> vector) {
		int[] table = new int[vector.size()];
		for (int i = 0; i < vector.size(); i++) {
			table[i] = vector.get(i);
		}
		return table;
	}

	public int[] getAvailableSpace(int[] indexInInv) {
		if (indexInInv == null) return null;
		int[] sum = new int[indexInInv.length];

		for (int i = 0; i < indexInInv.length; i++) {
			sum[i] = 16-listeObjets.get(indexInInv[i]).getCount();
		}

		return sum;
	}

	class SelectObjet implements MouseListener {
        /**
         * Methode lorsque la souris est cliquee
         * @param me MouseEvent
         */
        public void mouseClicked(MouseEvent me){
            AObjet objet = (AObjet)me.getSource();
			if (objet.getType().usable) {
				hero.consommerObjet(objet);
				retirerObjet(objet.createClone(1));
				Game mainWindow = (Game)(javax.swing.SwingUtilities.getWindowAncestor(Inventaire.this));
				mainWindow.updateStats();
			}
        }
        /**
         * Methode lorsque la souris est cliquee
         * @param me MouseEvent
         */
        public void mouseEntered(MouseEvent me) {
			AObjet objet = (AObjet)me.getSource();
			setSelectedItem(objet, true);
		}
        /**
         * Methode lorsque la souris est cliquee
         * @param me MouseEvent
         */
        public void mouseExited(MouseEvent me) {
			AObjet objet = (AObjet)me.getSource();
			setSelectedItem(objet, false);
		}
        /**
         * Methode lorsque la souris est cliquee
         * @param me MouseEvent
         */
        public void mousePressed(MouseEvent me){}
        /**
         * Methode lorsque la souris est cliquee
         * @param me MouseEvent
         */
        public void mouseReleased(MouseEvent me){}
    }
}