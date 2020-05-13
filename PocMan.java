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
public class PocMan extends JFrame implements IApplication {

	private Entity user;
	private Entity[] ghosts;
	private Timer timer;
	private final DrawCanvas display;
	private TopPanel topPanel;
	private JPanel gameContainer;
	private BottomPanel bottomPanel;
	// private Grid grid;
	private boolean isPaused = true;

	public PocMan() {
		gameContainer = new JPanel();
		topPanel = new TopPanel();
		display = new DrawCanvas();
		bottomPanel = new BottomPanel();
		
		gameContainer.setBackground(Color.black);
		gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
		gameContainer.add(topPanel);
		gameContainer.add(display);
		gameContainer.add(bottomPanel);
		
		Board board = new Board();
		user = new Player(520, 500, 4);
		
		int n = 4;
		ghosts = new Ghost[n];
		
		for (int i = 0; i < n; i++) {
			ghosts[i] = new Ghost(180, 155, 3, user);
			display.addEntity(ghosts[i]);
		}
		
		display.addEntity(user);
		board.initBoard();
				
		addKeyListener(InputManager.newController(user));
		addKeyListener(PauseManager.newPauseController(this));
		
		setFocusable(true);
		add(gameContainer);
		initUI();
		repaint();
		togglePause();
	}
	
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
	
	@Override
	public void updateUI() {
		//ScoreBoard.repaint();
	}
	
	@Override
	public void togglePause() {
		isPaused = !isPaused;
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