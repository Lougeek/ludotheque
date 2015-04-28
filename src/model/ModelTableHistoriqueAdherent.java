/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AdhérentManager;
import dao.HistoriqueManager;
import entitées.Adhérent;
import entitées.Historique;
import interfaces.HistoriqueAdherent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andre
 * 
 */

public class ModelTableHistoriqueAdherent extends AbstractTableModel {
    
   // private Object memo;
    private List<Historique> listeHistoAdherent;
    private HistoriqueAdherent histo_adh;
    
    private String[] titreColonnes = {"Date et Heure","Type ","Réf", "Nom du jeu", "Date de retour", "Montant", "Mode"}; 
       

    public ModelTableHistoriqueAdherent(String ref_adh) {
        HistoriqueManager manag_histo = new HistoriqueManager();
        
        listeHistoAdherent = manag_histo.getHistoriqueAdh(ref_adh);
        System.out.println("liste histo dans modeltable "+listeHistoAdherent.size());
//        if (listeHistoAdherent.size()> 0){ // selectionne le premier si il y a en un!!!
//            memo = listeHistoAdherent.get(0);
//         //    histo_adh = new HistoriqueAdherent(ref_adh);
//     } 
    }    

    
    
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return listeHistoAdherent.size();
    }

    @Override
    public int getColumnCount() {
        return titreColonnes.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           Object cellule = null;
        Historique histo = listeHistoAdherent.get(rowIndex);
        switch (columnIndex) {
            case 0:
                cellule = histo.getDateHistorique();
                break;
            case 1:
                cellule = histo.getTypeMvt();
                break;
            case 2:
                cellule = histo.getRef();
                break;
            case 3:
                cellule = histo.getNom();
                break;
            case 4:
                cellule = histo.getDateRetour();
                break;
            case 5:
                cellule = histo.getMontant();
                break;
            case 6:
                cellule = histo.getModePaiement();
break;
            default:
                cellule = null;
        }
        return cellule;
    }; 
    
    @Override
    public String getColumnName(int column) {
        return titreColonnes[column]; 
    }    
}
