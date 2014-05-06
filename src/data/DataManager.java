/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Mustafa
 */
public class DataManager {
    SettingsManager settingsMgr;
    HighScoreManager hScoresMgr;
    
    public DataManager(){
        settingsMgr= new SettingsManager();
        hScoresMgr = new HighScoreManager();
    }
    
    public Settings getSettings() {
        return settingsMgr.getSettings();
    }
    
    public HighScoreManager gethScoresMgr() {
        return hScoresMgr;
    }
}
