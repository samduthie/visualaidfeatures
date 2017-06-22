package managers;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.FreeTTS;

/**
 * SpeechManager class creates the voices and controls the action events and generates the methods.
 * @author Group 5
 *
 */
public class SpeechManager {
	
	//Voice name.
	private static final String VOICENAME = "kevin16";
	//Voice object.
	private Voice voice;
	//Voice Manager object.
	private VoiceManager vm;
	
	private FreeTTS stop;
	
	/*
	 * To fix the hanging bug, I had created a method that would kill the connection
	 * to the audio player everything the mouse moved away from an icon. I would also
	 * create a new thread whenever you would hover over an icon so that the GUI and 
	 * the speech could work concurrently. Reason for not fully implementing them, there
	 * are more program ending bugs that are creating from this implementation.
	 */
	
	
	/**
	 * Creates a voice manager and selects the voice.
	 */
	public SpeechManager() {
		
		vm = VoiceManager.getInstance();
		voice = vm.getVoice(VOICENAME);
		stop = new FreeTTS(voice);
	}
	
	/**
	 * Speaks the string.
	 * @param desc	the string to speak.
	 */
	public void speak(String desc) {
		
		 voice.allocate();
		 voice.speak(desc);
	 }
	
	public void stop() {
		stop.shutdown();
	}
	
	public void start() {
		stop.startup();
	}


}
