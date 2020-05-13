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
		box = new Collider<Entity>(this, Collision.PLAYER, Board.BOARD_PIECE_SIZE);
		sprite = new Sprite<Entity>(this, Board.BOARD_PIECE_SIZE, DrawOptions.PAINT_RED);
	}
	
	void move() {
		
		Vector2 pos = Board.queryAxis(x, y);
		Entity nearby = Board.queryEntity(axisX, axisY);
		axisX = pos.x;
		axisY = pos.y;
		int state = -1;
		
		if (nearby != null) {
			state = box.colliding(nearby);
		}
		
		if (!Board.isValid(axisX+facing.x, axisY+facing.y)) {
			velocity = 0;
		}
		else
			velocity = speed;
		
		
		if (state == 5) {
			System.out.println("COLLIDED WITH A GHOST");
		} else if(state == 4) {
			DrawCanvas.removeEntity(nearby);
			Board.removeEntity(nearby.x/Board.BOARD_PIECE_SIZE, nearby.y/Board.BOARD_PIECE_SIZE);
			ScoreBoard.addScore(10);
		}
		
		
		int dx = facing.x * velocity;
		int dy = facing.y * velocity;
		
		x += dx;
		y += dy;
	}

	void bufferDirection(Direction dir) {
		if(Board.isValid(axisX+dir.x, axisY+dir.y)) {
			facing = dir;
		}
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
