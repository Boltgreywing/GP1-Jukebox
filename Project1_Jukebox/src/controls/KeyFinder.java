package controls;

import java.awt.event.KeyEvent;

public interface KeyFinder {
	
	 default short findKey(String key) {
		short keyCode = -1;
		if(key.equals("UP")) {
			keyCode = KeyEvent.VK_UP;
		} else if(key.equals("LEFT")) {
			keyCode = KeyEvent.VK_LEFT;
		} else if(key.equals("RIGHT")) {
			keyCode = KeyEvent.VK_RIGHT;
		} else if(key.equals("DOWN")) {
			keyCode = KeyEvent.VK_DOWN;
		} else if(key.equals("A")) {
			keyCode = KeyEvent.VK_A;
		} else if(key.equals("B")) {
			keyCode = KeyEvent.VK_B;
		} else if(key.equals("C")) {
			keyCode = KeyEvent.VK_C;
		} else if(key.equals("D")) {
			keyCode = KeyEvent.VK_D;
		} else if(key.equals("E")) {
			keyCode = KeyEvent.VK_E;
		} else if(key.equals("F")) {
			keyCode = KeyEvent.VK_F;
		} else if(key.equals("G")) {
			keyCode = KeyEvent.VK_G;
		} else if(key.equals("H")) {
			keyCode = KeyEvent.VK_H;
		} else if(key.equals("I")) {
			keyCode = KeyEvent.VK_I;
		} else if(key.equals("J")) {
			keyCode = KeyEvent.VK_J;
		} else if(key.equals("K")) {
			keyCode = KeyEvent.VK_K;
		} else if(key.equals("L")) {
			keyCode = KeyEvent.VK_L;
		} else if(key.equals("M")) {
			keyCode = KeyEvent.VK_M;
		} else if(key.equals("N")) {
			keyCode = KeyEvent.VK_N;
		} else if(key.equals("O")) {
			keyCode = KeyEvent.VK_O;
		} else if(key.equals("P")) {
			keyCode = KeyEvent.VK_P;
		} else if(key.equals("Q")) {
			keyCode = KeyEvent.VK_Q;
		} else if(key.equals("R")) {
			keyCode = KeyEvent.VK_R;
		} else if(key.equals("S")) {
			keyCode = KeyEvent.VK_S;
		} else if(key.equals("T")) {
			keyCode = KeyEvent.VK_T;
		} else if(key.equals("U")) {
			keyCode = KeyEvent.VK_U;
		} else if(key.equals("V")) {
			keyCode = KeyEvent.VK_V;
		} else if(key.equals("W")) {
			keyCode = KeyEvent.VK_W;
		} else if(key.equals("X")) {
			keyCode = KeyEvent.VK_X;
		} else if(key.equals("Y")) {
			keyCode = KeyEvent.VK_Y;
		} else if(key.equals("Z")) {
			keyCode = KeyEvent.VK_Z;
		} else if(key.equals("0")) {
			keyCode = KeyEvent.VK_0;
		} else if(key.equals("1")) {
			keyCode = KeyEvent.VK_1;
		} else if(key.equals("2")) {
			keyCode = KeyEvent.VK_2;
		} else if(key.equals("3")) {
			keyCode = KeyEvent.VK_3;
		} else if(key.equals("4")) {
			keyCode = KeyEvent.VK_4;
		} else if(key.equals("5")) {
			keyCode = KeyEvent.VK_5;
		} else if(key.equals("6")) {
			keyCode = KeyEvent.VK_6;
		} else if(key.equals("7")) {
			keyCode = KeyEvent.VK_7;
		} else if(key.equals("8")) {
			keyCode = KeyEvent.VK_8;
		} else if(key.equals("9")) {
			keyCode = KeyEvent.VK_9;
		} else if(key.equals("SPACEBAR")) {
			keyCode = KeyEvent.VK_SPACE;
		}
		
		return keyCode;
	}
}