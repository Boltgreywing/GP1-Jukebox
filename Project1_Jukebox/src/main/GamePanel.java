package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import screens.Jukebox;
import screens.Screen;
import screens.TitleScreen;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 2412263606636090867L;
	private JFrame jframe;
	private int width, height;
	private float scale;
	public short scaledTileSize;
	private Screen cur;
	public boolean exitApplication = false;
	
	void init() {
		//Initializes the settings
		scale = 2.0f;
		scaledTileSize = (short) (TileSettings.tileSize * scale);
		int tiledWidth = (int) (TileSettings.tileSize * TileSettings.horizontalTiles);
		int tiledHeight = (int) (TileSettings.tileSize * TileSettings.verticalTiles);
		width = tiledWidth;
		height = tiledHeight;
		
		//Builds the current screen
		cur = new TitleScreen();
		cur.setPanel(this);
		cur.cartKeyboard(this);
		setFocusable(true);
	}
	
	void buildWindow() {
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		float scaledWidth = width * scale;
		float scaledHeight = height * scale;
		Dimension size = new Dimension((int) scaledWidth, (int) scaledHeight);
		setPreferredSize(size);
		
		jframe.add(this);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	
	public void update() {
		boolean exitGame = (cur != null && cur.exitScreen());
		if(exitGame && cur.getNextScreen() != null) {
			switchGame();
		} else if(exitGame) {
			cur = null;
			exitApplication = true;
			jframe.setVisible(false);
			jframe.dispose();
			jframe = null;
		}
		
		if(cur != null) {
			cur.update();
		}
	}
	
	private void switchGame() {
		if(cur.getNextScreen() == "") {
			System.out.println("Switching to TitleScreen");
			cur = new TitleScreen();
			cur.setPanel(this);
			cur.cartKeyboard(this);
		} else if(cur.getNextScreen() == "Jukebox") {
			System.out.println("Switching to Jukebox");
			cur = new Jukebox();
			cur.setPanel(this);
			cur.cartKeyboard(this);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(cur != null) {
			cur.draw(g);
		}
	}
	
	public int getPanelWidth() {
		return (int) (width * scale);
	}
	
	public int getPanelHeight() {
		return (int) (height * scale);
	}
}