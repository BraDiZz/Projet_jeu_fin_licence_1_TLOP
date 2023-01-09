package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import titlescreen.JBackgroundPanel;
import terrain.*;
import save.*;
import personnages.*;
import save.CustomSerializeObject;
import java.io.File;
import java.io.StreamCorruptedException;

/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Main extends JFrame {
    /**
     * Un JBackgroudPanel pour le fond de la fenetre de demarrage
     */
    private JBackgroundPanel mainWindow = new JBackgroundPanel("/assets/background.png", new GridBagLayout());
    /**
     * Un JPanel pour le centre de la fenêtre
     */
    private JPanel centerArea = new JPanel(new GridLayout(5, 1));
    /**
     * Un JPanel pour le bouton ajouter un personnage
     */
    private JButton addCharacter = new JButton("Ajouter un personnage");
    /**
     * Un int pour le nombre de personnage que le joueur a choisi
     */
    private int characterNumber = 0;
    /**
     * Un JTextField pour le nom du monde
     */
    private JTextField worldName = new JTextField();
    /**
     * Un JTextField pour la seed
     */
    private JTextField seed = new JTextField();
    /**
     * Un JTextField pour la taille du monde en longueur
     */
    private JTextField sizeX = new JTextField();
    /**
     * Un JTextField pour la taille du monde en largeur
     */
    private JTextField sizeY = new JTextField();
    /**
     * Un JTextField pour le nom du personnage
     */
    private JTextField[] characterName = {new JTextField(), new JTextField(), new JTextField()};
    /**
     * Un tableau de String pour le type du APersonnage
     */
    private String[] type = {"Archer", "Assassin", "Chevalier"};
    /**
     * Un JComboBox pour le choix de tous les types de APersonnage
     */
    private JComboBox[] characterType = {new JComboBox(type), new JComboBox(type), new JComboBox(type)};
    /**
     * Methode pour executer le programme
     * @param args String[]
     */
    public static void main(String[] args) {
        new Main();
    }
    /**
     * Constructeur par defaut
     */
    public Main() {
        init();
        mainMenu();
    }
    /**
     * Methode pour creer la fenetre et initialiser toutes les fonctions de base
     */
    public void init() {
        int windowWidth = 1280;
        int windowHeight = 720;

        setContentPane(mainWindow);
        setSize(windowWidth, windowHeight);
	    setLocationRelativeTo(null);
        setResizable(false);
	    setTitle("The Legend of Perlin");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     * Methode pour creer l'interface du menu dans la fenetre
     */
    public void mainMenu() {
        mainWindow.removeAll();

        GridBagConstraints center = new GridBagConstraints();
        center.gridx = 1;
        center.gridy = 1;
        center.fill = GridBagConstraints.HORIZONTAL;
        center.insets = new Insets(75, 75, 75, 75);

        GridBagConstraints top = new GridBagConstraints();
        top.gridx = 1;
        top.gridy = 0;
        top.gridwidth = 3;
        top.fill = GridBagConstraints.HORIZONTAL;

        JPanel menuButtons = new JPanel(new BorderLayout(10, 20));
        JBackgroundPanel title = new JBackgroundPanel("/assets/title.png");
        title.setRatio(0.8);

        menuButtons.setOpaque(false);

        JButton[] menuButtonList = {new JButton("Nouvelle partie"), new JButton("Charger une partie"), new JButton("Quitter")};

        for (JButton button : menuButtonList) {
            button.setPreferredSize(new Dimension(150, 30));
        }

        menuButtons.add(menuButtonList[0], BorderLayout.LINE_START);
        menuButtons.add(menuButtonList[1], BorderLayout.LINE_END);
        menuButtons.add(menuButtonList[2], BorderLayout.PAGE_END);

        menuButtonList[0].addActionListener(new CreateWorldButton());
        menuButtonList[1].addActionListener(new LoadWorldButton());
        menuButtonList[2].addActionListener(new QuitButton());

        mainWindow.add(menuButtons, center);
        mainWindow.add(title, top);

        validate();
        repaint();
    }
    /**
     * Methode pour creer l'interface du monde dans la fenetre
     */
    public void createWorld() {
        mainWindow.removeAll();

        GridBagConstraints top = new GridBagConstraints();
        top.gridx = 1;
        top.gridy = 0;

        JPanel topArea = new JPanel(new GridLayout(2, 1));

        JPanel worldNameContainer = new JPanel();
        worldName.setPreferredSize(new Dimension(200, 25));
        worldNameContainer.add(new JLabel("Nom du monde:"));
        worldNameContainer.add(worldName);

        JPanel seedContainer = new JPanel();
        seed.setPreferredSize(new Dimension(200, 25));
        seedContainer.add(new JLabel("Seed du monde:"));
        seedContainer.add(seed);

        topArea.add(worldNameContainer);
        topArea.add(seedContainer);

        GridBagConstraints center = new GridBagConstraints();
        center.gridx = 1;
        center.gridy = 1;
        center.insets = new Insets(25, 0, 25, 0);

        JPanel sizeContainer = new JPanel();
        sizeX.setPreferredSize(new Dimension(50, 25));
        sizeY.setPreferredSize(new Dimension(50, 25));
        sizeContainer.add(new JLabel("Largeur du monde:"));
        sizeContainer.add(sizeX);
        sizeContainer.add(new JLabel("Hauteur du monde:"));
        sizeContainer.add(sizeY);
        centerArea.add(sizeContainer);

        addCharacter.addActionListener(new AddCharacterButton());
        centerArea.add(addCharacter);

        addCharacter();


        GridBagConstraints bottom = new GridBagConstraints();
        bottom.gridx = 1;
        bottom.gridy = 2;

        JPanel bottomArea = new JPanel();
        JButton[] actions = {new JButton("Cr\u00e9er le monde"), new JButton("Retour")};

        for (JButton x : actions) {
            x.setPreferredSize(new Dimension(150, 25));
            bottomArea.add(x);
        }

        actions[0].addActionListener(new ValidateWorldSettings());
        actions[1].addActionListener(new BackButton());

        mainWindow.add(topArea, top);
        mainWindow.add(centerArea, center);
        mainWindow.add(bottomArea, bottom);

        validate();
        repaint();
    }
    /**
     * Methode pour verifier que tous les JTextField soient bien remplis
     * @return boolean
     */
    public boolean validateWorld() {
        boolean verify = true;
        String[] f = {worldName.getText(), seed.getText(), sizeX.getText(), sizeY.getText()};
        String[] fields = new String[f.length+characterNumber];
        for (int i = 0; i < f.length; i++) fields[i] = f[i];
        for (int i = f.length; i < fields.length; i++) {
            fields[i] = characterName[i-f.length].getText();
        }

        try {
            for (String x : fields) {
                if (x.trim().equals("")) {
                    throw new IllegalArgumentException("Empty field !");
                }
            }
            Long.parseLong(fields[1]);
            Integer.parseInt(fields[2]);
            Integer.parseInt(fields[3]);
        } catch(NumberFormatException err) {
            JOptionPane.showMessageDialog(this, "L'un des champs est incorrect :(");
            return false;
        } catch(IllegalArgumentException err) {
            JOptionPane.showMessageDialog(this, "L'un des champs est vide :(");
            return false;
        }

        return(verify);
    }
    /**
     * Methode pour ajouter un personnage
     */
    public void addCharacter() {
        if (characterNumber <= 2) {
            JPanel characterContainer = new JPanel();
            characterName[characterNumber].setPreferredSize(new Dimension(75, 25));
            characterContainer.add(new JLabel("Nom du personnage:"));
            characterContainer.add(characterName[characterNumber]);
            characterContainer.add(new JLabel("Type du personnage:"));
            characterContainer.add(characterType[characterNumber]);
            centerArea.add(characterContainer);
            centerArea.validate();
            centerArea.repaint();
            characterNumber++;
            if (characterNumber == 3) {
                addCharacter.setEnabled(false);
            }
        }
    }
    /**
     * Class pour le bouton "Quitter"
     */
    public class QuitButton implements ActionListener {
        /**
         * Methode lorsque le bouton est clique
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    /**
     * Class pour le bouton "Creer le monde"
     */
    public class ValidateWorldSettings implements ActionListener {
        /**
         * Methode lorsque le bouton est clique
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            validateWorld();
            if (validateWorld()) {
                setVisible(false);
                Map map = new Map(Integer.parseInt(sizeX.getText()), Integer.parseInt(sizeY.getText()), Long.parseLong(seed.getText()));
                String gameWorldName = worldName.getText();
                AHero[] heroes = new AHero[characterNumber];

                for (int i = 0; i < heroes.length; i++) {
                    String playerType = characterType[i].getSelectedItem().toString();
                    AHero hero;
                    if (playerType == MobType.ARCHER.defaultName) {
                        hero = new Archer(characterName[i].getText(), -1, -1);
                    } else if (playerType == MobType.MURDERER.defaultName) {
                        hero = new Assassin(characterName[i].getText(), -1, -1);
                    } else {
                        hero = new Chevalier(characterName[i].getText(), -1, -1);
                    }
                    heroes[i] = hero;
                }
                new Game(map, heroes, gameWorldName);
                new Histoire();
            }
        }
    }
    /**
     * Class pour le bouton "Retour"
     */
    public class BackButton implements ActionListener {
        /**
         * Methode lorsque le bouton est clique
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            mainMenu();
            centerArea.removeAll();
            addCharacter.setEnabled(true);
            addCharacter.removeActionListener(addCharacter.getActionListeners()[0]);
            characterNumber = 0;
        }
    }
    /**
     * Class pour le bouton Ajouter un personnage
     */
    public class AddCharacterButton implements ActionListener {
        /**
         * Methode lorsque le bouton est clique
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            addCharacter();
        }
    }
    /**
     * Class pour le bouton "Nouvelle partie"
     */
    public class CreateWorldButton implements ActionListener {
        /**
         * Methode lorsque le bouton est clique
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            createWorld();
        }
    }
    /**
     * Class pour le bouton Charger monde
     */
    public class LoadWorldButton implements ActionListener {
        /**
         * Methode lorsque le bouton est clique
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(mainWindow);
            File file = fileChooser.getSelectedFile();
            if (file != null) {
                GameSave save = (GameSave)(CustomSerializeObject.deserialize(file));
                if (save == null) {
                    JOptionPane.showMessageDialog(Main.this, "Le fichier de sauvegarde est corrompu ou incorrect :(");
                } else {
                    setVisible(false);
                    new Game(save.getMap(), save.getHeroes(), save.getWorldName(), save.getHeroTurn(), save.getBossSpawned());
                }
            }
        }
    }
}