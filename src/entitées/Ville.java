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
public class Ville {

    private int _id_ville;
    private String _d�partement;
    private String _nom;
    private String _code_postal;

    public int getId_ville() {
        return _id_ville;
    }

    public void setId_ville(int id_ville) {
        this._id_ville = id_ville;
    }

    public String getD�partement() {
        return _d�partement;
    }

    public void setD�partement(String d�partement) {
        this._d�partement = d�partement;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String nom) {
        this._nom = nom;
    }

    public String getCode_postal() {
        return _code_postal;
    }

    public void setCode_postal(String code_postal) {
        this._code_postal = code_postal;
    }
 @Override
    public boolean equals(Object obj) {
        return ((Ville)obj).getCode_postal().equals(this.getCode_postal()); //To change body of generated methods, choose Tools | Templates.
    }

}
