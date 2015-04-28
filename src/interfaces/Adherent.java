/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dao.AdhérentManager;
import entitées.Adhérent;
import entitées.Personne;
import entitées.Ville;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.ModelComboVille;
import model.ModelTablePersonne;
import renderer.RendererComboVille;

/**
 *
 *
 */
public class Adherent extends javax.swing.JFrame {

    private static boolean enab;
    private static Integer act;
    public boolean ferme;
    private static String refAdh;
    public static Adherent jFrameAdherent;
    public Adhérent _adherent;

    /**
     * Creates new form Jeux
     */
    public Adherent() {
        initComponents();
        Image icone = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/ludo.jpg"));
        this.setIconImage(icone);
    }

    /**
     * @deprecated 22/04 alex pas à jour
     */
    public static void adherent(Integer action, String refAdherent) {
        // 1 -- Création
        // 2 -- Affichage
        // 3 -- Modification

        act = action;
        if (action == 1) {
            enab = true;
            jFrameAdherent.modifEnableAdherent();
        }
        if (action == 2) {
            enab = false;
            refAdh = refAdherent;
            jFrameAdherent.modifEnableAdherent();
        }
        if (action == 3) {
            enab = true;
            refAdh = refAdherent;
            jFrameAdherent.modifEnableAdherent();
        }
        jFrameAdherent.setVisible(true);
    }

    /**
     * @deprecated 22/04 alex, on ne passe plus par la
     * @param action
     * @param refAdherent
     * @return
     */
    public static Adherent getInstance(Integer action, String refAdherent) {

        if (jFrameAdherent == null) {
            jFrameAdherent = new Adherent();
        }
        adherent(action, refAdherent);
        return jFrameAdherent;
    }

    public static Adherent getInstance() {

        if (jFrameAdherent == null) {
            jFrameAdherent = new Adherent();
        }

        return jFrameAdherent;
    }

    public void setFenetre(Integer action, String refAdherent) {
        // 1 -- Création
        // 2 -- Affichage
        // 3 -- Modification

        act = action;
        if (action == 1) {
            enab = true;
            System.out.println("création!");
            _adherent = new Adhérent();
            jFrameAdherent.modifEnableAdherent();
        }
        if (action == 2) {
            enab = false;
            jFrameAdherent.modifEnableAdherent();
            refAdh = refAdherent;

            //get adhérent
            _adherent = new AdhérentManager().getAdhérent(refAdh);
            //chargement de la famille
            ((ModelTablePersonne) jTablePersonnes.getModel()).setListePersonne(_adherent);

            //maj des infos adhérents
            chargerAdhérent();

        }
        if (action == 3) {
            enab = true;
            refAdh = refAdherent;
            _adherent = new AdhérentManager().getAdhérent(refAdh);
            jFrameAdherent.modifEnableAdherent();
            chargerAdhérent();
        }
        jFrameAdherent.setVisible(true);
    }

    /**
     * met à jour les données de l'affichage avec l'adhérent en cour
     */
    private void chargerAdhérent() {
        jTextFieldReferenceAdherent.setText(_adherent.getRef_adhérent());
        setSelectedTitre(_adherent.getTitre());
        jTextFieldNomAdherent.setText(_adherent.getRéférent().getNom());
        jTextFieldPrenomAdherent.setText(_adherent.getRéférent().getPrénom());
        jTextAreaAdresse.setText(_adherent.getAdresse());
        jComboBoxVille.setSelectedItem(_adherent.getVille());
        jTextFieldCodePostal.setText(_adherent.getVille().getCode_postal());
        jTextFieldTelephoneDomicile.setText(_adherent.getTel1());
        jTextFieldTelephonePortable.setText(_adherent.getTel2());
        jTextFieldTelephoneTravail.setText(_adherent.getTel3());
        jTextFieldEmail.setText(_adherent.getEmail());
        jTextAreaNotes.setText("TODO");//TODO rajouter le commentazire dans la base

    }

