/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitées;

import java.util.Date;

/**
 *
 * @author catenne
 */
public class Compta {

    private int _id_mouvement;
    private Date _date_mouvement;
    private int _crédit;
    private String _nature;
    private String _ref_adhérent;
    private double _montant;
    private String _type;
    /**
     * est-ce que le mouvement est encaissé
     */
    private boolean _encaissé;

    public int getId_mouvement() {
        return _id_mouvement;
    }

    public void setId_mouvement(int _id_mouvement) {
        this._id_mouvement = _id_mouvement;
    }

    public Date getDate_mouvement() {
        return _date_mouvement;
    }

    public void setDate_mouvement(Date _date_mouvement) {
        this._date_mouvement = _date_mouvement;
    }

    public int getCrédit() {
        return _crédit;
    }

    public void setCrédit(int _crédit) {
        this._crédit = _crédit;
    }

    public String getNature() {
        return _nature;
    }

    public void setNature(String _nature) {
        this._nature = _nature;
    }

    public String getRef_adhérent() {
        return _ref_adhérent;
    }

    public void setRef_adhérent(String _ref_adhérent) {
        this._ref_adhérent = _ref_adhérent;
    }

    public double getMontant() {
        return _montant;
    }

    public void setMontant(double _montant) {
        this._montant = _montant;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public boolean isEncaissé() {
        return _encaissé;
    }

    public void setEncaissé(boolean _encaissé) {
        this._encaissé = _encaissé;
    }

}
