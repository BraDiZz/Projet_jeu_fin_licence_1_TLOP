package untitledgame.terrain;

import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
    private JPanel grid = new JPanel();
    private Map map;
    private int curDisX = 0;
    private int curDisY = 0;


    public Game(int mapSize, long seed) {
        setSize(1200,900);
	    setLocationRelativeTo(null);
	    setTitle("Game save name");
        setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        map = new Map(mapSize, mapSize, seed);
        
        JPanel mainWindow = new JPanel();
        mainWindow.setLayout(new FlowLayout());
        mainWindow.setBackground(Color.black);

        grid.setLayout(new GridLayout(15, 15));
        
        loadChunk(map.getChunkAtPos(curDisX, curDisY));

        

      
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(3,1));


        mainWindow.add(grid);
        mainWindow.add(info);
        
        info.setPreferredSize(new Dimension(350,780));
        
        JPanel preaction = new JPanel();
        preaction.setBackground(Color.black);
        JPanel inventaire = new JPanel();
        info.add(inventaire);
        inventaire.setBackground(Color.white);
        JPanel action = new JPanel();
        JPanel suraction = new JPanel();
        suraction.setLayout(new GridLayout(3,1));
        suraction.setBackground(Color.black);
        info.add(suraction);
        suraction.add(preaction);
        suraction.add(action);
        action.setLayout(new GridLayout(1,3));

        JButton attack = new JButton("attaque");
        action.add(attack);
        JPanel milieu = new JPanel();
        milieu.setBackground(Color.black);
        action.add(milieu);
        milieu.setBackground(Color.black);
        JButton defend = new JButton("defense");
        action.add(defend);


		JPanel commande = new JPanel();
        info.add(commande);
        commande.setBackground(Color.black);

        commande.setLayout(new GridLayout(1,2));

        JPanel touches = new JPanel();
        JPanel stats = new JPanel();

        commande.add(touches);
        touches.setBackground(Color.black);

        commande.add(stats);
        stats.setBackground(Color.white);

        JLabel[][] Fleche = new JLabel[3][3];

        JPanel pourCentrer = new JPanel();
        pourCentrer.setBackground(Color.black);
        pourCentrer.setPreferredSize(new Dimension(140,60));
        touches.add(pourCentrer);

        


        for(int i=0;i<3;i++){
        	for(int j=0;j<3;j++){
        		Fleche[i][j] = new Fleche("");
        		Fleche[0][1]= new Fleche("haut");
        		Fleche[1][0]= new Fleche("gauche");
        		Fleche[1][2]= new Fleche("droite");
        		Fleche[2][1]= new Fleche("bas");
        		Fleche[i][j].repaint();
        		touches.add(Fleche[i][j]);
        		Fleche[i][j].setPreferredSize(new Dimension(50,50));	
        	}
        }

        





        

        getContentPane().add(mainWindow);

	    setVisible(true);
    }

    public void loadChunk(Chunk chunk) {
        grid.removeAll();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                grid.add(chunk.getContentAtPos(x, y));
            }
        }
        grid.validate();
        grid.repaint();
    }

    public void changeMapChunk(Map map, int direction) {
        switch (direction) {
            case 0:
                if (curDisX < map.getSizeX()-1) {
                    curDisX++;
                }
                break;
            case 1:
                if (curDisY < map.getSizeY()-1) {
                    curDisY++;
                }
                break;
            case 2:
                if (curDisX > 0) {
                    curDisX--;
                }
                break;
            case 3:
                if (curDisY > 0) {
                    curDisY--;
                }
                break;
        }
        System.out.println(curDisX + " " + curDisY);
        loadChunk(map.getChunkAtPos(curDisX, curDisY));
    }

    class ChangeMapButton implements java.awt.event.ActionListener {
        private int direction;

        public ChangeMapButton(int direction) {
            this.direction = direction;
        }

        public void actionPerformed(java.awt.event.ActionEvent ev) {
            changeMapChunk(map, direction);
        }
    }
}