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
public class Adh�rentManager {

    /**
     * Retourne un adh�rent
     *
     * @param ref_adh
     * @return un adh�rent
     */
    public Adh�rent getAdh�rent(String ref_adh) {
        Adh�rent adh�rent = null;
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            ResultSet rs = st.executeQuery("select a.*, p.*, v.id_ville,v.d�partement,v.nom as nom_ville, v.code_postal\n"
                    + "from nu_adh�rent a LEFT JOIN nu_personne as p on a.`id_r�f�rent`=p.id_personne\n"
                    + "LEFT JOIN ville as v on v.id_ville=a.id_ville "
                    + "where a.ref_adh�rent='" + ref_adh + "'");
            if (rs.next()) {
                adh�rent = new Adh�rent();

                adh�rent.setRef_adh�rent(rs.getString("ref_adh�rent"));
                adh�rent.setTitre(rs.getString("titre"));
                adh�rent.setAdresse(rs.getString("adresse"));
                adh�rent.setTel1(rs.getString("tel1"));
                adh�rent.setTel2(rs.getString("tel2"));
                adh�rent.setTel3(rs.getString("tel3"));
                adh�rent.setEmail(rs.getString("email"));
                adh�rent.set�ch�ance_cotisation(rs.getDate("�ch�ance_cotisation"));
                adh�rent.setSolde_cr�dit(rs.getInt("solde_cr�dit"));
                adh�rent.setDate_cr�ation(rs.getDate("date_cr�ation"));
//r�f�rent

                Personne r�f�rent = new Personne();
                r�f�rent.setId_personne(rs.getInt("id_personne"));
                r�f�rent.setNom(rs.getString("nom"));
                r�f�rent.setPr�nom(rs.getString("pr�nom"));
                r�f�rent.setDate_naissance(rs.getString("date_naissance"));
                adh�rent.setR�f�rent(r�f�rent);
//ville
                Ville ville = new Ville();
                ville.setId_ville(rs.getInt("id_ville"));
                ville.setD�partement(rs.getString("d�partement"));
                ville.setNom(rs.getString("nom_ville"));
                ville.setCode_postal(rs.getString("code_postal"));
                adh�rent.setVille(ville);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getAdh�rent " + ex.getMessage());
        }

        return adh�rent;
    }

    /**
     * retourne la liste de tous les adh�rents
     *
     * @return liste de tout les adh�rents
     */
    public List<Adh�rent> getAdh�rents() {
        Adh�rent adh�rent = null;
        List<Adh�rent> listeAdh�rents = new ArrayList<>();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            ResultSet rs = st.executeQuery("select a.*, p.*, v.id_ville,v.d�partement,v.nom as nom_ville, v.code_postal\n"
                    + "from nu_adh�rent a, nu_personne p, ville v\n"
                    + "where a.id_r�f�rent=p.id_personne\n"
                    + "and a.id_ville=v.id_ville ");
            while (rs.next()) {
                adh�rent = new Adh�rent();

                adh�rent.setRef_adh�rent(rs.getString("ref_adh�rent"));
                adh�rent.setTitre(rs.getString("titre"));
                adh�rent.setAdresse(rs.getString("adresse"));
                adh�rent.setTel1(rs.getString("tel1"));
                adh�rent.setTel2(rs.getString("tel2"));
                adh�rent.setTel3(rs.getString("tel3"));
                adh�rent.setEmail(rs.getString("email"));
                adh�rent.set�ch�ance_cotisation(rs.getDate("�ch�ance_cotisation"));
                adh�rent.setSolde_cr�dit(rs.getInt("solde_cr�dit"));
                adh�rent.setDate_cr�ation(rs.getDate("date_cr�ation"));
//r�f�rent

                Personne r�f�rent = new Personne();
                r�f�rent.setId_personne(rs.getInt("id_personne"));
                r�f�rent.setNom(rs.getString("nom"));
                r�f�rent.setPr�nom(rs.getString("pr�nom"));
                r�f�rent.setDate_naissance(rs.getString("date_naissance"));
                adh�rent.setR�f�rent(r�f�rent);
//ville
                Ville ville = new Ville();
                ville.setId_ville(rs.getInt("id_ville"));
                ville.setD�partement(rs.getString("d�partement"));
                ville.setNom(rs.getString("nom_ville"));
                ville.setCode_postal(rs.getString("code_postal"));
                adh�rent.setVille(ville);

                listeAdh�rents.add(adh�rent);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getAdh�rent " + ex.getMessage());
        }

        return listeAdh�rents;
    }

