/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mustafa
 */
public class Student extends Pedestrian {
    private int radius;
    public Student(int x,int y)
    {
        super(x,y);
        radius = 10;
    }
    
    @Override
    public void paintPedestrian(Graphics g){
        
        g.setColor(Color.RED);
        g.fillOval(x,y,10,10);
        g.setColor(Color.BLACK);
        g.drawOval(x,y,10,10);
    }

    @Override
    public boolean isStudent() {
        return true;
    }

}
