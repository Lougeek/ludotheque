
import bdd.Connexion;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import entit�es.Adh�rent;
import entit�es.Personne;
import entit�es.Ville;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.List;
import dao.Adh�rentManager;
import dao.JeuManager;
import dao.ReservationManager;
import entit�es.Jeu;
import java.util.HashMap;
import java.util.Map;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author catenne
 */
public class testBdd {
    private static Connexion connexion;

  /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("test contact BDD");
        connexion = Connexion.getInstance();
       getTruc();
        Adh�rentManager adhManager = new Adh�rentManager();
        Adh�rent adh = adhManager.getAdh�rent("15/001");
//        System.out.println("nom "+adh.getR�f�rent().getNom());
//        System.out.println("ville "+adh.getVille().getNom()+" "+ adh.getVille().getD�partement());
//        List liste = adhManager.getAdh�rents();
//        System.out.println("nb adh�rents : "+liste.size());
//        
//        //cr�ation
//        Personne nu_pers = new Personne();
//        nu_pers.setNom("BON");
//        nu_pers.setPr�nom("Jean");
//        
//        Adh�rent nu_adh = new Adh�rent();
//        nu_adh.setAdresse("rue Tillante");
//        nu_adh.setSolde_cr�dit(12);
//        nu_adh.setR�f�rent(nu_pers);
//        Ville mars = new Ville();
//        mars.setId_ville(2416);
//        nu_adh.setVille(mars);
//      //  adhManager.nouvelAdh�rent(nu_adh);
//        
//        //maj adh�rent
//        nu_adh.getR�f�rent().setNom("patrick");
//        nu_adh.setAdresse("rue pain");
//        nu_adh.setTitre("maj");
//      //  adhManager.majAdh�rent(nu_adh);
//        
//        //get liste jeu r�server
//        ReservationManager resMan = new ReservationManager();
//        List listeJeux = resMan.getListeJeuxReserve(1);
//        
//        for (Object jeu : listeJeux) {
//            
//            System.out.println("resa 1 ="+((Map) jeu).get("nom"));
//        }
//        listeJeux = resMan.getListeReservationsJeu("15/001");
//        
//        for (Object jeu : listeJeux) {
//            
//            System.out.println("resa jeu 15/001 ="+((Map)jeu).get("ref_adh�rent")+" "+((Map) jeu).get("nom"));
//        }
       //famille
        adh.setRef_adh�rent("15/001");
        System.out.println("adher ref "+adh.getRef_adh�rent());
        System.out.println("taille de la famille de 15/001" +adhManager.getFamille(adh).size());
       
        //get nb jeux emprunter
        JeuManager jM = new JeuManager();
        System.out.println("nb jeux sorti liste" +jM.getJeux(Boolean.TRUE).size());
        System.out.println("nb jeux libre liste" +jM.getJeux(Boolean.FALSE).size());
        System.out.println("15/001"+adhManager.getNbJeuxSortis("15/001"));
        System.out.println("nb jeu total "+jM.getNbJeux());
        System.out.println("nb jeu sortis "+jM.getNbJeuxSortis());
//        Jeu monjeu = new Jeu();
//        monjeu.setNom("le nouveau jeu");
//        jM.nouveauJeu(monjeu);
//        monjeu.setContenu("plein de trucs chouettes");
//        jM.majJeu(monjeu);
        //list des jeux emprunter par 15/001
       // jM.getListeJeuxEmprunte(Adh�rent adh)
    }
    
        public static void getTruc() {
        Hashtable<String, String> vol = null;
        try {
            Statement select = connexion.getConnexion().createStatement();
            
            ResultSet rs = select.executeQuery("select count(*) from ex_adherents");
            vol = new Hashtable<>();
            if (rs.next()) {
                System.out.println("rs "+rs.getString(1));

            }
            select.close();

        } catch (SQLException ex) {
            System.out.println("�chec chargement des pilotes " + ex);
        }
     
    }
}
