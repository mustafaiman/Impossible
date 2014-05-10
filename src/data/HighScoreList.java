/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.ArrayList;

/**
 *
 * @author Ayhun
 */
public class HighScoreList {
    String [] buffer;
    ArrayList<String> names;
    ArrayList<Integer> scores;
    
    public HighScoreList(String scoreInfo){
        names = new ArrayList<String>();
        scores = new ArrayList<Integer>();
        buffer = scoreInfo.split(",");
        
        for(int i = buffer.length - 2; i >= 0 ; i = i - 2 ){
            names.add(buffer[i]);
            scores.add(Integer.parseInt(buffer[i+1]));
        }
    }
    
    public String toString(){
        String tmp="<html>";
        for(int i = 0; i < names.size();i++){
            tmp += names.get(i) + "\t->" + scores.get(i)+"<br>";
        }
        
        return tmp;
    }
    
    public boolean isHighScore(int i){
        for(int j: scores){
            if(i > j){
                return true;
            }
        }
        return false;
    }
}
