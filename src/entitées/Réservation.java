/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entit�es;

import java.util.Date;
import java.util.List;

/**
 *
 * @author catenne
 */
public class R�servation {

    private int _id_r�servation;
    private String _ref_jeu;
    private String _ref_adh�rent;
    private Date _date_d�but;
    private Date _date_fin;
    private boolean _emport�;
    private List<R�saJeu> _r�sa_jeu;

    public int getId_r�servation() {
        return _id_r�servation;
    }

    public void setId_r�servation(int _id_r�servation) {
        this._id_r�servation = _id_r�servation;
    }

    public String getRef_jeu() {
        return _ref_jeu;
    }

    public void setRef_jeu(String _ref_jeu) {
        this._ref_jeu = _ref_jeu;
    }

    public String getRef_adh�rent() {
        return _ref_adh�rent;
    }

    public void setRef_adh�rent(String _ref_adh�rent) {
        this._ref_adh�rent = _ref_adh�rent;
    }

    public Date getDate_d�but() {
        return _date_d�but;
    }

    public void setDate_d�but(Date _date_d�but) {
        this._date_d�but = _date_d�but;
    }

    public Date getDate_fin() {
        return _date_fin;
    }

    public void setDate_fin(Date _date_fin) {
        this._date_fin = _date_fin;
    }

    public boolean isEmport�() {
        return _emport�;
    }

    public void setEmport�(boolean _emport�) {
        this._emport� = _emport�;
    }

    public List<R�saJeu> getR�sa_jeu() {
        return _r�sa_jeu;
    }

    public void setR�sa_jeu(List<R�saJeu> _r�sa_jeu) {
        this._r�sa_jeu = _r�sa_jeu;
    }

}
