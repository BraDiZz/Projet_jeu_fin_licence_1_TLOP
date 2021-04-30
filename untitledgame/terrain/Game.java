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

        grid.setLayout(new GridLayout(15, 15));
        
        loadChunk(map.getChunkAtPos(curDisX, curDisY));

        

      
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

        JPanel touches = new JPanel();
        JPanel stats = new JPanel();

        commande.add(touches);
        touches.setBackground(Color.black);

        commande.add(stats);
        stats.setBackground(Color.black);

        JLabel[][] touche = new JLabel[3][3];

        JPanel pourCentrer = new JPanel();
        pourCentrer.setBackground(Color.black);
        pourCentrer.setPreferredSize(new Dimension(140,60));
        touches.add(pourCentrer);


        for(int i=0;i<3;i++){
        	for(int j=0;j<3;j++){
        		touche[i][j] = new JLabel();
        		touche[i][j].setBorder(BorderFactory.createLineBorder(Color.blue));  
        		touches.add(touche[i][j]);
        		touche[i][j].setPreferredSize(new Dimension(40,40));	
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