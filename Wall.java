//package Maestus.PocMan;

/**
 * An <code>Entity</code> meant to block your path
 * Doesn't actually block your path, functionality elsewhere, merely  a e s t h e t i c
 * 
 * @author Oracle
 */
public class Wall extends Entity {
	
	Collider<Entity> bigBox;
	
	/**
	 * Creates a new wall
	 * @param _x
	 * @param _y
	 * @param size
	 */
	public Wall(int _x, int _y, int size) {
		super(_x, _y, 0);
		box = new Collider<Entity>(this, Collision.WALL, size);
		sprite = new Sprite<Entity>(this, Board.BOARD_PIECE_SIZE, DrawOptions.PAINT_BLUE);
	}
	
	@Override
	void move() { ; }
}
