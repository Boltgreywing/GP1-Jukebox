package helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static BufferedImage GetSpriteAtlas(String name, String end) {
		InputStream is = LoadSave.class.getClassLoader().getResourceAsStream(name + end);
		BufferedImage img = null;
		if(is != null) {
			try {
				img = ImageIO.read(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	
	public static int[][] GetMapData(String name, String end) {
		File mapFile = new File("res/map/" + name + ".txt");
		int[][] pointer = null;
		
		if(mapFile.exists()) {
			//Builds the initial array to the file's size
			int arrayLimit = (int) mapFile.length();
			int[] mapArray = new int[arrayLimit];
			try {
				Scanner sc = new Scanner(mapFile);
				int count = 0;
				while(sc.hasNextInt()) {
					mapArray[count] = sc.nextInt();
					count++;
				}
				sc.close();
				
				//Builds the tile array
				int width = mapArray[count - 2];
				int height = mapArray[count - 1];
				System.out.println("My width is: " + width);
				System.out.println("My height is: " + height);
				
				int[][] tempArray = new int[height][width];
				for(int j = 0; j < height; j++) {
					for(int i = 0; i < 26; i++) {
						int index = (j * width) + i;
						System.out.println("Index is: " + index);
						tempArray[j][i] = mapArray[index];
					}
				}
				pointer = tempArray;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Silly bat, the file: " + name + end + " does not exist!");
			System.out.println("Why are you trying to load it, you little goober.");
		}
		return pointer;
	}
	
	public static String[] LoadCampaign(String name) {
		File campaign = new File("res/" + name + ".txt");
		String[] pointer = null;
		if(campaign.exists()) {
			int arrayLimit = (int) campaign.length();
			String[] tempArray = new String[arrayLimit];
			try {
				Scanner sc = new Scanner(campaign);
				int count = 0;
				while(sc.hasNextLine()) {
					tempArray[count] = sc.nextLine();
					count++;
				}
				sc.close();
				
				//Builds the campaign
				String[] campaignArray = new String[count];
				for(int i = 0; i < count; i++) {
					campaignArray[i] = tempArray[i];
				}
				pointer = campaignArray;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Silly bat, the file: " + name + ".txt" + " does not exist!");
			System.out.println("Why are you trying to load it, you little goober.");
		}
		return pointer;
	}
}