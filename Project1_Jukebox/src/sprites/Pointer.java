package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;

public class Pointer {
	
	public int xPos, yPos;
	private BufferedImage atlas;
	
	public Pointer(short spawnX, short spawnY) {
		xPos = spawnX;
		yPos = spawnY;
		atlas = LoadSave.GetSpriteAtlas("sprites/Pointer", ".png");
	}
	
	public void render(Graphics g) {
		g.drawImage(atlas.getSubimage(0, 0, 16, 16), xPos, yPos, 26, 26, null);
	}
}