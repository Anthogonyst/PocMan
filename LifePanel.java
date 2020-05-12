import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel to display amount of lives remaining in game.
 * 
 * @author Vincent Ndokaj
 *
 */
public class LifePanel extends JPanel {
	private Dimension dim = new Dimension(27, 30);
	private static JLabel life, life2;
	private static boolean first = true;
	
	public LifePanel(){		
		life = new JLabel(Assets.medPocMan2);
		life2 = new JLabel(Assets.medPocMan2);
		life.setMaximumSize(dim);
		life2.setMaximumSize(dim);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(life);
		add(Box.createRigidArea(new Dimension(6, 30)));
		add(life2);
		
		setBackground(Color.black);
		setMaximumSize(new Dimension(70, 30));
	}
	
	/**
	 * Removes life from JPanel
	 */
	public void removeLife() {
		if(first) {
			remove(life2);
			first = false;
		}
		else
			remove(life);
	}
}
