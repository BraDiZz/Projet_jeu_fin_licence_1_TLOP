package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import personnages.*;
import terrain.*;
import gamegui.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Game extends JFrame {
    /**
     * Un JPanel pour l'interface du monde
     */
    private JPanel grid = new JPanel();
    /**
     * Une Map pour la carte
     */
    private long seed;
    private String worldName;
    private AHero hero;
    private Map map;
    /**
     * Constructeur par initialisation
     * @param mapSizeX int
     * @param mapSizeY int
     * @param seed long
     */
    public Game(Map map, AHero hero, String worldName) {
        this.map = map;
        this.hero = hero;
        this.worldName = worldName;

        setSize(1200,900);
	    setLocationRelativeTo(null);
	    setTitle(worldName);
        setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel mainWindow = new JPanel();
        mainWindow.setBackground(Color.black);
        mainWindow.setLayout(new FlowLayout());

        grid.setLayout(new GridLayout(15, 15));
        
        loadChunk(map.getCurrentlyLoadedChunk());

        map.spawnMob(hero, map.getCurrentlyLoadedChunk());
        
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(3,1));

        mainWindow.add(grid);
        
        mainWindow.add(info);
        info.setBorder(BorderFactory.createLineBorder(Color.black));
        info.setPreferredSize(new Dimension(350,800));
        
        JPanel preaction = new JPanel();
        preaction.setBackground(Color.black);

        info.add(hero.getInventaire());
        hero.getInventaire().setBackground(Color.white);

        JPanel action = new JPanel();
        JPanel suraction = new JPanel();
        suraction.setLayout(new GridLayout(3,1));
        suraction.setBackground(Color.black);
        info.add(suraction);
        suraction.add(preaction);
        suraction.add(action);
        action.setLayout(new GridLayout(1,3));

        JButton attack = new JButton("Attaque");
        action.add(attack);
        JLabel milieu = new JLabel();
        action.add(milieu);
        milieu.setBackground(Color.black);
        JButton defend = new JButton("D\u00e9fense");
        action.add(defend);

		hero.getInventaire().setBorder(BorderFactory.createLineBorder(Color.red));

		JPanel commande = new JPanel();
        info.add(commande);

        commande.setLayout(new GridLayout(1,2));

        JPanel touches = new JPanel();
        touches.setBackground(new Color(255,220,155));
        JPanel stats = new JPanel();
        commande.add(touches);
        commande.add(stats);
        stats.setBackground(new Color(41,2,186));
        
        stats.setLayout(new GridLayout(3,3));

        JLabel att = new JLabel("attaque");
        att.setPreferredSize(new Dimension(50,50));
        att.setFont(new Font("Serif", Font.BOLD, 14));
        att.setForeground(new Color(255,131,0));
        JLabel att2 = new JLabel("80");
        att2.setPreferredSize(new Dimension(50,50));
        att2.setFont(new Font("Serif", Font.BOLD, 14));
        att2.setForeground(new Color(255,131,0));

        JLabel def = new JLabel("defense");
        def.setFont(new Font("Serif", Font.BOLD, 14));
        def.setForeground(new Color(3,127,252));
        JLabel def2 = new JLabel("80");
        def2.setFont(new Font("Serif", Font.BOLD, 14));
        def2.setForeground(new Color(3,127,252));

        JLabel autre = new JLabel("autre");
        autre.setFont(new Font("Serif", Font.BOLD, 14));
        autre.setForeground(new Color(255,0,162));
        JLabel autre2 = new JLabel("80");
        autre2.setFont(new Font("Serif", Font.BOLD, 14));
        autre2.setForeground(new Color(255,0,162));

        JLabel invisible1 = new JLabel();
        JLabel invisible2 = new JLabel();
        JLabel invisible3 = new JLabel();

        stats.add(invisible1);
        stats.add(att);
        stats.add(att2);
        stats.add(invisible2);
        stats.add(def);
        stats.add(def2);
        stats.add(invisible3);
        stats.add(autre);
        stats.add(autre2);

        JLabel bord = new JLabel();
        touches.add(bord);
        bord.setPreferredSize(new Dimension(200,47));



        JLabel[][] Fleche = new JLabel[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Fleche[i][j] = new Fleche("");
                Fleche[0][1]= new Fleche("haut");
                Fleche[1][0]= new Fleche("gauche");
                Fleche[1][2]= new Fleche("droite");
                Fleche[2][1]= new Fleche("bas");
                Fleche[i][j].repaint();
                Fleche[0][1].addMouseListener(new ChangeMapButton(Direction.UP));
                Fleche[2][1].addMouseListener(new ChangeMapButton(Direction.DOWN));
                Fleche[1][0].addMouseListener(new ChangeMapButton(Direction.LEFT));
                Fleche[1][2].addMouseListener(new ChangeMapButton(Direction.RIGHT));
                touches.add(Fleche[i][j]);
                Fleche[i][j].setPreferredSize(new Dimension(50,50));    
            }
        }

        /*for (Direction value: Direction.values()) {
            Fleche2 direction = new Fleche2(value);
            touches.add(direction, value.layout);
        }*/

        getContentPane().add(mainWindow);
        setVisible(true);
        }
    /**
     * Methode pour changer de Chunk
     * @param chunk Chunk
     */
    public void loadChunk(Chunk chunk) {
        grid.removeAll();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                grid.add(chunk.getContentAtPos(y, x));
            }
        }
        grid.validate();
        grid.repaint();
    }
    /**
     * Methode pour changer le joueur de position dans le monde
     * @param direction Direction
     */
    public void changePlayerPos(Direction direction){
        int xBeforeChange = map.curChunkX;
        int yBeforeChange = map.curChunkY;
        map.changeMobPos(hero, direction);
        repaint();
        if (map.curChunkX != xBeforeChange ^ map.curChunkY != yBeforeChange) {
            loadChunk(map.getCurrentlyLoadedChunk());
            map.getCurrentlyLoadedChunk().spawnVilain(player.getNiveau());
        }
    }
    /**
     * Class pour les fleches
     */
    class ChangeMapButton implements MouseListener{
        /**
         * Une Direction pour la direction du clique
         */
        private Direction direction;
        /**
         * Constructeur par initialisation
         * @param direction Direction
         */
        public ChangeMapButton(Direction direction) {
            this.direction = direction;
        }
        /**
         * Methode lorsque la souris est cliquee
         * @param me MouseEvent
         */
        public void mouseClicked(MouseEvent me){
            changePlayerPos(direction);
        }
        /**
         * Methode obligatoire pour que le programme puisse se lancer
         * @param me MouseEvent
         */
        public void mouseEntered(MouseEvent me){}
        /**
         * Methode obligatoire pour que le programme puisse se lancer
         * @param me MouseEvent
         */
        public void mouseExited(MouseEvent me){}
        /**
         * Methode lorsque le clique reste appuye
         * @param me MouseEvent
         */
        public void mousePressed(MouseEvent me){
            Fleche fleche=(Fleche) me.getSource();
            fleche.clique(true);
            fleche.repaint();
        }
        /**
         * Methode lorsque le clique est relache
         * @param me MouseEvent
         */
        public void mouseReleased(MouseEvent me){
            Fleche fleche=(Fleche) me.getSource();
            fleche.clique(false);
            fleche.repaint();
        }
    }
}