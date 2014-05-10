/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Holds a set of parking lots together. It has a certain position and orientation(vertical or horizontal)
 * @author Mustafa
 */
public class ParkingArea {
    private ArrayList<ParkingLot> parkingLots;
    private final int x,y;
    private final boolean orientation; //true=vertical,false=horizontal
    /**
     * Constructor for ParkingArea. Creates parking lots.
     * @param x x coordinate of the parking area
     * @param y y coordinate of the parking area
     * @param num number of parking lots this parking are has
     * @param orientation orientation of parking lots inside this parking area
     */
    public ParkingArea(int x,int y,int num,boolean orientation)
    {
        this.x=x;
        this.y=y;
        this.orientation = orientation;
        parkingLots = new ArrayList<ParkingLot>();
        for(int i=0;i<num;i++) {
            parkingLots.add(new ParkingLot(x,y));
            if(this.orientation)
                y+=ParkingLot.height;
            else
                x+=ParkingLot.width;
        }
    }

    /**
     * Checks each parking lot if they contain the specified rectangle completely
     * @param x x coordinate of the rectangle
     * @param y y coordinate of the rectangle
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @return True if specified rectangle is contained by one of this parking area's parking lots.
     */
    public boolean contains(int x, int y, int width, int height) {
        for(ParkingLot pLot : parkingLots)
            if(pLot.contains(x,y,width,height))
                return true;
        return false;
    }

    /**
     * Tells each parking lot to draw itself.
     * @param g Geometry object
     */
    public void paintParkingArea(Graphics g) {
        for(ParkingLot pLot : parkingLots)
            pLot.paintParkingLot(g);
    }
}
