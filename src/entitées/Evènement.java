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
public class Evčnement {

    private int _idEvčnement;
    private String _nom;
    private Date _dateEvčnement;
    private TypeEvent _typeEvent;

    public int getIdEvčnement() {
        return _idEvčnement;
    }

    public void setIdEvčnement(int _idEvčnement) {
        this._idEvčnement = _idEvčnement;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public Date getDateEvčnement() {
        return _dateEvčnement;
    }

    public void setDateEvčnement(Date _dateEvčnement) {
        this._dateEvčnement = _dateEvčnement;
    }

    public TypeEvent getTypeEvent() {
        return _typeEvent;
    }

    public void setTypeEvent(TypeEvent _typeEvent) {
        this._typeEvent = _typeEvent;
    }

}
