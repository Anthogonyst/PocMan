package Maestus.PocMan;

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
		
		if (x + dx < 15 || y + dy < 15 || x + dx > 800 || y + dy > 800) {
			speed = 0;
			velocity = 0;
			return;
		}
		
		if (lerpX >= Board.BOARD_PIECE_SIZE || lerpY >= Board.BOARD_PIECE_SIZE || lerpX < 0 || lerpY < 0) {
			Vector2 pos = Board.queryAxis(x + dx, y + dy);
			axisX = pos.x;
			axisY = pos.y;
			
			lerpX = Math.abs(lerpX % Board.BOARD_PIECE_SIZE);
			lerpY = Math.abs(lerpX % Board.BOARD_PIECE_SIZE);
			
			Direction oldDirection = facing;
			ArrayList<Direction> dirs = Board.queryChoices(axisX, axisY);
			facing = newDirection(dirs);
			
			// add positional correction here
			
		}
		
		x += dx;
		y += dy;
		//System.out.println("After:  " + printIsADebugFeatureISwear());
	}
	
	boolean checkCollisions() {
		return false;
	}
	
	private Direction newDirection(ArrayList<Direction> dirs) {
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
