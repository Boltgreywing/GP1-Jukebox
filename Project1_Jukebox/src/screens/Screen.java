package screens;

import java.awt.Graphics;
import controls.NesController;
import main.GamePanel;

public abstract class Screen {
	
	private String name, nextScreen;
	private boolean quit;
	private NesController key;
	
	Screen(String screenName) {
		name = screenName;
	}
	
	//Methods to define in subclasses
	public abstract void update();
	public abstract void draw(Graphics g);
	
	public void setPanel(GamePanel panel) {
		
	}
		
	public void cartKeyboard(GamePanel screen) {
		key = new NesController();
		key.setPlayerKeys("UP", "UP");
		key.setPlayerKeys("LEFT", "LEFT");
		key.setPlayerKeys("RIGHT", "RIGHT");
		key.setPlayerKeys("DOWN", "DOWN");
		key.setPlayerKeys("JUMP", "J");
		key.setPlayerKeys("ATTACK", "K");
		key.setPlayerKeys("START", "SPACEBAR");
		key.setPlayerKeys("SELECT", "M");
		screen.addKeyListener(key);
	}
	
	public String getScreenName() {
		return name;
	}
	
	public boolean exitScreen() {
		return quit;
	}
	
	void setEndgame(boolean value) {
		quit = value;
	}
	
	protected NesController getKeyboard() {
		return key;
	}
	
	public void setNextScreen(String next) {
		nextScreen = next;
	}
	
	public String getNextScreen() {
		return nextScreen;
	}
}