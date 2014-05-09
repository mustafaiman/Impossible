/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Ayhun
 */
public class Settings {
    int volume, difficulty, carID;
    String[] buffer;
    public Settings(String data){
        buffer = data.split(",");
        this.volume = Integer.parseInt(buffer[0]);
        this.difficulty = Integer.parseInt(buffer[1]);
        this.carID = Integer.parseInt(buffer[2]);
    }
    
    public Settings copy(){
        return new Settings(volume+","+difficulty+","+carID);
    }
    
    public String toString(){
        return volume+","+difficulty+","+carID;
    }

    public int getVolume() {
        return volume;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getCarID() {
        return carID;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }
    
    
}
