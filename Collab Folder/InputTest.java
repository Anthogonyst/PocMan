package Maestus.PocMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class InputTest extends JFrame {

	Entity user;
	Entity[] ghosts;
	Timer timer;

	public InputTest() {
		user = new Entity();
		ghosts = new Entity[4];
		
		for (int i = 0; i < 4; i++) {
			ghosts[i] = new Entity();
		}
		
		setSize(800,600);
		setLocationRelativeTo(null);

		final JPanel display = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(Color.black);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setColor(Color.RED);
				g.fillRect(user.x, user.y, 30, 30);
			}
		};

		addKeyListener(InputManager.newController(user));
		setFocusable(true);
		add(display);
		repaint();
		
	}
	
	void nextFrame() {
		user.move();
	}

	public static void main(String[] args) {
		int UPDATES = 60;  // set the updates of the values to 60 per second
		int UPDATEUNIT = 1000000; // Just the devider to calc up from nano
		Thread t = new Thread();
		//Time time = new Time();
		
		try {
			t.sleep(100);
			InputTest m = new InputTest();
			m.setVisible(true);
			m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			long executionStamp = System.nanoTime() / UPDATEUNIT; // the timestamp of the last execution
			while(true) { 
			    long now = System.nanoTime() / UPDATEUNIT; // get the current time
			    long difference  = now - executionStamp; // get the difference between the last update and the current run
			    long interval = 1000 / UPDATES; // a number representing the time that needs to pass for the next value update to happen
				System.out.println(difference);
			    if (difference > interval) {
			    	m.nextFrame();
			        m.repaint();
			        executionStamp = System.nanoTime() / UPDATEUNIT; // set new executiontimestamp
			    }
			    //m.updateUI(); // Upating the ui should allways be able to have unlimited FPS if you don´t want the user to lock it manually
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}