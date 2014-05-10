/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

import data.DataManager;
import java.awt.Graphics;

/**
 * This is a class for representing player's car
 *
 * @author Ayhun, Dilara
 */
public class PlayerCar extends MobileCar {

    private int protection;

    public PlayerCar(int x, int y) {

        super(x, y, DataManager.getInstance().getSettings().getCarID() + 1);
        speed = 0;
        protection = 12;
    }

    /**
     * enables a few seconds exterritoriality for the car after a crash
     */
    public void enableProtection() {
        protection = 28;
    }

    @Override
    public void advance() {
        if (protection > 0) {
            protection--;
        }

        int tempx = x + (int) (Math.cos(Math.toRadians(direction)) * speed);
        int tempy = y + (int) (-1 * Math.sin(Math.toRadians(direction)) * speed);
        if (tempx <= 750 && tempx >= 0) {
            x = tempx;
        }
        if (tempy <= 570 && tempy >= 0) {
            y = tempy;
        }

    }

    /**
     * Accelerates car until its speed reaches constant amount 12
     */
    public void accelerate() {
        if (speed > 12) {
            return;
        }
        speed++;
    }

    /**
     * Decelerates car until it stops, then it accelaretes it in the backward
     * direction until its speed reaches -5
     */
    public void decelerate() {
        if (speed < -5) {
            return;
        }
        speed--;
    }

    /**
     * Turns the car to the right when the argument is true for the direction
     * right turns it to the left otherwise
     *
     * @param right direction right
     */
    public void changeDirection(boolean right) {
        if (speed >= 0) {    // if the car is moving forward
            if (right) {
                direction -= 5;
            } else {
                direction += 5;
            }
        } else {            // if the car is moving backward
            if (right) {
                direction += 5;
            } else {
                direction -= 5;
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        if (protection / 4 % 2 == 0) {
            super.paint(g);
        }
    }

    boolean isProtectionEnabled() {
        if (protection > 0) {
            return true;
        } else {
            return false;
        }
    }
}
