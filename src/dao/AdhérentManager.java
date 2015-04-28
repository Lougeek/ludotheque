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
public class AdhérentManager {

    /**
     * Retourne un adhérent
     *
     * @param ref_adh
     * @return un adhérent
     */
    public Adhérent getAdhérent(String ref_adh) {
        Adhérent adhérent = null;
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            ResultSet rs = st.executeQuery("select a.*, p.*, v.id_ville,v.département,v.nom as nom_ville, v.code_postal\n"
                    + "from nu_adhérent a LEFT JOIN nu_personne as p on a.`id_référent`=p.id_personne\n"
                    + "LEFT JOIN ville as v on v.id_ville=a.id_ville "
                    + "where a.ref_adhérent='" + ref_adh + "'");
            if (rs.next()) {
                adhérent = new Adhérent();

                adhérent.setRef_adhérent(rs.getString("ref_adhérent"));
                adhérent.setTitre(rs.getString("titre"));
                adhérent.setAdresse(rs.getString("adresse"));
                adhérent.setTel1(rs.getString("tel1"));
                adhérent.setTel2(rs.getString("tel2"));
                adhérent.setTel3(rs.getString("tel3"));
                adhérent.setEmail(rs.getString("email"));
                adhérent.setÉchéance_cotisation(rs.getDate("échéance_cotisation"));
                adhérent.setSolde_crédit(rs.getInt("solde_crédit"));
                adhérent.setDate_création(rs.getDate("date_création"));
//référent

                Personne référent = new Personne();
                référent.setId_personne(rs.getInt("id_personne"));
                référent.setNom(rs.getString("nom"));
                référent.setPrénom(rs.getString("prénom"));
                référent.setDate_naissance(rs.getString("date_naissance"));
                adhérent.setRéférent(référent);
//ville
                Ville ville = new Ville();
                ville.setId_ville(rs.getInt("id_ville"));
                ville.setDépartement(rs.getString("département"));
                ville.setNom(rs.getString("nom_ville"));
                ville.setCode_postal(rs.getString("code_postal"));
                adhérent.setVille(ville);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getAdhérent " + ex.getMessage());
        }

        return adhérent;
    }

    /**
     * retourne la liste de tous les adhérents
     *
     * @return liste de tout les adhérents
     */
    public List<Adhérent> getAdhérents() {
        Adhérent adhérent = null;
        List<Adhérent> listeAdhérents = new ArrayList<>();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            ResultSet rs = st.executeQuery("select a.*, p.*, v.id_ville,v.département,v.nom as nom_ville, v.code_postal\n"
                    + "from nu_adhérent a, nu_personne p, ville v\n"
                    + "where a.id_référent=p.id_personne\n"
                    + "and a.id_ville=v.id_ville ");
            while (rs.next()) {
                adhérent = new Adhérent();

                adhérent.setRef_adhérent(rs.getString("ref_adhérent"));
                adhérent.setTitre(rs.getString("titre"));
                adhérent.setAdresse(rs.getString("adresse"));
                adhérent.setTel1(rs.getString("tel1"));
                adhérent.setTel2(rs.getString("tel2"));
                adhérent.setTel3(rs.getString("tel3"));
                adhérent.setEmail(rs.getString("email"));
                adhérent.setÉchéance_cotisation(rs.getDate("échéance_cotisation"));
                adhérent.setSolde_crédit(rs.getInt("solde_crédit"));
                adhérent.setDate_création(rs.getDate("date_création"));
//référent

                Personne référent = new Personne();
                référent.setId_personne(rs.getInt("id_personne"));
                référent.setNom(rs.getString("nom"));
                référent.setPrénom(rs.getString("prénom"));
                référent.setDate_naissance(rs.getString("date_naissance"));
                adhérent.setRéférent(référent);
//ville
                Ville ville = new Ville();
                ville.setId_ville(rs.getInt("id_ville"));
                ville.setDépartement(rs.getString("département"));
                ville.setNom(rs.getString("nom_ville"));
                ville.setCode_postal(rs.getString("code_postal"));
                adhérent.setVille(ville);

                listeAdhérents.add(adhérent);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getAdhérent " + ex.getMessage());
        }

        return listeAdhérents;
    }

    /**
     * rnevoie une chaine indiquant le nombre et la durée des emprunt d'un
     * adhérent
     *
     * @param ref_adh
     * @return nombre de jeu sortis et durée du pret
     */
    public String getNbJeuxSortis(String ref_adh) {
        String retour = "";
        try {

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement("select CONCAT(count(*),' (', DATEDIFF(SYSDATE(),min(e.date_sortie)),' jour(s))')\n"
                    + "from nu_emprunt  e\n"
                    + "where e.ref_adhérent=?\n"
                    + "and e.date_retour is null");
            st.setString(1, ref_adh);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                retour = rs.getString(1);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getNbJeuxSortis " + ex.getMessage());
        }
        return retour;
    }

