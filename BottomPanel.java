import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Container class to consolidate all panels for the bottom bar before being used
 * in PocMan class
 * 
 * @author Vincent Ndokaj
 *
 */
public class BottomPanel extends JPanel {
	private static LifePanel lp;
	private static LevelPanel level;
	
	public BottomPanel() {
		lp = new LifePanel();
		level = new LevelPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(lp);
		add(Box.createHorizontalGlue());
		add(level);
		
		setBackground(Color.black);
		setMaximumSize(new Dimension(Board.BOARD_WIDTH, 60));
	}
	
	/**
	 * Static function to remove life from LifePanel
	 */
	public static void removeLife() {
		lp.removeLife();
	}
	
	/**
	 * Static function to increment the level, AKA add a fruit
	 */
	public static void addLevel() {
		level.addLevel();
	}
}
