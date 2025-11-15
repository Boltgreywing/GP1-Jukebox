package main;

public class Game {
	
	GamePanel gamePanel = new GamePanel();
	
	public static void main(String[] args) {
		boolean running = true;
		Game game = new Game();
		game.gamePanel.init();
		game.gamePanel.buildWindow();
		
		double updateCycle = 1000000000 / GameSettings.updateLimit;
		double renderCycle = 1000000000 / GameSettings.renderLimit;
		long updateTime = System.nanoTime();
		long renderTime = System.nanoTime();
		
		long displayTime = System.currentTimeMillis();
		int fps = 0;
		short ups = 0;
		byte sleepCounter = 0;
		
		while(running) {
			long now = System.nanoTime();
			if(now - updateTime >= updateCycle) {
				game.updateGame();
				updateTime = now;
				ups++;
			}
			
			if(now - renderTime >= renderCycle) {
				game.renderGame();
				renderTime = now;
				fps++;
			}
			
			if(System.currentTimeMillis() - displayTime >= GameSettings.displayCycle) {
				displayTime = System.currentTimeMillis();
				System.out.println("UPS: " + ups + " FPS: " + fps);
				ups = 0;
				fps = 0;
				sleepCounter++;
			}
			
			if(game.gamePanel.exitApplication) {
				running = false;
				game.gamePanel = null;
				game = null;
				System.out.println("--------------------------");
				System.out.println("Exiting Application!");
				System.out.println("Freeing up Resources!");
				System.out.println("See you next time!");
			}
			
			if(sleepCounter > 5) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sleepCounter = 0;
			}
		}
	}
	
	private void updateGame() {
		//System.out.println("I am updating!");
		gamePanel.update();
	}
	
	private void renderGame() {
		//System.out.println("I am rendering pixels!");
		gamePanel.repaint();
	}
}