    /**
     * active ou désactive la modification des champs
     */
    private void modifEnableAdherent() {

        jRadioButtonEcole.setEnabled(enab);
        jRadioButtonAssociation.setEnabled(enab);
        jRadioButtonFamille.setEnabled(enab);
        jRadioButtonRAM.setEnabled(enab);

        jTextFieldReferenceAdherent.setEnabled(false);//pas de modifs quoi qu'il arrive
        jTextFieldNomAdherent.setEnabled(enab);
        jTextFieldPrenomAdherent.setEnabled(enab);
        jTextAreaAdresse.setEnabled(enab);
        jComboBoxVille.setEnabled(enab);
        jTextFieldCodePostal.setEnabled(enab);
        jTextFieldTelephoneDomicile.setEnabled(enab);
        jTextFieldTelephonePortable.setEnabled(enab);
        jTextFieldTelephoneTravail.setEnabled(enab);
        jTextFieldEmail.setEnabled(enab);
        jTablePersonnes.setEnabled(enab);
        jTextAreaNotes.setEnabled(enab);

        if (enab) {
            /**
             * Enable = True --> Création ou modification Enable = False -->
             * Affichage
             *
             */
            jButtonOK.setText("OK");
            jButtonAnnuler.setText("Annuler");
            ferme = false;

        } else {
            jButtonOK.setText("Modif");
            jButtonAnnuler.setText("Fermer");
            ferme = true;
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

        buttonGroupTitre = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        jPanellAdherent = new javax.swing.JPanel();
        jLabelTitre = new javax.swing.JLabel();
        jLabelRefAdherent = new javax.swing.JLabel();
        jTextFieldReferenceAdherent = new javax.swing.JTextField();
        jLabelTitreAdherent = new javax.swing.JLabel();
        jLabelNomAdherent = new javax.swing.JLabel();
        jTextFieldNomAdherent = new javax.swing.JTextField();
        jLabelPrenomAdherent = new javax.swing.JLabel();
        jTextFieldPrenomAdherent = new javax.swing.JTextField();
        jRadioButtonFamille = new javax.swing.JRadioButton();
        jRadioButtonAssociation = new javax.swing.JRadioButton();
        jRadioButtonRAM = new javax.swing.JRadioButton();
        jRadioButtonEcole = new javax.swing.JRadioButton();
        jLabelAdresse = new javax.swing.JLabel();
        jLabelCodePostal = new javax.swing.JLabel();
        jTextFieldCodePostal = new javax.swing.JTextField();
        jLabelVille = new javax.swing.JLabel();
        jComboBoxVille = new javax.swing.JComboBox();
        jLabelTelephone = new javax.swing.JLabel();
        jTextFieldTelephonePortable = new javax.swing.JTextField();
        jLabelTelephonePortable = new javax.swing.JLabel();
        jLabelTelephoneDomicile = new javax.swing.JLabel();
        jLabelTelephoneTravail = new javax.swing.JLabel();
        jTextFieldTelephoneDomicile = new javax.swing.JTextField();
        jTextFieldTelephoneTravail = new javax.swing.JTextField();
        jScrollPaneAdresse = new javax.swing.JScrollPane();
        jTextAreaAdresse = new javax.swing.JTextArea();
        jScrollPaneNotes = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jLabelNotes = new javax.swing.JLabel();
        jLabelEcheanceCotisation = new javax.swing.JLabel();
        jTextFieldEcheanceCotisation = new javax.swing.JTextField();
        jLabelCredits = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonOK = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonHistorique = new javax.swing.JButton();
        jScrollPanePersonnes = new javax.swing.JScrollPane();
        jTablePersonnes = new javax.swing.JTable();
        jButtonReservation = new javax.swing.JButton();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        buttonGroupTitre.add(jRadioButtonFamille);
        buttonGroupTitre.add(jRadioButtonAssociation);
        buttonGroupTitre.add(jRadioButtonRAM);
        buttonGroupTitre.add(jRadioButtonEcole);
        jRadioButtonFamille.setSelected(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setTitle("ADHERENT");
        setResizable(false);

        jPanellAdherent.setBackground(new java.awt.Color(199, 245, 233));
        jPanellAdherent.setName(""); // NOI18N
        jPanellAdherent.setPreferredSize(new java.awt.Dimension(646, 825));

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelTitre.setText("Fiche Adhérent");

        jLabelRefAdherent.setText("Référence");

        jTextFieldReferenceAdherent.setEnabled(false);

        jLabelTitreAdherent.setText("Titre");

        jLabelNomAdherent.setText("Nom");

        jLabelPrenomAdherent.setText("Prénom");

        jRadioButtonFamille.setBackground(new java.awt.Color(199, 245, 233));
        jRadioButtonFamille.setText("Famille");

        jRadioButtonAssociation.setBackground(new java.awt.Color(199, 245, 233));
        jRadioButtonAssociation.setText("Association");

        jRadioButtonRAM.setBackground(new java.awt.Color(199, 245, 233));
        jRadioButtonRAM.setText("RAM / Périscolaire");

        jRadioButtonEcole.setBackground(new java.awt.Color(199, 245, 233));
        jRadioButtonEcole.setText("Ecole");

        jLabelAdresse.setText("Adresse");

        jLabelCodePostal.setText("Code postal");

        jTextFieldCodePostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodePostalFocusLost(evt);
            }
        });

