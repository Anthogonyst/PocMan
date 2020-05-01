package Maestus.PocMan;

public class Ghost extends Entity {
	
	public Ghost(int _x, int _y, int _speed) {
		super(_x, _y, _speed);
	}
	
	void move() {
		int _x = x;
		int _y = y;

		x += facing.x * velocity;
		y += facing.y * velocity;
		
		boolean notTouchingWall = checkCollisions();
		
		if (notTouchingWall) {
			velocity = speed;
		} else velocity = 0;
		
	}
	
	boolean checkCollisions() {
		return true;
	}
}
