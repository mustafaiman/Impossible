/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages Settings information on disk
 * @author Ayhun
 */
public class SettingsManager {

    private final String settingsFilePath = "data/settings.txt";
    
    Settings settings;

    /**
     * Constructor of SettingsManager
     */
    public SettingsManager(){
        try (BufferedReader br = new BufferedReader(new FileReader(settingsFilePath))) {
            settings = new Settings(br.readLine());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
    /**
     * Returns a copy of the setting object
     * @return setting object
     */
    public Settings readSettings() {
        return settings.copy();
    }

    /**
     * Saves the setting object to the disk
     * @param settings Setting object
     */
    public void saveSettings(Settings settings) {
        FileOutputStream writer = null;
        try {
            this.settings = settings;
            writer = new FileOutputStream(settingsFilePath);
            writer.write(settings.toString().getBytes());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
