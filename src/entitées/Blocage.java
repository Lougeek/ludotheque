/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitées;

/**
 *
 * @author catenne
 */
public class Blocage {

    private int _id_blocage;
    private Evènement _Evènement;
    private Jeu _jeu;

    public int getId_blocage() {
        return _id_blocage;
    }

    public void setId_blocage(int _id_blocage) {
        this._id_blocage = _id_blocage;
    }

    public Evènement getEvènement() {
        return _Evènement;
    }

    public void setEvènement(Evènement _Evènement) {
        this._Evènement = _Evènement;
    }

    public Jeu getJeu() {
        return _jeu;
    }

    public void setJeu(Jeu _jeu) {
        this._jeu = _jeu;
    }

}
