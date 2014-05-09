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
public class AcademicPersonnel extends Pedestrian {
    public AcademicPersonnel(int x,int y)
    {
        super(x,y);
    }
    
    @Override
    boolean checkCollision(int x, int y, int width, int height, double direction) {
        return false;
    }
    
    @Override
    public void paintPedestrian(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x,y,10,10);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,10,10);  
    }
}
