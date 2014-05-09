/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;
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
    public Pedestrian(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    
    abstract void advance();
    
    abstract void paintPedestrian(Graphics g);
}
