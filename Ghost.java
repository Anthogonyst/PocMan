//package Maestus.PocMan;

import java.util.ArrayList;

public class Ghost extends Entity {
	
	private int axisX;
	private int axisY;
	private int lerpX;
	private int lerpY;
	private Direction lerpDir;
	private Entity target;
	private Entity altTarget;
	
	public Ghost(int _x, int _y, int _speed, Entity _target) {
		super(_x, _y, _speed);
		lerpX = 0;
		lerpY = 0;
		lerpDir = facing;
		target = _target;
		altTarget = _target;
		Vector2 pos = Board.queryAxis(_x, _y);
		axisX = pos.x;
		axisY = pos.y;
		velocity = speed;
		sprite = new Sprite<Entity>(this, Board.BOARD_PIECE_SIZE, DrawOptions.PAINT_WHITE);
	}
	
	void move() {
		//System.out.println("Before: " + printIsADebugFeatureISwear());
		int dx = facing.x * velocity;
		int dy = facing.y * velocity;
		
		lerpX += velocity;
		lerpY += velocity;
		
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
			
			lerpX = Math.abs(lerpX % Board.BOARD_PIECE_SIZE);
			lerpY = Math.abs(lerpX % Board.BOARD_PIECE_SIZE);
			
			Direction oldDirection = facing;
			ArrayList<Direction> dirs = Board.queryChoices(axisX, axisY);
			facing = newDirection(dirs);
			
			// If entity passes intersection slightly, center onto intersection and go
			Vector2 correction = Direction.drawVector(oldDirection, lerpX + lerpY);
			x -= correction.x;
			y -= correction.y;
			
			// Might need to set lerp to 0 but it seems fine so far without it; unit test for certainty
			
			x += dx;
			y += dy;
		} else {
			x += dx;
			y += dy;
		}
		//System.out.println("After:  " + printIsADebugFeatureISwear());
	}
	
	boolean checkCollisions() {
		return false;
	}
	
	private Direction newDirection(ArrayList<Direction> dirs) {
		if (dirs.contains(Direction.backwards(facing))) {
			dirs.remove(Direction.backwards(facing));
		}
		
		if (dirs.size() > 0) {
			int rand = (int)(Math.ceil(dirs.size()*Math.random()) % dirs.size());
			return dirs.get(rand);
		} else return facing;
	}
	
	public String printIsADebugFeatureISwear() {
		String s = toString() + "\tPos:  \t" + x + "," + y + "\t\tAxis: \t" + axisX + "," + axisY + "\tLerp: \t" + lerpX + "," + lerpY + "\tDir:\t" + facing;
		return s;
	}
}
