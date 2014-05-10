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
import java.util.ArrayList;

/**
 *
 * @author Ayhun
 */
public class HighScoreManager {
    private final String hsPath = "data/hscores/";
    private String targetPath;
    private HighScoreList list;
    
    public HighScoreList getHighScores(int stage, int difficulty){
        targetPath = hsPath + stage + "/";
        switch (difficulty){
            case 0: targetPath += "easy.txt";
                    break;
            case 1: targetPath += "medium.txt";
                    break;
            case 2: targetPath += "hard.txt";
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
    
    public boolean isHighScore(int stage, int diff, int score){
        return getHighScores(stage, diff).isHighScore(score) ;
    }
}
