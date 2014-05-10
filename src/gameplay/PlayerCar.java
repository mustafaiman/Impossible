/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import data.DataManager;
import java.awt.Graphics;

/**
 *
 * @author ayhun
 */
public class PlayerCar extends MobileCar{
    private int protection;
    public PlayerCar(int x, int y) {
        
        super(x, y, DataManager.getInstance().getSettings().getCarID()+1);
        speed=0;
        protection = 12;
    }
    
    
    
    public void enableProtection()
    {
        protection = 28;
    }
    
    @Override
    public void advance()
    {
        if(protection > 0 )
            protection--;
        
        int tempx = x + (int)(Math.cos(Math.toRadians(direction))*speed);
        int tempy = y + (int)(-1*Math.sin(Math.toRadians(direction))*speed);
        if(tempx <= 750 && tempx >=0)
            x = tempx;
        if(tempy <= 570 && tempy >=0)
            y = tempy;
        
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
        if(speed>=0){
            if (right)
                direction-=5;
            else
                direction+=5;
        }
        else{
            if (right)
                direction+=5;
            else
                direction-=5;
        }
            
    }
    
    @Override
    public void paint(Graphics g)
    {
        if(protection/4%2 == 0)
            super.paint(g);
    }

    boolean isProtectionEnabled() {
        if(protection > 0)
            return true;
        else
            return false;
    }
}
