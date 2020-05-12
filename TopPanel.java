import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Container class to consolidate all panels for the top bar before being used
 * in PocMan class
 * 
 * @author Vincent Ndokaj
 *
 */
public class TopPanel extends JPanel {
	public ScoreBoard sb;
	public HighScore hs;
	
	public TopPanel() {
		sb = new ScoreBoard();
		hs = new HighScore();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(sb);
		add(hs);
		//add(Box.createRigidArea(new Dimension(300, 60)));
		
		setBackground(Color.black);
		setMaximumSize(new Dimension(900, 60));
	}
}
