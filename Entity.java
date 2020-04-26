package Maestus.PocMan;

public class Entity {
	int x = 150;
	int y = 150;
	int speed = 3;
	int velocity = 3;
	Direction facing = Direction.RIGHT;
	Direction buffer = Direction.RIGHT;
	
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
