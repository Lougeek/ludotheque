
import bdd.Connexion;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import entitées.Adhérent;
import entitées.Personne;
import entitées.Ville;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.List;
import dao.AdhérentManager;
import dao.JeuManager;
import dao.ReservationManager;
import entitées.Jeu;
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
        AdhérentManager adhManager = new AdhérentManager();
        Adhérent adh = adhManager.getAdhérent("15/001");
//        System.out.println("nom "+adh.getRéférent().getNom());
//        System.out.println("ville "+adh.getVille().getNom()+" "+ adh.getVille().getDépartement());
//        List liste = adhManager.getAdhérents();
//        System.out.println("nb adhérents : "+liste.size());
//        
//        //création
//        Personne nu_pers = new Personne();
//        nu_pers.setNom("BON");
//        nu_pers.setPrénom("Jean");
//        
//        Adhérent nu_adh = new Adhérent();
//        nu_adh.setAdresse("rue Tillante");
//        nu_adh.setSolde_crédit(12);
//        nu_adh.setRéférent(nu_pers);
//        Ville mars = new Ville();
//        mars.setId_ville(2416);
//        nu_adh.setVille(mars);
//      //  adhManager.nouvelAdhérent(nu_adh);
//        
//        //maj adhérent
//        nu_adh.getRéférent().setNom("patrick");
//        nu_adh.setAdresse("rue pain");
//        nu_adh.setTitre("maj");
//      //  adhManager.majAdhérent(nu_adh);
//        
//        //get liste jeu réserver
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
//            System.out.println("resa jeu 15/001 ="+((Map)jeu).get("ref_adhérent")+" "+((Map) jeu).get("nom"));
//        }
       //famille
        adh.setRef_adhérent("15/001");
        System.out.println("adher ref "+adh.getRef_adhérent());
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
       // jM.getListeJeuxEmprunte(Adhérent adh)
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
            System.out.println("échec chargement des pilotes " + ex);
        }
     
    }
}
