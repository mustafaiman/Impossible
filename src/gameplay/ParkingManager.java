/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Manages parking areas. Checks if the player car is correctly parked into a
 * parking lot.
 * @author Mustafa
 */
public class ParkingManager {
    private ArrayList<ParkingArea> parkingAreas;
    /**
     * Constructor for ParkingManager. Creates given number of parking areas with 3 parking lots
     * in each.
     * @param x x coordinate of upper right corner
     * @param y y coordiante of upper right corner
     * @param num number of parking areas
     * @param orientation orientation of parking area. True(Vertical)/False(Horizontal)
     */
    public ParkingManager(int x, int y,int num,boolean orientation)
    {
        parkingAreas = new ArrayList<ParkingArea>();
        for(int i=0;i<num;i++)
            parkingAreas.add(new ParkingArea(x,y,3,orientation));
    }
    
    /**
     * Checks if the given rectangle is completely inside one of the parking areas.
     * @param x x coordinate of upper right corner
     * @param y y coordinate of upper right corner
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @return True if the given rectangle is contained by a parking area.
     */
    public boolean checkIfParked(int x,int y,int width,int height)
    {
        for(ParkingArea pArea : parkingAreas)
            if(pArea.contains(x,y,width,height))
                return true;
        return false;
    }
    /**
     * Tells ParkingArea's to draw themselves.
     * @param g 
     */
    public void paintComponent(Graphics g)
    {
        for(ParkingArea pArea : parkingAreas)
            pArea.paintParkingArea(g);
    }
}
