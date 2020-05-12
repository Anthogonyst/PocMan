import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * Class that instantiates a ScoreBoard for PocMan and supports
 * updating score with a method call.
 * @author Vincent Ndokaj
 *
 */
public class ScoreBoard extends JPanel {
	private static Integer score = 0, level = 1; //prefer to get level from somewhere else
	private static JLabel scoreText;
	private static JLabel oneUP;
	private Dimension dim = new Dimension(Board.BOARD_WIDTH/3,30);
	
	public ScoreBoard() {
		scoreText = new JLabel(score.toString(), JLabel.CENTER);
		scoreText.setMaximumSize(dim);
		oneUP = new JLabel((level.toString() + "UP"), JLabel.CENTER);
		oneUP.setMaximumSize(dim);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setFont();
		
		add(oneUP);
		add(scoreText);
		
		setAlignmentX(CENTER_ALIGNMENT);
		
		setBackground(Color.black);
		setMaximumSize(new Dimension(Board.BOARD_WIDTH/3, 60));
	}
	
	/**
	 * Adds an int value to the score and updates the label holding
	 * the current score. If higher than highScore also updates highScore
	 * 
	 * @param s amount of points to be added to the ScoreBoard
	 */
	public static void addScore(int s) {
		score = s;
		scoreText.setText(score.toString());
		if(score > HighScore.highScore) {
			HighScore.updateHighScore(score);
		}
	}
	
	/**
	 * Sets font for labels within the ScoreBoard class 
	 */
	private void setFont() {
		Font f = new Font("Serif", Font.BOLD, 30);
		oneUP.setFont(f);
		oneUP.setForeground(Color.white);
		scoreText.setFont(f);
		scoreText.setForeground(Color.white);
	}
}