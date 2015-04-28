/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdd.Connexion;
import static bdd.Utilitaires.*;
import entitées.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catenne
 */
public class ReservationManager {

    /**
     * liste des jeux liés à une réservation
     *
     * @param id_resa
     * @return
     */
    public List getListeJeuxReserve(int id_resa) {
        List listeJeux = new ArrayList();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            //ResultSet rs = st.executeQuery("CALL listeJeuReserve(" + id_resa + ")");
            ResultSet rs = st.executeQuery("select jeu.*,adh.ref_adhérent, CONCAT_WS(' ',pers.nom,pers.prénom),\n"
                    + "if(emprunt.date_sortie is not null and emprunt.date_retour is null,'','emprunté') as etat\n"
                    + "from nu_jeu jeu\n"
                    + "\n"
                    + "left join nu_emprunt emprunt on jeu.ref_jeu=emprunt.ref_jeu and emprunt.date_retour is null\n"
                    + "join nu_resa_jeu as resa on resa.ref_jeu=jeu.ref_jeu\n"
                    + "join nu_réservation reserve on reserve.id_réservation=resa.id_réservation\n"
                    + "join nu_adhérent as adh on adh.ref_adhérent=reserve.ref_adhérent\n"
                    + "join nu_personne as pers on pers.id_personne=adh.id_référent\n"
                    + "and resa.id_réservation=" + id_resa + "\n"
                    + "group by jeu.ref_jeu;");
            listeJeux = resultSetToArrayList(rs);

        } catch (SQLException ex) {
            System.out.println("Echec getListeJeuxReserve " + ex.getMessage());
        }
        return listeJeux;
    }

    /**
     * nouvelle réservation (avec la liste des jeux)
     *
     * @param resa
     */
    public void nouvelleReservation(Réservation resa) {
        String requete = "INSERT INTO nu_réservation (ref_adhérent, date_début, date_fin) VALUES (?, ?, ?)";
        try {
//TODO controle de la résa
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requete);

            st.setString(1, resa.getRef_adhérent());
            st.setDate(2, (Date) resa.getDate_début());
            st.setDate(3, (Date) resa.getDate_fin());

            st.executeUpdate();
            resa.setId_réservation(last_insert_id());

            for (RésaJeu resa_jeu : resa.getRésa_jeu()) {
                nouvelleResaJeu(resa.getId_réservation(), resa_jeu);
            }

        } catch (SQLException ex) {
            System.out.println("Echec nouvelleReservation " + ex.getMessage());
        }
    }

    /**
     * Ajoute un jeu a une réservation
     *
     * @param resa
     * @param resa_jeu
     */
    public void nouvelleReservationJeu(Réservation resa, RésaJeu resa_jeu) {

        try {
            nouvelleResaJeu(resa.getId_réservation(), resa_jeu);

        } catch (SQLException ex) {
            System.out.println("Echec nouvelleReservationJeu " + ex.getMessage());
        }
    }

    /**
     * enregistrement de la réservation d'un jeu
     *
     * @param id_res
     * @param resa_jeu
     * @throws SQLException
     */
    private void nouvelleResaJeu(int id_res, RésaJeu resa_jeu) throws SQLException {
        String requete = "INSERT INTO nu_resa_jeu (id_réservation, ref_jeu, id_emprunt) VALUES (?, ?);";

        PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requete);

        st.setInt(1, id_res);
        st.setString(2, resa_jeu.getJeu().getRef_jeu());

        st.executeUpdate();

    }

    /**
     * liste des réservation faites sur un jeu
     *
     * @param ref_jeu
     * @return
     */
    public List getListeReservationsJeu(String ref_jeu) {
        List listeReservations = new ArrayList();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            //ResultSet rs = st.executeQuery("CALL listeReservationJeu('15/001')");
            ResultSet rs = st.executeQuery("select r.id_réservation, a.ref_adhérent,p.nom,p.prénom, r.date_début, r.date_fin, e.date_sortie, e.date_retour\n"
                    + "from nu_réservation r \n"
                    + "join nu_resa_jeu as rj on r.id_réservation=rj.id_réservation \n"
                    + "join nu_adhérent a on a.ref_adhérent=r.ref_adhérent\n"
                    + "join nu_personne p on p.id_personne=a.id_référent\n"
                    + "join nu_jeu j on j.ref_jeu = rj.ref_jeu\n"
                    + "left join nu_emprunt e on e.id_emprunt = rj.id_emprunt\n"
                    + "where rj.ref_jeu='" + ref_jeu + "'");
            listeReservations = resultSetToArrayList(rs);

        } catch (SQLException ex) {
            System.out.println("Echec getListeReservationsJeu " + ex.getMessage());
        }
        return listeReservations;
    }



    /**
     * renvoie le dernier identifiant inséré
     *
     * @return int
     * @throws SQLException
     */
    private int last_insert_id() throws SQLException {
        int retour = 0;
        Statement st = Connexion.getInstance().getConnexion().createStatement();
        ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
        if (rs.next()) {
            retour = rs.getInt(1);
        } else {
            throw new SQLException("Impossible de trouver le dernier enrgistrement");
        }
        return retour;
    }

    /**
     * Renvoie le prochain identifiant de la table jeu
     *
     * @return String
     * @throws SQLException
     */
    private String next_adhérent() throws SQLException {
        String retour = "";
        Statement st = Connexion.getInstance().getConnexion().createStatement();
        ResultSet rs = st.executeQuery("select max(j.ref_jeu ), SUBSTRING(year(SYSDATE()),-2) from nu_jeu j");
        if (rs.next()) {
            retour = rs.getString(1);
            String an = retour.split("/")[0];
            String id = retour.split("/")[1];
            String date = rs.getString(2);

            if (an.equals(date)) {
                retour = date + "/" + String.format("%03d", (Integer.parseInt(id) + 1));
            } else {
                retour = date + "/" + "001";
            }

        } else {
            throw new SQLException("Impossible calculer le prochain id jeu");
        }
        return retour;
    }
}
