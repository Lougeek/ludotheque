/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.*;
import entitées.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andre
 * 
 */

public class ModelTableAdherent extends AbstractTableModel {
    
    private Object memo;
    private String[] titreColonnes = {"","Référence","Nombre de jeux","Echéance cotisation","Crédit","Titre","Nom Prénom","Commune"}; 
    private List<Adhérent> listeAdherent;

    public ModelTableAdherent() {
        AdhérentManager am = new AdhérentManager();
        
        listeAdherent = am.getAdhérents();
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
        Adhérent a = listeAdherent.get(rowIndex);
        switch(columnIndex)
        {
            case 0: 
                return 1; 
            case 1 : 
                return a.getRef_adhérent();
            case 2 : 
                AdhérentManager amjs = new AdhérentManager();
                return amjs.getNbJeuxSortis(a.getRef_adhérent());
            case 3: 
                return a.getÉchéance_cotisation();
            case 4 : 
                return a.getSolde_crédit();
            case 5 : 
                return a.getTitre();        
            case 6 : 
                return a.getRéférent().getNom() + " " + a.getRéférent().getPrénom() ;
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
