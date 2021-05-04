import untitledgame.Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import untitledgame.titlescreen.JBackgroundPanel;

public class Main extends JFrame {
    private JBackgroundPanel mainWindow = new JBackgroundPanel("assets/titlescreen/background.png", new GridBagLayout());
    private JTextField worldName = new JTextField();
    private JTextField seed = new JTextField();
    private JTextField sizeX = new JTextField();
    private JTextField sizeY = new JTextField();
    private JTextField characterName = new JTextField();
    private String[] type = {"Archer", "Assassin", "Chevalier"};
    private JComboBox characterType = new JComboBox(type);

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        init();
        mainMenu();
    }

    public void init() {
        int windowWidth = 1280;
        int windowHeight = 720;

        setContentPane(mainWindow);
        setSize(windowWidth, windowHeight);
	    setLocationRelativeTo(null);
        setResizable(false);
	    setTitle("Untitled Game");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

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
        JBackgroundPanel title = new JBackgroundPanel("assets/titlescreen/title.png");
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
        menuButtonList[2].addActionListener(new QuitButton());

        mainWindow.add(menuButtons, center);
        mainWindow.add(title, top);

        validate();
        repaint();
    }

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

        JPanel centerArea = new JPanel(new GridLayout(2, 1));

        JPanel sizeContainer = new JPanel();
        sizeX.setPreferredSize(new Dimension(50, 25));
        sizeY.setPreferredSize(new Dimension(50, 25));
        sizeContainer.add(new JLabel("Largeur du monde:"));
        sizeContainer.add(sizeX);
        sizeContainer.add(new JLabel("Hauteur du monde:"));
        sizeContainer.add(sizeY);

        JPanel characterContainer = new JPanel();
        characterName.setPreferredSize(new Dimension(75, 25));
        characterContainer.add(new JLabel("Nom du personnage:"));
        characterContainer.add(characterName);
        characterContainer.add(new JLabel("Type du personnage:"));
        characterContainer.add(characterType);

        centerArea.add(sizeContainer);
        centerArea.add(characterContainer);

        GridBagConstraints bottom = new GridBagConstraints();
        bottom.gridx = 1;
        bottom.gridy = 2;

        JPanel bottomArea = new JPanel();
        JButton[] actions = {new JButton("Créer le monde"), new JButton("Retour")};

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

    public boolean validateWorld() {
        boolean verify = true;
        String[] fields = {worldName.getText(), seed.getText(), sizeX.getText(), sizeY.getText(), characterName.getText()};
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

    public class QuitButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class ValidateWorldSettings implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (validateWorld()) {
                setVisible(false);
                new Game(Integer.parseInt(sizeX.getText()), Integer.parseInt(sizeY.getText()), Long.parseLong(seed.getText()));
            }
        }
    }

    public class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainMenu();
        }
    }
    

    public class CreateWorldButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            createWorld();
        }
    }
}