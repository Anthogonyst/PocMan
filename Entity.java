package Maestus.PocMan;

import java.awt.Rectangle;

/**
 * An abstract class that shares all features common to a game object
 * @author Oracle
 *
 */
public class Entity {
	int x = 150;
	int y = 150;
	int speed ;
	int velocity;
	Direction facing;
	//Direction buffer = Direction.RIGHT;  // only the player will have this
	Collider box;
	
	public Entity() {
		x = 150;
		y = 150;
		speed = 3;
		velocity = 3;
		facing = Direction.RIGHT;
		box = new Collider<Entity>(this, Collision.GHOST);
	}
	
	public Entity(int _x, int _y, int _speed) {
		x = _x;
		y = _y;
		facing = Direction.UP;
		speed = _speed;
		velocity = 0;
		box = new Collider<Entity>(this, Collision.GHOST);
	}
	
	void move() {
		if (true /* not facing a wall */) {
			velocity = speed;
		} else velocity = 0;
		
		x += facing.x * velocity;
		y += facing.y * velocity;
	}
	
	void bufferDirection() {
		// Timer t = 10 milliseconds
		// If an intersection is reached, the direction facing is set to direction buffer
		// At the end of 10 milliseconds, the direction buffer is set to the direction facingW
	}
	
	void updateSpeed() {
		// increase speed every level
	}
}
