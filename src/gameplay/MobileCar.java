/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
        speed = 5;
    }
    public MobileCar(int x,int y,int type)
    {
        super(x,y,type);
        random = new Random();
        speed = 5;
    }

    @Override
    void advance() {
        int tempx = x + (int)(Math.cos(Math.toRadians(direction))*speed);
        int tempy = y + (int)(-1*Math.sin(Math.toRadians(direction))*speed);
        
        if(tempx <= 750 && tempx >=0)
            x = tempx;
        if(tempy <= 570 && tempy >=0)
            y = tempy;
        if(tempx < 0 || tempx > 750 || tempy < 0 || tempy > 570) {
            changeDirection();
            direction +=random.nextInt(50)+150;
        }
        else
            possiblyChangeDirection();
    }

    @Override
    void paint(Graphics g) {
        g.drawImage(rotate(carImage,direction), x, y, 64, 64, null);
    }

    protected void changeDirection() {
        direction += random.nextInt(30)-15;
        
    }

    protected void possiblyChangeDirection() {
        int changeDirectionChance = random.nextInt(100);
        if(changeDirectionChance >=96)
            changeDirection();
    }
    
}
