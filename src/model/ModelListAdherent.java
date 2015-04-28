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

public class ModelListAdherent extends AbstractListModel {
    
    private Object memo;
    private List<Adhérent> listeAdherent;

    public ModelListAdherent() {
        AdhérentManager am = new AdhérentManager();      
        listeAdherent = am.getAdhérents();
        if (listeAdherent.size()> 0){ // selectionne le premier si il y a en un!!!
            memo = listeAdherent.get(0);
        }
    } 
    
    @Override
    public int getSize() {
        return listeAdherent.size();
    }

    @Override
    public Object getElementAt(int index) {
        Adhérent a = listeAdherent.get(index);
        return a.getRef_adhérent()+ " " + a.getRéférent().getNom() + " " + a.getRéférent().getPrénom();
    }
}
