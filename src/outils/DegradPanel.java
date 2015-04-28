/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Afficher un fond degrade dans un JPanel
 * http://www.fobec.com/java/983/afficher-fond-degrade-dans-jpanel.html Fobec
 * 2010
 */
public class DegradPanel extends JPanel {

    /**
     * Constructeur
     */
    public DegradPanel() {
        super();
    }

    /**
     * Surcharger l'evenement Paint
     *
     * @param _g
     */
    public void paint(Graphics _g) {
        super.paintComponent(_g);
        Graphics2D g = (Graphics2D) _g;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle bounds = getBounds();
        System.setProperty("myColor1", "#C7F5E9");
        System.setProperty("myColor2", "#88BFB2");
        Paint gradientPaint = new GradientPaint(0, bounds.y, Color.getColor("myColor1"),
                0, bounds.y + bounds.width, Color.getColor("myColor2"));
        g.setPaint(gradientPaint);
        g.fillRect(0, 0, bounds.width, bounds.height);
    }

    /**
     * Exemple dans un jFrame
     *
     * @param args
     */
    public static void main(String args[]) {
     DegradPanel degradPanel = new DegradPanel();
     JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 400);
     frame.setLocation(200, 200);
     FlowLayout toolBarLayout = new FlowLayout();
     JPanel jPanel = new javax.swing.JPanel(toolBarLayout);
     System.out.println("JPanel Size - " + jPanel.getSize());
     TitledBorder nameBorder = BorderFactory.createTitledBorder(
            "Change Description");
        nameBorder.setTitleJustification(TitledBorder.LEFT);
     jPanel.setPreferredSize(new Dimension(400, 400));

       
        jPanel.setMaximumSize(new Dimension(250, 150));  // hardCoded sizing
        jPanel.setMinimumSize(new Dimension(150, 150));  // hardCoded sizing
        jPanel.setBorder(nameBorder);
        jPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
     System.out.println("JPanel Size - " + jPanel.getSize());
     jPanel.add(degradPanel);
     frame.add(jPanel);
     
     
     frame.setVisible(true);
     }
}
