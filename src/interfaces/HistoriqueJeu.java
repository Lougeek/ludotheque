/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.*;

/**
 *
 * @author andre
 */
public class HistoriqueJeu extends javax.swing.JFrame {

    private static HistoriqueJeu instance = null;
    
    /**
     * Creates new form HistoriqueJeu
     */
    public HistoriqueJeu() {
        initComponents();
        this.setLocation(400, 50);
    }

    public static HistoriqueJeu getInstance(String ref) {
         if (instance == null) {
            instance = new HistoriqueJeu();
        }
        instance.setVisible(true);
        return instance;
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHistoJeu = new javax.swing.JPanel();
        jLabelHistoJeu = new javax.swing.JLabel();
        jLabelRef = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPaneHistoJeu = new javax.swing.JScrollPane();
        jTableHistoJeu = new javax.swing.JTable();
        jButtonFermer = new javax.swing.JButton();
        jLabelTitre = new javax.swing.JLabel();
        jTextFieldRefJeu = new javax.swing.JTextField();
        jTextFieldNomJeu = new javax.swing.JTextField();

        setTitle("HISTORIQUE JEUX");

        jPanelHistoJeu.setBackground(new java.awt.Color(199, 245, 233));

        jLabelHistoJeu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelHistoJeu.setText("Historique");

        jLabelRef.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRef.setText("R�f�rence : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nom du jeu :");

        jTableHistoJeu.setModel(new ModelTableHistoriqueJeu());
        jScrollPaneHistoJeu.setViewportView(jTableHistoJeu);

        jButtonFermer.setText("Fermer");
        jButtonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFermerActionPerformed(evt);
            }
        });

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelTitre.setText("Fiche Jeu");

        jTextFieldRefJeu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRefJeu.setEnabled(false);

        jTextFieldNomJeu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNomJeu.setEnabled(false);

        javax.swing.GroupLayout jPanelHistoJeuLayout = new javax.swing.GroupLayout(jPanelHistoJeu);
        jPanelHistoJeu.setLayout(jPanelHistoJeuLayout);
        jPanelHistoJeuLayout.setHorizontalGroup(
            jPanelHistoJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHistoJeuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonFermer)
                .addGap(81, 81, 81))
            .addGroup(jPanelHistoJeuLayout.createSequentialGroup()
                .addGroup(jPanelHistoJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHistoJeuLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPaneHistoJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHistoJeuLayout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jLabelHistoJeu))
                    .addGroup(jPanelHistoJeuLayout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHistoJeuLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabelRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRefJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNomJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelHistoJeuLayout.setVerticalGroup(
            jPanelHistoJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistoJeuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelHistoJeu)
                .addGap(39, 39, 39)
                .addGroup(jPanelHistoJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRef)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldRefJeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomJeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneHistoJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonFermer)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHistoJeu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHistoJeu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFermerActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Jeux.getInstance(3,"",this); 
    }//GEN-LAST:event_jButtonFermerActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFermer;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelHistoJeu;
    private javax.swing.JLabel jLabelRef;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JPanel jPanelHistoJeu;
    private javax.swing.JScrollPane jScrollPaneHistoJeu;
    private javax.swing.JTable jTableHistoJeu;
    private javax.swing.JTextField jTextFieldNomJeu;
    private javax.swing.JTextField jTextFieldRefJeu;
    // End of variables declaration//GEN-END:variables
}
