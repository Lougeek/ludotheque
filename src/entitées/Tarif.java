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
public class Tarif {

    private int _id_tarif;
    private String _nom;
    private double _prix;

    public int getId_tarif() {
        return _id_tarif;
    }

    public void setId_tarif(int _id_tarif) {
        this._id_tarif = _id_tarif;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public double getPrix() {
        return _prix;
    }

    public void setPrix(double _prix) {
        this._prix = _prix;
    }

}
