/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entit�es;

/**
 *
 * @author catenne
 */
public class Blocage {

    private int _id_blocage;
    private Ev�nement _Ev�nement;
    private Jeu _jeu;

    public int getId_blocage() {
        return _id_blocage;
    }

    public void setId_blocage(int _id_blocage) {
        this._id_blocage = _id_blocage;
    }

    public Ev�nement getEv�nement() {
        return _Ev�nement;
    }

    public void setEv�nement(Ev�nement _Ev�nement) {
        this._Ev�nement = _Ev�nement;
    }

    public Jeu getJeu() {
        return _jeu;
    }

    public void setJeu(Jeu _jeu) {
        this._jeu = _jeu;
    }

}
