/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdd.Connexion;
import entitées.*;

import dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Christelle
 */
public class HistoriqueManager {

    public List<Historique> getHistoriqueAdh(String ref_adh) {

        List<Historique> listeHistoAdh = new ArrayList<>();

        // Création de la liste des emprunts de l'adhérent
        List<Emprunt> listeEmprunt = new ArrayList<>();
        EmpruntManager manag_emprunt = new EmpruntManager();
        listeEmprunt = manag_emprunt.getEmprunt(ref_adh);
        Jeu jeu = new Jeu();
        JeuManager manag_jeu = new JeuManager();
        Emprunt emprunt;
        Integer i = 0;
        Integer taille = listeEmprunt.size();
        System.out.println("Liste emprunt size : " + taille);

        while (i < taille) {

            // adherentDate = listeEmprunt.get(i);
            emprunt = listeEmprunt.get(i);
            Date datesort;
            datesort = emprunt.getDate_sortie();
            System.out.println("Date sortie" + datesort);
            Historique adhHisto = new Historique();
            adhHisto.setDateHistorique(datesort);
            adhHisto.setDateRetour(emprunt.getDate_retour());
            adhHisto.setTypeMvt("Emprunt");

            adhHisto.setRef(emprunt.getJeu());
            jeu = manag_jeu.getJeu(emprunt.getJeu());

            long dureest = 0;
            long date;

            date = emprunt.getDate_sortie().getTime();
            if (date != 0) {
                date = emprunt.getDate_retour().getTime();
                if (date != 0) {
                    dureest = (emprunt.getDate_sortie().getTime() - emprunt.getDate_retour().getTime()) / 86400000;

                    if (dureest != 0) {
                        dureest = (dureest / 7) * (jeu.getPoints());
                    }
                }
            }
            // Montant = Nombre de semaines de location * nombre de points du jeu

            adhHisto.setMontant(String.valueOf(dureest));
            adhHisto.setNom(jeu.getNom());
            listeHistoAdh.add(adhHisto);
            i++;
        }

        // Création de la liste comptable de l'adhérent
        // Cette liste reprend les informations de paiement des cotisations, adhésion ou achat de points de l'adhérent
        List<Compta> listeCompta = new ArrayList<>();
        ComptaManager manag_compta = new ComptaManager();
        listeCompta = manag_compta.getCompta(ref_adh);
        Compta compta = new Compta();
        i = 0;
        String typeMvt;
        taille = listeCompta.size();

        while (i < taille) {
            compta = listeCompta.get(i);
            Historique adhHisto = new Historique();

            adhHisto.setDateHistorique(compta.getDate_mouvement());
            adhHisto.setModePaiement(compta.getNature());
            typeMvt = compta.getType();
            if (typeMvt.equals("Crédit")) {
                adhHisto.setTypeMvt("Crédit de points");
                adhHisto.setMontant(String.valueOf(compta.getCrédit()));

            } else {
                adhHisto.setTypeMvt(compta.getType());
                adhHisto.setMontant(String.valueOf(compta.getMontant()));
            }
            listeHistoAdh.add(adhHisto);
            i++;
        }
//tri
        Collections.sort(listeHistoAdh, Collections.reverseOrder());

        taille = listeHistoAdh.size();
        System.out.println("Liste chargée : " + taille);
//        for (Historique histo : listeHistoAdh) {
//            
//        }
//        while (i < taille) {
//            histo = listeHistoAdh.get(i);
//
//            getContentPane().add(jTableHistoAdherent);
//            i++;
//        }

        return listeHistoAdh;
    }
}
