package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;

public class RecordPlayer {
	
	private int xPos, yPos;
	private BufferedImage atlas;
	
	public RecordPlayer(short spawnX, short spawnY) {
		xPos = spawnX;
		yPos = spawnY;
		atlas = LoadSave.GetSpriteAtlas("sprites/Jukebox", ".png");
	}
	
	public void render(Graphics g) {
		g.drawImage(atlas.getSubimage(0, 0, 36, 36), xPos, yPos, 86, 86, null);
	}
}