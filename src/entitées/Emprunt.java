/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entit�es;

import java.util.Date;

/**
 *
 * @author catenne
 */
public class Emprunt {
 private int _id_emprunt;
    private Date _date_sortie;
    private Date _date_retour;
    private String _ref_jeu;
    private String _ref_adh�rent;

    public Date getDate_sortie() {
        return _date_sortie;
    }

    public void setDate_sortie(Date _date_sortie) {
        this._date_sortie = _date_sortie;
    }

    public Date getDate_retour() {
        return _date_retour;
    }

    public void setDate_retour(Date _date_retour) {
        this._date_retour = _date_retour;
    }

    public String getJeu() {
        return _ref_jeu;
    }

    public void setJeu(String _jeu) {
        this._ref_jeu = _jeu;
    }

    public String getAdh�rent() {
        return _ref_adh�rent;
    }

    public void setAdh�rent(String _adh�rent) {
        this._ref_adh�rent = _adh�rent;
    }

    public int getId_emprunt() {
        return _id_emprunt;
    }

    public void setId_emprunt(int _id_emprunt) {
        this._id_emprunt = _id_emprunt;
    }

}
