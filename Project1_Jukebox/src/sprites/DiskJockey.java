package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;

public class DiskJockey {
	
	private int xPos, yPos;
	private BufferedImage atlas;
	
	public DiskJockey(short spawnX, short spawnY) {
		xPos = spawnX;
		yPos = spawnY;
		atlas = LoadSave.GetSpriteAtlas("sprites/CharacterSprites", ".png");
	}
	
	public void render(Graphics g) {
		g.drawImage(atlas.getSubimage(0, 0, 46, 46), xPos, yPos, 82, 82, null);
	}
}
