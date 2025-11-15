package screens;

import java.awt.Color;
import java.awt.Graphics;
import helpers.AudioPlayer;
import helpers.WordReader;
import main.GamePanel;
import sprites.Pointer;

public class TitleScreen extends Screen {
	
	//Variables for the jukebox
	private AudioPlayer audio;
	private byte position;
		
	//Variables for the menu
	private short lockTimeout;
	private boolean lockSet;
	private short songId = 4;
	//private GamePanel panel;
		
	private WordReader title, start, quit;
	private Pointer pointer;
	private int width, height;
	
	public TitleScreen() {
		super("None");
		audio = new AudioPlayer("/songlist/Jukebox.txt");
		lockSet = false;
		audio.loopMusic(songId);
	}
	
	public void setPanel(GamePanel panel) {
		//this.panel = panel;
		width = panel.getPanelWidth();
		height = panel.getPanelHeight();
		title = new WordReader("Jukebox", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 20, true);
		start = new WordReader("Start", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 200, true);
		quit = new WordReader("Quit", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 280, true);
		pointer = new Pointer((short) start.getXPos(), (short) start.getYPos());
	}

	@Override
	public void update() {
		//Lock timer used for menu movement and song selection
		if(lockSet) {
			lockTimeout--;
		}
		
		//Reset the lock after time expires
		if(lockTimeout == 0 && lockSet == true) {
			lockSet = false;
		}
		
		//Allow menu navigation if the lock is not set
		if(!lockSet) {
			boolean buttonPressed = false;
			if(getKeyboard().playerKeys[0] && position - 1 >= 0) {
				position -= 1;
				buttonPressed = true;
			} else if(getKeyboard().playerKeys[3] && position < 1) {
				position += 1;
				buttonPressed = true;
			}
			
			if(buttonPressed) {
				lockSet = true;
				lockTimeout = 8;
				moveCursor();
			}
		}
		
		if(getKeyboard().playerKeys[4]) {
			if(position == 0) {
				setNextScreen("Jukebox");
			} else if(position == 1) {
				setNextScreen(null);
			}
			setEndgame(true);
			cleanup();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		if(!exitScreen()) {
			title.render(g);
			start.render(g);
			quit.render(g);
			pointer.render(g);			
		}
	}
	
	private void cleanup() {
		if(audio != null) {
			audio.stopMusic();			
			audio = null;
		}
		
		//Clears the pointer and options
		title = null;
		start = null;
		quit = null;
		pointer = null;
	}
	
	private void moveCursor() {
		if(position == 0) {
			pointer.xPos = start.getXPos();
			pointer.yPos = start.getYPos();
		} else if(position == 1) {
			pointer.xPos = quit.getXPos();
			pointer.yPos = quit.getYPos();
		}
	}
}