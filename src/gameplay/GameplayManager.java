/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import javax.swing.Timer;
import ui.ScreenManager;

/**
 *
 * @author Mustafa
 */
public class GameplayManager implements KeyListener {
    protected PedestrianManager pedestrianManager;
    protected VehicleManager vehicleManager;
    protected ScreenManager screen;
    private Timer timer;
    protected GameplayPanel panel;
    public GameplayManager(int level, int difficulty)
    {
        screen = ui.ScreenManager.getInstance();
        panel = new GameplayPanel();
        panel.setFocusable(true);
        panel.addKeyListener(this);
        screen.setContentPane(panel);
        panel.requestFocus();
        pedestrianManager = new PedestrianManager(difficulty);
        vehicleManager = new VehicleManager(0);
        
        screen.revalidate();
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
        }
        panel.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='k') {
            pedestrianManager.killPedestrian(0);
        }
        System.out.println(pedestrianManager.checkCollision(300, 300, 50, 70, 0));
        pedestrianManager.advance();
        panel.repaint();
    }
    private class GameplayPanel extends JPanel {
        public GameplayPanel() {
            setPreferredSize(new Dimension(800,600));
        }
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawRect(275, 265, 50, 70);
            pedestrianManager.paintComponent(g);
            vehicleManager.paintComponent(g);
            
            
            
        }
    }
}
