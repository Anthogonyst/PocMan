import java.util.ArrayList;

/**
 * The player controlled <code>Entity</code> which when binded can be used with the <code>InputManager</code> class
 * @author Oracle, Vin
 *
 */
public class Player extends Entity {

	private int axisX;
	private int axisY;
	private int bufferFrames;
	private Direction bufferDir;
	private boolean isBacktracking;
	
	private static int MAX_BUFFER = 30;
	
	/**
	 * Constructs a new player
	 * @param x
	 * @param y
	 * @param speed
	 */
	public Player(int _x, int _y, int _speed) {
		super(_x, _y, _speed);
		Vector2 pos = Board.queryAxis(_x, _y);
		axisX = pos.x;
		axisY = pos.y;
		velocity = speed;
		bufferFrames = 0;
		bufferDir = facing;
		isBacktracking = false;
		box = new Collider<Entity>(this, Collision.PLAYER, Board.BOARD_PIECE_SIZE);
		sprite = new Sprite<Entity>(this, Board.BOARD_PIECE_SIZE, DrawOptions.SINGLE);
	}
	
	/**
	 * Dictates how the <code>Player</code> will move each frame in a <code>Board</code> environment
	 */
	void move() {
		Collision state = Collision.NONE;
		Vector2 pos = Board.queryAxis(x, y);
		Entity nearby = Board.queryEntity(axisX, axisY);
		axisX = pos.x;
		axisY = pos.y;
		
		if (nearby != null) {
			state = box.colliding(nearby);
		}
		
		if (!Board.isValid(axisX+facing.x, axisY+facing.y)) {
			velocity = 0;
		}
		else
			velocity = speed;
		
		if (state == Collision.PELLET) {
			if (nearby.sprite.isVisible()) {
				nearby.sprite.setVisible(false);
				GameManager.notifyPelletLoss();
				ScoreBoard.addScore(10);
			}
		}
		
		
		int dx = facing.x * velocity;
		int dy = facing.y * velocity;
		
		x += dx;
		y += dy;
	}
	
	/**
	 * Buffers the direction from the <code>InputManager</code> for smooth playing
	 */
	void bufferDirection(Direction dir) {
		if(Board.isValid(axisX+dir.x, axisY+dir.y)) {
			facing = dir;
		}
	}
	
	/**
	 * Checks for collisions
	 */
	Collision checkCollisions() {
		return Collision.NONE;
	}
	
	/**
	 * Validates the buffered direction
	 * @param directions
	 * @return <code>Direction</code>
	 */
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
