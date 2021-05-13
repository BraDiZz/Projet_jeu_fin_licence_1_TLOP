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
    private Map map;
    private AHero[] hero;
    private String worldName;
    private int heroTurn = 0;
    /**
     * Constructeur par initialisation
     * @param mapSizeX int
     * @param mapSizeY int
     * @param seed long
     */
    
    public static void main(String[] args) {
        AHero[] mobs = {new Archer("A", 0, 0), new Chevalier("B", 0, 0), new Assassin("B", 0, 0)};
        new Game(new Map(4, 4, 56164), mobs, "hein");
    }

    public Game(Map map, AHero[] hero, String worldName) {
        this.map = map;
        this.hero = hero;
        this.worldName = worldName;

        init();

        loadChunk(map.getCurrentlyLoadedChunk());

        for (int i = 0; i < hero.length; i++) {
            map.spawnMob(hero[i], map.getCurrentlyLoadedChunk());
        }
        
        validate();
        repaint();
    }







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
        public void mouseClicked(MouseEvent me) {
            changePlayerPos(hero[heroTurn], direction);
            surroundMobSquaresWithListeners(hero[heroTurn], direction);
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

    class SelectSquare implements MouseListener{
        public void mouseClicked(MouseEvent me){
            Square test = (Square)me.getSource();
            test.setIsSelected(true);
            test.repaint();
        }

        public void mouseEntered(MouseEvent me){}
        public void mouseExited(MouseEvent me){}
        public void mousePressed(MouseEvent me){}
        public void mouseReleased(MouseEvent me){}
    }

    class NextTurn implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            heroTurn++;
            if (heroTurn == hero.length) {
                heroTurn = 0;
            }
            loadChunk(map.getChunkOfMob(hero[heroTurn]));
        }
    }





    public void init() {
        setSize(1200,900);
	    setLocationRelativeTo(null);
	    setTitle(worldName);
        setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainWindow = new JPanel();
        mainWindow.setBackground(Color.black);
        mainWindow.setLayout(new FlowLayout());

        grid.setLayout(new GridLayout(15, 15));
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(3,1));

        mainWindow.add(grid);
        
        mainWindow.add(info);
        info.setBorder(BorderFactory.createLineBorder(Color.black));
        info.setPreferredSize(new Dimension(350,800));
        
        JPanel preaction = new JPanel();
        preaction.setBackground(Color.black);

        info.add(hero[heroTurn].getInventaire());
        hero[heroTurn].getInventaire().setBackground(Color.white);

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
        JButton nextTurn = new JButton("Tour suivant");
        action.add(nextTurn);
        nextTurn.addActionListener(new NextTurn());
        JButton defend = new JButton("D\u00e9fense");
        action.add(defend);

		hero[heroTurn].getInventaire().setBorder(BorderFactory.createLineBorder(Color.red));

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

        getContentPane().add(mainWindow);
        setVisible(true);
            }
        }
    }

    /**
    * Methode pour changer de Chunk
    * @param chunk Chunk
    */
    public void loadChunk(Chunk chunk) {
        grid.removeAll();
        map.curChunkX = chunk.getChunkPosX();
        map.curChunkY = chunk.getChunkPosY();
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
    public void changePlayerPos(AHero hero, Direction direction) {
        int xBeforeChange = map.curChunkX;
        int yBeforeChange = map.curChunkY;
        map.changeMobPos(hero, direction);
        repaint();
        if (map.curChunkX != xBeforeChange ^ map.curChunkY != yBeforeChange) {
            loadChunk(map.getCurrentlyLoadedChunk());
            map.getCurrentlyLoadedChunk().spawnVilain(hero.getNiveau());
        }
    }

    public void surroundMobSquaresWithListeners(AHero hero, Direction direction) {
        for (Direction dir : Direction.values()) {
            Square squareBefore = map.getCurrentlyLoadedChunk().getContentAtPos((hero.squarePosX-direction.x)%15+dir.x, (hero.squarePosY-direction.y)%15+dir.y);
            Square square = map.getCurrentlyLoadedChunk().getContentAtPos(hero.squarePosX%15+dir.x, hero.squarePosY%15+dir.y);
            if (square != null) {
                square.addMouseListener(new SelectSquare());
                if (squareBefore != null && squareBefore.getMouseListeners().length != 0) {
                    squareBefore.removeMouseListener(squareBefore.getMouseListeners()[0]);
                }
            }
        }
    }
}