import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Container class to display and keep track of the high score
 * 
 * @author Vincent Ndokaj
 *
 */
public class HighScore extends JPanel {
	public static Integer highScore = 3333360; //temporary high score, will most likely be read from file
	private static JLabel scoreText;
	private static JLabel text;
	private Dimension dim = new Dimension(Board.BOARD_WIDTH/3,30);
	
	public HighScore() {
		text = new JLabel("High Score", JLabel.CENTER);
		text.setMaximumSize(dim);
		scoreText = new JLabel(highScore.toString(), JLabel.CENTER); //parse file for high score and add to JLabel
		scoreText.setMaximumSize(dim);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setFont();
		
		add(text, BorderLayout.CENTER);
		add(scoreText, BorderLayout.CENTER);
		
		setAlignmentX(CENTER_ALIGNMENT);
		
		setBackground(Color.black);
		setMaximumSize(new Dimension(Board.BOARD_WIDTH/3, 60));
	}
	
	/**
	 * Sets font for labels within the HighScore class 
	 */
	private void setFont() {
		Font f = new Font("Serif", Font.BOLD, 30);
		scoreText.setFont(f);
		scoreText.setForeground(Color.white);
		text.setFont(f);
		text.setForeground(Color.white);
	}
	
	/**
	 * Updates high score with score if new high score is reached.
	 * 
	 * @param s integer that is the new high score
	 */
	public static void updateHighScore(int s) {
		highScore = s;
		scoreText.setText(highScore.toString());
		//write the new high score to file
	}
}
