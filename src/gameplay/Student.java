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
    boolean checkCollision(int x, int y, int width, int height, int direction) {
        int vectorCarX = (int)(Math.cos(Math.toRadians(direction))*(height/2));
        int vectorCarY = (int)(Math.sin(Math.toRadians(direction))*(height/2));
        int vectorPedX = this.x-x;
        int vectorPedY = this.y-y;
        
        long dotproduct = vectorPedX*vectorCarX+vectorPedY*vectorCarY;
        long magnitudeAsq = vectorPedX*vectorPedX+vectorPedY*vectorPedY;
        long magnitudeBsq = vectorCarX*vectorCarX+vectorCarY*vectorCarY;
        
        double costheta = dotproduct/Math.sqrt((double)(magnitudeAsq*magnitudeBsq));
        
        double distToEdge = (double)width/2/(Math.sqrt(1-costheta*costheta));
        double distToPed = Math.sqrt((double)vectorPedX*vectorPedX+vectorPedY*vectorPedY);
        
        if(distToPed-radius < distToEdge) {
            System.out.println(distToPed + " " + distToEdge + " " + costheta);
            System.out.println(vectorCarX + " " + vectorCarY + " " + vectorPedX + " " + vectorPedY);
            return true;
        }
        return false;
    }
    
    @Override
    public void paintPedestrian(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x,y,10,10);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,10,10);  
    }

}
