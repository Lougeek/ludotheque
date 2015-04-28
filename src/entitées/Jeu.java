/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitées;

import java.util.Date;
import java.util.List;

/**
 *
 * @author catenne
 */
public class Jeu {

    private String _ref_jeu;
    private String _nom;
    private String _fabricant;
    private Date _date_creation;
    private double _prix_achat;
    private Date _date_achat;
    private int _nb_joueurs_min;
    private int _nb_joueurs_max;
    private boolean _consomme_piles;
    private String _contenu;
    private String _commentaires;
    private int _points;
    private boolean _don;
    private Age _age_min;
    private Age _age_max;
    private Pile _pile;
    private List<Catégorie> Catégories;

    public String getRef_jeu() {
        return _ref_jeu;
    }

    public void setRef_jeu(String _ref_jeu) {
        this._ref_jeu = _ref_jeu;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getFabricant() {
        return _fabricant;
    }

    public void setFabricant(String _fabricant) {
        this._fabricant = _fabricant;
    }

    public Date getDate_creation() {
        return _date_creation;
    }

    public void setDate_creation(Date _date_creation) {
        this._date_creation = _date_creation;
    }

    public double getPrix_achat() {
        return _prix_achat;
    }

    public void setPrix_achat(double _prix_achat) {
        this._prix_achat = _prix_achat;
    }

    public Date getDate_achat() {
        return _date_achat;
    }

    public void setDate_achat(Date _date_achat) {
        this._date_achat = _date_achat;
    }

    public int getNb_joueurs_min() {
        return _nb_joueurs_min;
    }

    public void setNb_joueurs_min(int _nb_joueurs_min) {
        this._nb_joueurs_min = _nb_joueurs_min;
    }

    public int getNb_joueurs_max() {
        return _nb_joueurs_max;
    }

    public void setNb_joueurs_max(int _nb_joueurs_max) {
        this._nb_joueurs_max = _nb_joueurs_max;
    }

    public boolean isConsomme_piles() {
        return _consomme_piles;
    }

    public void setConsomme_piles(boolean _consomme_piles) {
        this._consomme_piles = _consomme_piles;
    }

    public String getContenu() {
        return _contenu;
    }

    public void setContenu(String _contenu) {
        this._contenu = _contenu;
    }

    public String getCommentaires() {
        return _commentaires;
    }

    public void setCommentaires(String _commentaires) {
        this._commentaires = _commentaires;
    }

    public int getPoints() {
        return _points;
    }

    public void setPoints(int _points) {
        this._points = _points;
    }

    public boolean isDon() {
        return _don;
    }

    public void setDon(boolean _don) {
        this._don = _don;
    }

    public Age getAge_min() {
        return _age_min;
    }

    public void setAge_min(Age _age_min) {
        this._age_min = _age_min;
    }

    public Age getAge_max() {
        return _age_max;
    }

    public void setAge_max(Age _age_max) {
        this._age_max = _age_max;
    }

    public Pile getPile() {
        return _pile;
    }

    public void setPile(Pile _pile) {
        this._pile = _pile;
    }

    public List<Catégorie> getCatégories() {
        return Catégories;
    }

    public void setCatégories(List<Catégorie> Catégories) {
        this.Catégories = Catégories;
    }

}
