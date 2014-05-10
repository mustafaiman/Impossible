/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * Manages an array of vehicles including taxis and normal vehicles
 *
 * @author ayhun
 */
public class VehicleManager {

    private int difficulty;
    private ArrayList<Vehicle> vehicles;
    private PlayerCar pCar;

    /**
     * Constructor of VehicleManager. Changes number of cars according to given
     * difficulty
     *
     * @param diff level of difficulty
     */
    public VehicleManager(int diff) {
        difficulty = diff;
        vehicles = new ArrayList<Vehicle>();
        pCar = new PlayerCar(750, 550);
        Random random = new Random();

        int numCars;

        switch (difficulty) {
            case 0:
                numCars = 4;
                break;
            case 1:
                numCars = 8;
                break;
            case 2:
                numCars = 12;
                break;
            default:
                numCars = 4;
        }

        for (int i = 0; i < numCars / 2; i++) {
            vehicles.add(new MobileCar(random.nextInt(800), random.nextInt(600)));
            vehicles.add(new Taxi(random.nextInt(800), random.nextInt(600)));
        }
    }

    /**
     * Advances every car including the player's car
     */
    public void advance() {
        pCar.advance();
        for (Vehicle v : vehicles) {
            v.advance();
        }
    }

    /**
     * Paints every car including the player's car
     *
     * @param g Graphics object
     */
    public void paintComponent(Graphics g) {
        pCar.paint(g);
        for (Vehicle v : vehicles) {
            v.paint(g);
        }
    }

    /**
     * Checks every computer generated car for the possibility of a collision
     * with player's car
     *
     * @param x x coordinate of the player's car
     * @param y y coordinate of the player's car
     * @param width width of the player's car
     * @param height height of the player's car
     * @return returns a boolean value
     */
    public boolean checkCollision(int x, int y, int width, int height) {
        Point p;
        for (Vehicle v : vehicles) {
            p = v.getLocation();
            if (v.checkCollision(x, y, width, height)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Returns the location of player's car
     *
     * @return Point object
     */
    public Point getPCarLocation() {
        return pCar.getLocation();
    }

    /**
     * Sends appropriate commands to player's car according to input from user
     *
     * @param code 0-accelerate, 1-decelerate, 2-turn right, 3-turn left
     */
    public void movePCar(int code) {
        switch (code) {
            case 0:
                pCar.accelerate();
                break;
            case 1:
                pCar.decelerate();
                break;
            case 2:
                pCar.changeDirection(true);
                break;
            case 3:
                pCar.changeDirection(false);
                break;
            default:
                break;

        }
    }

    /**
     * Provides the speed of player's car
     *
     * @return
     */
    public int getPCarSpeed() {
        return pCar.getSpeed();
    }

    /**
     * When protection is enabled, score does not decrease
     */
    void enableProtection() {
        pCar.enableProtection();
    }

    /**
     * Checks if the protection is enabled
     *
     * @return returns a boolean value
     */
    boolean isProtectionEnabled() {
        return pCar.isProtectionEnabled();
    }
}
