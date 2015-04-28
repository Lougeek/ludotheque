/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdd.Connexion;
import entitées.Personne;
import entitées.Ville;
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
            //TODO controle de l'adhérent
            String requète = "select * from ville \n"
                    + "where ville.`département` in ('01','07','26','38','42','69','73','74')\n"
                    + "order by nom";

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ville ville = new Ville();
                ville.setId_ville(rs.getInt("id_ville"));
                ville.setDépartement(rs.getString("département"));
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
