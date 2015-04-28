/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ListeManager;
import entitées.Ville;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Alexandre
 */
public class ModelComboVille extends AbstractListModel implements ComboBoxModel {

    private List<Ville> listeVille = new ArrayList<>();
    private Ville selected = null;

    public ModelComboVille() {
        listeVille.add(new Ville());
        listeVille = ListeManager.getVilles();
    }

    
    @Override
    public int getSize() {
        return listeVille.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listeVille.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (Ville) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
/**
 * test l'existance d'une ville dans la liste
 * @param v
 * @return 
 */
   public boolean existe(Ville v){
       boolean retour = false;
       for (Ville ville : listeVille) {
           if(ville.equals(v))
               retour = true;
       }
       return retour;
   }
    
    

}
