package helpers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class WordReader {
	
	private String myLetters;
	private int xPos, yPos;
	private BufferedImage atlas;
	private int letterSize;
	
	public WordReader(String letters, short screenWidth, short letterWidth, short spawnX, short spawnY, boolean center) {
		int spaceCount = 0;
		for(int i = 0; i < letters.length(); i++) {
			char letter = letters.charAt(i);
			if(letter == ' ') {
				spaceCount++;
			}
		}
		
		int letterCount = letters.length() - spaceCount;
		
		float centerX = screenWidth / 2 - (letterWidth * (letterCount / 2));
		letterSize = letterWidth;
		myLetters = letters;
		xPos = spawnX;
		yPos = spawnY;
		if(center) {
			xPos = (int) centerX;
		}
		atlas = LoadSave.GetSpriteAtlas("sprites/WordTilesheet26pixels", ".png");
	}
	
	public WordReader(String letters, short spawnX, short spawnY) {
		myLetters = letters;
		xPos = spawnX;
		yPos = spawnY;
		atlas = LoadSave.GetSpriteAtlas("sprites/WordTilesheet26pixels", ".png");
		//convertTextToSprite(letters);
	}
	
	public void render(Graphics g) {
		boolean moved = false;
		for(int i = 0; i < myLetters.length(); i++) {
			char curLetter = myLetters.charAt(i);
			int[] spriteCords = letterFinder(curLetter);
			int currentX = xPos + 26 * i;
			
			if(i - 1 >= 0 && letterFinder(myLetters.charAt(i - 1))[0] == 0 && letterFinder(myLetters.charAt(i - 1))[1] == 0) {
				currentX = xPos + 26 * (i - 1) + 5;
				moved = true;
			}
			
			if(spriteCords[0] != 0 || spriteCords[1] != 0) {
				//int
				//int[] pastCords = letterFinder(myLetters.charAt(i - 1));
				//if(pastCords != null && pastCords[0] == 0 && pastCords[1] == 0) {
					//currentX = xPos
				//}
				if(moved) {
					currentX = xPos + 26 * (i - 1) + 5;
				}
				
				g.drawImage(grabSprite(spriteCords[0], spriteCords[1], 8, 8), currentX, yPos, 26, 26, null);
			}
		}
	}
	
	BufferedImage grabSprite(int xCord, int yCord, int xLimit, int yLimit) {
		//int xLimit = atlas.getWidth() / width;
		//int yLimit = atlas.getHeight() / height;
		BufferedImage sprite = null;
		
		//Restricts sprite range
		if(xCord < xLimit && yCord < yLimit) {
			int xPos = xCord * 26;
			int yPos = yCord * 26;
			sprite = atlas.getSubimage(xPos, yPos, 26, 26);
		}
		return sprite;
	}
	
	private int[] letterFinder(char curLetter) {
		int x = 0;
		int y = 0;
		
		if(curLetter == 'A' || curLetter == 'a') {
			x = 1;
		} else if(curLetter == 'B' || curLetter == 'b') {
			x = 2;
		} else if(curLetter == 'C' || curLetter == 'c') {
			x = 3;
		} else if(curLetter == 'D' || curLetter == 'd') {
			x = 4;
		} else if(curLetter == 'E' || curLetter == 'e') {
			x = 5;
		} else if(curLetter == 'F' || curLetter == 'f') {
			x = 6;
		} else if(curLetter == 'G' || curLetter == 'g') {
			x = 7;
		} else if(curLetter == 'H' || curLetter == 'h') {
			x = 0;
			y = 1;
		} else if(curLetter == 'I' || curLetter == 'i') {
			x = 1;
			y = 1;
		} else if(curLetter == 'J' || curLetter == 'j') {
			x = 2;
			y = 1;
		} else if(curLetter == 'K' || curLetter == 'k') {
			x = 3;
			y = 1;
		} else if(curLetter == 'L' || curLetter == 'l') {
			x = 4;
			y = 1;
		} else if(curLetter == 'M' || curLetter == 'm') {
			x = 5;
			y = 1;
		} else if(curLetter == 'N' || curLetter == 'n') {
			x = 6;
			y = 1;
		} else if(curLetter == 'O' || curLetter == 'o') {
			x = 7;
			y = 1;
		} else if(curLetter == 'P' || curLetter == 'p') {
			x = 0;
			y = 2;
		} else if(curLetter == 'Q' || curLetter == 'q') {
			x = 1;
			y = 2;
		} else if(curLetter == 'R' || curLetter == 'r') {
			x = 2;
			y = 2;
		} else if(curLetter == 'S' || curLetter == 's') {
			x = 3;
			y = 2;
		} else if(curLetter == 'T' || curLetter == 't') {
			x = 4;
			y = 2;
		} else if(curLetter == 'U' || curLetter == 'u') {
			x = 5;
			y = 2;
		} else if(curLetter == 'V' || curLetter == 'v') {
			x = 6;
			y = 2;
		} else if(curLetter == 'W' || curLetter == 'w') {
			x = 7;
			y = 2;
		} else if(curLetter == 'X' || curLetter == 'x') {
			x = 0;
			y = 3;
		} else if(curLetter == 'Y' || curLetter == 'y') {
			x = 1;
			y = 3;
		} else if(curLetter == 'Z' || curLetter == 'z') {
			x = 2;
			y = 3;
		} else if(curLetter == '0') {
			x = 3;
			y = 3;
		} else if(curLetter == '1') {
			x = 4;
			y = 3;
		} else if(curLetter == '2') {
			x = 5;
			y = 3;
		} else if(curLetter == '3') {
			x = 6;
			y = 3;
		} else if(curLetter == '4') {
			x = 7;
			y = 3;
		} else if(curLetter == '5') {
			x = 0;
			y = 4;
		} else if(curLetter == '6') {
			x = 1;
			y = 4;
		} else if(curLetter == '7') {
			x = 2;
			y = 4;
		} else if(curLetter == '8') {
			x = 3;
			y = 4;
		} else if(curLetter == '9') {
			x = 4;
			y = 4;
		} else if(curLetter == '[') {
			x = 3;
			y = 5;
		} else if(curLetter == ']') {
			x = 4;
			y = 5;
		}
		
		int[] spriteCords = new int[2];
		spriteCords[0] = x;
		spriteCords[1] = y;
		
		return spriteCords;
	}
	
	public int getXPos() {
		return xPos - letterSize - 2;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public void setSong(String letter) {
		myLetters = "[" + letter + "]";
	}
}