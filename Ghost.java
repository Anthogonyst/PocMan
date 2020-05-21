//package Maestus.PocMan;

import java.util.ArrayList;

/**
 * The <code>Ghost</code> class is the main opposition for the <code>Player</code> class
 * 
 * @author Oracle
 *
 */
public class Ghost extends Entity {

	private EntityStrategy<Entity> ai;
	private Entity target;
	private int axisX;
	private int axisY;
	private int lerpX;
	private int lerpY;
	
	private boolean debugPrint;
	
	/**
	 * Constructs a new ghost
	 * @param x
	 * @param y
	 * @param speed
	 * @param entity target
	 */
	public Ghost(int _x, int _y, int _speed, Entity _target) {
		super(_x, _y, _speed);
		box = new Collider<Entity>(this, Collision.GHOST, Board.BOARD_PIECE_SIZE);
		sprite = new Sprite<Entity>(this, Board.BOARD_PIECE_SIZE, DrawOptions.PAINT_WHITE);
		ai = new StrategyRandom<Entity>(this);
		Vector2 pos = Board.queryAxis(_x, _y);
		axisX = pos.x;
		axisY = pos.y;
		lerpX = 0;
		lerpY = 0;
		target = _target;
		velocity = speed;
		
		debugPrint = false;
	}
	
	/**
	 * Dictates how the ghost will move
	 */
	void move() {
		if (debugPrint)
			System.out.println("Before: " + printIsADebugFeatureISwear());
		
		int dx = facing.x * velocity;
		int dy = facing.y * velocity;
		
		lerpX += facing.x * velocity;
		lerpY += facing.y * velocity;
		
		// Soft patch for going out of bounds; delete when there isn't something wrong
		if (outofBounds(dx, dy)) {
			lerpX = 0;
			lerpY = 0;
			Vector2 pos = Board.queryAxis(x, y);
			axisX = pos.x;
			axisY = pos.y;
			return;
		}
		
		// The entity implicitly reached an intersection if this is true
		if (lerpX >= Board.BOARD_PIECE_SIZE || lerpY >= Board.BOARD_PIECE_SIZE || lerpX < 0 || lerpY < 0) {
			Vector2 pos = Board.queryAxis(x + dx, y + dy);
			axisX = pos.x;
			axisY = pos.y;
			
			lerpX = (lerpX + Board.BOARD_PIECE_SIZE) % Board.BOARD_PIECE_SIZE;
			lerpY = (lerpY + Board.BOARD_PIECE_SIZE) % Board.BOARD_PIECE_SIZE;
			
			// If entity passes intersection slightly, center onto intersection
			Vector2 correction = new Vector2(axisX*Board.BOARD_PIECE_SIZE, axisY*Board.BOARD_PIECE_SIZE);
			x = correction.x;
			y = correction.y;

			//Direction oldDirection = facing;
			ArrayList<Direction> dirs = Board.queryChoices(axisX, axisY);
			facing = ai.newDirection(dirs);
			
			// May be desirable to modulate extra distance as a cross product but currently it is discarded
			//x += dx;
			//y += dy;
		} else {
			x += dx;
			y += dy;
		}
		
		if (debugPrint)
			System.out.println("After:  " + printIsADebugFeatureISwear());
	}
	
	/**
	 * Checks for collision with the <code>Player</code>
	 */
	Collision checkCollisions() {
		if (target != null)
			return box.colliding(target);
		return Collision.NONE;
	}
	
	/**
	 * Return coordinates and info
	 * @return String
	 */
	public String printIsADebugFeatureISwear() {
		String s = toString() + "\tPos:  \t" + x + "," + y + "\t\tAxis: \t" + axisX + "," + axisY + "\tLerp: \t" + lerpX + "," + lerpY + "\tDir:\t" + facing;
		return s;
	}
}
