/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AdhérentManager;
import entitées.Adhérent;
import entitées.Personne;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author catenne
 */
public class ModelTablePersonne extends AbstractTableModel {

    private String[] titreColonnes = {"Nom", "Prénom", "Date de naissance"};
    private List<Personne> listePersonne = new ArrayList<>();

    public void setListePersonne(Adhérent adh) {
        this.listePersonne = new AdhérentManager().getFamille(adh);
        System.out.println("liste de " + listePersonne.size() + " personnes");
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listePersonne.size();
    }

    @Override
    public int getColumnCount() {
        return titreColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String cellule = null;
        Personne p = listePersonne.get(rowIndex);
        switch (columnIndex) {
            case 0:
                cellule = p.getNom();
                break;
            case 1:
                cellule = p.getPrénom();
                break;

            case 2:
                cellule = p.getDate_naissance();
                break;
        }

        return cellule;
    }

    @Override
    public String getColumnName(int column) {
        return titreColonnes[column];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int ligneindex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                listePersonne.get(ligneindex).setNom((String) value);
                break;
            case 1:
                listePersonne.get(ligneindex).setPrénom((String) value);
                break;
            case 2:
                listePersonne.get(ligneindex).setDate_naissance((String) value);
                break;
        }
        fireTableCellUpdated(ligneindex, columnIndex);
    }

    public void nouvellePersonne(Personne pers) {
        listePersonne.add(pers);
        this.fireTableDataChanged();
    }
    
}
