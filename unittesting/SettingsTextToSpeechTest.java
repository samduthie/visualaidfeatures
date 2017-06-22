package unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import managers.SettingsManager;
import utils.Settings;

public class SettingsTextToSpeechTest {

	@Test
	public void test() {
		
		SettingsManager sm = SettingsManager.getInstance();
		
	    sm.setSetting(Settings.ACCESSIBILITY_TEXT_TO_SPEECH, "True");
	    sm.saveSettings();
	      
	    assertEquals("The settings must be set to true to enable text to speech.", "True", sm.getSetting(Settings.ACCESSIBILITY_TEXT_TO_SPEECH));
	    
	    sm.setSetting(Settings.ACCESSIBILITY_TEXT_TO_SPEECH, "False");
	    sm.saveSettings();
	    
	    assertEquals("The settings must be set to false to disable text to speech", "False", sm.getSetting(Settings.ACCESSIBILITY_TEXT_TO_SPEECH));
		
	}

}
