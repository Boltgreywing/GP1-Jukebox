package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NesController implements KeyListener, KeyFinder {

	public boolean[] playerKeys;
	private short player_up, player_left, player_right, player_down;
	private short player_jump, player_attack, player_start, player_select;
	
	public NesController() {
		playerKeys = new boolean[8];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("I am pressed!");
		keyCheck(e, true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyCheck(e, false);
	}
	
	public void setPlayerKeys(String key, String keyCode) {
		short keyValue = findKey(keyCode);
		if(key.equals("UP")) {
			player_up = keyValue;
		} else if(key.equals("LEFT")) {
			player_left = keyValue;
		} else if(key.equals("RIGHT")) {
			player_right = keyValue;
		} else if(key.equals("DOWN")) {
			player_down = keyValue;
		} else if(key.equals("JUMP")) {
			player_jump = keyValue;
		} else if(key.equals("ATTACK")) {
			player_attack = keyValue;
		} else if(key.equals("START")) {
			player_start = keyValue;
		} else if(key.equals("SELECT")) {
			player_select = keyValue;
		}
	}
	
	private void keyCheck(KeyEvent e, boolean keyValue) {
		if(e.getKeyCode() == player_up) {
			playerKeys[0] = keyValue;
		}
				
		if(e.getKeyCode() == player_left) {
			playerKeys[1] = keyValue;
		}
		
		if(e.getKeyCode() == player_right) {
			playerKeys[2] = keyValue;
		}
		
		if(e.getKeyCode() == player_down) {
			playerKeys[3] = keyValue;
		}
		if(e.getKeyCode() == player_jump) {
			playerKeys[4] = keyValue;
		}
		
		if(e.getKeyCode() == player_attack) {
			playerKeys[5] = keyValue;
		}
		
		if(e.getKeyCode() == player_start) {
			playerKeys[6] = keyValue;
		}
		
		if(e.getKeyCode() == player_select) {
			playerKeys[7] = keyValue;
		}
	}
}