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
		ghosts = new Entity[4];
		
		for (int i = 0; i < 4; i++) {
			ghosts[i] = new Entity();
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