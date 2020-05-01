package Maestus.PocMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

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
	// private Grid grid;

	public PocMan() {
		display = new DrawCanvas();

		Board board = new Board();
		user = new Entity();
		
		int n = 40;
		ghosts = new Ghost[n];
		
		for (int i = 0; i < n; i++) {
			ghosts[i] = new Ghost(180, 180, 3, user);
			display.addEntity(ghosts[i]);
		}
		
		display.addEntity(user);
		board.initBoard();
		
		setSize(800,600);
		setLocationRelativeTo(null);


		addKeyListener(InputManager.newController(user));
		setFocusable(true);
		add(display);
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
		;
	}
	
    private void initUI() {
        //setResizable(false);
        pack();

        setSize(800, 600);
        setTitle("Poc Man");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}