import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles pausing the game
 * @author Oracle
 *
 */
public class PauseManager {
	
	private static PauseManager single_instance = null;
	
	private PauseManager() {
	}

	/**
	 * Static method to create instance of Singleton class 
	 * @return
	 */
	public static PauseManager getInstance() {
		if (single_instance == null)
			single_instance = new PauseManager();
		
		return single_instance;
	}
	
	/**
	 * Binds the keyboard keys P
	 * Input will pause the <code>IApplication</code> class
	 * @param <code>IApplication</code>
	 * @return <code>KeyAdapter</code>
	 */
	static KeyAdapter newPauseController(IApplication p) {
		
		return new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {

				boolean[] keys = new boolean[KeyEvent.KEY_TYPED];
				keys[arg0.getKeyCode()] = true;

				// For now, we will set the direction
				// In the future, we will buffer the action by using a setter method
				if(keys[KeyEvent.VK_P])
				{
					p.togglePause();
				}
			}
		};
	}
}
