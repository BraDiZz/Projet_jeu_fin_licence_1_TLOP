package main;

import java.awt.*;
import javax.swing.*;

import texture.*;
import terrain.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class FullMapViewer extends JFrame {
    /**
     * Le main a executer
     * @param args 
     */
    public static void main(String[] args) {
        new FullMapViewer();
    }
    /**
     * Une Map avec des caracteristiques de base
     */
    private Map map = new Map(9, 16, 5646441l);
    /**
     * Constructeur par defaut
     */
    public FullMapViewer() {
        setSize(1920,1080);
	    setLocationRelativeTo(null);
	    setTitle("Game save name");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mapView = new JPanel();

        validate();
        repaint();

        getContentPane().add(mapView);

        setVisible(true);
    }
}