//package Maestus.PocMan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An application that will hopefully play Poc Man
 * 
 * @author Oracle
 *
 */
public class PocMan extends JFrame implements IApplication {

	private Entity user;
	private Entity[] ghosts;
	private Timer timer;
	private final DrawCanvas display;
	private ScoreBoard scoreBoard;
	private JPanel gameContainer;
	// private Grid grid;

	public PocMan() {
		gameContainer = new JPanel();
		scoreBoard = new ScoreBoard();
		display = new DrawCanvas();
		
		gameContainer.setBackground(Color.black);
		gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
		gameContainer.add(scoreBoard);
		gameContainer.add(display);
		
		Board board = new Board();
		user = new Player(500, 500, 3);
		
		int n = 0;
		ghosts = new Ghost[n];
		
		for (int i = 0; i < n; i++) {
			ghosts[i] = new Ghost(180, 180, 3, user);
			display.addEntity(ghosts[i]);
		}
		
		display.addEntity(user);
		board.initBoard();
				
		addKeyListener(InputManager.newController(user));
		setFocusable(true);
		add(gameContainer);
		initUI();
		repaint();
	}
	
	@Override
	public void nextFrame() {
		user.move();
		
		for (Entity g : ghosts) {
			g.move();
		}
		repaint();
	}
	
	@Override
	public void updateUI() {
		//ScoreBoard.repaint();
	}
	
    private void initUI() {
        //setResizable(false);
        pack();

        setSize(900, 900);
        setTitle("Poc Man");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}