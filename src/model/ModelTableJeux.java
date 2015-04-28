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

/**
 *
 * @author andre
 * 
 */

public class ModelTableJeux extends AbstractTableModel {
    
    private Object memo;
    private String[] titreColonnes = {"","Référence","Etat","Nom du jeu","Age","Nombre de joueurs"}; 
    private List<Jeu> listeJeu;

    public ModelTableJeux() {
        JeuManager tj = new JeuManager();      
        listeJeu = tj.getJeux();
        if (listeJeu.size()> 0){ // selectionne le premier si il y a en un!!!
            memo = listeJeu.get(0);
        }
    }
    
    public ModelTableJeux(Adhérent adh) {
        JeuManager tj = new JeuManager();  
        listeJeu = tj.getListeJeuxEmprunte(adh);
        if (listeJeu.size()> 0){ // selectionne le premier si il y a en un!!!
            memo = listeJeu.get(0);
        }        
    }
   
    public ModelTableJeux(boolean bool) {
        JeuManager tj = new JeuManager();  
        listeJeu = tj.getJeux(bool);
        if (listeJeu.size()> 0){ // selectionne le premier si il y a en un!!!
            memo = listeJeu.get(0);
        }        
    }    
    
    @Override
    public int getRowCount() {
        //return listeJeu.size();
        return listeJeu.size();
    }

    @Override
    public int getColumnCount() {
        return titreColonnes.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
        Jeu a = listeJeu.get(rowIndex);
        }catch(Exception e){
            return null;
        }
        Jeu a = listeJeu.get(rowIndex);
        switch(columnIndex)
        {
            case 0: 
                return null; 
            case 1 : 
                return a.getRef_jeu();
            case 2 : 
                return null;
            case 3: 
                return a.getNom();
            case 4 : 
                if ( a.getAge_max().getNb() != 0){
                    return a.getAge_min().getNb()+ " " + a.getAge_min().getNom() + " à " + a.getAge_max().getNb() + " " +  a.getAge_max().getNom();
                }else{
                    return a.getAge_min().getNb()+ " " + a.getAge_min().getNom();
                }
            case 5 : 
                if (a.getNb_joueurs_max()== 0){
                    return a.getNb_joueurs_min(); 
                }else{
                    return a.getNb_joueurs_min() + " à " + a.getNb_joueurs_max();  
                }
            default :
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return titreColonnes[column]; 
    }  

    public List<Jeu> getListeJeu() {
        return listeJeu;
    }

    public void setListeJeu(List<Jeu> listeJeu) {
        this.listeJeu = listeJeu;
    }
    
}
