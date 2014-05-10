/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import data.DataManager;
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
import ui.MainMenuPanel;
import ui.NewHighscorePanel;
import ui.ScreenManager;

/**
 *
 * @author Mustafa
 */
public class GameplayManager implements KeyListener, ActionListener {
    protected PedestrianManager pedestrianManager;
    protected VehicleManager vehicleManager;
    protected ParkingManager parkingManager;
    protected ScreenManager screen;
    protected GameplayPanel panel;
    private boolean stillUpdating;
    private Timer displayTimer = new Timer(100, this);
    private int currentScore, scoreDivider;
    private int stage, diff;

    public GameplayManager(int stage, int diff)
    {
        this.stage=stage;
        this.diff=diff;
        currentScore = 2000;
        scoreDivider = 10;
        screen = ui.ScreenManager.getInstance();
        panel = new GameplayPanel();
        panel.setFocusable(true);
        panel.addKeyListener(this);
        screen.setContentPane(panel);
        panel.requestFocus();
        parkingManager = new ParkingManager(1); //1 parking area only
        screen.revalidate();
        
        pedestrianManager = new PedestrianManager(diff);
        vehicleManager = new VehicleManager(diff);
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
                exit(); break;
            case KeyEvent.VK_P:
                pause();break;
            case KeyEvent.VK_SPACE:
                if(!DataManager.getInstance().isHighScore(stage, diff, currentScore)){
                    displayTimer.stop();
                    JOptionPane.showConfirmDialog (null, "You have failed to make it to high score table\nYour score:"+currentScore,"Looser",JOptionPane.PLAIN_MESSAGE);
                    screen.setContentPane(new MainMenuPanel(screen));//new NewHighscorePanel(screen,stage,diff,currentScore));
                    screen.revalidate();    
                }
                else{
                    displayTimer.stop();
                    screen.setContentPane(new NewHighscorePanel(screen, stage, diff, currentScore));
                    screen.revalidate();
                }
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
            displayTimer.stop();
            screen.setContentPane(new MainMenuPanel(screen));
            screen.revalidate();
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
        if (!vehicleManager.isProtectionEnabled() && vehicleManager.checkCollision((int)p.getX(), (int)p.getY(), 32, 64)) {
            currentScore -= 30;
            vehicleManager.enableProtection();
        }
        boolean inLot = parkingManager.checkIfParked((int)p.getX(), (int)p.getY(), 32, 64);
        if(vehicleManager.getPCarSpeed() == 0 && inLot)
            System.out.println("Success!");
        
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
            parkingManager.paintComponent(g);
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
