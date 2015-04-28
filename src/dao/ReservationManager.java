/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdd.Connexion;
import static bdd.Utilitaires.*;
import entit�es.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catenne
 */
public class ReservationManager {

    /**
     * liste des jeux li�s � une r�servation
     *
     * @param id_resa
     * @return
     */
    public List getListeJeuxReserve(int id_resa) {
        List listeJeux = new ArrayList();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            //ResultSet rs = st.executeQuery("CALL listeJeuReserve(" + id_resa + ")");
            ResultSet rs = st.executeQuery("select jeu.*,adh.ref_adh�rent, CONCAT_WS(' ',pers.nom,pers.pr�nom),\n"
                    + "if(emprunt.date_sortie is not null and emprunt.date_retour is null,'','emprunt�') as etat\n"
                    + "from nu_jeu jeu\n"
                    + "\n"
                    + "left join nu_emprunt emprunt on jeu.ref_jeu=emprunt.ref_jeu and emprunt.date_retour is null\n"
                    + "join nu_resa_jeu as resa on resa.ref_jeu=jeu.ref_jeu\n"
                    + "join nu_r�servation reserve on reserve.id_r�servation=resa.id_r�servation\n"
                    + "join nu_adh�rent as adh on adh.ref_adh�rent=reserve.ref_adh�rent\n"
                    + "join nu_personne as pers on pers.id_personne=adh.id_r�f�rent\n"
                    + "and resa.id_r�servation=" + id_resa + "\n"
                    + "group by jeu.ref_jeu;");
            listeJeux = resultSetToArrayList(rs);

        } catch (SQLException ex) {
            System.out.println("Echec getListeJeuxReserve " + ex.getMessage());
        }
        return listeJeux;
    }

    /**
     * nouvelle r�servation (avec la liste des jeux)
     *
     * @param resa
     */
    public void nouvelleReservation(R�servation resa) {
        String requete = "INSERT INTO nu_r�servation (ref_adh�rent, date_d�but, date_fin) VALUES (?, ?, ?)";
        try {
//TODO controle de la r�sa
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requete);

            st.setString(1, resa.getRef_adh�rent());
            st.setDate(2, (Date) resa.getDate_d�but());
            st.setDate(3, (Date) resa.getDate_fin());

            st.executeUpdate();
            resa.setId_r�servation(last_insert_id());

            for (R�saJeu resa_jeu : resa.getR�sa_jeu()) {
                nouvelleResaJeu(resa.getId_r�servation(), resa_jeu);
            }

        } catch (SQLException ex) {
            System.out.println("Echec nouvelleReservation " + ex.getMessage());
        }
    }

    /**
     * Ajoute un jeu a une r�servation
     *
     * @param resa
     * @param resa_jeu
     */
    public void nouvelleReservationJeu(R�servation resa, R�saJeu resa_jeu) {

        try {
            nouvelleResaJeu(resa.getId_r�servation(), resa_jeu);

        } catch (SQLException ex) {
            System.out.println("Echec nouvelleReservationJeu " + ex.getMessage());
        }
    }

    /**
     * enregistrement de la r�servation d'un jeu
     *
     * @param id_res
     * @param resa_jeu
     * @throws SQLException
     */
    private void nouvelleResaJeu(int id_res, R�saJeu resa_jeu) throws SQLException {
        String requete = "INSERT INTO nu_resa_jeu (id_r�servation, ref_jeu, id_emprunt) VALUES (?, ?);";

        PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requete);

        st.setInt(1, id_res);
        st.setString(2, resa_jeu.getJeu().getRef_jeu());

        st.executeUpdate();

    }

    /**
     * liste des r�servation faites sur un jeu
     *
     * @param ref_jeu
     * @return
     */
    public List getListeReservationsJeu(String ref_jeu) {
        List listeReservations = new ArrayList();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            //ResultSet rs = st.executeQuery("CALL listeReservationJeu('15/001')");
            ResultSet rs = st.executeQuery("select r.id_r�servation, a.ref_adh�rent,p.nom,p.pr�nom, r.date_d�but, r.date_fin, e.date_sortie, e.date_retour\n"
                    + "from nu_r�servation r \n"
                    + "join nu_resa_jeu as rj on r.id_r�servation=rj.id_r�servation \n"
                    + "join nu_adh�rent a on a.ref_adh�rent=r.ref_adh�rent\n"
                    + "join nu_personne p on p.id_personne=a.id_r�f�rent\n"
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
     * renvoie le dernier identifiant ins�r�
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
    private String next_adh�rent() throws SQLException {
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
