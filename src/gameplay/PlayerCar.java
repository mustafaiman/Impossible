/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import data.DataManager;

/**
 *
 * @author ayhun
 */
public class PlayerCar extends MobileCar{

    public PlayerCar(int x, int y) {
        
        super(x, y, DataManager.getInstance().getSettings().getCarID()+1);
        speed=0;
    }
    
    @Override
    public void advance()
    {
        x = x + (int)(Math.cos(Math.toRadians(direction))*speed);
        y = y + (int)(-1*Math.sin(Math.toRadians(direction))*speed);
        
    }
    
    public void accelerate(){
        if (speed > 12)
            return;
        speed++;
    }
    
    public void decelerate(){
        if (speed < -5)
            return;
        speed--;
    }
    
    public void changeDirection(boolean right){
        if (right)
            direction-=5;
        else
            direction+=5;
    }
}
