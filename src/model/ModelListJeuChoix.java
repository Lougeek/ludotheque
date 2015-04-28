/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.*;
import javax.swing.table.AbstractTableModel;
import entitées.*;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author andre
 * 
 */

public class ModelListJeuChoix extends AbstractListModel {
    
    private Object memo;
    private List<Jeu> listeJeu;

    public ModelListJeuChoix() {
        JeuManager tj = new JeuManager();      
        listeJeu = tj.getJeux();
        if (listeJeu.size()> 0){ // selectionne le premier si il y a en un!!!
            memo = listeJeu.get(0);
        }
    } 
    
    @Override
    public int getSize() {
        return listeJeu.size();
    }

    @Override
    public Object getElementAt(int index) {
        Jeu j = listeJeu.get(index);
        return j.getRef_jeu() + " " + j.getNom();
    }
}
