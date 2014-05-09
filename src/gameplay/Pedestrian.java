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
public class Pedestrian {
    private int x,y,direction;
    public Pedestrian(int x,int y)
    {
        this.x = x;
        this.y = y;
        this.direction=0;
    }
    
    public void advance() {
        
    }
    
    public void paintPedestrian(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x,y,10,10);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,10,10);  
    }
}
