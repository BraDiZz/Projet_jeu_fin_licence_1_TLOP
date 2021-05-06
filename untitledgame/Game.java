package untitledgame;

import java.awt.*;
import javax.swing.*;
<<<<<<< HEAD
import untitledgame.personnages.*;
import untitledgame.terrain.*;
=======
import java.awt.event.*;
import untitledgame.personnages.*;
import untitledgame.terrain.*;
import untitledgame.objets.*;
>>>>>>> main

public class Game extends JFrame {
    private JPanel grid = new JPanel();
    private Map map;
<<<<<<< HEAD
    private APersonnage mob = new Archer("A");
=======
    private APersonnage player;
>>>>>>> main

    public static void main(String[] args) {
        new Game(4, 5, 564564l);
    }

    public Game(int mapSizeX, int mapSizeY, long seed) {
        setSize(1200,900);
	    setLocationRelativeTo(null);
	    setTitle("Game save name");
        setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
<<<<<<< HEAD
=======
        player = new Archer();
>>>>>>> main

        map = new Map(mapSizeX, mapSizeY, seed);
        
        JPanel mainWindow = new JPanel();
<<<<<<< HEAD
=======
        mainWindow.setBackground(Color.black);
>>>>>>> main
        mainWindow.setLayout(new FlowLayout());

        grid.setLayout(new GridLayout(15, 15));
        
        loadChunk(map.getCurrentlyLoadedChunk());

<<<<<<< HEAD
        map.addMobAtPos(mob, map.getCurrentlyLoadedChunk(), 0, 0);
=======
        map.addMobAtPos(player, map.getCurrentlyLoadedChunk(), 0, 0);
>>>>>>> main

        JPanel info = new JPanel();
        info.setLayout(new GridLayout(3,1));

        mainWindow.add(grid);
        grid.setBorder(BorderFactory.createLineBorder(Color.blue));
        mainWindow.add(info);
        info.setBorder(BorderFactory.createLineBorder(Color.red));
        info.setPreferredSize(new Dimension(350,800));
        
        JPanel preaction = new JPanel();
        preaction.setBackground(Color.black);
        JPanel inventaire = new JPanel();
        info.add(inventaire);
        inventaire.setBackground(Color.black);
        JPanel action = new JPanel();
        JPanel suraction = new JPanel();
        suraction.setLayout(new GridLayout(3,1));
<<<<<<< HEAD
=======
        suraction.setBackground(Color.black);
>>>>>>> main
        info.add(suraction);
        suraction.add(preaction);
        suraction.add(action);
        action.setLayout(new GridLayout(1,3));

        JButton attack = new JButton("attaque");
        action.add(attack);
        JLabel milieu = new JLabel();
        action.add(milieu);
        milieu.setBackground(Color.black);
        JButton defend = new JButton("defense");
        action.add(defend);

		inventaire.setBorder(BorderFactory.createLineBorder(Color.red));

		JPanel commande = new JPanel();
        info.add(commande);

        commande.setLayout(new GridLayout(1,2));

<<<<<<< HEAD
        JPanel touches = new JPanel(new BorderLayout());
        commande.add(touches);
        JPanel stats = new JPanel();

        touches.setBackground(Color.black);

        commande.add(stats);
        stats.setBackground(Color.black);

        for (Direction value: Direction.values()) {
            JButton direction = new JButton(value.label);
            direction.addActionListener(new ChangeMapButton(value));
            direction.setPreferredSize(new Dimension(80, 80));
            touches.add(direction, value.layout);
        }

        getContentPane().add(mainWindow);

	    setVisible(true);
=======
        JPanel touches = new JPanel();
        touches.setBackground(Color.black);
        commande.add(touches);
        JPanel stats = new JPanel();

        commande.add(stats);
        stats.setBackground(Color.black);

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
>>>>>>> main
    }

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

<<<<<<< HEAD
    public void changePlayerPos(Direction direction) {
        int xBeforeChange = map.curChunkX;
        int yBeforeChange = map.curChunkY;
        map.changeMobPos(mob, direction);
=======
    public void changePlayerPos(Direction direction){
        int xBeforeChange = map.curChunkX;
        int yBeforeChange = map.curChunkY;
        map.changeMobPos(player, direction);
>>>>>>> main
        repaint();
        if (map.curChunkX != xBeforeChange ^ map.curChunkY != yBeforeChange) {
            loadChunk(map.getCurrentlyLoadedChunk());
        }
    }

<<<<<<< HEAD
    class ChangeMapButton implements java.awt.event.ActionListener {
=======
    class ChangeMapButton implements MouseListener{
>>>>>>> main
        private Direction direction;

        public ChangeMapButton(Direction direction) {
            this.direction = direction;
        }
<<<<<<< HEAD

        public void actionPerformed(java.awt.event.ActionEvent ev) {
            changePlayerPos(direction);
        }
=======
        public void mouseClicked(MouseEvent me){
            changePlayerPos(direction);
        }
        public void mouseEntered(MouseEvent me){}
        public void mouseExited(MouseEvent me){}
        public void mousePressed(MouseEvent me){
            Fleche fleche=(Fleche) me.getSource();
            fleche.clique(true);
            fleche.repaint();
        }
        public void mouseReleased(MouseEvent me){
            Fleche fleche=(Fleche) me.getSource();
            fleche.clique(false);
            fleche.repaint();
            
        }
>>>>>>> main
    }
}