/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import ui.ImageTool;

/**
 *
 * @author ayhun
 */
public abstract class Vehicle {
    protected int x,y;
    protected int speed;
    protected int direction; //degrees
    protected boolean forward;
    protected int carTypeId;
    protected Image carImage;
    
    public Vehicle(int x,int y)
    {
        this.x = x;
        this.y = y;
        speed = 0;
        direction = 90;
        carTypeId = 0;
        carImage = Toolkit.getDefaultToolkit().getImage("images/cars/defaultCar.png");
    }
    public Vehicle(int x,int y,int carType)
    {
        this.x = x;
        this.y = y;
        speed = 0;
        direction = 90;
        carTypeId = carType;
        String carFileName;
        if(carType == 6)
            carFileName = "taxi";
        else
            carFileName = ""+carTypeId;
        carImage = Toolkit.getDefaultToolkit().getImage("images/cars/"+carFileName +".png");
        
    }
    
    abstract void advance();
    
    abstract void paint(Graphics g);
    
    public boolean checkCollision(int x,int y,int width,int height)
    {
        Rectangle rectC = new Rectangle(x,y,width,height);
        Rectangle rectA = new Rectangle(this.x,this.y,32,64);
        PathIterator it = rectA.getPathIterator(null);
        while(!it.isDone()) {
            double[] coords = new double[2];
            it.currentSegment(coords);
            if(rectC.contains(coords[0],coords[1]))
                return true;
            // At this point, coords contains the coordinates of one of the vertices. This is where you should check to make sure the vertex is inside your circle
            it.next(); // go to the next point
        }
        return false;
    }
    
    public Image rotate(Image img, double angle)
    {
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
               cos = Math.abs(Math.cos(Math.toRadians(angle)));

        int w = img.getWidth(null), h = img.getHeight(null);

        int neww = (int) Math.floor(w*cos + h*sin),
            newh = (int) Math.floor(h*cos + w*sin);

        BufferedImage bimg = ImageTool.toBufferedImage(ImageTool.getEmptyImage(neww, newh));
        Graphics2D g = bimg.createGraphics();

        g.translate((neww-w)/2, (newh-h)/2);
        g.rotate(-Math.toRadians(angle), w/2, h/2);
        g.drawRenderedImage(ImageTool.toBufferedImage(img), null);
        g.dispose();

        return ImageTool.toImage(bimg);
    }
    public Point getLocation(){
        return new Point(x, y);
    }
    
    public int getSpeed()
    {
        return speed;
    }
}
