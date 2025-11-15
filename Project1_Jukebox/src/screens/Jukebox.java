package screens;

import java.awt.Color;
import java.awt.Graphics;
import helpers.AudioPlayer;
import helpers.WordReader;
import main.GamePanel;
import sprites.DiskJockey;
import sprites.MusicalNote;
import sprites.Pointer;
import sprites.RecordPlayer;

public class Jukebox extends Screen {

	//Variables for the jukebox
	private AudioPlayer audio;
	private byte position;
	
	//Variables for the menu
	private short lockTimeout;
	private boolean lockSet;
	private short songId = 0;
	
	private WordReader title, track, song;
	private WordReader prev, next, quit;
	private WordReader curSong;
	private Pointer pointer;
	private MusicalNote note, note2, note3, note4;
	private RecordPlayer player;
	private DiskJockey dj;
	private int width, height;
	
	public Jukebox() {
		super("TitleScreen");
		audio = new AudioPlayer("/songlist/Jukebox.txt");
		lockSet = false;
	}
	
	public void setPanel(GamePanel panel) {
		//this.panel = panel;
		width = panel.getPanelWidth();
		height = panel.getPanelHeight();
		title = new WordReader("Jukebox", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 20, true);
		track = new WordReader("Play Track", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 66, true);
		song = new WordReader("Play Song", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 112, true);
		curSong = new WordReader("[0]", (short) (panel.getPanelWidth() - 205), (short) song.getYPos());
		prev = new WordReader("Prev Song", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 158, true);
		next = new WordReader("Next Song", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 204, true);
		quit = new WordReader("Quit", (short) panel.getPanelWidth(), (short) 26, (short) -1, (short) 250, true);
		pointer = new Pointer((short) track.getXPos(), (short) 66);
		note = new MusicalNote((short) 30, (short) (66));
		note2 = new MusicalNote((short) 70, (short) 88);
		note3 = new MusicalNote((short) (panel.getPanelWidth() - 100), (short) 66);
		note4 = new MusicalNote((short) (panel.getPanelWidth() - 60), (short) 88);
		player = new RecordPlayer((short) 30, (short) (panel.getPanelHeight() - 120));
		dj = new DiskJockey((short) (panel.getPanelWidth() - 110), (short) (panel.getPanelHeight() - 110));
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
			} else if(getKeyboard().playerKeys[3] && position < 4) {
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
				//Plays the entire track
				audio.playTunes();
			} else if(position == 1) {
				//Plays an individual song
				audio.stopMusic();
				audio.playSong(songId);
			} else if(position == 2) {
				if(!lockSet) {
					//Jumps back to the previous song
					if(songId > 0) {
						songId--;
					}
					
					curSong.setSong("" + songId);
					lockSet = true;
					lockTimeout = 8;
				}
			} else if(position == 3) {
				if(!lockSet) {
					//Jumps to the next song in the list
					if(songId < audio.getTrackSize() - 1) {
						songId++;
					}
					
					curSong.setSong("" + songId);
					lockSet = true;
					lockTimeout = 8;
				}
			} else if(position == 4) {
				//Exits the application
				setEndgame(true);
				setNextScreen("");
				cleanup();
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		if(!exitScreen()) {
			title.render(g);
			track.render(g);
			song.render(g);
			curSong.render(g);
			prev.render(g);
			next.render(g);
			quit.render(g);
			note.render(g);
			note2.render(g);
			note3.render(g);
			note4.render(g);
			player.render(g);
			dj.render(g);
			pointer.render(g);
		}
	}
	
	private void cleanup() {
		if(audio != null) {
			audio.stopMusic();			
			audio = null;
		}
		
		//Clear all the objects
		title = null;
		track = null;
		song = null;
		curSong = null;
		prev = null;
		next = null;
		quit = null;
		note = null;
		note2 = null;
		note3 = null;
		note4 = null;
		player = null;
		dj = null;
		pointer = null;
	}
	
	private void moveCursor() {
		if(position == 0) {
			pointer.xPos = track.getXPos();
			pointer.yPos = track.getYPos();
		} else if(position == 1) {
			pointer.xPos = song.getXPos();
			pointer.yPos = song.getYPos();
		} else if(position == 2) {
			pointer.xPos = prev.getXPos();
			pointer.yPos = prev.getYPos();
		} else if(position == 3) {
			pointer.xPos = next.getXPos();
			pointer.yPos = next.getYPos();
		} else if(position == 4) {
			pointer.xPos = quit.getXPos();
			pointer.yPos = quit.getYPos();
		}
	}
}