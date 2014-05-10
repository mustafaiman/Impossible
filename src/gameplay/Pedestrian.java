/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

/**
 * This is an abstract class for pedestrian types
 *
 * @author Mustafa
 */
public abstract class Pedestrian {

    protected int x, y;
    protected int direction;
    Random random;

    /**
     * Constructor of the Pedestrian class
     *
     * @param x horizontal coordinate of the location of pedestrian
     * @param y vertical coordinate of the location of pedestrian
     */
    public Pedestrian(int x, int y) {
        this.x = x;
        this.y = y;
        random = new Random();
        this.direction = random.nextInt(360);
    }

    /**
     * Advances the pedestrian objects, moves them as changing their direction
     */
    public void advance() {
        int tempx, tempy;
        tempx = x + (int) (Math.sin(Math.toRadians(direction)) * 2.0);
        tempy = y + (int) (Math.cos(Math.toRadians(direction)) * 2.0);

        if (tempx <= 800 && tempx >= 0) {
            x = tempx;
        }
        if (tempy <= 600 && tempy >= 0) {
            y = tempy;
        }
        if (tempx < 0 || tempx > 800 || tempy < 0 || tempy > 600) {
            changeDirection();
        } else {
            possiblyChangeDirection();
        }
    }

    /**
     * Changes direction of a pedestrian with probability %4 is used inside the
     * advance method of the class
     */
    private void possiblyChangeDirection() {
        int changeDirectionChance = random.nextInt(100);
        if (changeDirectionChance >= 96) {
            changeDirection();
        }
    }

    /**
     * Changes direction of pedestrian is used inside the advance method of the
     * class
     */
    private void changeDirection() {
        direction = random.nextInt(360);
    }

    /**
     * Checks if there is a crash into a pedestian
     *
     * @param x horizontal coordinate of the location of pedestrian
     * @param y vertical coordinate of the location of pedestrian
     * @param width width of pedestrian
     * @param height height of pedestrian
     * @return true if there is a collision, false otherwise
     */
    protected boolean checkCollision(int x, int y, int width, int height) {

        Rectangle rect = new Rectangle(x, y, width, height);
        if (rect.contains(new Point(this.x, this.y))) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return true if the pedestrian is a student
     */
    public abstract boolean isStudent();

    abstract void paintPedestrian(Graphics g);
}
