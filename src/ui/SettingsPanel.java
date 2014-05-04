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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SettingsPanel extends JPanel implements ActionListener,ChangeListener {

    ScreenManager frame;
    private JButton cancelButton,saveButton;
    private JLabel titleLabel,volumeLabel,difficultyLabel;
    private JRadioButton easy,medium,hard;
    private ButtonGroup buttonGroup;
    private JSlider volumeSlider;
    

    //constructor
    public SettingsPanel(ScreenManager frame) {
        this.frame = frame;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        add(Box.createRigidArea(new Dimension(0,40)));
        
        JPanel ipanel1 = new JPanel();
        
        ipanel1.add(Box.createVerticalGlue());
        titleLabel = new JLabel();
        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setText("Settings");
        ipanel1.add(titleLabel);
        ipanel1.add(Box.createVerticalGlue());
        add(ipanel1);
        
        add(Box.createRigidArea(new Dimension(0,40)));
        
        
        JPanel ipanel2 = new JPanel();
        volumeLabel= new JLabel();
        volumeLabel.setText("Volume");
        ipanel2.add(volumeLabel);
        volumeSlider = new JSlider(JSlider.HORIZONTAL,0,100,25);
        volumeSlider.addChangeListener(this);
        ipanel2.add(volumeSlider);
        add(ipanel2);
        
        JPanel ipanel4 = new JPanel();
        difficultyLabel= new JLabel();
        difficultyLabel.setText("Difficulty");
        ipanel4.add(difficultyLabel);
        easy = new JRadioButton("Easy");
        easy.setActionCommand("easy");
        easy.setSelected(true);
        easy.addActionListener(this);
        medium = new JRadioButton("Medium");
        medium.setActionCommand("medium");
        medium.addActionListener(this);
        hard = new JRadioButton("Hard");
        hard.setActionCommand("hard");
        hard.addActionListener(this);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(easy);
        buttonGroup.add(medium);
        buttonGroup.add(hard);
        ipanel4.add(easy);
        ipanel4.add(medium);
        ipanel4.add(hard);
        add(ipanel4);
        
        
        
        JPanel ipanel3 = new JPanel();
        
        ipanel3.add(Box.createHorizontalGlue());
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.YELLOW);
        cancelButton.setForeground(new Color(0, 128, 0));
        cancelButton.setFont(new Font("Verdana", Font.BOLD, 20));
        cancelButton.addActionListener(this);
        ipanel3.add(cancelButton);
        
        saveButton = new JButton("Save");
        saveButton.setBackground(Color.YELLOW);
        saveButton.setForeground(new Color(0, 128, 0));
        saveButton.setFont(new Font("Verdana", Font.BOLD, 20));
        saveButton.addActionListener(this);
        
        ipanel3.add(saveButton);
        
        
        add(ipanel3);
        

        setPreferredSize(new Dimension(730, 620));

    }

    //following method is for setting MainMenuPanel's background image 

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //following method listens the action

    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==cancelButton)
        {
            frame.remove(this);
            frame.add(new MainMenuPanel(frame));
            frame.repaint();
            frame.setSize(730,620);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
