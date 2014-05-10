/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is for representing pedestrian of type Student
 * @author Mustafa
 */
public class Student extends Pedestrian {
    private int radius;
    public Student(int x,int y)
    {
        super(x,y);
        radius = 10;
    }
    
    /**
     * Sets the color of pedestrian to red to distinguish it from an academic personnel and
     * make it a student
     * @param g Graphic g
     */
    @Override
    public void paintPedestrian(Graphics g){
        
        g.setColor(Color.RED);
        g.fillOval(x,y,10,10);
        g.setColor(Color.BLACK);
        g.drawOval(x,y,10,10);
    }
    /**
     * 
     * @return true if a pedestrian is a student 
     */
    @Override
    public boolean isStudent() {
        return true;
    }

}
