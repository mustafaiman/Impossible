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
 * This is a class to perform operations on pedestrians
 *
 * @author Mustafa
 */
public class PedestrianManager {

    private int difficulty;
    ArrayList<Pedestrian> pedestrians;

    /**
     * Manages all pedestrian objects in the current game initializing them
     * within a list of pedestrians
     *
     * @param diff difficulty level of the game
     */
    public PedestrianManager(int diff) {
        difficulty = diff;
        pedestrians = new ArrayList<Pedestrian>();
        Random random = new Random();

        int numOfStudents, numOfAcademics;
        if (diff == 0) {
            numOfStudents = 10;
            numOfAcademics = 10;
        } else if (diff == 1) {
            numOfStudents = 20;
            numOfAcademics = 20;
        } else {
            numOfStudents = 30;
            numOfAcademics = 30;
        }

        for (int i = 0; i < numOfStudents; i++) {
            pedestrians.add(new Student(random.nextInt(790), random.nextInt(590)));
        }
        for (int i = 0; i < numOfAcademics; i++) {
            pedestrians.add(new AcademicPersonnel(random.nextInt(790), random.nextInt(590)));
        }
    }

    /**
     * Advances all pedestrians in pedestrian list using advance method of
     * Pedestrian class
     */
    public void advance() {
        for (Pedestrian ped : pedestrians) {
            ped.advance();
        }
    }

    /**
     * Checks if there is a collision between any pedestrian within pedestrians
     * list and player's car
     *
     * @param x horizontal coordinate of the location of pedestrian
     * @param y vertical coordinate of the location of pedestrian
     * @param width width of pedestrian
     * @param height height of pedestrian
     * @return current score
     */
    public int checkCollision(int x, int y, int width, int height) {
        int score = 0;
        for (int i = 0; i < pedestrians.size(); i++) {
            if (pedestrians.get(i).checkCollision(x, y, width, height)) {
                if (pedestrians.get(i).isStudent()) {
                    score = 200;
                } else {
                    score = 100;
                }
                pedestrians.remove(i);
            }
        }
        return score;
    }

    /**
     * Determines the type of a pedestrian
     *
     * @param index specifies the type of a pedestrian
     * @return 0 if pedestrian is a student, 1 otherwise (=if academic
     * personnel)
     */
    public int getPedestrianType(int index) {
        if (pedestrians.get(index) instanceof Student) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * paints pedestrians onto panel
     *
     * @param g Graphic object
     */
    public void paintComponent(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.BOLD, 32));
        for (Pedestrian ped : pedestrians) {
            ped.paintPedestrian(g);
        }
    }
}
