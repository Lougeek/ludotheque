/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.*;
import entit�es.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andre
 * 
 */

public class ModelTableAdherent extends AbstractTableModel {
    
    private Object memo;
    private String[] titreColonnes = {"","R�f�rence","Nombre de jeux","Ech�ance cotisation","Cr�dit","Titre","Nom Pr�nom","Commune"}; 
    private List<Adh�rent> listeAdherent;

    public ModelTableAdherent() {
        Adh�rentManager am = new Adh�rentManager();
        
        listeAdherent = am.getAdh�rents();
        if (listeAdherent.size()> 0){ // selectionne le premier si il y a en un!!!
            memo = listeAdherent.get(0);
        }
    }    

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return listeAdherent.size();
    }

    @Override
    public int getColumnCount() {
        return titreColonnes.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Adh�rent a = listeAdherent.get(rowIndex);
        switch(columnIndex)
        {
            case 0: 
                return 1; 
            case 1 : 
                return a.getRef_adh�rent();
            case 2 : 
                Adh�rentManager amjs = new Adh�rentManager();
                return amjs.getNbJeuxSortis(a.getRef_adh�rent());
            case 3: 
                return a.get�ch�ance_cotisation();
            case 4 : 
                return a.getSolde_cr�dit();
            case 5 : 
                return a.getTitre();        
            case 6 : 
                return a.getR�f�rent().getNom() + " " + a.getR�f�rent().getPr�nom() ;
            case 7 : 
                return a.getVille().getNom(); 
            default :
                 return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return titreColonnes[column]; 
    }    
}
