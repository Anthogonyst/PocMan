import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * Class that instantiates a scoreboard for PocMan and supports
 * updating score with a method call.
 *
 */
public class ScoreBoard extends JPanel {
	private Integer score = 0;
	private JLabel text; 
	private JLabel scoreText;
	
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
	 * @param s amount of points to be added to the scoreboard
	 */
	public void addScore(int s) {
		score += s;
		scoreText.setText(score.toString());
	}
	
	private void setFont() {
		Font f = new Font("Serif", Font.BOLD, 30);
		text.setFont(f);
		scoreText.setFont(f);
		text.setForeground(Color.white);
		scoreText.setForeground(Color.white);
	}
}