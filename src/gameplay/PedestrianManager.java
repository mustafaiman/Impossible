/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameplay;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

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
            pedestrians.add(new Student(random.nextInt(790),random.nextInt(590)));
        }
        for(int i=0;i<numOfAcademics;i++)
        {
            pedestrians.add(new AcademicPersonnel(random.nextInt(790),random.nextInt(590)));
        }
    }
    public void advance()
    {
        for(Pedestrian ped : pedestrians)
            ped.advance();
    }
    
    public int checkCollision(int x, int y, int width, int height)
    {
        int score = 0  ;
        for(int i=0;i<pedestrians.size();i++) {
            if( pedestrians.get(i).checkCollision(x, y, width, height) ){
                if(pedestrians.get(i).isStudent())
                    score = 200;
                else
                    score = 100;
                pedestrians.remove(i);
            }
        }
        return score;
    }
    public int getPedestrianType(int index)
    {
        if(pedestrians.get(index) instanceof Student)
            return 0;
        else
            return 1;
    }
    public void paintComponent(Graphics g)
    {
        g.setFont(new Font("TimesRoman", Font.BOLD, 32)); 
        for(Pedestrian ped : pedestrians)
            ped.paintPedestrian(g);
    }
}
