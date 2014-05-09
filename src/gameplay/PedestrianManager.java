/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mustafa
 */
public class PedestrianManager {
    private int difficulty;
    ArrayList<Pedestrian> pedestrians;
    public PedestrianManager(int diff)
    {
        difficulty = diff;
        pedestrians = new ArrayList<Pedestrian>();
        Random random = new Random();
        
        int numOfStudents,numOfAcademics;
        if(diff == 0)
        {
            numOfStudents = 10;
            numOfAcademics = 10;
        } else if(diff == 1)
        {
            numOfStudents = 20;
            numOfAcademics = 20;
        } else {
            numOfStudents = 30;
            numOfAcademics = 30;
        }
        
        for(int i=0;i<numOfStudents;i++)
        {
            pedestrians.add(new Student(random.nextInt(800),random.nextInt(600)));
        }
        for(int i=0;i<numOfAcademics;i++)
        {
            pedestrians.add(new AcademicPersonnel(random.nextInt(800),random.nextInt(600)));
        }
    }
    public void advance()
    {
        for(Pedestrian ped : pedestrians)
            ped.advance();
    }
    public void killPedestrian(int id)
    {
        if(id >= pedestrians.size() )
            return;
        pedestrians.remove(id);
    }
    public int checkCollision(int x, int y, int width, int height)
    {
        return 0;
    }
    public void paintComponent(Graphics g)
    {
        for(Pedestrian ped : pedestrians)
            ped.paintPedestrian(g);
    }
}
