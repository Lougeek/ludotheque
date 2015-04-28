/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author andre
 * 
 */

public class ImageButton extends JButton{
    public ImageButton(ImageIcon icon){
        setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null));
        setIcon(icon);
        setMargin(new Insets(0,0,0,0));
        setIconTextGap(0);
        setBorderPainted(false);
        setBorder(null);
        setText(null);
    }  
}