    /**
     * création d'un adhérent
     *
     * @param adh
     */
    public void nouvelAdhérent(Adhérent adh) {
        try {
            //TODO controle de l'adhérent
            String requète = "INSERT INTO nu_adhérent (ref_adhérent,titre, adresse, tel1, tel2, tel3, email, échéance_cotisation, solde_crédit, id_référent, id_ville, date_création)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate());";
            //si  la personne n'est pas connue
            if (adh.getRéférent().getId_personne() == 0) {
                nouvellePersonne(adh.getRéférent());
            }

            adh.setRef_adhérent(next_adhérent());
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);
            st.setString(1, adh.getRef_adhérent());
            st.setString(2, adh.getTitre());
            st.setString(3, adh.getAdresse());
            st.setString(4, adh.getTel1());
            st.setString(5, adh.getTel2());
            st.setString(6, adh.getTel3());
            st.setString(7, adh.getEmail());
            st.setDate(8, (Date) adh.getÉchéance_cotisation());
            st.setInt(9, adh.getSolde_crédit());
            st.setInt(10, adh.getRéférent().getId_personne());
            st.setInt(11, adh.getVille().getId_ville());
            // st.setDate(12, (Date) adh.getDate_création());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Echec nouvelAdhérent " + ex.getMessage());
        }
    }

    /**
     * création du référent
     *
     * @param référent
     * @throws SQLException
     */
    private void nouvellePersonne(Personne référent) throws SQLException {
        String requète = "INSERT INTO nu_personne (nom, prénom, date_naissance) VALUES (?, ?, ?) ";
//TODO vérifier la présence d'un nom ou d'un prénom
        PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);
        st.setString(1, référent.getNom());
        st.setString(2, référent.getPrénom());
        st.setString(3, référent.getDate_naissance());

        st.executeUpdate();

        référent.setId_personne(last_insert_id());

    }

    /**
     * misae à jour de l'adhérent
     *
     * @param adh
     */
    public void majAdhérent(Adhérent adh) {
        try {
            //TODO controle de l'adhérent
            String requète = "UPDATE nu_adhérent"
                    + " SET titre=?,"
                    + " adresse=?,"
                    + " tel1=?,"
                    + " tel2=?,"
                    + " tel3=?,"
                    + " email=?,"
                    + " échéance_cotisation=?,"
                    + " solde_crédit=?,"
                    + " id_référent=?,"
                    + " id_ville=? "
                    + "WHERE  ref_adhérent=?;";
            //si  la personne n'est pas connue
            if (adh.getRéférent().getId_personne() == 0) {
                nouvellePersonne(adh.getRéférent());
            } else {
                majPersonne(adh.getRéférent());
            }
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);

            st.setString(1, adh.getTitre());
            st.setString(2, adh.getAdresse());
            st.setString(3, adh.getTel1());
            st.setString(4, adh.getTel2());
            st.setString(5, adh.getTel3());
            st.setString(6, adh.getEmail());
            st.setDate(7, (Date) adh.getÉchéance_cotisation());
            st.setInt(8, adh.getSolde_crédit());
            st.setInt(9, adh.getRéférent().getId_personne());
            st.setInt(10, adh.getVille().getId_ville());
            st.setString(11, adh.getRef_adhérent());
            System.out.println("update adh "+adh.getTitre()+" "+adh.getRéférent().getNom());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Echec majAdhérent " + ex.getMessage());
        }
    }

    public List<Personne> getFamille(Adhérent adh) {
        List<Personne> listePersonnes = new ArrayList<>();
        try {
            //TODO controle de l'adhérent
            String requète = "select p.*\n"
                    + "from nu_famille f, nu_personne p\n"
                    + " where f.id_personne =p.id_personne\n"
                    + "and f.ref_adhérent=?";
            
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);

            st.setString(1, adh.getRef_adhérent());
            System.out.println(" adh.getRef_adhérent() "+adh.getRef_adhérent());
            ResultSet rs = st.executeQuery();
           while(rs.next()){
               Personne pers = new Personne();
               pers.setId_personne(rs.getInt("id_personne"));
               pers.setNom(rs.getString("nom"));
               pers.setPrénom(rs.getString("prénom"));
               pers.setDate_naissance(rs.getString("date_naissance"));
               listePersonnes.add(pers);
           }
            
        } catch (SQLException ex) {
            System.out.println("Echec majAdhérent " + ex.getMessage());
        }

        return listePersonnes;
    }

    /**
     * Renvoie le prochain identifiant de la table adhérent
     *
     * @return String
     * @throws SQLException
     */
    private String next_adhérent() throws SQLException {
        String retour = "";
        Statement st = Connexion.getInstance().getConnexion().createStatement();
        ResultSet rs = st.executeQuery("select max(a.ref_adhérent ), SUBSTRING(year(SYSDATE()),-2) from nu_adhérent a");
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
            throw new SQLException("Impossible calculer le prochain id adhérent");
        }
        return retour;
    }

    private void majPersonne(Personne référent) throws SQLException {
        String requète = "UPDATE ludo.nu_personne SET nom=?, prénom=?, date_naissance=? WHERE  id_personne=?;";
//TODO mêmes controles qu'à l'insertion
        PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);
        st.setString(1, référent.getNom());
        st.setString(2, référent.getPrénom());
        st.setString(3, référent.getDate_naissance());
        st.setInt(4, référent.getId_personne());
        st.executeUpdate();

    }
}
