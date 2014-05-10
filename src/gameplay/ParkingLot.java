/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.PathIterator;

/**
 * Represents a single parking lot
 *
 * @author Mustafa
 */
public class ParkingLot {

    private final int x, y;
    public static final int width = 64, height = 90;
    private final Rectangle rect;
    private static Image bg;

    /**
     * Constructor for ParkingLot. Creates a Rectangle object which will be used
     * for collision tests. Loads the background image.
     *
     * @param x x coordinate of the upper-left corner
     * @param y y coordinate of the upper-left corner
     */
    public ParkingLot(int x, int y) {
        this.x = x;
        this.y = y;
        rect = new Rectangle(x, y, width, height);
        bg = Toolkit.getDefaultToolkit().getImage("images/lot.png");
    }

    /**
     * Checks if given rectangle is completely contained by the parking lot.
     *
     * @param x x coordinate of upper right corner
     * @param y y coordinate of upper right corner
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @return True if the parking lot completely contains the given rectangle.
     */
    boolean contains(int x, int y, int width, int height) {
        Rectangle veh = new Rectangle(x + 16, y, width, height);
        PathIterator it = veh.getPathIterator(null);
        while (!it.isDone()) {
            double[] coords = new double[2];
            it.currentSegment(coords);
            it.next();
            if (coords[0] == 0 && coords[1] == 0) {
                continue;
            }
            if (!rect.contains(coords[0], coords[1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Draws the parking lot by placing background image and surrounding it with
     * a border
     *
     * @param g Graphics object
     */
    void paintParkingLot(Graphics g) {
        g.drawImage(bg, x, y, width, height, null);
        g.setColor(Color.yellow);
        g.drawRect(x, y, width, height);
        g.setColor(Color.black);
    }
}
