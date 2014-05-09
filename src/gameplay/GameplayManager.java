/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import ui.ScreenManager;

/**
 *
 * @author Mustafa
 */
public class GameplayManager implements KeyListener {
    protected PedestrianManager pedestrianManager;
    protected ScreenManager screen;
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
        screen.revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
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
            pedestrianManager.paintComponent(g);
        }
    }
}
