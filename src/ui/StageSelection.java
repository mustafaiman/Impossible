/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Dilara, ayhun
 */

import gameplay.GameplayManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

class StageSelectionPanel extends JPanel implements ActionListener {

    ScreenManager frame;
    private final JButton stage1Button, stage2Button, stage3Button, stage4Button, stage5Button, stage6Button, mainMenuButton;
    private final JLabel titleLabel;
    private final ImageIcon mssfIcon, EEIcon, FIcon, SAIcon, kutuphaneIcon, BIcon;

    public StageSelectionPanel(ScreenManager frame) {
        this.frame = frame;
        titleLabel = new javax.swing.JLabel();
        stage1Button = new javax.swing.JButton();
        stage2Button = new javax.swing.JButton();
        stage3Button = new javax.swing.JButton();
        stage4Button = new javax.swing.JButton();
        stage5Button = new javax.swing.JButton();
        stage6Button = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();

        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        titleLabel.setText(" Choose a stage");

        mainMenuButton.setText("Back");
        mainMenuButton.setBackground(new java.awt.Color(255, 255, 51));
               
        BIcon=new ImageIcon("images/B.jpg");
        EEIcon=new ImageIcon("images/EEE.jpg");
        mssfIcon=new ImageIcon("images/MSSF.jpg"); 
        SAIcon=new ImageIcon("images/SA.jpg");
        FIcon=new ImageIcon("images/F.jpg");
        kutuphaneIcon=new ImageIcon("images/kutuphane.jpg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(stage1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(stage2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(stage3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(stage4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(stage5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(stage6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(3, 3, 3)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(stage1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stage2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stage3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(stage4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stage5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stage6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
        );
        setBackground(Color.WHITE);
        
        stage1Button.setIcon(BIcon);
        stage2Button.setIcon(EEIcon);
        stage3Button.setIcon(mssfIcon);
        stage4Button.setIcon(SAIcon);
        stage5Button.setIcon(FIcon);
        stage6Button.setIcon(kutuphaneIcon);
     
        stage1Button.addActionListener(this);
        stage2Button.addActionListener(this);
        stage3Button.addActionListener(this);
        stage4Button.addActionListener(this);
        stage5Button.addActionListener(this);
        stage6Button.addActionListener(this);
        mainMenuButton.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == mainMenuButton) {
            frame.setContentPane(new MainMenuPanel(frame));
            frame.revalidate();
        }
        else if ( event.getSource() == stage1Button){
            System.out.println("Stage 1");
            new GameplayManager(1,0);
        }
        else if ( event.getSource() == stage2Button){
            System.out.println("Stage 2");
        }
        else if ( event.getSource() == stage3Button){
            System.out.println("Stage 3");
        }
        else if ( event.getSource() == stage4Button){
            System.out.println("Stage 4");
        }
        else if ( event.getSource() == stage5Button){
            System.out.println("Stage 5");
        }
        else if ( event.getSource() == stage6Button){
            System.out.println("Stage 6");
            System.err.println("Stage 7");
        }
    }
}
