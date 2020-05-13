//package Maestus.PocMan;

import java.awt.Graphics;

/**
 * An abstract class that shares all features common to a game object
 * @author Oracle
 *
 */
public abstract class Entity {
	int x;
	int y;
	int speed;
	int velocity;
	Direction facing;
	Collider<Entity> box;
	Sprite<Entity> sprite;
	
	public Entity(int _x, int _y, int _speed) {
		x = _x;
		y = _y;
		speed = _speed;
		velocity = 0;
		facing = Direction.UP;
	}
	
	/**
	 * Frame based action
	 */
	abstract void move();
	
	/**
	 * Input a direction
	 * @param dir
	 */
	void bufferDirection(Direction dir) {
	}
	
	/**
	 * Change max speed
	 * @param speed
	 */
	void updateSpeed(int s) {
		speed = s;
	}
	
	/**
	 * If collisions enabled, check collision
	 * @return
	 */
	Collision checkCollisions() {
		return Collision.NONE;
	}
	
	protected void paintComponent(Graphics g) {
	}

	/**
	 * Checks if outside of board grid
	 * @param dx
	 * @param dy
	 * @return
	 */
	boolean outofBounds(int dx, int dy) {
		if (x + dx >= Board.BOARD_PIECE_SIZE/2 || y + dy >= Board.BOARD_PIECE_SIZE/2 
				|| x + dx <= Board.BOARD_WIDTH - Board.BOARD_PIECE_SIZE/2 || y + dy <= Board.BOARD_HEIGHT - Board.BOARD_PIECE_SIZE/2)
			return false;
		
		if (x + dx < Board.BOARD_PIECE_SIZE/2)
			x = Board.BOARD_WIDTH - Board.BOARD_PIECE_SIZE;
			
		if (y + dy < Board.BOARD_PIECE_SIZE/2)
			y = Board.BOARD_HEIGHT - Board.BOARD_PIECE_SIZE;
			
		if (x + dx > Board.BOARD_WIDTH - Board.BOARD_PIECE_SIZE/2)
			x = Board.BOARD_PIECE_SIZE;
		
		if (y + dy > Board.BOARD_HEIGHT - Board.BOARD_PIECE_SIZE/2 )
			y = Board.BOARD_PIECE_SIZE;
		
		return true;
	}
}
