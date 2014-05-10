/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import ui.ImageTool;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author ayhun
 */
public abstract class Vehicle {
    protected int x,y;
    protected int speed;
    protected int direction; //degrees
    protected boolean forward;
    
    public Vehicle(int x,int y)
    {
        this.x = x;
        this.y = y;
        speed = 0;
        direction = 90;
    }
    
    abstract void advance();
    
    abstract void paint(Graphics g);
    
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
}
