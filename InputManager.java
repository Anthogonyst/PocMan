//package Maestus.PocMan;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles all of the keyboard inputs to play the game
 * @author Oracle
 *
 */
public class InputManager {

	static KeyAdapter newController(Entity e) {
		
		return new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {

				boolean[] keys = new boolean[KeyEvent.KEY_TYPED];
				keys[arg0.getKeyCode()] = true;

				// For now, we will set the direction
				// In the future, we will buffer the action by using a setter method
				if(keys[KeyEvent.VK_UP])
				{
					e.facing = Direction.UP;
				}
				if(keys[KeyEvent.VK_DOWN])
				{
					e.facing = Direction.DOWN;
				}
				if(keys[KeyEvent.VK_LEFT])
				{
					e.facing = Direction.LEFT;
				}
				if(keys[KeyEvent.VK_RIGHT])
				{
					e.facing = Direction.RIGHT;
				}

			}
		};
	}
}
