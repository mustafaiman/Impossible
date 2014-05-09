/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mustafa
 */
public class PedestrianManager {
    private JPanel panel;
    ArrayList<Pedestrian> pedestrians;
    public PedestrianManager()
    {
        pedestrians = new ArrayList<Pedestrian>();
        pedestrians.add(new Pedestrian(0,0));
        pedestrians.add(new Pedestrian(100,200));
        pedestrians.add(new Pedestrian(85,600));
        pedestrians.add(new Pedestrian(600,400));
    }
    public void paintComponent(Graphics g)
    {
        for(Pedestrian ped : pedestrians)
            ped.paintPedestrian(g);
    }
}
