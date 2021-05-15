package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import personnages.*;
import terrain.*;
import gamegui.*;
import save.*;
import objets.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Game extends JFrame {
    /**
     * Un JPanel pour l'interface du monde
     */
    private JPanel grid = new JPanel();
    private JPanel inventory = new JPanel();
    /**
     * Une Map pour la carte
     */
    private Map map;
    private AHero[] hero;
    private String worldName;
    private int heroTurn = 0;
    private JLabel experience = new JLabel();
    private JLabel pv = new JLabel();
    private JLabel att = new JLabel();
    private JLabel def = new JLabel();
    private JLabel niveau = new JLabel();
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

        for (int i = 0; i < hero.length; i++) {
            map.spawnMob(hero[i]);
        }

        loadChunk(map.getCurrentlyLoadedChunk());

        inventory.add(hero[heroTurn].getInventaire());
        
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
            inventory.removeAll();
            inventory.add(hero[heroTurn].getInventaire());
            inventory.validate();
            inventory.repaint();
            updateStats();
        }
    }

    class Save implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GameSave save = new GameSave(map, hero, worldName);
            CustomSerializeObject.serialize(save, worldName + ".txt");
        }
    }





    public void init() {
        setSize(1200,900);
	    setLocationRelativeTo(null);
	    setTitle(worldName);
        setResizable(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainWindow = new JPanel();
        mainWindow.setBackground(Color.black);
        mainWindow.setLayout(new FlowLayout());         



        grid.setLayout(new GridLayout(15, 15));
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(3,1));

        mainWindow.add(grid);
        mainWindow.add(info);
        JButton save = new JButton("Sauvegarder");
        save.addActionListener(new Save());
        mainWindow.add(save);
        info.setBorder(BorderFactory.createLineBorder(Color.black));
        info.setPreferredSize(new Dimension(350,800));
        
        JPanel preaction = new JPanel();
        preaction.setBackground(Color.black);

        info.add(inventory);
        inventory.setBackground(Color.white);
		inventory.setBorder(BorderFactory.createLineBorder(Color.red));

        JPanel action = new JPanel();
        JPanel suraction = new JPanel();
        suraction.setLayout(new GridLayout(3,1));
        suraction.setBackground(Color.black);
        info.add(suraction);
        suraction.add(preaction);
        suraction.add(action);
        action.setLayout(new GridLayout(1,3));


        JButton attack = new JButton("Attaque");
        attack.addActionListener(new Attaquer());
        action.add(attack);
        JLabel milieu = new JLabel();;
        milieu.setOpaque(true);
        action.add(milieu);
        milieu.setBackground(Color.black);
        JButton defend = new JButton("D\u00e9fense");
        action.add(defend);
        
		JPanel commande = new JPanel();
        info.add(commande);

        commande.setLayout(new GridLayout(1,2));

        JPanel touches = new JPanel();
        touches.setBackground(Color.black);
        JPanel stats = new JPanel();
        commande.add(touches);
        commande.add(stats);
        stats.setBackground(Color.black);
        
        stats.setLayout(new GridLayout(5,2));

        pv.setText("Vie " + hero[heroTurn].getPointDeVie() + "/" + hero[heroTurn].getPointDeVieMax());
        pv.setFont(new Font("Serif", Font.BOLD, 16));
        pv.setForeground(new Color(27,144,0));
        
        att.setText("Attaque " + hero[heroTurn].getAttaque());
        att.setPreferredSize(new Dimension(50,50));
        att.setFont(new Font("Serif", Font.BOLD, 16));
        att.setForeground(new Color(255,131,0));
        
        def.setText("Defense " + hero[heroTurn].getArmure());
        def.setFont(new Font("Serif", Font.BOLD, 16));
        def.setForeground(new Color(3,127,252));
        
        experience.setText("Niveau " + hero[heroTurn].getNiveau());
        experience.setFont(new Font("Serif", Font.BOLD, 16));
        experience.setForeground(new Color(255,0,162));

        niveau.setText("Niveau " + hero[heroTurn].getNiveau());
        niveau.setFont(new Font("Serif", Font.BOLD, 16));
        niveau.setForeground(new Color(255,0,162));

        experience.setText("XP " + hero[heroTurn].getXp() + "/" + hero[heroTurn].getXpAAtteindre());
        experience.setFont(new Font("Serif", Font.BOLD, 16));
        experience.setForeground(Color.white);
        
        JLabel invisible1 = new JLabel();
        JLabel invisible2 = new JLabel();
        JLabel invisible3 = new JLabel();
        JLabel invisible4 = new JLabel();
        JLabel invisible5 = new JLabel();

        stats.add(invisible1);
        stats.add(pv);
        
        stats.add(invisible2);
        stats.add(att);
        
        stats.add(invisible3);
        stats.add(def);
        
        stats.add(invisible4);
        stats.add(experience);

        stats.add(invisible5);
        stats.add(niveau);

        JLabel bord = new JLabel();
        JButton nextTurn = new JButton("Tour suivant");
        nextTurn.addActionListener(new NextTurn());
        touches.add(nextTurn);
        touches.add(bord);
        bord.setPreferredSize(new Dimension(200,27));

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
        getContentPane().add(mainWindow);
        setVisible(true);
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
            map.getCurrentlyLoadedChunk().spawnVilains(hero.getNiveau());
            map.getCurrentlyLoadedChunk().spawnBoss(hero.getNiveau());
        }
        map.moveVilains(hero);
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

    public class Attaquer implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AVilain target = map.vilainAAttaquer(hero[heroTurn]);
            if (target != null) {
                if (hero[heroTurn].monstreVaincu(target)) {
                    map.getChunkOfMob(target).killVillain(target);
                    dropItem();
                    if (target.getMobType() == MobType.BOSS) {
                        new Fin();
                    }
                }
                if (target.heroVaincu(hero[heroTurn])) {
                    System.out.println("Le hero est vaincu, vous avez perdu...");
                    new Gameover();
                }
            }
            updateStats();
        }
    }

    public void updateStats(){
        pv.setText("Vie " + hero[heroTurn].getPointDeVie() + "/" + hero[heroTurn].getPointDeVieMax());
        if(hero[heroTurn].getPointDeVie()<0){pv.setText("Vie " + "0/"+ hero[heroTurn].getPointDeVieMax());}
        att.setText("Attaque " + hero[heroTurn].getAttaque());
        def.setText("Defense " + hero[heroTurn].getArmure());
        niveau.setText("Niveau " + hero[heroTurn].getNiveau());
        experience.setText("XP " + hero[heroTurn].getXp() + "/" + hero[heroTurn].getXpAAtteindre());
    }

    public void dropItem(){
        int drop = 0 + (int)(Math.random() * ((5 - 0) + 1));
        System.out.println("drop : " + drop);
        switch(drop){
            case 0:
                hero[heroTurn].getInventaire().addObjetToInv(new Jus(1));
                break;
            case 1:
                hero[heroTurn].getInventaire().addObjetToInv(new Pomme(1));
                break;
            case 2:
                hero[heroTurn].getInventaire().addObjetToInv(new Potion(1));
                break;
            case 3:
                hero[heroTurn].getInventaire().addObjetToInv(new Pain(1));
                break;
            case 4:
                hero[heroTurn].getInventaire().addObjetToInv(new Superpotion(1));
                break;
            case 5:
                hero[heroTurn].getInventaire().addObjetToInv(new Poulet(1));
                break;
        }
    }
}