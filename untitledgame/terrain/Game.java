package untitledgame.terrain;

import java.awt.*;
import javax.swing.*;
import untitledgame.personnages.*;

public class Game extends JFrame {
    private JPanel grid = new JPanel();
    private Map map;
    private APersonnage mob = new Archer("A");

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
        
        loadChunk(map.getCurrentlyLoadedChunk());

        map.addPlayerAtPos(mob, 0, 0);

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

    public void changePlayerPos(Direction direction) {
        Chunk curChunk = map.getCurrentlyLoadedChunk();
        curChunk.changeMobPos(mob, direction);
        repaint();
    }

    class ChangeMapButton implements java.awt.event.ActionListener {
        private Direction direction;

        public ChangeMapButton(Direction direction) {
            this.direction = direction;
        }

        public void actionPerformed(java.awt.event.ActionEvent ev) {
            changePlayerPos(direction);
            System.out.println(mob.squarePosX + " " + mob.squarePosY);
        }
    }
}