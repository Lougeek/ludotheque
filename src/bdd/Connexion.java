/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author catenne
 */
public class Connexion {

    private Connection connexion;
    private static Connexion instance = null;

    private Connexion() {
        try {
            //création de la connexion et du driver
           
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3311/ludo";
            connexion = java.sql.DriverManager.getConnection(url, "dba", "dba");
           
            System.out.println("Connexion réussie");

        } catch (Exception e) {
            System.out.println("Connexion échouée " + e);
        }
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void finConnexion() {
        try {
            if (connexion != null) {
                connexion.close();
                instance = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }





}
