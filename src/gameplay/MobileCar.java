/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

/**
 *
 * @author Home-PC
 */
public class MobileCar extends Vehicle{
    Random random;
    public MobileCar(int x, int y) {
        super(x, y);
        random = new Random();
    }

    @Override
    void advance() {
        int tempx = x + (int)(-1*Math.cos(Math.toRadians(direction))*speed);
        int tempy = y + (int)(Math.sin(Math.toRadians(direction))*speed);

        if(tempx <= 800 && tempx >=0)
            x = tempx;
        if(tempy <= 600 && tempy >=0)
            y = tempy;
        if(tempx < 0 || tempx > 800 || tempy < 0 || tempy > 600)
            changeDirection();
        else
            possiblyChangeDirection();
    }

    @Override
    void paint(Graphics g) {
        g.drawImage(rotate(Toolkit.getDefaultToolkit().getImage("images/cars/defaultCar.png"),direction), x, y, 64, 64, null);
    }

    private void changeDirection() {
        direction = random.nextInt(360);
    }

    private void possiblyChangeDirection() {
        int changeDirectionChance = random.nextInt(100);
        if(changeDirectionChance >=96)
            changeDirection();
    }
    
}
