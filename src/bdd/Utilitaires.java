/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author catenne
 */
public class Utilitaires {
    
    /**
     * transforme un résultset complet en list de map, les clefs correspondent au nom de colonnes de la requète
     * @see <code>
     * for (Object ligne : liste) {
     *      System.out.println("item nom ="+((Map) ligne).get("nom"));
     * }
     * </code>
     * @param rs
     * @return <code>List<HashMap></code>
     * @throws SQLException 
     */
        public static List<HashMap> resultSetToArrayList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList();
        while (rs.next()) {
            HashMap row = new HashMap(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }
        
            /**
     * renvoie le dernier identifiant inséré
     *
     * @return int
     * @throws SQLException
     */
    public static int last_insert_id() throws SQLException {
        int retour = 0;
        Statement st = Connexion.getInstance().getConnexion().createStatement();
        ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
        if (rs.next()) {
            retour = rs.getInt(1);
        } else {
            throw new SQLException("Impossible de trouver le dernier enrgistrement");
        }
        return retour;
    }
}