        jLabelVille.setText("Ville ");

        jComboBoxVille.setModel(new ModelComboVille());
        jComboBoxVille.setRenderer(new RendererComboVille());
        jComboBoxVille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxVilleItemStateChanged(evt);
            }
        });

        jLabelTelephone.setText("Téléphone");

        jTextFieldTelephonePortable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelephonePortableKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelephonePortableKeyTyped(evt);
            }
        });

        jLabelTelephonePortable.setText("Portable");

        jLabelTelephoneDomicile.setText("Domicile");

        jLabelTelephoneTravail.setText("Travail");

        jTextFieldTelephoneDomicile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelephoneDomicileKeyTyped(evt);
            }
        });

        jTextFieldTelephoneTravail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelephoneTravailKeyTyped(evt);
            }
        });

        jTextAreaAdresse.setColumns(20);
        jTextAreaAdresse.setRows(5);
        jScrollPaneAdresse.setViewportView(jTextAreaAdresse);

        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setRows(5);
        jScrollPaneNotes.setViewportView(jTextAreaNotes);

        jLabelNotes.setText("Notes");

        jLabelEcheanceCotisation.setText("Echéance cotis.");

        jTextFieldEcheanceCotisation.setText("12/12/2015");
        jTextFieldEcheanceCotisation.setEnabled(false);

        jLabelCredits.setText("CREDITS");

        jTextField1.setText("24 points");
        jTextField1.setEnabled(false);

        jButtonOK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonSupprimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSupprimer.setForeground(new java.awt.Color(255, 0, 51));
        jButtonSupprimer.setText("X");

        jButtonAnnuler.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jButtonHistorique.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonHistorique.setText(".../...");
        jButtonHistorique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistoriqueActionPerformed(evt);
            }
        });

        jTablePersonnes.setModel(new ModelTablePersonne());
        jTablePersonnes.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTablePersonnes.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTablePersonnes.setRequestFocusEnabled(false);
        jTablePersonnes.getTableHeader().setReorderingAllowed(false);
        jTablePersonnes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePersonnesMouseClicked(evt);
            }
        });
        jScrollPanePersonnes.setViewportView(jTablePersonnes);

        jButtonReservation.setText("Reservation");
        jButtonReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservationActionPerformed(evt);
            }
        });

        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyTyped(evt);
            }
        });

        jLabel1.setText("Email");

        javax.swing.GroupLayout jPanellAdherentLayout = new javax.swing.GroupLayout(jPanellAdherent);
        jPanellAdherent.setLayout(jPanellAdherentLayout);
        jPanellAdherentLayout.setHorizontalGroup(
            jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanellAdherentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanellAdherentLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanellAdherentLayout.createSequentialGroup()
                        .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomAdherent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                .addComponent(jLabelAdresse)
                                .addGap(11, 11, 11)))
                        .addGap(487, 487, 487))
                    .addGroup(jPanellAdherentLayout.createSequentialGroup()
                        .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEcheanceCotisation)
                                    .addComponent(jLabelCredits))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEcheanceCotisation, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                .addComponent(jLabelCodePostal)
                                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jRadioButtonAssociation)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonRAM)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonEcole))
                                    .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jScrollPaneAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanellAdherentLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelVille, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jComboBoxVille, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                        .addGap(178, 178, 178)
                                        .addComponent(jLabelTelephoneDomicile)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldTelephoneDomicile, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelTelephoneTravail)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanellAdherentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReservation)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAnnuler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonHistorique))
                            .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                    .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelTitreAdherent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelRefAdherent, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                            .addComponent(jTextFieldNomAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabelPrenomAdherent)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextFieldPrenomAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextFieldReferenceAdherent, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButtonFamille, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                    .addComponent(jLabelNotes)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPaneNotes)
                                    .addGap(80, 80, 80))
                                .addComponent(jScrollPanePersonnes)
                                .addGroup(jPanellAdherentLayout.createSequentialGroup()
                                    .addComponent(jLabelTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabelTelephonePortable)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldTelephonePortable, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(238, 238, 238)
                                    .addComponent(jTextFieldTelephoneTravail, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanellAdherentLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(313, 313, 313))))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanellAdherentLayout.setVerticalGroup(
            jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanellAdherentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitre)
                .addGap(44, 44, 44)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRefAdherent)
                    .addComponent(jTextFieldReferenceAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitreAdherent)
                    .addComponent(jRadioButtonFamille)
                    .addComponent(jRadioButtonAssociation)
                    .addComponent(jRadioButtonRAM)
                    .addComponent(jRadioButtonEcole))
                .addGap(18, 18, 18)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomAdherent)
                    .addComponent(jLabelPrenomAdherent)
                    .addComponent(jTextFieldPrenomAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAdresse)
                    .addComponent(jScrollPaneAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCodePostal)
                        .addComponent(jTextFieldCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelVille)
                    .addComponent(jComboBoxVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelephonePortable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelephonePortable)
                    .addComponent(jLabelTelephone)
                    .addComponent(jLabelTelephoneDomicile)
                    .addComponent(jTextFieldTelephoneDomicile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelephoneTravail)
                    .addComponent(jTextFieldTelephoneTravail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(17, 17, 17)
                .addComponent(jScrollPanePersonnes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNotes)
                    .addComponent(jScrollPaneNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelEcheanceCotisation)
                    .addComponent(jTextFieldEcheanceCotisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCredits))
                .addGap(27, 27, 27)
                .addGroup(jPanellAdherentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanellAdherent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanellAdherent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHistoriqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistoriqueActionPerformed
        //TODO refactorer ça
        HistoriqueAdherent.getInstance(this, refAdh);
    }//GEN-LAST:event_jButtonHistoriqueActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        //cacher la fenêtre
        jFrameAdherent.setVisible(false);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        // TODO vérification de données

        /**
         * Enable = True --> Création ou modification Valider la création ou la
         * modification Si tout se passe bien, on passe en affichage
         */
        if (enab) {
            act = 2;
            enab = false;
            _adherent.setVille(((Ville) jComboBoxVille.getSelectedItem()));
            _adherent.getRéférent().setNom(jTextFieldNomAdherent.getText());
            _adherent.getRéférent().setPrénom(jTextFieldPrenomAdherent.getText());
            _adherent.setAdresse(jTextAreaAdresse.getText());
            _adherent.setVille((Ville) ((ModelComboVille) jComboBoxVille.getModel()).getSelectedItem());
            _adherent.setTitre(getSelectedTitre());
            new AdhérentManager().majAdhérent(_adherent);
            modifEnableAdherent();
        } else {
            /**
             * Enable = False --> Affichage Demande de modification
             */
            enab = true;
            act = 3;
            modifEnableAdherent();

        }
    }//GEN-LAST:event_jButtonOKActionPerformed
    private String getSelectedTitre() {
        String titre = "";
        if (jRadioButtonAssociation.isSelected()) {
            titre = "asso";
        }
        if (jRadioButtonEcole.isSelected()) {
            titre = "ecole";
        }
        if (jRadioButtonFamille.isSelected()) {
            titre = "famille";
        }
        if (jRadioButtonRAM.isSelected()) {
            titre = "RAM";
        }
        return titre;
    }

    private void setSelectedTitre(String titre) {
        switch (titre) {
            case "asso":
                jRadioButtonAssociation.setSelected(true);
                break;
            case "école":
                jRadioButtonEcole.setSelected(true);
                break;

            case "RAM":
                jRadioButtonRAM.setSelected(true);
                break;
            default:
                jRadioButtonFamille.setSelected(true);
                break;
        }

    }
    private void jButtonReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservationActionPerformed

        ReservationListeAdherent.getInstance(refAdh);
    }//GEN-LAST:event_jButtonReservationActionPerformed
    /**
     * Sur un double click, ajouter une ligne
     *
     * @param evt
     */
    private void jTablePersonnesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePersonnesMouseClicked
