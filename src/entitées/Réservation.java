/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitées;

import java.util.Date;
import java.util.List;

/**
 *
 * @author catenne
 */
public class Réservation {

    private int _id_réservation;
    private String _ref_jeu;
    private String _ref_adhérent;
    private Date _date_début;
    private Date _date_fin;
    private boolean _emporté;
    private List<RésaJeu> _résa_jeu;

    public int getId_réservation() {
        return _id_réservation;
    }

    public void setId_réservation(int _id_réservation) {
        this._id_réservation = _id_réservation;
    }

    public String getRef_jeu() {
        return _ref_jeu;
    }

    public void setRef_jeu(String _ref_jeu) {
        this._ref_jeu = _ref_jeu;
    }

    public String getRef_adhérent() {
        return _ref_adhérent;
    }

    public void setRef_adhérent(String _ref_adhérent) {
        this._ref_adhérent = _ref_adhérent;
    }

    public Date getDate_début() {
        return _date_début;
    }

    public void setDate_début(Date _date_début) {
        this._date_début = _date_début;
    }

    public Date getDate_fin() {
        return _date_fin;
    }

    public void setDate_fin(Date _date_fin) {
        this._date_fin = _date_fin;
    }

    public boolean isEmporté() {
        return _emporté;
    }

    public void setEmporté(boolean _emporté) {
        this._emporté = _emporté;
    }

    public List<RésaJeu> getRésa_jeu() {
        return _résa_jeu;
    }

    public void setRésa_jeu(List<RésaJeu> _résa_jeu) {
        this._résa_jeu = _résa_jeu;
    }

}
