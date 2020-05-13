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
 * @author Oracle, Vincent Ndokaj
 *
 */
public final class PocMan extends JFrame implements IApplication {

	private static final long serialVersionUID = 1;
	private Entity user;
	private Entity[] ghosts;
	private final DrawCanvas display;
	private TopPanel topPanel;
	private JPanel gameContainer;
	private BottomPanel bottomPanel;
	private GameManager gameState;
	private boolean isPaused = true;

	/**
	 * Starts constructing game assets
	 */
	public PocMan() {
		gameContainer = new JPanel();
		topPanel = new TopPanel();
		bottomPanel = new BottomPanel();
		display = DrawCanvas.getInstance();
		gameState = GameManager.getInstance();
		GameManager.bind(this);
		
		
		gameContainer.setBackground(Color.black);
		gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
		gameContainer.add(topPanel);
		gameContainer.add(display);
		gameContainer.add(bottomPanel);
		
		user = new Player(Board.BOARD_PIECE_SIZE*11, Board.BOARD_PIECE_SIZE*12, 4);
		
		int n = 1;
		ghosts = new Ghost[n];
		
		for (int i = 0; i < n; i++) {
			ghosts[i] = new Ghost(Board.BOARD_PIECE_SIZE*5, Board.BOARD_PIECE_SIZE*6, 3, user);
			DrawCanvas.addEntity(ghosts[i]);
		}
		
		DrawCanvas.addEntity(user);
		Board.initBoard();
				
		addKeyListener(InputManager.newController(user));
		addKeyListener(PauseManager.newPauseController(this));
		
		setFocusable(true);
		add(gameContainer);
		initUI();
		repaint();
		togglePause();
	}
	
	/**
	 * Update frame
	 */
	@Override
	public void nextFrame() {
		if (!isPaused) {
			user.move();
		
			for (Entity g : ghosts) {
				g.move();
			}
		}
		repaint();
	}
	
	/**
	 * Unfixed update
	 */
	@Override
	public void updateUI() {
		//ScoreBoard.repaint();
	}
	
	/**
	 * Toggle pause
	 */
	@Override
	public void togglePause() {
		isPaused = !isPaused;
	}
	
	/**
	 * Initializes the game window
	 */
    private void initUI() {
        //setResizable(false);
        pack();

        setSize(900, 900);
        setTitle("Poc Man");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}