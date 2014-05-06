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
public class DataManager {
    private static DataManager instance = null;
    SettingsManager settingsMgr;
    HighScoreManager hScoresMgr;
    
    //Singleton
    protected DataManager(){
        settingsMgr= new SettingsManager();
        hScoresMgr = new HighScoreManager();
    }
    
    public static DataManager getInstance() {
      if(instance == null) {
         instance = new DataManager();
      }
      return instance;
   }
    
    public Settings getSettings() {
        return settingsMgr.readSettings();
    }
    
    public HighScoreManager gethScoresMgr() {
        return hScoresMgr;
    }

    public void setSettings(Settings settings) {
        settingsMgr.saveSettings(settings);
    }
}
