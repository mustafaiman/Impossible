/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import ui.ScreenManager;

/**
 *
 * @author Mustafa
 */
public class GameplayManager implements KeyListener, ActionListener {
    protected PedestrianManager pedestrianManager;
    protected VehicleManager vehicleManager;
    protected ScreenManager screen;
    protected GameplayPanel panel;
    private boolean stillUpdating;
    private Timer displayTimer = new Timer(100, this);
    private int currentScore, scoreDivider;

    public GameplayManager(int level, int difficulty)
    {
        currentScore = 2000;
        scoreDivider = 10;
        screen = ui.ScreenManager.getInstance();
        panel = new GameplayPanel();
        panel.setFocusable(true);
        panel.addKeyListener(this);
        screen.setContentPane(panel);
        panel.requestFocus();
        pedestrianManager = new PedestrianManager(difficulty);
        vehicleManager = new VehicleManager(0);
        
        screen.revalidate();
        stillUpdating = false;
        displayTimer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                vehicleManager.movePCar(0);
                break;
            case KeyEvent.VK_DOWN:
                vehicleManager.movePCar(1);
                // handle down 
                break;
            case KeyEvent.VK_LEFT:
                vehicleManager.movePCar(3);
                // handle left
                break;
            case KeyEvent.VK_RIGHT :
                vehicleManager.movePCar(2);
                // handle right
                break;
            case KeyEvent.VK_ESCAPE:
                exit();
            case KeyEvent.VK_P:
                pause();
        }
    }
    
    public void pause(){
        if(displayTimer.isRunning()){
            displayTimer.stop();
        }
        else {
            displayTimer.start();
        }
    }
    
    public void exit(){
        if(displayTimer.isRunning())
            displayTimer.stop();
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","Warning",dialogButton);

        if(dialogButton == JOptionPane.YES_OPTION){ 
            //TODO: nasıl çıkacazzzz
        }
        else{
            displayTimer.start();
        }
            
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //If still loading, can't animate.
        if (stillUpdating) {
            return;
        }
        stillUpdating = true;
        
        pedestrianManager.advance();
        vehicleManager.advance();
        Point p = vehicleManager.getPCarLocation();
        currentScore -= pedestrianManager.checkCollision((int)p.getX(), (int)p.getY(), 32, 64);
        System.out.println(vehicleManager.checkCollision((int)p.getX(), (int)p.getY(), 32, 64));
        panel.repaint();
        
        stillUpdating = false;
        
    }
    
    private class GameplayPanel extends JPanel {
        public GameplayPanel() {
            setPreferredSize(new Dimension(800,600));
        }
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            pedestrianManager.paintComponent(g);
            vehicleManager.paintComponent(g);
            g.drawString(""+currentScore, 50, 50);
            
            if (!(scoreDivider>0)){
                currentScore-=5;
                scoreDivider=10;
            }
            scoreDivider--;
        }
    }
}
