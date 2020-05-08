//package Maestus.PocMan;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * Handles the drawing code for the game by allocating what entities are where
 * @author Oracle
 *
 */
public class DrawCanvas extends JPanel {
	
	static LinkedList<Entity> entities;
	
	DrawCanvas() {
		entities = new LinkedList<Entity>();
	}
	
	static boolean addEntity(Entity e) {
		if (!entities.contains(e)) {
			entities.add(e);
			return true;
		} else {
			return false;
		}
	}
	
	static boolean removeEntity(Entity e) {
		if (entities.contains(e)) {
			entities.remove(e);
			return true;
		} else {
			return false;
		}
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for (Entity e : entities) {
			e.sprite.paintComponent(g);
		}
	}
}
