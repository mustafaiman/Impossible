/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * Manages data related tasks. Like IO operations for saving, loading.
 *
 * @author Ayhun
 */
public class DataManager {

    private static DataManager instance = null;
    SettingsManager settingsMgr;
    HighScoreManager hScoresMgr;

    //Singleton
    /**
     * Constructor is protected for meeting the singleton pattern's requirement
     */
    protected DataManager() {
        settingsMgr = new SettingsManager();
        hScoresMgr = new HighScoreManager();
    }

    /**
     * Returns a Datamanager instance
     *
     * @return DataManager
     */
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }
    
    /**
     * Provides setting information
     * @return Setting object that hold current setting info
     */
    public Settings getSettings() {
        return settingsMgr.readSettings();
    }
    
    /**
     * Provides High Score information for the given stage and difficulty
     * @param stage Stage info
     * @param difficulty Difficulty info
     * @return HighScoreList object
     */
    public HighScoreList getHighScores(int stage, int difficulty) {
        return hScoresMgr.getHighScores(stage, difficulty);
    }
    
    /**
     * Sets the settings to the values that are in the given settings object
     * @param settings Setting info that we want to save to file
     */
    public void setSettings(Settings settings) {
        settingsMgr.saveSettings(settings);
    }
    
    /**
     * Checks if the given score beats any high score in the given stage difficulty pair
     * @param stage stage info
     * @param diff difficulty info
     * @param score score info
     * @return returns a boolean value
     */
    public boolean isHighScore(int stage, int diff, int score) {
        return hScoresMgr.isHighScore(stage, diff, score);
    }

    /**
     * Saves the given high score to the appropriate file
     * @param stage stage info
     * @param diff difficulty info
     * @param score score info
     * @param name name of the player
     */
    public void handleHighScore(int stage, int diff, int score, String name) {
        hScoresMgr.handleHighScore(stage, diff, score, name);
    }
}
