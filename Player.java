import java.util.ArrayList;

/**
 * The player controlled <code>Entity</code> which when binded can be used with the <code>InputManager</code> class
 * @author Oracle, Vin
 *
 */
public class Player extends Entity {

	private int axisX;
	private int axisY;
	private int lerpX;
	private int lerpY;
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
		lerpX = 0;
		lerpY = 0;
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
		Entity nearby = Board.queryEntity(axisX, axisY);
		Collision state = box.colliding(nearby);
		int dx = facing.x * velocity;
		int dy = facing.y * velocity;

		int backwardsMod = isBacktracking ? -1 : 1;
		lerpX += facing.x * velocity * backwardsMod;
		lerpY += facing.y * velocity * backwardsMod;
		
		// Soft patch for going out of bounds; delete when there isn't something wrong
		if (outofBounds(dx, dy)) {
			lerpX = 0;
			lerpY = 0;
			Vector2 pos = Board.queryAxis(x, y);
			axisX = pos.x;
			axisY = pos.y;
			return;
		}
		
		if (bufferFrames > 0)
			bufferFrames--;
		else if (!bufferDir.equals(facing))
			bufferDir = facing;

		// The entity implicitly reached an intersection if this is true
		if (lerpX >= Board.BOARD_PIECE_SIZE || lerpY >= Board.BOARD_PIECE_SIZE || lerpX < 0 || lerpY < 0 || state.equals(Collision.PELLET)) {
			Vector2 pos = Board.queryAxis(x + dx, y + dy);
			axisX = pos.x;
			axisY = pos.y;

			// Notify the pellet to initiate its events
			if (state.equals(Collision.PELLET)) {
				if (nearby.sprite.isVisible()) {
					nearby.sprite.setVisible(false);
					GameManager.notifyPelletLoss();
					ScoreBoard.addScore(10);
				}
			}
			
			lerpX = (lerpX + Board.BOARD_PIECE_SIZE) % Board.BOARD_PIECE_SIZE;
			lerpY = (lerpY + Board.BOARD_PIECE_SIZE) % Board.BOARD_PIECE_SIZE;
			
			Vector2 correction = new Vector2(axisX*Board.BOARD_PIECE_SIZE, axisY*Board.BOARD_PIECE_SIZE);
			x = correction.x;
			y = correction.y;

			ArrayList<Direction> dirs = Board.queryChoices(axisX, axisY);
			facing = newDirection(dirs);
			
			isBacktracking = false;
		} else if (bufferFrames > 0 && bufferDir.equals(Direction.backwards(facing))) {
			facing = bufferDir;
			isBacktracking = !isBacktracking;
			
			x -= dx;
			y -= dy;
		} else {
			x += dx;
			y += dy;
		}
	}
	
	/**
	 * Buffers the direction from the <code>InputManager</code> for smooth playing
	 */
	void bufferDirection(Direction dir) {
		if (bufferDir.equals(dir))
			bufferFrames = 0;
		else bufferFrames = MAX_BUFFER;
		
		bufferDir = dir;
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
			velocity = speed;
			return bufferDir;
		} else if (dirs.contains(facing)) {
			velocity = speed;
			return facing;
		} else {
			velocity = 0;
			return facing;
		}
	}
}
