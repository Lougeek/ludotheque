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
public class Personne {

    private int id_personne;
    private String nom;
    private String pr�nom;
    private String date_naissance;

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPr�nom() {
        return pr�nom;
    }

    public void setPr�nom(String pr�nom) {
        this.pr�nom = pr�nom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

}
