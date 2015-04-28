/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdd.Connexion;
import entit�es.Compta;
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
public class ComptaManager {

    public List<Compta> getCompta(String refAdh) {
        Compta compta = null;
        List<Compta> listeCompta = new ArrayList<>();
        try {
            // Cr�ation de la liste des emprunts de l'adh�rent

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement("select date_mouvement, cr�dit, nature, type, montant  from nu_compta where ref_adh�rent=?");
            st.setString(1, refAdh);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                compta = new Compta();
                compta.setDate_mouvement(rs.getDate("date_mouvement"));
                compta.setCr�dit(rs.getInt("cr�dit"));
                compta.setNature(rs.getString("nature"));
                compta.setType(rs.getString("type"));
                compta.setMontant(rs.getDouble("montant"));
                listeCompta.add(compta);
            }
        } catch (SQLException ex) {
            System.out.println("Echec getCompta " + ex.getMessage());
        }

        return listeCompta;
    }
}
