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
public class Compta {

    private int _id_mouvement;
    private Date _date_mouvement;
    private int _cr�dit;
    private String _nature;
    private String _ref_adh�rent;
    private double _montant;
    private String _type;
    /**
     * est-ce que le mouvement est encaiss�
     */
    private boolean _encaiss�;

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

    public int getCr�dit() {
        return _cr�dit;
    }

    public void setCr�dit(int _cr�dit) {
        this._cr�dit = _cr�dit;
    }

    public String getNature() {
        return _nature;
    }

    public void setNature(String _nature) {
        this._nature = _nature;
    }

    public String getRef_adh�rent() {
        return _ref_adh�rent;
    }

    public void setRef_adh�rent(String _ref_adh�rent) {
        this._ref_adh�rent = _ref_adh�rent;
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

    public boolean isEncaiss�() {
        return _encaiss�;
    }

    public void setEncaiss�(boolean _encaiss�) {
        this._encaiss� = _encaiss�;
    }

}
