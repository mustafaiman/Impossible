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
 *
 * @author ayhun
 */
public class VehicleManager {
    private int difficulty;
    ArrayList<Vehicle> vehicles;
    PlayerCar pCar;
    
    public VehicleManager(int diff){
        difficulty = diff;
        vehicles = new ArrayList<Vehicle>();
        pCar = new PlayerCar(750,550);
        Random random = new Random();
        
        int numCars;
        
        switch (difficulty){
            case 0:  numCars = 4;  break;
            case 1:  numCars = 8; break;
            case 2:  numCars = 12; break;
            default: numCars = 4;
        }
        
        for (int i = 0; i< numCars/2;i++){
            vehicles.add(new MobileCar(random.nextInt(800), random.nextInt(600)));
            vehicles.add(new Taxi(random.nextInt(800), random.nextInt(600)));
        }
    }
    
    public void advance()
    {
        for(Vehicle v : vehicles)
            v.advance();
    }
    public void paintComponent(Graphics g)
    {
        for(Vehicle v : vehicles)
            v.paint(g);
    }
    
    public boolean checkCollision(int x, int y, int width, int height){// dolsun diye yazdım düzeltilecek.
        Point p;
        for(Vehicle v : vehicles){
            p=v.getLocation();
            if(p.getX() > x && p.getX() < x+width)
                if(p.getY()> y && p.getY() < y+height)
                    return true;           
        }
        return false;

    }
}
