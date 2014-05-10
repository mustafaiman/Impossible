/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 * Holds the setting information on its variables
 * @author Ayhun
 */
public class Settings {
    int volume, difficulty, carID;
    String[] buffer;
    
    /**
     * Constructor of the Settings class, parses a string to obtain setting info
     * @param data String to be parsed. Input should have the form "(volume),(difficulty),(carID)"
     */
    public Settings(String data){
        buffer = data.split(",");
        this.volume = Integer.parseInt(buffer[0]);
        this.difficulty = Integer.parseInt(buffer[1]);
        this.carID = Integer.parseInt(buffer[2]);
    }
    
    /**
     * Makes a new settings object from current settings information
     * @return Settings object
     */
    public Settings copy(){
        return new Settings(volume+","+difficulty+","+carID);
    }
    
    /**
     * Converts to string
     * @return String representation of current setting info
     */
    public String toString(){
        return volume+","+difficulty+","+carID;
    }

    /**
     * Returns volume info
     * @return Volume 
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns difficulty info
     * @return Difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Returns carID info
     * @return carID
     */
    public int getCarID() {
        return carID;
    }

    /**
     * Sets the volume
     * @param volume volume level
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Sets the difficulty
     * @param difficulty difficulty level
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Sets the carID
     * @param carID id of car
     */
    public void setCarID(int carID) {
        this.carID = carID;
    }
    
    
}
