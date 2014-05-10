/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.DataManager;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Dilara, Ayhun
 */
public class HighScoresPanel extends javax.swing.JPanel {

    ScreenManager frame;
    DataManager dataManager;
    protected Image backGroundCupImage = null;

    /**
     * Creates new form HighScoresPanel
     */
    public HighScoresPanel(ScreenManager frame, int stage) {
        this.frame = frame;
        dataManager = DataManager.getInstance();
        backGroundCupImage = Toolkit.getDefaultToolkit().getImage("images/CupIcon.gif");
        initComponents();
        scoreEasy.setText(dataManager.getHighScores(stage, 0).toString());
        scoreMedium.setText(dataManager.getHighScores(stage, 1).toString());
        scoreHard.setText(dataManager.getHighScores(stage, 2).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGroundCupImage, 1, 1, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHard = new javax.swing.JLabel();
        labelMedium = new javax.swing.JLabel();
        labelEasy = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        scoreHard = new javax.swing.JLabel();
        scoreMedium = new javax.swing.JLabel();
        scoreEasy = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        labelHard.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelHard.setText("Hard");

        labelMedium.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelMedium.setText("Medium");

        labelEasy.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelEasy.setText("Easy");

        backButton.setBackground(new java.awt.Color(255, 255, 51));
        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        scoreHard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoreHard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scoreHard.setText("Hardscores");
        scoreHard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        scoreHard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        scoreMedium.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoreMedium.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scoreMedium.setText("Mediumscores");
        scoreMedium.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        scoreMedium.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        scoreEasy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoreEasy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scoreEasy.setText("Easyscores");
        scoreEasy.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        scoreEasy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMedium)
                    .addComponent(scoreMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEasy)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreHard, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labelHard)
                            .addGap(361, 361, 361))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(labelHard)
                .addGap(18, 18, 18)
                .addComponent(scoreHard, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMedium)
                    .addComponent(labelEasy))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        frame.setContentPane(new HighScoreStageSelectionPanel(frame));
        frame.revalidate();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel labelEasy;
    private javax.swing.JLabel labelHard;
    private javax.swing.JLabel labelMedium;
    private javax.swing.JLabel scoreEasy;
    private javax.swing.JLabel scoreHard;
    private javax.swing.JLabel scoreMedium;
    // End of variables declaration//GEN-END:variables
}
