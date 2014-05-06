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
 *
 * @author Ayhun
 */
public class SettingsManager {

    private final String settingsFilePath = "data/settings.txt";
    
    Settings settings;

    public SettingsManager() {
        try (BufferedReader br = new BufferedReader(new FileReader(settingsFilePath))) {
            settings = new Settings(br.readLine());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
    
}
