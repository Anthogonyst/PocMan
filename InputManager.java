//package Maestus.PocMan;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles all of the keyboard inputs to play the game
 * @author Oracle
 *
 */
public class InputManager {
	
	private static InputManager single_instance = null;
	
	private InputManager() {
	}

	/**
	 * Static method to create instance of <code>InputManager</code> class 
	 * @return instance
	 */
	public static InputManager getInstance() {
		if (single_instance == null)
			single_instance = new InputManager();
		
		return single_instance;
	}
	
	/**
	 * Binds the keyboard keys UP, DOWN, LEFT, RIGHT
	 * Inputs will buffer an input on an <code>Entity</code> such as <code>Player</code> class
	 * @param <code>Entity</code>
	 * @return <code>KeyAdapter</code>
	 */
	static KeyAdapter newController(Entity e) {
		
		return new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {

				boolean[] keys = new boolean[KeyEvent.KEY_TYPED];
				keys[arg0.getKeyCode()] = true;

				// For now, we will set the direction
				// In the future, we will buffer the action by using a setter method
				if(keys[KeyEvent.VK_UP])
				{
					e.bufferDirection(Direction.UP);
				}
				if(keys[KeyEvent.VK_DOWN])
				{
					e.bufferDirection(Direction.DOWN);
				}
				if(keys[KeyEvent.VK_LEFT])
				{
					e.bufferDirection(Direction.LEFT);
				}
				if(keys[KeyEvent.VK_RIGHT])
				{
					e.bufferDirection(Direction.RIGHT);
				}

			}
		};
	}
}
