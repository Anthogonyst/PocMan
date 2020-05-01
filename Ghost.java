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
		
		int get = checkCollisions();
		
		if (true /* not facing a wall */) {
			velocity = speed;
		} else velocity = 0;
		
	}
	
	int checkCollisions() {
		
	}
}
