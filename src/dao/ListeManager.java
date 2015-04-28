/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdd.Connexion;
import entit�es.Personne;
import entit�es.Ville;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class ListeManager {

    public static List<Ville> getVilles() {
        List<Ville> listeVilles = new ArrayList<>();
        try {
            //TODO controle de l'adh�rent
            String requ�te = "select * from ville \n"
                    + "where ville.`d�partement` in ('01','07','26','38','42','69','73','74')\n"
                    + "order by nom";

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requ�te);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ville ville = new Ville();
                ville.setId_ville(rs.getInt("id_ville"));
                ville.setD�partement(rs.getString("d�partement"));
                ville.setNom(rs.getString("nom"));
                ville.setCode_postal(rs.getString("code_postal"));
                listeVilles.add(ville);
            }
            System.out.println(" villes : "+listeVilles.size() );

        } catch (SQLException ex) {
            System.out.println("Echec getVilles " + ex.getMessage());
        }

        return listeVilles;
    }
}
