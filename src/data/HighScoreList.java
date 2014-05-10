/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Holds high score information for a single stage difficulty pair
 * @author Ayhun
 */
public class HighScoreList {
    String [] buffer;
    ArrayList<String> names;
    ArrayList<Integer> scores;
    /**
     * Constructor takes a string and parses it to two arrays (names and scores). Input string should have the form "name1,score1,name2,score2..."
     * @param scoreInfo Input string that will be parsed
     */
    public HighScoreList(String scoreInfo){
        names = new ArrayList<String>();
        scores = new ArrayList<Integer>();
        buffer = scoreInfo.split(",");
        
        for(int i = 0; i <= buffer.length - 2 ; i = i + 2 ){
            names.add(buffer[i]);
            scores.add(Integer.parseInt(buffer[i+1]));
        }
    }
    
    /**
     * returns html version of high score info to be printed on a JLabel object
     * @return 
     */
    public String toString(){
        String tmp="<html>";
        for(int i = 0; i < names.size();i++){
            tmp += names.get(i) + "\t->" + scores.get(i)+"<br>";
        }
        
        return tmp;
    }
    
    /**
     * Checks if the given score is a high score on current list
     * @param i score to be tested
     * @return 
     */
    public boolean isHighScore(int i){
        if(i==0)
            return false;
        
        if (scores.size() < 5)
            return true;
        
        for(int j: scores){
            if(i > j){
                return true;
            }
        }
        return false;
    }
    /**
     * Handles the given score. (saves it to disk without breaking the decreasing order)
     * @param score score to be added to list
     * @param name name of the person who accomplished that score
     * @param targetPath path of the file in which the handled version of the list to be written
     */
    public void handleHighScore(int score, String name, String targetPath){
        
        for(int i = 0; i < scores.size(); i++){
            System.out.println("-" + i + " " + scores.get(i) + " " + score);
            if(scores.get(i)<=score){
                scores.add(i, score);
                names.add(i, name);
                break;
            }
        }
        if(scores.size() > 5){
            scores.remove(scores.size()-1);
            names.remove(names.size()-1);
        }
        
        try (BufferedWriter  wr = new BufferedWriter (new FileWriter (targetPath))) {
            for(int i = 0 ; i < scores.size();i++){
                if(i==scores.size()-1){
                    wr.write(names.get(i)+","+scores.get(i));
                    break;
                }
                wr.write(names.get(i)+","+scores.get(i)+",");

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
    }
}
