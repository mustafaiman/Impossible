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
    protected int direction;
    Random random;
    public Pedestrian(int x,int y)
    {
        this.x = x;
        this.y = y;
        random = new Random();
        this.direction = random.nextInt(360);
    }
    
    public void advance()
    {
        int tempx,tempy;
        tempx = x + (int)(Math.sin(Math.toRadians(direction))*10.0);
        tempy = y + (int)(Math.cos(Math.toRadians(direction))*10.0);

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
        direction = random.nextInt(360);
    }
    abstract boolean checkCollision(int x, int y, int width, int height, double direction);
    abstract void paintPedestrian(Graphics g);
}
