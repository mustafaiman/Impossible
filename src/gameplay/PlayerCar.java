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
    
    public void accelerate(){
        speed++;
    }
    
    public void decelerate(){
        speed--;
    }
    
    public void changeDirection(boolean right){
        if (right)
            direction--;
        else
            direction++;
    }
}
