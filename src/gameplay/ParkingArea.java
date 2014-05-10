/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Mustafa
 */
public class ParkingArea {
    private ArrayList<ParkingLot> parkingLots;
    private final int x,y;
    private final boolean orientation; //true=vertical,false=horizontal
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

    public boolean contains(int x, int y, int width, int height) {
        for(ParkingLot pLot : parkingLots)
            if(pLot.contains(x,y,width,height))
                return true;
        return false;
    }

    public void paintParkingArea(Graphics g) {
        for(ParkingLot pLot : parkingLots)
            pLot.paintParkingLot(g);
    }
}
