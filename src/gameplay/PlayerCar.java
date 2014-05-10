/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

/**
 *
 * @author ayhun
 */
public class PlayerCar extends MobileCar{

    public PlayerCar(int x, int y) {
        super(x, y);
    }
    
    public void advance()
    {
        int tempx = x + (int)(-1*Math.sin(Math.toRadians(direction))*speed);
        int tempy = y + (int)(Math.cos(Math.toRadians(direction))*speed);

        if(tempx <= 800 && tempx >=0)
            x = tempx;
        if(tempy <= 600 && tempy >=0)
            y = tempy;
    }
    
    public void accelerate(){
        if (speed > 50)
            return;
        speed++;
    }
    
    public void decelerate(){
        if (speed < -25)
            return;
        speed--;
    }
    
    public void changeDirection(boolean right){
        if (right)
            direction--;
        else
            direction++;
    }
}
