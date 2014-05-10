/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

/**
 * It is a Vehicle that has capability to move.
 * @author Ayhun
 */
public class MobileCar extends Vehicle{
    Random random;
    /**
     * Constructor for MobeileCar. It uses the default car png for representation.
     * Initializes the random class. Random is used
     * to move system controlled cars at different directions.
     * @param x x coordinate of the location of the car
     * @param y y coordinate of the location of the car
     */
    public MobileCar(int x, int y) {
        super(x, y);
        random = new Random();
        speed = 5;
    }
    /**
     * This constructor can determine the png file to be used as car image.
     * @param x x coordinate of the location of the car
     * @param y y coordinate of the location of the car
     * @param type type id of the car. Range between 1-5
     */
    public MobileCar(int x,int y,int type)
    {
        super(x,y,type);
        random = new Random();
        speed = 5;
    }

    /**
     * It determines next x and y coordinate of the vehicle based on its speed and direction.
     * It makes the vehicles stay in the visible area.
     */
    @Override
    void advance() {
        int tempx = x + (int)(Math.cos(Math.toRadians(direction))*speed);
        int tempy = y + (int)(-1*Math.sin(Math.toRadians(direction))*speed);
        
        if(tempx <= 750 && tempx >=0)
            x = tempx;
        if(tempy <= 570 && tempy >=0)
            y = tempy;
        if(tempx < 0 || tempx > 750 || tempy < 0 || tempy > 570) {
            changeDirection();
            direction +=random.nextInt(50)+150;
        }
        else
            possiblyChangeDirection();
    }

    /**
     * Paints the car on the screen
     * @param g 
     */
    @Override
    void paint(Graphics g) {
        g.drawImage(rotate(carImage,direction), x, y, 64, 64, null);
    }

    /**
     * Changes the direction of the car randomly between -15 and 15 degrees.
     */
    protected void changeDirection() {
        direction += random.nextInt(30)-15;
        
    }

    /**
     * It may or may not change the direction of the car. The probability that it will
     * change direction is 4%
     */
    protected void possiblyChangeDirection() {
        int changeDirectionChance = random.nextInt(100);
        if(changeDirectionChance >=96)
            changeDirection();
    }
    
}
