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
public class Ev�nement {

    private int _idEv�nement;
    private String _nom;
    private Date _dateEv�nement;
    private TypeEvent _typeEvent;

    public int getIdEv�nement() {
        return _idEv�nement;
    }

    public void setIdEv�nement(int _idEv�nement) {
        this._idEv�nement = _idEv�nement;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public Date getDateEv�nement() {
        return _dateEv�nement;
    }

    public void setDateEv�nement(Date _dateEv�nement) {
        this._dateEv�nement = _dateEv�nement;
    }

    public TypeEvent getTypeEvent() {
        return _typeEvent;
    }

    public void setTypeEvent(TypeEvent _typeEvent) {
        this._typeEvent = _typeEvent;
    }

}
