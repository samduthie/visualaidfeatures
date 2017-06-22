package unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import managers.SettingsManager;
import utils.Settings;

public class SettingsLargeGUITest {

	@Test
	public void test() {
		
		SettingsManager sm = SettingsManager.getInstance();
		
	    sm.setSetting(Settings.ACCESSIBILITY_LARGE_GUI, "True");
	    sm.saveSettings();
	      
	    assertEquals("The settings must be set to for an enlarged GUI ", "True", sm.getSetting(Settings.ACCESSIBILITY_LARGE_GUI));
	    
	    sm.setSetting(Settings.ACCESSIBILITY_LARGE_GUI, "False");
	    sm.saveSettings();
	    
	    assertEquals("The settings must be set to false for the normal GUI", "False", sm.getSetting(Settings.ACCESSIBILITY_LARGE_GUI));
		
	}

}