    /**
     * rnevoie une chaine indiquant le nombre et la dur�e des emprunt d'un
     * adh�rent
     *
     * @param ref_adh
     * @return nombre de jeu sortis et dur�e du pret
     */
    public String getNbJeuxSortis(String ref_adh) {
        String retour = "";
        try {

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement("select CONCAT(count(*),' (', DATEDIFF(SYSDATE(),min(e.date_sortie)),' jour(s))')\n"
                    + "from nu_emprunt  e\n"
                    + "where e.ref_adh�rent=?\n"
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
     * cr�ation d'un adh�rent
     *
     * @param adh
     */
    public void nouvelAdh�rent(Adh�rent adh) {
        try {
            //TODO controle de l'adh�rent
            String requ�te = "INSERT INTO nu_adh�rent (ref_adh�rent,titre, adresse, tel1, tel2, tel3, email, �ch�ance_cotisation, solde_cr�dit, id_r�f�rent, id_ville, date_cr�ation)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate());";
            //si  la personne n'est pas connue
            if (adh.getR�f�rent().getId_personne() == 0) {
                nouvellePersonne(adh.getR�f�rent());
            }

            adh.setRef_adh�rent(next_adh�rent());
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requ�te);
            st.setString(1, adh.getRef_adh�rent());
            st.setString(2, adh.getTitre());
            st.setString(3, adh.getAdresse());
            st.setString(4, adh.getTel1());
            st.setString(5, adh.getTel2());
            st.setString(6, adh.getTel3());
            st.setString(7, adh.getEmail());
            st.setDate(8, (Date) adh.get�ch�ance_cotisation());
            st.setInt(9, adh.getSolde_cr�dit());
            st.setInt(10, adh.getR�f�rent().getId_personne());
            st.setInt(11, adh.getVille().getId_ville());
            // st.setDate(12, (Date) adh.getDate_cr�ation());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Echec nouvelAdh�rent " + ex.getMessage());
        }
    }

    /**
     * cr�ation du r�f�rent
     *
     * @param r�f�rent
     * @throws SQLException
     */
    private void nouvellePersonne(Personne r�f�rent) throws SQLException {
        String requ�te = "INSERT INTO nu_personne (nom, pr�nom, date_naissance) VALUES (?, ?, ?) ";
//TODO v�rifier la pr�sence d'un nom ou d'un pr�nom
        PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requ�te);
        st.setString(1, r�f�rent.getNom());
        st.setString(2, r�f�rent.getPr�nom());
        st.setString(3, r�f�rent.getDate_naissance());

        st.executeUpdate();

        r�f�rent.setId_personne(last_insert_id());

    }

    /**
     * misae � jour de l'adh�rent
     *
     * @param adh
     */
    public void majAdh�rent(Adh�rent adh) {
        try {
            //TODO controle de l'adh�rent
            String requ�te = "UPDATE nu_adh�rent"
                    + " SET titre=?,"
                    + " adresse=?,"
                    + " tel1=?,"
                    + " tel2=?,"
                    + " tel3=?,"
                    + " email=?,"
                    + " �ch�ance_cotisation=?,"
                    + " solde_cr�dit=?,"
                    + " id_r�f�rent=?,"
                    + " id_ville=? "
                    + "WHERE  ref_adh�rent=?;";
            //si  la personne n'est pas connue
            if (adh.getR�f�rent().getId_personne() == 0) {
                nouvellePersonne(adh.getR�f�rent());
            } else {
                majPersonne(adh.getR�f�rent());
            }
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requ�te);

            st.setString(1, adh.getTitre());
            st.setString(2, adh.getAdresse());
            st.setString(3, adh.getTel1());
            st.setString(4, adh.getTel2());
            st.setString(5, adh.getTel3());
            st.setString(6, adh.getEmail());
            st.setDate(7, (Date) adh.get�ch�ance_cotisation());
            st.setInt(8, adh.getSolde_cr�dit());
            st.setInt(9, adh.getR�f�rent().getId_personne());
            st.setInt(10, adh.getVille().getId_ville());
            st.setString(11, adh.getRef_adh�rent());
            System.out.println("update adh "+adh.getTitre()+" "+adh.getR�f�rent().getNom());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Echec majAdh�rent " + ex.getMessage());
        }
    }

    public List<Personne> getFamille(Adh�rent adh) {
        List<Personne> listePersonnes = new ArrayList<>();
        try {
            //TODO controle de l'adh�rent
            String requ�te = "select p.*\n"
                    + "from nu_famille f, nu_personne p\n"
                    + " where f.id_personne =p.id_personne\n"
                    + "and f.ref_adh�rent=?";
            
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requ�te);

            st.setString(1, adh.getRef_adh�rent());
            System.out.println(" adh.getRef_adh�rent() "+adh.getRef_adh�rent());
            ResultSet rs = st.executeQuery();
           while(rs.next()){
               Personne pers = new Personne();
               pers.setId_personne(rs.getInt("id_personne"));
               pers.setNom(rs.getString("nom"));
               pers.setPr�nom(rs.getString("pr�nom"));
               pers.setDate_naissance(rs.getString("date_naissance"));
               listePersonnes.add(pers);
           }
            
        } catch (SQLException ex) {
            System.out.println("Echec majAdh�rent " + ex.getMessage());
        }

        return listePersonnes;
    }

    /**
     * Renvoie le prochain identifiant de la table adh�rent
     *
     * @return String
     * @throws SQLException
     */
    private String next_adh�rent() throws SQLException {
        String retour = "";
        Statement st = Connexion.getInstance().getConnexion().createStatement();
        ResultSet rs = st.executeQuery("select max(a.ref_adh�rent ), SUBSTRING(year(SYSDATE()),-2) from nu_adh�rent a");
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
            throw new SQLException("Impossible calculer le prochain id adh�rent");
        }
        return retour;
    }

    private void majPersonne(Personne r�f�rent) throws SQLException {
        String requ�te = "UPDATE ludo.nu_personne SET nom=?, pr�nom=?, date_naissance=? WHERE  id_personne=?;";
//TODO m�mes controles qu'� l'insertion
        PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requ�te);
        st.setString(1, r�f�rent.getNom());
        st.setString(2, r�f�rent.getPr�nom());
        st.setString(3, r�f�rent.getDate_naissance());
        st.setInt(4, r�f�rent.getId_personne());
        st.executeUpdate();

    }
}
