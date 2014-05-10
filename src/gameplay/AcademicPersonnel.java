/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;

/**
 * It represents academic personnel walking around.
 * @author Mustafa
 */
public class AcademicPersonnel extends Pedestrian {
    private int radius;
    /**
     * Constructor for academic personnel
     * @param x x coordinate of the location
     * @param y y coordiante of the location
     */
    public AcademicPersonnel(int x,int y)
    {
        super(x,y);
        radius = 10;
    }
    
    /**
     * Method for painting object
     * @param g 
     */
    @Override
    public void paintPedestrian(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x,y,10,10);
        g.setColor(Color.BLACK);
        g.drawOval(x,y,10,10); 
    }

    /**
     * Always returns false for AcademicPersonnel since it is not a student.
     * @return if the object is a student
     */
    @Override
    public boolean isStudent() {
        return false;
    }
}
