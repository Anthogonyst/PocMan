import java.io.Serializable;

/**
 * Manages the state of the game
 * 
 * @author Oracle
 *
 */
public class GameManager implements Serializable {
	
	static long gameVersion = 2;
	private static final long serialVersionUID = gameVersion;
	private static PocMan app;
	private static GameManager single_instance = null;
	private static int totalPellets;
	private static int remainingPellets;
	private static Integer highscore = 0;
	
	private GameManager() {
		totalPellets = 0;
		remainingPellets = 0;
	}

	/**
	 * Static method to create instance of <code>GameManager</code> class 
	 * @return
	 */
	static GameManager getInstance() {
		if (single_instance == null)
			single_instance = new GameManager();
		
		return single_instance;
	}
	
	/**
	 * Binds notifications to the application
	 * @param <code>PocMan</code>
	 */
	static void bind(PocMan _app) {
		app = _app;
	}

	/**
	 * Receive a message about pellet gain
	 */
	static void notifyPelletGain() {
		remainingPellets++;
		
		if (remainingPellets > totalPellets)
			totalPellets = remainingPellets;
	}
	
	/**
	 * Receive a message about pellet loss
	 */
	static void notifyPelletLoss() {
		remainingPellets--;
		
		if (remainingPellets <= 0)
			newLevel();
	}
	
	/**
	 * Receive a message about board state
	 */
	static void notifyInitDone() {
		
	}
	
	/**
	 * Initialize a new level
	 */
	static void newLevel() {
		app.togglePause();
	}
	
}
