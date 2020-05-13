//package Maestus.PocMan;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * An abstract class that shares all features common to a game object
 * @author Oracle
 *
 */
public abstract class Entity {
	int x = 150;
	int y = 150;
	int speed ;
	int velocity;
	Direction facing;
	Collider box;
	Sprite sprite;
	
	public Entity(int _x, int _y, int _speed) {
		x = _x;
		y = _y;
		speed = _speed;
		velocity = 0;
		facing = Direction.UP;
	}
	
	abstract void move();

	boolean outofBounds(int dx, int dy) {
		if (x + dx >= 15 || y + dy >= 15 || x + dx <= 905 || y + dy <= 905)
			return false;
		
		if (x + dx < 15)
			x = 890;
			
		if (y + dy < 15)
			y = 890;
			
		if (x + dx > 905)
			x = 30;
		
		if (y + dy > 905)
			y = 30;
		
		return true;
	}
	
	void bufferDirection(Direction dir) {
	}
	
	void updateSpeed() {
		// increase speed every level
	}
	
	boolean checkCollisions() {
		return false;
		// check the collisions here
	}
	
	
	protected void paintComponent(Graphics g) {
		
	}
}
