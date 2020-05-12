import java.util.ArrayList;

/**
 * 
 * @author Oracle
 *
 */
public class Player extends Entity {

	private int axisX;
	private int axisY;
	private int bufferFrames;
	private Direction bufferDir;
	private boolean isBacktracking;
	
	private static int MAX_BUFFER = 30;
	
	public Player(int _x, int _y, int _speed) {
		super(_x, _y, _speed);
		bufferFrames = 0;
		bufferDir = facing;
		isBacktracking = false;
		Vector2 pos = Board.queryAxis(_x, _y);
		axisX = pos.x;
		axisY = pos.y;
		velocity = speed;
		box = new Collider<Entity>(this, Collision.PLAYER, 4);
		sprite = new Sprite<Entity>(this, Board.BOARD_PIECE_SIZE, DrawOptions.PAINT_RED);
	}
	
	void move() {
		if (bufferFrames > 0) {
			bufferFrames--;
		} else {
			bufferDir = facing;
		}
		
		if (bufferFrames > 0 && bufferDir.equals(Direction.backwards(facing))) {
			isBacktracking = !isBacktracking;
			facing = bufferDir;
			velocity = speed;
			bufferFrames = 0;
		}
		
		//ScoreBoard.addScore(bufferFrames);
		
		Vector2 pos = Board.queryAxis(x, y);
		Entity nearby = Board.queryEntity(axisX, axisY);
		axisX = pos.x;
		axisY = pos.y;
		int state = -1;
		
		if (nearby != null)
			state = box.colliding(nearby);
		
		if (state == 4) {
			Direction oldDirection = facing;
			ArrayList<Direction> dirs = Board.queryChoices(axisX, axisY);
			
			if (!facing.equals(bufferDir)) {
				facing = newDirection(dirs);
			}
			
			//if (!dirs.contains(facing))
				//velocity = 0;
		}
		

		int dx = facing.x * velocity;
		int dy = facing.y * velocity;

		// Soft patch for going out of bounds; delete when there isn't something wrong
		if (outofBounds(dx, dy)) {
			Vector2 pos2 = Board.queryAxis(x, y);
			axisX = pos2.x;
			axisY = pos2.y;
			return;
		}
		
		x += dx;
		y += dy;
	}

	void bufferDirection(Direction dir) {
		bufferDir = dir;
		bufferFrames = MAX_BUFFER;
	}
	
	private Direction newDirection(ArrayList<Direction> dirs) {
		if (dirs.contains(bufferDir)) {
			return bufferDir;
		} else if (dirs.contains(facing)) {
			return facing;
		} else {
			velocity = 0;
			return facing;
		}
	}
}
