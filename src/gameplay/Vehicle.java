/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author ayhun
 */
public abstract class Vehicle {
    protected int x,y;
    protected int speed;
    protected int direction; //degrees
    protected boolean forward;
    
    public Vehicle(int x,int y)
    {
        this.x = x;
        this.y = y;
        speed = 0;
        direction = 90;
    }
    
    abstract void advance();
    
    abstract void paint(Graphics g);
    
    public Point getLocation(){
        return new Point(x, y);
    }
}
