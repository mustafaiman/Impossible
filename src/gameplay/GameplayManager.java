/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import ui.ScreenManager;

/**
 *
 * @author Mustafa
 */
public class GameplayManager {
    protected PedestrianManager pedestrianManager;
    protected ScreenManager screen;
    public GameplayManager(int level, int difficulty)
    {
        screen = ui.ScreenManager.getInstance();
        GameplayPanel panel = new GameplayPanel();
        screen.setContentPane(panel);
        pedestrianManager = new PedestrianManager(difficulty);
        screen.revalidate();
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
