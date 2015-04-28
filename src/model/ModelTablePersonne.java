/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Adh�rentManager;
import entit�es.Adh�rent;
import entit�es.Personne;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author catenne
 */
public class ModelTablePersonne extends AbstractTableModel {

    private String[] titreColonnes = {"Nom", "Pr�nom", "Date de naissance"};
    private List<Personne> listePersonne = new ArrayList<>();

    public void setListePersonne(Adh�rent adh) {
        this.listePersonne = new Adh�rentManager().getFamille(adh);
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
                cellule = p.getPr�nom();
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
                listePersonne.get(ligneindex).setPr�nom((String) value);
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
