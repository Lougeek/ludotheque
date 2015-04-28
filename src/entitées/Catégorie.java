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
class Catégorie {

    private int _id_catégorie;
    private String _nom;

    public int getId_catégorie() {
        return _id_catégorie;
    }

    public void setId_catégorie(int _id_catégorie) {
        this._id_catégorie = _id_catégorie;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

}
