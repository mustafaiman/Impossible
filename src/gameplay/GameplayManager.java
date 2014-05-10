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
 * Is responsible for managing all aspects of the game. It holds a
 * PedestrianManager, VehicleManager, ParkinkManager, ScreenManager and the
 * panel that all the gameplay occurs. Listeners for user keyboard input is
 * handled here.
 *
 * @author Mustafa, Dilara, Ayhun
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
    private final int parealocx[] = {0, 150, 0, 250, 400, 0, 530};
    private final int parealocy[] = {0, 0, 50, 510, 0, 330, 0};
    private final boolean pareaorientation[] = {false, false, true, false, false, true, false};

    /**
     * Constructor creates instances of managers specified in the class
     * decsription. Score and score decrease rate are initialized. Game panel is
     * created and respective listeners are associated Timer which will invoke
     * advance methods of the managers is started.
     *
     * @param stage Stage number for newly created game
     * @param diff Difficulty level for newly created game
     */
    public GameplayManager(int stage, int diff) {
        this.stage = stage;
        this.diff = diff;
        currentScore = 2000;
        scoreDivider = 10;
        screen = ui.ScreenManager.getInstance();
        panel = new GameplayPanel();
        panel.setFocusable(true);
        panel.addKeyListener(this);
        screen.setContentPane(panel);
        panel.requestFocus();
        parkingManager = new ParkingManager(parealocx[stage], parealocy[stage], 1, pareaorientation[stage]); //1 parking area only
        screen.revalidate();

        pedestrianManager = new PedestrianManager(diff);
        vehicleManager = new VehicleManager(diff);
        stillUpdating = false;
        displayTimer.start();
    }

    /**
     * Keyboard listener. Listens for arrow keys(move the car), escape key(exit
     * game) and p key(pause)
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        switch (keyCode) {
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
            case KeyEvent.VK_RIGHT:
                vehicleManager.movePCar(2);
                // handle right
                break;
            case KeyEvent.VK_ESCAPE:
                exit();
                break;
            case KeyEvent.VK_P:
                pause();
                break;
        }
    }

    /**
     * Pauses/resumes the timer to pause/resume game.
     */
    public void pause() {
        if (displayTimer.isRunning()) {
            displayTimer.stop();
        } else {
            displayTimer.start();
        }
    }

    /**
     * Shows a confirmation dialog to ask whether the player wants to exit the
     * game. If yes, then it stops the timer and loads the main menu.
     */
    public void exit() {
        if (displayTimer.isRunning()) {
            displayTimer.stop();
        }

        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Warning", dialogButton);

        if (dialogButton == JOptionPane.YES_OPTION) {
            //TODO: nasıl çıkacazzzz
            displayTimer.stop();
            screen.setContentPane(new MainMenuPanel(screen));
            screen.revalidate();
        } else {
            displayTimer.start();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * The actions taken at each unit time interval is specified here. At every
     * tick, pedestrianManager and vehicleManager are asked to refresh
     * themselves by executing their advance() method. Current location of the
     * player car is passed to pedestrianManager and vehicleManager to determine
     * if any collision happened. If yes, currentScore is reduced accordingly.
     * Also checks if the car is parked to any suitable parking lot. If the car
     * is parked or score reaches zero, then the game terminates and passes
     * currentScore data to high score management.
     *
     * @param ae
     */
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
        currentScore -= pedestrianManager.checkCollision((int) p.getX(), (int) p.getY(), 32, 64);
        if (!vehicleManager.isProtectionEnabled() && vehicleManager.checkCollision((int) p.getX(), (int) p.getY(), 32, 64)) {
            currentScore -= 70;
            vehicleManager.enableProtection();
        }
        boolean inLot = parkingManager.checkIfParked((int) p.getX(), (int) p.getY(), 32, 64);
        if (currentScore <= 0) {
            currentScore = 0;
        }
        if (currentScore <= 0 || (vehicleManager.getPCarSpeed() == 0 && inLot)) {
            if (!DataManager.getInstance().isHighScore(stage, diff, currentScore)) {
                displayTimer.stop();
                JOptionPane.showConfirmDialog(null, "You have failed to make it to high score table\nYour score:" + currentScore, "Looser", JOptionPane.PLAIN_MESSAGE);
                screen.setContentPane(new MainMenuPanel(screen));//new NewHighscorePanel(screen,stage,diff,currentScore));
                screen.revalidate();
            } else {
                displayTimer.stop();
                screen.setContentPane(new NewHighscorePanel(screen, stage, diff, currentScore));
                screen.revalidate();
            }
        }

        panel.repaint();

        stillUpdating = false;

    }

    /**
     * This is the panel that shows game objects.
     */
    private class GameplayPanel extends JPanel {

        /**
         * Constructs a full-size panel
         */
        public GameplayPanel() {
            setPreferredSize(new Dimension(800, 600));
        }

        /**
         * It paints currentScore and calls required methods to paint parking
         * areas, pedestrians and vehicles.
         *
         * @param g
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            parkingManager.paintComponent(g);
            pedestrianManager.paintComponent(g);
            vehicleManager.paintComponent(g);
            g.drawString("" + currentScore, 50, 50);

            if (!(scoreDivider > 0)) {
                currentScore -= 5;
                scoreDivider = 10;
            }
            scoreDivider--;
        }
    }
}
