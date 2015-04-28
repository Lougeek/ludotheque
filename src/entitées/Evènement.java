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
public class Evènement {

    private int _idEvènement;
    private String _nom;
    private Date _dateEvènement;
    private TypeEvent _typeEvent;

    public int getIdEvènement() {
        return _idEvènement;
    }

    public void setIdEvènement(int _idEvènement) {
        this._idEvènement = _idEvènement;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public Date getDateEvènement() {
        return _dateEvènement;
    }

    public void setDateEvènement(Date _dateEvènement) {
        this._dateEvènement = _dateEvènement;
    }

    public TypeEvent getTypeEvent() {
        return _typeEvent;
    }

    public void setTypeEvent(TypeEvent _typeEvent) {
        this._typeEvent = _typeEvent;
    }

}
