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
public class Adh�rent {

    private String _ref_adh�rent;
    private String _titre;
    private String _adresse;
    private String _tel1;
    private String _tel2;
    private String _tel3;
    private String _email;
    private Date _�ch�ance_cotisation;
    private int _solde_cr�dit;
    private Personne _r�f�rent;
    private Ville _ville;
    private Date _date_cr�ation;

    public Adh�rent() {
    }

    public String getRef_adh�rent() {
        return _ref_adh�rent;
    }

    public void setRef_adh�rent(String ref_adh�rent) {
        this._ref_adh�rent = ref_adh�rent;
    }

    public String getTitre() {
        return _titre;
    }

    public void setTitre(String titre) {
        this._titre = titre;
    }

    public String getAdresse() {
        return _adresse;
    }

    public void setAdresse(String adresse) {
        this._adresse = adresse;
    }

    public String getTel1() {
        return _tel1;
    }

    public void setTel1(String tel1) {
        this._tel1 = tel1;
    }

    public String getTel2() {
        return _tel2;
    }
/**
 * telephonne portable
 * @param tel2 
 */
    public void setTel2(String tel2) {
        this._tel2 = tel2;
    }

    public String getTel3() {
        return _tel3;
    }

    public void setTel3(String tel3) {
        this._tel3 = tel3;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public Date get�ch�ance_cotisation() {
        return _�ch�ance_cotisation;
    }

    public void set�ch�ance_cotisation(Date �ch�ance_cotisation) {
        this._�ch�ance_cotisation = �ch�ance_cotisation;
    }

    public int getSolde_cr�dit() {
        return _solde_cr�dit;
    }

    public void setSolde_cr�dit(int solde_cr�dit) {
        this._solde_cr�dit = solde_cr�dit;
    }

    public Personne getR�f�rent() {
        return _r�f�rent;
    }

    public void setR�f�rent(Personne r�f�rent) {
        this._r�f�rent = r�f�rent;
    }

    public Ville getVille() {
        return _ville;
    }

    public void setVille(Ville ville) {
        this._ville = ville;
    }

  

    public Date getDate_cr�ation() {
        return _date_cr�ation;
    }

    public void setDate_cr�ation(Date date_cr�ation) {
        this._date_cr�ation = date_cr�ation;
    }

    

}
