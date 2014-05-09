/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Mustafa
 */
public class Student extends Pedestrian {
    Random random;
    public Student(int x,int y)
    {
        super(x,y);
        random = new Random();
    }
    public void advance()
    {
        if(forward)
        {
            x += (int)(direction*10.0);
            y += (int)(Math.sqrt(1-direction*direction)*10.0);
        } else {
            x -= (int)(direction*10.0);
            y -= (int)(Math.sqrt(1-direction*direction)*10.0);
        }
        int changeDirectionChance = random.nextInt(100);
        if(changeDirectionChance >=80)
        {
            direction = random.nextDouble();//-1 ile 1 arası olacak. şuan 0 ile 1 arası
            forward = random.nextBoolean();
        }
    }
    public void paintPedestrian(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x,y,10,10);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,10,10);  
    }
}
