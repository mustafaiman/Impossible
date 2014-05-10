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
public class ParkingManager {

    private ArrayList<ParkingArea> parkingAreas;

    /**
     * Constructor of the parking manager
     *
     * @param x
     * @param y
     * @param num
     * @param orientation
     */
    public ParkingManager(int x, int y, int num, boolean orientation) {
        parkingAreas = new ArrayList<ParkingArea>();
        for (int i = 0; i < num; i++) {
            parkingAreas.add(new ParkingArea(x, y, 3, orientation));
        }
    }

    public boolean checkIfParked(int x, int y, int width, int height) {
        for (ParkingArea pArea : parkingAreas) {
            if (pArea.contains(x, y, width, height)) {
                return true;
            }
        }
        return false;
    }

    public void paintComponent(Graphics g) {
        for (ParkingArea pArea : parkingAreas) {
            pArea.paintParkingArea(g);
        }
    }
}
