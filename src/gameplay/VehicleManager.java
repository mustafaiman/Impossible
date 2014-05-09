/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

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
            case 0:  numCars = 5;  break;
            case 1:  numCars = 10; break;
            case 2:  numCars = 15; break;
            default: numCars = 5;
        }
        
        while ( numCars-- > 0){
            vehicles.add(new MobileCar(random.nextInt(800), random.nextInt(600)));
        }
    }
}
