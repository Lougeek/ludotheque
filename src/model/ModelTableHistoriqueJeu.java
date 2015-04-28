/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andre
 * 
 */

public class ModelTableHistoriqueJeu extends AbstractTableModel {
    
    private Object memo;
    private String[] titreColonnes = {"Date et Heure","Type mouvement","Référenc Adhérent","Date de retour"}; 
    
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 0;
    }

    @Override
    public int getColumnCount() {
        return titreColonnes.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return titreColonnes[column]; 
    }    
}
