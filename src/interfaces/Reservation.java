/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 *
 */
public class Reservation extends javax.swing.JFrame {

    public static Integer act;
    public static Reservation reservation;

    /**
     * Creates new form Jeux
     */
    public Reservation() {
        initComponents();
        Image icone = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/ludo.jpg"));
        this.setIconImage(icone);
    }

    /**
     * @param args the command line arguments
     */
    public static void reservation(Integer action) {
        // 1 -- Cr�ation
        // 2 -- Affichage
        // 3 -- Modification

        act = action;
        if (action == 1) {

            reservation.modifEnableReservation();
        }
        if (action == 2) {

            reservation.modifEnableReservation();
        }
        if (action == 3) {

            reservation.modifEnableReservation();
        }
        reservation.setVisible(true);
    }

    public static Reservation getInstance(Integer action) {

        if (reservation == null) {
            reservation = new Reservation();
        }
        reservation(action);
        return reservation;
    }

    private void modifEnableReservation() {
        if ((act == 1) || (act == 3)) {
            if (act == 1) {
                // Cr�ation 
                jLabelCreationModifReservation.setText("Cr�ation d'une r�servation");
            } else // Modification
            {
                reservation.jLabelCreationModifReservation.setText("Modification d'une r�servation");
            }
            // Cr�ation ou modification
            // Les zones sont en saisies � l'exception du num�ro de r�servation qui est incr�ment� automatiquement
            jTextFieldDebutReservation.setEnabled(true);
            jTextFieldDateFinReservation.setEnabled(true);
            jTextFieldReferenceAdherent.setEnabled(true);
        }
        if (act == 2) {
            // Affichage
            reservation.jLabelCreationModifReservation.setText("Affichage d'une r�servation");
            // Les zones sont en affichage � l'exception du num�ro de r�servation qui est incr�ment� automatiquement
            jTextFieldDebutReservation.setEnabled(false);
            jTextFieldDateFinReservation.setEnabled(false);
            jTextFieldReferenceAdherent.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelR�servation = new javax.swing.JPanel();
        jLabelTitre = new javax.swing.JLabel();
        jLabelNumeroReservation = new javax.swing.JLabel();
        jTextFieldNumeroReservation = new javax.swing.JTextField();
        jLabelDateDebutReservation = new javax.swing.JLabel();
        jTextFieldDebutReservation = new javax.swing.JTextField();
        jLabelDateFinReservation = new javax.swing.JLabel();
        jTextFieldDateFinReservation = new javax.swing.JTextField();
        jLabelReferenceAdherent = new javax.swing.JLabel();
        jTextFieldReferenceAdherent = new javax.swing.JTextField();
        jTextFieldNomPrenomAdherent = new javax.swing.JTextField();
        jScrollPaneJeuxReserves = new javax.swing.JScrollPane();
        jTableJeux = new javax.swing.JTable();
        jLabelJeuxReserves = new javax.swing.JLabel();
        jButtonAjouterJeu = new javax.swing.JButton();
        jButtonRetirerJeu = new javax.swing.JButton();
        jButtonFermer = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jLabelCreationModifReservation = new javax.swing.JLabel();

        setTitle("RESERVATION");
        setResizable(false);

        jPanelR�servation.setBackground(new java.awt.Color(199, 245, 233));
        jPanelR�servation.setName(""); // NOI18N
        jPanelR�servation.setPreferredSize(new java.awt.Dimension(646, 825));

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitre.setText("R�servation");

        jLabelNumeroReservation.setText("Num�ro de r�servation :");

        jTextFieldNumeroReservation.setEnabled(false);

        jLabelDateDebutReservation.setText("R�servation du :");

        jTextFieldDebutReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDebutReservationActionPerformed(evt);
            }
        });

        jLabelDateFinReservation.setText("Au : ");

        jLabelReferenceAdherent.setText("Adh�rent :");

        jTextFieldNomPrenomAdherent.setEnabled(false);

        jTableJeux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "R�f", "Nom "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneJeuxReserves.setViewportView(jTableJeux);
        if (jTableJeux.getColumnModel().getColumnCount() > 0) {
            jTableJeux.getColumnModel().getColumn(0).setMinWidth(80);
            jTableJeux.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableJeux.getColumnModel().getColumn(0).setMaxWidth(120);
            jTableJeux.getColumnModel().getColumn(1).setMinWidth(200);
            jTableJeux.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableJeux.getColumnModel().getColumn(1).setMaxWidth(300);
        }

        jLabelJeuxReserves.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelJeuxReserves.setText("Jeux r�serv�s");

        jButtonAjouterJeu.setText("Ajouter jeu");
        jButtonAjouterJeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterJeuActionPerformed(evt);
            }
        });

        jButtonRetirerJeu.setText("Retirer jeu");
        jButtonRetirerJeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetirerJeuActionPerformed(evt);
            }
        });

        jButtonFermer.setText("Fermer");
        jButtonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFermerActionPerformed(evt);
            }
        });

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jLabelCreationModifReservation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCreationModifReservation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreationModifReservation.setText("Cr�ation d'une r�servation");

        javax.swing.GroupLayout jPanelR�servationLayout = new javax.swing.GroupLayout(jPanelR�servation);
        jPanelR�servation.setLayout(jPanelR�servationLayout);
        jPanelR�servationLayout.setHorizontalGroup(
            jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelR�servationLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelR�servationLayout.createSequentialGroup()
                        .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelJeuxReserves, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPaneJeuxReserves, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelR�servationLayout.createSequentialGroup()
                        .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelDateDebutReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNumeroReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelReferenceAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNumeroReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDebutReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldReferenceAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 36, Short.MAX_VALUE)
                        .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomPrenomAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelR�servationLayout.createSequentialGroup()
                                .addComponent(jLabelDateFinReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDateFinReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(29, Short.MAX_VALUE))))
            .addGroup(jPanelR�servationLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonAjouterJeu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRetirerJeu)
                .addGap(165, 165, 165)
                .addComponent(jButtonAnnuler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFermer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelTitre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelCreationModifReservation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelR�servationLayout.setVerticalGroup(
            jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelR�servationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCreationModifReservation)
                .addGap(12, 12, 12)
                .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumeroReservation)
                    .addComponent(jTextFieldNumeroReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDateDebutReservation)
                    .addComponent(jTextFieldDebutReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDateFinReservation)
                    .addComponent(jTextFieldDateFinReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReferenceAdherent)
                    .addComponent(jTextFieldReferenceAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomPrenomAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabelJeuxReserves, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneJeuxReserves, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanelR�servationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouterJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRetirerJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFermer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelR�servation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelR�servation, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDebutReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDebutReservationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDebutReservationActionPerformed

    private void jButtonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFermerActionPerformed
        // TODO add your handling code here:
        reservation.setVisible(false);
    }//GEN-LAST:event_jButtonFermerActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        // TODO add your handling code here:
        // Valider la cr�ation, ou la modification et quitter
        reservation.setVisible(false);
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // TODO add your handling code here:
        // Annuler la modification ou cr�ation et quitter
        if ((act == 1) || (act == 3)) {
            reservation.setVisible(false);
        }
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonAjouterJeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterJeuActionPerformed
        // Appel de la fen�tre ajouter un jeu
        JeuxChoix.getInstance("RESERVATION");
    }//GEN-LAST:event_jButtonAjouterJeuActionPerformed

    private void jButtonRetirerJeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetirerJeuActionPerformed
        ReservationRetirerJeu.getInstance();
// TODO add your handling code here:

    }//GEN-LAST:event_jButtonRetirerJeuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouterJeu;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonFermer;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonRetirerJeu;
    private javax.swing.JLabel jLabelCreationModifReservation;
    private javax.swing.JLabel jLabelDateDebutReservation;
    private javax.swing.JLabel jLabelDateFinReservation;
    private javax.swing.JLabel jLabelJeuxReserves;
    private javax.swing.JLabel jLabelNumeroReservation;
    private javax.swing.JLabel jLabelReferenceAdherent;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JPanel jPanelR�servation;
    private javax.swing.JScrollPane jScrollPaneJeuxReserves;
    private javax.swing.JTable jTableJeux;
    private javax.swing.JTextField jTextFieldDateFinReservation;
    private javax.swing.JTextField jTextFieldDebutReservation;
    private javax.swing.JTextField jTextFieldNomPrenomAdherent;
    private javax.swing.JTextField jTextFieldNumeroReservation;
    private javax.swing.JTextField jTextFieldReferenceAdherent;
    // End of variables declaration//GEN-END:variables
}
