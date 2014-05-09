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
        int tempx,tempy;
        tempx = x + (int)(-1*Math.sin(Math.toRadians(direction))*20.0);
        tempy = y + (int)(Math.cos(Math.toRadians(direction))*20.0);

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
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(direction));
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(x,y,10,20);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x,y,10,20); 
    }

    private void changeDirection() {
        direction = random.nextInt(360);
    }

    private void possiblyChangeDirection() {
        int changeDirectionChance = random.nextInt(100);
        if(changeDirectionChance >=90)
            changeDirection();
    }
    
}