//TODO ajouter une personne
        if (evt.getClickCount() == 2 && enab == true) {

            Personne pers = new Personne();
            ((ModelTablePersonne) jTablePersonnes.getModel()).nouvellePersonne(pers);
            //handle double click event.
        }
    }//GEN-LAST:event_jTablePersonnesMouseClicked

    private void jComboBoxVilleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxVilleItemStateChanged
        jTextFieldCodePostal.setText(((Ville) evt.getItem()).getCode_postal());
    }//GEN-LAST:event_jComboBoxVilleItemStateChanged
    /**
     * valide le code postal et charge le nom de la ville dans la combobox
     *
     * @param evt
     */
    private void jTextFieldCodePostalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodePostalFocusLost
        Ville v = new Ville();
        v.setCode_postal(jTextFieldCodePostal.getText());
        jComboBoxVille.setSelectedItem(v);
        //vérification
        if (!((ModelComboVille) jComboBoxVille.getModel()).existe(v)) {
            jTextFieldCodePostal.setBackground(Color.red);
            jTextFieldCodePostal.setToolTipText("Le code postal est invalide");
        } else {
            jTextFieldCodePostal.setBackground(Color.white);
            jTextFieldCodePostal.setToolTipText("Le code postal est invalide");
        }
    }//GEN-LAST:event_jTextFieldCodePostalFocusLost

    private void jTextFieldTelephonePortableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelephonePortableKeyPressed

    }//GEN-LAST:event_jTextFieldTelephonePortableKeyPressed

    private void jTextFieldTelephonePortableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelephonePortableKeyTyped

        _adherent.setTel2(jTextFieldTelephonePortable.getText() + evt.getKeyChar());
        valideChamp(jTextFieldTelephonePortable, validatePhoneNumber(_adherent.getTel2()));

    }//GEN-LAST:event_jTextFieldTelephonePortableKeyTyped

    private void jTextFieldTelephoneDomicileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelephoneDomicileKeyTyped
        _adherent.setTel1(jTextFieldTelephoneDomicile.getText() + evt.getKeyChar());
        valideChamp(jTextFieldTelephoneDomicile, validatePhoneNumber(_adherent.getTel1()));
    }//GEN-LAST:event_jTextFieldTelephoneDomicileKeyTyped

    private void jTextFieldTelephoneTravailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelephoneTravailKeyTyped
        _adherent.setTel3(jTextFieldTelephoneTravail.getText() + evt.getKeyChar());
        valideChamp(jTextFieldTelephoneTravail, validatePhoneNumber(_adherent.getTel3()));
    }//GEN-LAST:event_jTextFieldTelephoneTravailKeyTyped

    private void jTextFieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyTyped
        _adherent.setEmail(jTextFieldEmail.getText()+evt.getKeyChar());
        valideChamp(jTextFieldEmail, validateEmail(_adherent.getEmail()));
    }//GEN-LAST:event_jTextFieldEmailKeyTyped

    private void valideChamp(Component component, boolean b) {
        if (b) {
            component.setBackground(Color.white);
        } else {
            component.setBackground(Color.pink);
        }
    }

    private static boolean validateEmail(String email) {

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        System.out.println(email + " : " + matcher.matches());

        return matcher.matches();
    }

    private static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) {
            return true;
        } //validating phone number with -, . or spaces 2 par 2
        else if (phoneNo.matches("\\d{2}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}")) {
            return true;
        } //validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            return true;
        } //validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
            return true;
        } //validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            return true;
        } //return false if nothing matches the input
        else {
            return false;
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTitre;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonHistorique;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonReservation;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxVille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelCodePostal;
    private javax.swing.JLabel jLabelCredits;
    private javax.swing.JLabel jLabelEcheanceCotisation;
    private javax.swing.JLabel jLabelNomAdherent;
    private javax.swing.JLabel jLabelNotes;
    private javax.swing.JLabel jLabelPrenomAdherent;
    private javax.swing.JLabel jLabelRefAdherent;
    private javax.swing.JLabel jLabelTelephone;
    private javax.swing.JLabel jLabelTelephoneDomicile;
    private javax.swing.JLabel jLabelTelephonePortable;
    private javax.swing.JLabel jLabelTelephoneTravail;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelTitreAdherent;
    private javax.swing.JLabel jLabelVille;
    private javax.swing.JPanel jPanellAdherent;
    private javax.swing.JRadioButton jRadioButtonAssociation;
    private javax.swing.JRadioButton jRadioButtonEcole;
    private javax.swing.JRadioButton jRadioButtonFamille;
    private javax.swing.JRadioButton jRadioButtonRAM;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneAdresse;
    private javax.swing.JScrollPane jScrollPaneNotes;
    private javax.swing.JScrollPane jScrollPanePersonnes;
    private javax.swing.JTable jTablePersonnes;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaAdresse;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldCodePostal;
    private javax.swing.JTextField jTextFieldEcheanceCotisation;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNomAdherent;
    private javax.swing.JTextField jTextFieldPrenomAdherent;
    private javax.swing.JTextField jTextFieldReferenceAdherent;
    private javax.swing.JTextField jTextFieldTelephoneDomicile;
    private javax.swing.JTextField jTextFieldTelephonePortable;
    private javax.swing.JTextField jTextFieldTelephoneTravail;
    // End of variables declaration//GEN-END:variables
}
