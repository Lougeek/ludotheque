/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poubelle;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
/**
 * Afficher un fond degrade dans un JPanel
 * http://www.fobec.com/java/983/afficher-fond-degrade-dans-jpanel.html
 * Fobec 2010
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
     * @param _g 
     */
    public void paint(Graphics _g) {
        super.paintComponent(_g);
        Graphics2D g = (Graphics2D) _g;
 
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle bounds = getBounds();
        Paint gradientPaint = new GradientPaint(0, bounds.y, Color.GREEN,
                0, bounds.y + bounds.width, Color.YELLOW);
        g.setPaint(gradientPaint);
        g.fillRect(0, 0, bounds.width, bounds.height);
    }
 
    /**
     * Exemple dans un jFrame
     * @param args 
     */
    public static void main(String args[]) {
        DegradPanel degradPanel = new DegradPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(degradPanel);
        frame.setSize(400, 400);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }
}