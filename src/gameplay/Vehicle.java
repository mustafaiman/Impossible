/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;

/**
 *
 * @author ayhun
 */
public abstract class Vehicle {
    protected int x,y;
    protected double direction;
    protected boolean forward;
    
    public Vehicle(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    
    abstract void advance();
    
    abstract void paint(Graphics g);
}
