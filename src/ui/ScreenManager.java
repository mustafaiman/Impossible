/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

/**
 *
 * @author Dilara
 */
import javax.swing.JFrame;
public class ScreenManager extends JFrame{
    
    static ScreenManager instance = null;
    private ScreenManager() {
	
	setSize(800,610);
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
	MainMenuPanel mainMenuPanel = new MainMenuPanel(this);
	add(mainMenuPanel);

        pack();
        setVisible(true);
        setResizable(false);
    }
    public static ScreenManager getInstance()
    {
    	if(instance==null)
    		instance = new ScreenManager();
    	return instance;
    }
}
