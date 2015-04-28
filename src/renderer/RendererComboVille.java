/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import entitées.Ville;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Alexandre
 */
public class RendererComboVille implements ListCellRenderer<Ville>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Ville> list, Ville value, int index, boolean isSelected, boolean cellHasFocus) {
        
         JLabel renderer = new JLabel(value==null?"":value.getNom()+" ("+value.getDépartement()+")");
        if (isSelected) {
            renderer.setOpaque(true);
            renderer.setForeground(Color.BLUE);
            renderer.setBackground(Color.LIGHT_GRAY);
        }
        return renderer;
    }
    
}
