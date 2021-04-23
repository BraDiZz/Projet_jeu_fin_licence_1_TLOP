package untitledgame;

import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
    public Game() {
        setSize(400,200);
        setLocationRelativeTo(null);
        setTitle("Game save name");
        setMinimumSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int a = 30;
        //taille des label des bordure1
        int b = 100;
        //taille des label des bordure2

        JLabel label1 = new JLabel();
        label1.setPreferredSize(new Dimension(10,a));
        label1.setBackground(Color.black);
        label1.setOpaque(true);
        JLabel label2 = new JLabel();
        label2.setPreferredSize(new Dimension(10,a));
        label2.setBackground(Color.black);
        label2.setOpaque(true);
        JLabel label3 = new JLabel();
        label3.setPreferredSize(new Dimension(a,10));
        label3.setBackground(Color.black);
        label3.setOpaque(true);
        //bordure1

        JLabel label4 = new JLabel();
        label4.setPreferredSize(new Dimension(10,b));
        label4.setBackground(Color.black);
        label4.setOpaque(true);
        JLabel label5 = new JLabel();
        label5.setPreferredSize(new Dimension(10,b));
        label5.setBackground(Color.black);
        label5.setOpaque(true);
        JLabel label6 = new JLabel();
        label6.setPreferredSize(new Dimension(b,10));
        label6.setBackground(Color.black);
        label6.setOpaque(true);
        JLabel label7 = new JLabel();
        label7.setPreferredSize(new Dimension(b,10));
        label7.setBackground(Color.black);
        label7.setOpaque(true);
        //bordure2
        

        JPanel panneauGlobal = new JPanel();
        JPanel control = new JPanel();
        JPanel grid = new JPanel();
        JPanel bordure1 = new JPanel();
        JPanel bordure2 = new JPanel();

        panneauGlobal.setLayout(new GridLayout());
        bordure1.setLayout(new BorderLayout());
        bordure2.setLayout(new BorderLayout());
        grid.setLayout(new GridLayout(15, 15));
        grid.setBorder(BorderFactory.createLineBorder(Color.black));

        bordure1.add(label1,BorderLayout.NORTH);
        bordure1.add(label2,BorderLayout.SOUTH);
        bordure1.add(label3,BorderLayout.WEST);

        bordure2.add(label4,BorderLayout.NORTH);
        bordure2.add(label5,BorderLayout.SOUTH);
        bordure2.add(label6,BorderLayout.WEST);
        bordure2.add(label7,BorderLayout.EAST);

        control.setLayout(new GridLayout(8,8));
        control.setBorder(BorderFactory.createLineBorder(Color.black));
        


        Chunk test = new Chunk();
        JLabel[][] map = loadChunk(test);

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                grid.add(map[x][y]);
            }
        }

        getContentPane().add(panneauGlobal);
        panneauGlobal.add(bordure1);
        panneauGlobal.add(bordure2);

        bordure1.add(grid);
        bordure2.add(control);

        setVisible(true);
    }

    public JLabel[][] loadChunk(Chunk temp) {
        return temp.getContent();
    }
}