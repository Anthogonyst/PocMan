import java.awt.Color;
import java.awt.Dimension;

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
	
	public BottomPanel() {
		lp = new LifePanel();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(lp);
		
		setBackground(Color.black);
		setMaximumSize(new Dimension(Board.BOARD_WIDTH, 60));
	}
	
	/**
	 * Static function to remove life from LifePanel
	 */
	public static void removeLife() {
		lp.removeLife();
	}
}
