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
import java.util.Date;
import java.util.List;
import org.jdesktop.swingx.calendar.DateUtils;

/**
 *
 * @author catenne
 */
public class JeuManager {

    /**
     * lise des jeux
     *
     * @return
     */
    public List<Jeu> getJeux() {
        Jeu jeu = null;
        List<Jeu> listeJeux = new ArrayList<>();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            ResultSet rs = st.executeQuery("CALL listeJeu()");
            while (rs.next()) {
                listeJeux.add(jeuFromResultSet(rs));
            }

        } catch (SQLException ex) {
            System.out.println("Echec getJeux " + ex.getMessage());
        }

        return listeJeux;
    }

    /**
     * liste des jeux
     *
     * @param estEmprunte
     * @return
     */
    public List<Jeu> getJeux(Boolean estEmprunte) {
        Jeu jeu = null;
        List<Jeu> listeJeux = new ArrayList<>();
        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            ResultSet rs = st.executeQuery("CALL listeJeu()");
            while (rs.next()) {
                if (estEmprunte) {//le jeu est emprunté
                    if (!"".equals(rs.getString("etat"))) {
                       listeJeux.add(jeuFromResultSet(rs));
                    }
                } else {//le jeux est dispo
                    if ("".equals(rs.getString("etat"))) {
                       listeJeux.add(jeuFromResultSet(rs));
                    }
                }
                
            }

        } catch (SQLException ex) {
            System.out.println("Echec getJeux " + ex.getMessage());
        }

        return listeJeux;
    }

    /**
     * Extrait un jeu du resultset
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Jeu jeuFromResultSet(ResultSet rs) throws SQLException {
        Jeu jeu = new Jeu();

        jeu.setRef_jeu(rs.getString("ref_jeu"));
        jeu.setNom(rs.getString("nom"));
        jeu.setFabricant(rs.getString("fabricant"));
        jeu.setDate_creation(rs.getDate("date_creation"));
        jeu.setPrix_achat(rs.getDouble("prix_achat"));
        jeu.setDate_achat(rs.getDate("date_achat"));
        jeu.setNb_joueurs_min(rs.getInt("nb_joueurs_min"));
        jeu.setNb_joueurs_max(rs.getInt("nb_joueurs_max"));
        jeu.setConsomme_piles(rs.getBoolean("consomme_piles"));
        jeu.setContenu(rs.getString("contenu"));
        jeu.setCommentaires(rs.getString("commentaires"));
        jeu.setPoints(rs.getInt("points"));
        jeu.setDon(rs.getBoolean("don"));
        //age mini
        Age ageMin = new Age();
        ageMin.setId_age(rs.getInt("id_age_min"));
        ageMin.setNb(rs.getInt("min_nb"));
        ageMin.setNom(rs.getString("min_nom"));
        jeu.setAge_min(ageMin);
        //Age Maxi
        Age ageMax = new Age();
        ageMax.setId_age(rs.getInt("id_age_max"));
        ageMax.setNb(rs.getInt("max_nb"));
        ageMax.setNom(rs.getString("max_nom"));
        jeu.setAge_max(ageMax);
        //Pile
        Pile pile = new Pile();
        pile.setId_pile(rs.getInt("id_pile"));
        jeu.setPile(pile);
        return jeu;
    }

    /**
     * retourne un jeu
     *
     * @param refJeu
     * @return
     */
    public Jeu getJeu(String refJeu) {
        Jeu jeu = null;

        try {
            Statement st = Connexion.getInstance().getConnexion().createStatement();
            ResultSet rs = st.executeQuery("CALL getJeu('" + refJeu + "')");
            if (rs.next()) {
                jeu = jeuFromResultSet(rs);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getJeu " + ex.getMessage());
        }

        return jeu;
    }

    /**
     *
     * @return nombre de jeux actuellmeent en pret
     */
    public int getNbJeuxSortis() {
        int retour = 0;
        try {

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement("select count(*) as nb_jeuxsortis \n"
                    + "from nu_emprunt  e \n"
                    + "where e.date_retour is null");

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                retour = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getNbJeuxSortis " + ex.getMessage());
        }
        return retour;
    }

    /**
     * @param adh
     * @return liste des jeux actuellement emprunté par l'adhérent
     */
    public List getListeJeuxEmprunte(Adhérent adh) {
        List listeJeux = new ArrayList();
        try {
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareCall("CALL listeJeuxEmprunte(?)");
            st.setString(1, adh.getRef_adhérent());
            ResultSet rs = st.executeQuery();

            listeJeux = resultSetToArrayList(rs);

        } catch (SQLException ex) {
            System.out.println("Echec getListeJeuxEmprunte " + ex.getMessage());
        }
        return listeJeux;
    }

    /**
     * @return le nombre de jeux total
     */
    public int getNbJeux() {
        int retour = 0;
        try {

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement("select count(*) as nb_jeuxtotal\n"
                    + "from nu_jeu  j");

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                retour = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Echec getNbJeux " + ex.getMessage());
        }
        return retour;
    }

    /**
     * permet a un adhérent d'emprunter un jeu
     *
     * @param emprunt
     */
    public void emprunterJeu(Emprunt emprunt) {
        try {
            String requète = "INSERT INTO nu_emprunt (ref_jeu, ref_adhérent, date_sortie) VALUES (?, ?, sysdate())";
//TODO bloquer si solde crédit <0
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);
            st.setString(1, emprunt.getAdhérent());
            st.setString(2, emprunt.getJeu());

            st.executeUpdate();

            emprunt.setId_emprunt(last_insert_id());

        } catch (SQLException ex) {
            System.out.println("Echec emprunterJeu " + ex.getMessage());
        }

    }

    /**
     * permet a un adhérent de rendre un jeu
     *
     * @param emprunt
     */
    public void rendreJeu(Emprunt emprunt) {
        try {
            String requète = "UPDATE ludo.nu_emprunt SET date_retour=sysdate() WHERE  id_emprunt=?";
//TODO consommer les crédits
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);
            st.setInt(1, emprunt.getId_emprunt());

            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Echec emprunterJeu " + ex.getMessage());
        }

    }

    /**
     * annuler un emprunt
     *
     * @deprecated 20/04/15 pas de besoin foncitionnel
     * @param emprunt
     */
    public void annulerEmprunt(Emprunt emprunt) {
        try {
            String requète = "DELETE FROM nu_emprunt WHERE  id_emprunt=?;";
//TODO ne permetre que la suppression d'un emprunt du jour
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requète);
            st.setInt(1, emprunt.getId_emprunt());

            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Echec emprunterJeu " + ex.getMessage());
        }

    }

    public void nouveauJeu(Jeu jeu) {
        String requete = "INSERT INTO nu_jeu "
                + "(ref_jeu, nom, fabricant,date_creation, prix_achat,date_achat,"
                + " nb_joueurs_min, nb_joueurs_max, consomme_piles, contenu,"
                + " commentaires, points, don,id_age_min, id_age_max, id_pile)"
                + " VALUES (?, ?, ?, sysdate(), ?, ?,"
                + " ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?);";
        try {
//TODO controle de la résa
            jeu.setRef_jeu(next_jeu());
            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requete);

            st.setString(1, jeu.getRef_jeu());
            st.setString(2, jeu.getNom());
            st.setString(3, jeu.getFabricant());
            st.setDouble(4, jeu.getPrix_achat());
            if (jeu.getDate_achat() != null) {
                st.setDate(5, new java.sql.Date(jeu.getDate_achat().getTime()));
            } else {
                st.setDate(5, null);
            }

            st.setInt(6, jeu.getNb_joueurs_min());
            st.setInt(7, jeu.getNb_joueurs_max());
            st.setInt(8, jeu.getPile() == null ? 0 : 1);
            st.setString(9, jeu.getContenu());
            st.setString(10, jeu.getCommentaires());
            
            st.setInt(11, jeu.getPoints());
            st.setInt(12, jeu.getPrix_achat() == 0.00 ? 1 : 0);//don?
            st.setInt(13, jeu.getAge_min() != null ? jeu.getAge_min().getId_age() : 0);
            st.setInt(14, jeu.getAge_max() != null ? jeu.getAge_max().getId_age() : 0);
            st.setInt(15, jeu.getPile() == null ? 0 : jeu.getPile().getId_pile());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Echec nouveauJeu " + ex.getMessage());
        }
    }

    public void majJeu(Jeu jeu) {
        String requete = "UPDATE ludo.nu_jeu SET nom=?,\n"
                + " fabricant=?,\n"
                + " prix_achat=?,\n"
                + " date_achat=?,\n"
                + " nb_joueurs_min=?,\n"
                + " nb_joueurs_max=?,\n"
                + " consomme_piles=?,\n"
                + " contenu=?,\n"
                + " commentaires=?,\n"
                + " points=?,\n"
                + " don=?,\n"
                + " id_age_min=?,\n"
                + " id_age_max=?,\n"
                + " id_pile=? WHERE  ref_jeu=?;";
        try {
//TODO controle de la résa

            PreparedStatement st = Connexion.getInstance().getConnexion().prepareStatement(requete);

            st.setString(1, jeu.getNom());
            st.setString(2, jeu.getFabricant());
            st.setDouble(3, jeu.getPrix_achat());
            if (jeu.getDate_achat() != null) {
                st.setDate(4, new java.sql.Date(jeu.getDate_achat().getTime()));
            } else {
                st.setDate(4, null);
            }
            st.setInt(5, jeu.getNb_joueurs_min());
            st.setInt(6, jeu.getNb_joueurs_max());
            st.setInt(7, jeu.getPile() == null ? 0 : 1);//conso pile?
            st.setString(8, jeu.getContenu());
            st.setString(9, jeu.getCommentaires());
            st.setInt(10, jeu.getPoints());
            st.setInt(11, jeu.getPrix_achat() == 0.00 ? 1 : 0);//don?
            st.setInt(12, jeu.getAge_min() != null ? jeu.getAge_min().getId_age() : 0);
            st.setInt(13, jeu.getAge_max() != null ? jeu.getAge_max().getId_age() : 0);
            st.setInt(14, jeu.getPile() == null ? 0 : jeu.getPile().getId_pile());
            st.setString(15, jeu.getRef_jeu());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Echec majJeu " + ex.getMessage());
        }
    }

    /**
     * Renvoie le prochain identifiant de la table adhérent
     *
     * @return String
     * @throws SQLException
     */
    private String next_jeu() throws SQLException {
        String retour = "";
        Statement st = Connexion.getInstance().getConnexion().createStatement();
        ResultSet rs = st.executeQuery("select max(j.ref_jeu), SUBSTRING(year(SYSDATE()),-2) from nu_jeu j");
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
