/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdd.Connexion;
import entitées.Emprunt;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christelle
 */
public class EmpruntManager {

    public List<Emprunt> getEmprunt(String refAdh) {
        Emprunt emprunt = null;
        List<Emprunt> listeEmprunt = new ArrayList<>();
        try {
            // Création de la liste des emprunts de l'adhérent

            // Statement st = Connexion.getInstance().getConnexion().createStatement();
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement("select date_sortie, date_retour, ref_jeu from nu_emprunt where ref_adhérent=?");
            st.setString(1, refAdh);

       
            ResultSet rs = st.executeQuery();
         
            
            while (rs.next()) {
                emprunt = new Emprunt();
                emprunt.setDate_sortie(rs.getDate("date_sortie"));
                emprunt.setJeu(rs.getString("ref_jeu"));
                emprunt.setDate_retour(rs.getDate("date_retour"));
                listeEmprunt.add(emprunt);
            }
        } catch (SQLException ex) {
            System.out.println("Echec getEmprunt " + ex.getMessage());
        }

        return listeEmprunt;
    }
}
