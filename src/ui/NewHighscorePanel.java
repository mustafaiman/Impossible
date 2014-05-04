/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Dilara
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;

class NewHighscorePanel extends JPanel implements ActionListener {

    ScreenManager frame;
    protected Image backGroundImage = null;
    private JButton okButton;
    private JLabel titleLabel,queryLabel;
    private JTextField nameField;

    //constructor
    public NewHighscorePanel(ScreenManager frame) {
        this.frame = frame;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        add(Box.createRigidArea(new Dimension(0,40)));
        
        JPanel ipanel1 = new JPanel();
        
        ipanel1.add(Box.createVerticalGlue());
        titleLabel = new JLabel();
        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setText("Highscore!");
        ipanel1.add(titleLabel);
        ipanel1.add(Box.createVerticalGlue());
        add(ipanel1);
        
        add(Box.createRigidArea(new Dimension(0,40)));
        
        
        JPanel ipanel2 = new JPanel();
        ipanel2.add(Box.createVerticalGlue());
        queryLabel= new JLabel();
        queryLabel.setText("Your name:");
        ipanel2.add(queryLabel);
        nameField = new JTextField(20);
        ipanel2.add(nameField);
        ipanel2.add(Box.createVerticalGlue());
        add(ipanel2);
        
        
        //button "Play Game" 
        okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setBackground(Color.YELLOW);
        okButton.setForeground(new Color(0, 128, 0));
        okButton.setFont(new Font("Verdana", Font.BOLD, 20));
        okButton.setPreferredSize(new Dimension(70, 70));
        okButton.addActionListener(this);
        
        add(okButton);
        
        add(Box.createRigidArea(new Dimension(0,240)));

        backGroundImage = Toolkit.getDefaultToolkit().getImage("images/newhighscore.jpg");

        setPreferredSize(new Dimension(730, 620));

    }

    //following method is for setting MainMenuPanel's background image 

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGroundImage, 0, 0, null);
    }

    //following method listens the action

    public void actionPerformed(ActionEvent event) {
        /*
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
