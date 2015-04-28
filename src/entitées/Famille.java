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
public class Famille {

    private String _ref_adhérent;
    private int _id_personne;

    public String getRef_adhérent() {
        return _ref_adhérent;
    }

    public void setRef_adhérent(String _ref_adhérent) {
        this._ref_adhérent = _ref_adhérent;
    }

    public int getId_personne() {
        return _id_personne;
    }

    public void setId_personne(int _id_personne) {
        this._id_personne = _id_personne;
    }

}
