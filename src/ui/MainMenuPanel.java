/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author user
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;

class MainMenuPanel extends JPanel implements ActionListener {

    ScreenManager frame;
    protected Image backGroundImage = null;
    private JButton playGameButton, highScoresButton, settingsButton, helpButton, creditsButton;

    //constructor
    public MainMenuPanel(ScreenManager frame) {
        this.frame = frame;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //button "Play Game" 
        playGameButton = new JButton("Play Game");
        playGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playGameButton.setBackground(Color.YELLOW);
        playGameButton.setForeground(new Color(0, 128, 0));
        playGameButton.setFont(new Font("Verdana", Font.BOLD, 20));
        playGameButton.setPreferredSize(new Dimension(70, 70));
        playGameButton.addActionListener(this);
        add(Box.createRigidArea(new Dimension(0, 60)));
        add(playGameButton);
        //button "High Scores"
        highScoresButton = new JButton("High Scores");
        highScoresButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoresButton.setBackground(Color.YELLOW);
        highScoresButton.setForeground(new Color(0, 128, 0));
        highScoresButton.setFont(new Font("Verdana", Font.BOLD, 20));
        highScoresButton.setPreferredSize(new Dimension(70, 70));
        highScoresButton.addActionListener(this);
        add(Box.createRigidArea(new Dimension(0, 60)));
        add(highScoresButton);
        //button "Settings"
        settingsButton = new JButton("Settings");
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setBackground(Color.YELLOW);
        settingsButton.setForeground(new Color(0, 128, 0));
        settingsButton.setFont(new Font("Verdana", Font.BOLD, 20));
        settingsButton.setPreferredSize(new Dimension(70, 70));
        settingsButton.addActionListener(this);
        add(Box.createRigidArea(new Dimension(0, 60)));
        add(settingsButton);
        //button "Tutorial"
        helpButton = new JButton("Tutorial");
        helpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpButton.setBackground(Color.YELLOW);
        helpButton.setForeground(new Color(0, 128, 0));
        helpButton.setFont(new Font("Verdana", Font.BOLD, 20));
        helpButton.setPreferredSize(new Dimension(70, 70));
        helpButton.addActionListener(this);
        add(Box.createRigidArea(new Dimension(0, 60)));
        add(helpButton);
        //button "Credits"
        creditsButton = new JButton("Credits");
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.setBackground(Color.YELLOW);
        creditsButton.setForeground(new Color(0, 128, 0));
        creditsButton.setFont(new Font("Verdana", Font.BOLD, 20));
        creditsButton.setPreferredSize(new Dimension(70, 70));
        creditsButton.addActionListener(this);
        add(Box.createRigidArea(new Dimension(0, 60)));
        add(creditsButton);

        backGroundImage = Toolkit.getDefaultToolkit().getImage("images/CarPark.jpg");

        setPreferredSize(new Dimension(700, 610));

    }

    //following method is for setting MainMenuPanel's background image 

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGroundImage, 1, 1, null);
    }

    //following method listens the action

    public void actionPerformed(ActionEvent event) {
        /*if(event.getSource()==playGameButton){
         frame.remove(this);
         frame.add(new StageSelectionPanel(frame));
         frame.repaint();
         frame.setSize(700,610); 
         } 
         if(event.getSource()==highScoresButton){
         frame.remove(this);
         frame.add(new HighScoresStageListPanel(frame));
         frame.repaint();
         frame.setSize(700,610);			
         }
         if(event.getSource()==settingsButton){
         frame.remove(this);
         frame.add(new SettingsPanel(frame));
         frame.repaint();
         frame.setSize(700,610); 
         }
         if(event.getSource()==helpButton){
         frame.remove(this);
         frame.add(new HelpPanel(frame));
         frame.repaint();
         frame.setSize(700,610);
         }
         if(event.getSource()==creditsButton){
         frame.remove(this);
         frame.add(new CreditsPanel(frame));
         frame.repaint();
         frame.setSize(700,610);
         } */
    }
}
