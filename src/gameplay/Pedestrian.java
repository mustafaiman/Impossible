/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.util.Random;

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
    protected boolean checkCollision(int x, int y, int width, int height, int direction) {
            if(checkDimensionalCollision(x,y,width,height,direction))
                return true;
            if(checkDimensionalCollision(x,y,height,width,direction))
                return true;
            return false;
    }
    protected boolean checkDimensionalCollision(int x,int y,int dia1, int dia2,int direction)
    {
        double px = ((double)dia1/2)*Math.cos(Math.toRadians(direction));
        double py = ((double)dia1/2)*Math.sin(Math.toRadians(direction));

        double len = px*px + py*py;

        double u =  ((this.x - x) * px + (this.y - y) * py) / len;

        if (u > 1)
            u = 1;
        else if (u < 0)
            u = 0;

        double tx = x + u * px;
        double ty = y + u * py;

        double dx = tx - this.x;
        double dy = ty - this.y;

        double dist = dx*dx + dy*dy;

        if(dist < Math.pow((double)dia2/2,2))
            return true;
        return false;
    }
    abstract void paintPedestrian(Graphics g);
}
