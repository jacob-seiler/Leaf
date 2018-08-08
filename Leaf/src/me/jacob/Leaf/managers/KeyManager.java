package me.jacob.Leaf.managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys = new boolean[65535];
    private boolean[] keysReturned = new boolean[65535];

    @Override
    public void keyPressed(KeyEvent e) {
	keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
	keys[e.getKeyCode()] = false;
	keysReturned[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean isKeyPressed(int keyCode) {
	return keys[keyCode];
    }

    public boolean isKeyPressedOnce(int keyCode) {
	if (!keys[keyCode])
	    return false;
	if (keysReturned[keyCode])
	    return false;

	keysReturned[keyCode] = true;
	return true;
    }

}
