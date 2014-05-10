/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

/**
 *
 * @author Home-PC
 */
public class Taxi extends MobileCar {

    public Taxi(int x, int y) {
        super(x, y,6);
        speed = 10;
        carTypeId = 6;
    }
    
    @Override
    protected void possiblyChangeDirection() {
        int changeDirectionChance = random.nextInt(100);
        if(changeDirectionChance >=80)
            changeDirection();
    }
    
    protected void changeDirection() {
        direction += random.nextInt(70)-35;
    }
    
    
    
}
