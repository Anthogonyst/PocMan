//package Maestus.PocMan;

/**
 * Enumerates the different directions that could be taken in (x, y) coordinates
 * There are four directions: UP, DOWN, LEFT, RIGHT
 * @author Oracle
 *
 */
public enum Direction {
	// Java draws a canvas from the top left corner to the bottom right
	// Thus, the (0, 0) coordinate is at the top left
	// Thus, the (1, 1) coordinate is down and right one pixel
	UP(0, -1),
	DOWN(0, 1),
	LEFT(-1, 0),
	RIGHT(1, 0);
	
	public final int x, y;
	
	Direction(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	public static Direction backwards(Direction dir) {
		switch(dir) {
			case UP: return Direction.DOWN;
			case DOWN: return Direction.UP;
			case LEFT: return Direction.RIGHT;
			case RIGHT: return Direction.LEFT;
			default: {
				System.out.println("This shouldn't have been reached.");
				return Direction.RIGHT;
			}
		}
	}
	
	public static Vector2 drawVector(Direction dir, int magnitude) {
		return new Vector2(dir.x * magnitude, dir.y * magnitude);
	}

	public String toString() {
		switch(this) {
		case UP: return "DOWN";
		case DOWN: return "UP";
		case LEFT: return "RIGHT";
		case RIGHT: return "LEFT";
		default: return "No direction???";
		}
	}
};
