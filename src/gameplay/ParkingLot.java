/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;

/**
 *
 * @author Mustafa
 */
public class ParkingLot {
    private final int x,y;
    public static final int width=64,height=90;
    private final Rectangle rect;
    
    public ParkingLot(int x,int y)
    {
        this.x=x;
        this.y=y;
        rect = new Rectangle(x,y,width,height);
    }

    boolean contains(int x, int y, int width, int height) {
        Rectangle veh = new Rectangle(x+16,y,width,height);
        PathIterator it = veh.getPathIterator(null);
        while(!it.isDone()) {
            double[] coords = new double[2];
            it.currentSegment(coords);
            it.next();
            if(coords[0] == 0 && coords[1] == 0)
                continue;
            if(!rect.contains(coords[0],coords[1]))
                return false;
            // At this point, coords contains the coordinates of one of the vertices. This is where you should check to make sure the vertex is inside your circle
             // go to the next point
        }
        return true;
    }

    void paintParkingLot(Graphics g) {
        g.drawRect(x, y, width, height);
    }
}
