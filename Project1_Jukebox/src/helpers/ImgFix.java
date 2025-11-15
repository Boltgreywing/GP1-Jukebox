package helpers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImgFix {
	public static BufferedImage getRotateImage(BufferedImage img, int rotationAngle) {
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage newImg = new BufferedImage(w, h, img.getType());
		Graphics2D g2d = newImg.createGraphics();
		
		g2d.rotate(Math.toRadians(rotationAngle), w / 2, h / 2);
		g2d.drawImage(img, 0, 0, null);
		g2d.dispose();
		
		return newImg;
	}
	
	public static BufferedImage buildImg(BufferedImage[] imgs) {
		int w = imgs[0].getWidth();
		int h = imgs[0].getHeight();
		
		BufferedImage newImg = new BufferedImage(w, h, imgs[0].getType());
		Graphics2D g2d = newImg.createGraphics();
		
		for(BufferedImage img : imgs) {
			g2d.drawImage(img, 0, 0, null);
		}
		
		g2d.dispose();
		return newImg;
	}
	
	public static BufferedImage buildRotateImg(BufferedImage[] imgs, int rotationAngle, int rotationAtIndex) {
		int w = imgs[0].getWidth();
		int h = imgs[0].getHeight();
		
		BufferedImage newImg = new BufferedImage(w, h, imgs[0].getType());
		Graphics2D g2d = newImg.createGraphics();
		
		for(int i = 0; i < imgs.length; i++) {
			if(rotationAtIndex == i) {
				g2d.rotate(Math.toRadians(rotationAngle), w / 2, h / 2);
			}
			g2d.drawImage(imgs[i], 0, 0, null);
			if(rotationAtIndex == i) {
				g2d.rotate(Math.toRadians(-rotationAngle), w / 2, h / 2);
			}
		}
		
		g2d.dispose();
		return newImg;
	}
	
	public static BufferedImage[] buildRotateAnimatedImg(BufferedImage[] imgs, BufferedImage secondImage, int rotationAngle) {
		int w = imgs[0].getWidth();
		int h = imgs[0].getHeight();
		
		BufferedImage[] arr = new BufferedImage[imgs.length];
		
		for(int i = 0; i < imgs.length; i++) {
			BufferedImage newImg = new BufferedImage(w, h, imgs[0].getType());
			Graphics2D g2d = newImg.createGraphics();
			
			g2d.drawImage(imgs[i], 0, 0, null);
			g2d.rotate(Math.toRadians(rotationAngle), w / 2, h / 2);
			g2d.drawImage(secondImage, 0, 0, null);
			g2d.dispose();
			
			arr[i] = newImg;
		}
		return arr;
	}
}