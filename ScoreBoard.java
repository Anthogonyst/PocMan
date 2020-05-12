import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * Class that instantiates a scoreboard for PocMan and supports
 * updating score with a method call.
 * @author Vincent Ndokaj
 *
 */
public class ScoreBoard extends JPanel {
	private static Integer score = 0;
	private static JLabel text; 
	private static JLabel scoreText;
	
	public ScoreBoard() {
		text = new JLabel("Score: ");
		scoreText = new JLabel(score.toString());
		
		setFont();
		
		add(text);
		add(scoreText);
		
		setBackground(Color.blue);
		setMaximumSize(new Dimension(900, 40));
	}
	
	/**
	 * Adds an int value to the score and updates the label holding
	 * the current score
	 * 
	 * @param s amount of points to be added to the ScoreBoard
	 */
	static void addScore(int s) {
		score = s;
		scoreText.setText(score.toString());
	}
	
	/**
	 * Sets font for labels within the ScoreBoard class 
	 */
	private void setFont() {
		Font f = new Font("Serif", Font.BOLD, 30);
		text.setFont(f);
		scoreText.setFont(f);
		text.setForeground(Color.white);
		scoreText.setForeground(Color.white);
	}
}