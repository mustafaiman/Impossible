/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Manages High Score information on disk
 *
 * @author Ayhun
 */
public class HighScoreManager {

    private final String hsPath = "data/hscores/";
    private String targetPath;
    private HighScoreList list;

    /**
     * Constructor of HighScoreList
     *
     * @param stage Stage information
     * @param difficulty Difficulty information
     * @return returns a HighScoreList object
     */
    public HighScoreList getHighScores(int stage, int difficulty) {
        targetPath = hsPath + stage + "/";
        switch (difficulty) {
            case 0:
                targetPath += "easy.txt";
                break;
            case 1:
                targetPath += "medium.txt";
                break;
            case 2:
                targetPath += "hard.txt";
                break;
        }
        System.out.println(targetPath);

        try (BufferedReader br = new BufferedReader(new FileReader(targetPath))) {
            list = new HighScoreList(br.readLine());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        return list;
    }

    /**
     * checks if given score is a high score material in the given stage
     * difficulty pair
     *
     * @param stage Stage info
     * @param diff Difficulty level
     * @param score Score info
     * @return returns a boolean value
     */
    public boolean isHighScore(int stage, int diff, int score) {
        return getHighScores(stage, diff).isHighScore(score);
    }

    /**
     * Handles a new High Score.
     *
     * @param stage Stage info
     * @param diff Difficulty info
     * @param score Score info
     * @param name Name of the person who did that score
     */
    public void handleHighScore(int stage, int diff, int score, String name) {
        getHighScores(stage, diff).handleHighScore(score, name, targetPath);
    }
}
