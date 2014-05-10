/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;
import data.DataManager;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import javax.swing.Icon;
/**
 *
 * @author Ayhun
 */
public class SettingsPanel extends javax.swing.JPanel {
    DataManager dataManager;
    data.Settings currentSettings;
    ScreenManager frame;
    int currCar;

    /**
     * Creates new form SettingPanel
     */
    public SettingsPanel(ScreenManager frame) {
        dataManager = DataManager.getInstance();
        currentSettings = dataManager.getSettings();
        this.frame = frame;
        initComponents();
        
        // set slider from file
        volume.setValue(currentSettings.getVolume());
        
        // set difficulty from file
        switch(currentSettings.getDifficulty()){
            case 0 : diffEasy.setSelected(true);
                     break;
            case 1 : diffMedium.setSelected(true);
                     break;
            case 2 : diffHard.setSelected(true);
                     break;
        }
        
        // set chosen car from difficulty
        switch(currentSettings.getCarID()){
            case 0 : car1.setSelected(true);
                     currCar=0;
                     break;
            case 1 : car2.setSelected(true);
                     currCar=1;
                     break;
            case 2 : car3.setSelected(true);
                     currCar=2;
                     break;
            case 3 : car4.setSelected(true);
                     currCar=3;
                     break;
            case 4 : car5.setSelected(true);
                     currCar=4;
                     break;
        }
        
        
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch(currCar){
            case 0:g.drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/1.png"), 550, 370, 128, 128, this); break;
            case 1:g.drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/2.png"), 550, 370, 128, 128, this); break;
            case 2:g.drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/3.png"), 550, 370, 128, 128, this); break;
            case 3:g.drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/4.png"), 550, 370, 128, 128, this); break;
            case 4:g.drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/5.png"), 550, 370, 128, 128, this); break;
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

        difficultyGroup = new javax.swing.ButtonGroup();
        carGroup = new javax.swing.ButtonGroup();
        volume = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        diffEasy = new javax.swing.JRadioButton();
        diffMedium = new javax.swing.JRadioButton();
        diffHard = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        car1 = new javax.swing.JRadioButton();
        car2 = new javax.swing.JRadioButton();
        car3 = new javax.swing.JRadioButton();
        car4 = new javax.swing.JRadioButton();
        car5 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        volume.setBackground(new java.awt.Color(255, 255, 255));
        volume.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                volumeMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Volume :");

        diffEasy.setBackground(new java.awt.Color(255, 255, 255));
        difficultyGroup.add(diffEasy);
        diffEasy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        diffEasy.setText("Easy");
        diffEasy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diffEasyMouseReleased(evt);
            }
        });

        diffMedium.setBackground(new java.awt.Color(255, 255, 255));
        difficultyGroup.add(diffMedium);
        diffMedium.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        diffMedium.setText("Medium");
        diffMedium.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diffMediumMouseReleased(evt);
            }
        });

        diffHard.setBackground(new java.awt.Color(255, 255, 255));
        difficultyGroup.add(diffHard);
        diffHard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        diffHard.setText("Hard");
        diffHard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        diffHard.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        diffHard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diffHardMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Difficulty :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Car :");
        save.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save.setText("Ok");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Settings");

        car1.setBackground(new java.awt.Color(255, 255, 255));
        carGroup.add(car1);
        car1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        car1.setText("Car 1");
        car1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                car1MouseReleased(evt);
            }
        });

        car2.setBackground(new java.awt.Color(255, 255, 255));
        carGroup.add(car2);
        car2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        car2.setText("Car 2");
        car2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                car2MouseReleased(evt);
            }
        });

        car3.setBackground(new java.awt.Color(255, 255, 255));
        carGroup.add(car3);
        car3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        car3.setText("Car 3");
        car3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                car3MouseReleased(evt);
            }
        });

        car4.setBackground(new java.awt.Color(255, 255, 255));
        carGroup.add(car4);
        car4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        car4.setText("Car 4");
        car4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                car4MouseReleased(evt);
            }
        });

        car5.setBackground(new java.awt.Color(255, 255, 255));
        carGroup.add(car5);
        car5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        car5.setText("Car 5");
        car5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                car5MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(diffMedium, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(diffEasy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(diffHard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(349, 349, 349))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(car1)
                                    .addComponent(car2)
                                    .addComponent(car3)
                                    .addComponent(car4)
                                    .addComponent(car5)))
                            .addGap(208, 208, 208)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(volume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(diffEasy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diffMedium)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diffHard))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(car1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(car2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(car3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(car4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(car5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        dataManager.setSettings(currentSettings);
        frame.setContentPane(new MainMenuPanel(frame));
        frame.revalidate();
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        frame.setContentPane(new MainMenuPanel(frame));
        frame.revalidate();
    }//GEN-LAST:event_cancelActionPerformed

    private void volumeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeMouseReleased
        currentSettings.setVolume(volume.getValue());
    }//GEN-LAST:event_volumeMouseReleased

    private void diffEasyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diffEasyMouseReleased
        currentSettings.setDifficulty(0);
    }//GEN-LAST:event_diffEasyMouseReleased

    private void diffMediumMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diffMediumMouseReleased
        currentSettings.setDifficulty(1);
    }//GEN-LAST:event_diffMediumMouseReleased

    private void diffHardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diffHardMouseReleased
        currentSettings.setDifficulty(2);
    }//GEN-LAST:event_diffHardMouseReleased

    private void car1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_car1MouseReleased
        currentSettings.setCarID(0);
        currCar = 0;
        this.getGraphics().drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/1.png"), 550, 370, 128, 128, this);
    }//GEN-LAST:event_car1MouseReleased

    private void car2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_car2MouseReleased
        currentSettings.setCarID(1);
        currCar = 1;
        this.getGraphics().drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/2.png"), 550, 370, 128, 128, this);
    }//GEN-LAST:event_car2MouseReleased

    private void car3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_car3MouseReleased
        currentSettings.setCarID(2);
        currCar = 2;
        this.getGraphics().drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/3.png"), 550, 370, 128, 128, this);
    }//GEN-LAST:event_car3MouseReleased

    private void car4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_car4MouseReleased
        currentSettings.setCarID(3);
        currCar = 3;
        this.getGraphics().drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/4.png"), 550, 370, 128, 128, this);
    }//GEN-LAST:event_car4MouseReleased

    private void car5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_car5MouseReleased
        currentSettings.setCarID(4);
        currCar = 4;
        this.getGraphics().drawImage(Toolkit.getDefaultToolkit().getImage("images/cars/5.png"), 550, 370, 128, 128, this);
    }//GEN-LAST:event_car5MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JRadioButton car1;
    private javax.swing.JRadioButton car2;
    private javax.swing.JRadioButton car3;
    private javax.swing.JRadioButton car4;
    private javax.swing.JRadioButton car5;
    private javax.swing.ButtonGroup carGroup;
    private javax.swing.JRadioButton diffEasy;
    private javax.swing.JRadioButton diffHard;
    private javax.swing.JRadioButton diffMedium;
    private javax.swing.ButtonGroup difficultyGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton save;
    private javax.swing.JSlider volume;
    // End of variables declaration//GEN-END:variables
}
