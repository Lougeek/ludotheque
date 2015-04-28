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
public class Adhérent {

    private String _ref_adhérent;
    private String _titre;
    private String _adresse;
    private String _tel1;
    private String _tel2;
    private String _tel3;
    private String _email;
    private Date _échéance_cotisation;
    private int _solde_crédit;
    private Personne _référent;
    private Ville _ville;
    private Date _date_création;

    public Adhérent() {
    }

    public String getRef_adhérent() {
        return _ref_adhérent;
    }

    public void setRef_adhérent(String ref_adhérent) {
        this._ref_adhérent = ref_adhérent;
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

    public Date getÉchéance_cotisation() {
        return _échéance_cotisation;
    }

    public void setÉchéance_cotisation(Date échéance_cotisation) {
        this._échéance_cotisation = échéance_cotisation;
    }

    public int getSolde_crédit() {
        return _solde_crédit;
    }

    public void setSolde_crédit(int solde_crédit) {
        this._solde_crédit = solde_crédit;
    }

    public Personne getRéférent() {
        return _référent;
    }

    public void setRéférent(Personne référent) {
        this._référent = référent;
    }

    public Ville getVille() {
        return _ville;
    }

    public void setVille(Ville ville) {
        this._ville = ville;
    }

  

    public Date getDate_création() {
        return _date_création;
    }

    public void setDate_création(Date date_création) {
        this._date_création = date_création;
    }

    

}
