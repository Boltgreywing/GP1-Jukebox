package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;

public class MusicalNote {
	
	private int xPos, yPos;
	private BufferedImage atlas;
	
	public MusicalNote(short spawnX, short spawnY) {
		xPos = spawnX;
		yPos = spawnY;
		atlas = LoadSave.GetSpriteAtlas("sprites/MusicalNote", ".png");
	}
	
	public void render(Graphics g) {
		g.drawImage(atlas.getSubimage(0, 0, 16, 16), xPos, yPos, 36, 36, null);
	}
}