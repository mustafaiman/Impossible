/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

/**
 *
 * @author Mustafa
 */
public abstract class Pedestrian {
    protected int x,y;
    protected double direction;
    protected boolean forward;
    Random random;
    public Pedestrian(int x,int y)
    {
        this.x = x;
        this.y = y;
        random = new Random();
    }
    
    public void advance()
    {
        int tempx,tempy;
        if(forward)
        {
            tempx = x + (int)(direction*10.0);
            tempy = y + (int)(Math.sqrt(1-direction*direction)*10.0);
        } else {
            tempx = x - (int)(direction*10.0);
            tempy = y - (int)(Math.sqrt(1-direction*direction)*10.0);
        }
        if(tempx <= 800 && tempx >=0)
            x = tempx;
        if(tempy <= 600 && tempy >=0)
            y = tempy;
        if(tempx < 0 || tempx > 800 || tempy < 0 || tempy > 600)
            changeDirection();
        else
            possiblyChangeDirection();
    }
    private void possiblyChangeDirection()
    {
        int changeDirectionChance = random.nextInt(100);
        if(changeDirectionChance >=90)
            changeDirection();
    }
    private void changeDirection()
    {
        direction = random.nextDouble();//-1 ile 1 arası olacak. şuan 0 ile 1 arası
        forward = random.nextBoolean();
    }
    
    abstract void paintPedestrian(Graphics g);
}
