/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import org.jdesktop.swingx.calendar.*;

/**
 * @deprecated 
 * @author andre
 */
public class SortieJeux extends javax.swing.JFrame {

    /**
     * Creates new form Sortie
     */
    public SortieJeux() {
        initComponents();
        this.setLocation(400, 50);
        CalendarUtils cal = new CalendarUtils();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSortie = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonSortie = new javax.swing.JButton();
        jLabelListeDesJeux = new javax.swing.JLabel();
        jScrollPaneListeJeux = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButtonSortirAutreJeux = new javax.swing.JButton();
        jLabelLabelAdh�rent = new javax.swing.JLabel();
        jLabelAdherent = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jXDatePickerDate = new org.jdesktop.swingx.JXDatePicker();
        jLabelDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SORTIE D'UN OU PLUSIEURS JEUX");

        jPanelSortie.setBackground(new java.awt.Color(199, 245, 233));

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

        jButtonSortie.setBackground(new java.awt.Color(255, 51, 51));
        jButtonSortie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSortie.setText("SORTIE");
        jButtonSortie.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonSortie.setEnabled(false);
        jButtonSortie.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabelListeDesJeux.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelListeDesJeux.setText("Liste de jeux emprunt�s : ");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneListeJeux.setViewportView(jList1);

        jButtonSortirAutreJeux.setText("Sortir un autre jeu");
        jButtonSortirAutreJeux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortirAutreJeuxActionPerformed(evt);
            }
        });

        jLabelLabelAdh�rent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLabelAdh�rent.setText("Adh�rent :");

        jLabelAdherent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAdherent.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Choisir l'adh�rent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Notes :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Effacer les notes");

        jLabelDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDate.setText("Date :");

        javax.swing.GroupLayout jPanelSortieLayout = new javax.swing.GroupLayout(jPanelSortie);
        jPanelSortie.setLayout(jPanelSortieLayout);
        jPanelSortieLayout.setHorizontalGroup(
            jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSortieLayout.createSequentialGroup()
                .addGroup(jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSortieLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButtonAnnuler))
                    .addGroup(jPanelSortieLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXDatePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelSortieLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButtonSortie, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelSortieLayout.createSequentialGroup()
                                    .addComponent(jLabelListeDesJeux)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                                    .addComponent(jButtonSortirAutreJeux, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPaneListeJeux)
                                .addGroup(jPanelSortieLayout.createSequentialGroup()
                                    .addComponent(jLabelLabelAdh�rent)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelAdherent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1))
                            .addComponent(jLabelDate))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanelSortieLayout.setVerticalGroup(
            jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSortieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSortie, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelListeDesJeux)
                    .addComponent(jButtonSortirAutreJeux))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneListeJeux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLabelAdh�rent)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXDatePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanelSortieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonAnnuler))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelSortie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelSortie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonSortirAutreJeuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortirAutreJeuxActionPerformed
        
        setVisible(false);
        //SortieChoix.getInstance();
    }//GEN-LAST:event_jButtonSortirAutreJeuxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        setVisible(false);
        AdherentChoix.choix();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        //TODO cr�er un emprunt
    }//GEN-LAST:event_jButtonOKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void jeux() {
        new SortieJeux().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonSortie;
    private javax.swing.JButton jButtonSortirAutreJeux;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAdherent;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelLabelAdh�rent;
    private javax.swing.JLabel jLabelListeDesJeux;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanelSortie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneListeJeux;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerDate;
    // End of variables declaration//GEN-END:variables
}
