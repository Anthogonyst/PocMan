import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel to display what level you're on via how many fruits there are
 * 
 * @author Vincent Ndokaj
 *
 */
public class LevelPanel extends JPanel {
	private JLabel level;
	private int i = 1;
	
	public LevelPanel() {
		level = new JLabel(Assets.fruits[0]);
		
		add(level);
		
		setBackground(Color.black);
		setMaximumSize(new Dimension(100, 30));
	}
	
	/**
	 * Adds a fruit which signifies adding a level
	 */
	public void addLevel() {
		if(i < Assets.fruits.length) {
			add(Box.createRigidArea(new Dimension(1, 15)));
			add(new JLabel(Assets.fruits[i]));
			i++;
		}
	}
}
