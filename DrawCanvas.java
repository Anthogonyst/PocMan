//package Maestus.PocMan;

import java.awt.Color;
import java.awt.Dimension;
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
		setMaximumSize(new Dimension(900, 900));
	}
	
	/**
	 * Static method to add an entity to the LinkedList
	 * 
	 * @param e entity to be added
	 * @return true if entity was not present added, false if entity was already present
	 */
	static boolean addEntity(Entity e) {
		if (!entities.contains(e)) {
			entities.add(e);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Static method to remove an entity from the LinkedList
	 * 
	 * @param e entity to be removed
	 * @return true if entity was present and removed, flase if entity was not present
	 */
	static boolean removeEntity(Entity e) {
		if (entities.contains(e)) {
			entities.remove(e);
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Paints a component on the JPanel 
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for (Entity e : entities) {
			e.sprite.paintComponent(g);
		}
	}
}
