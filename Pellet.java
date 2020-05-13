//package Maestus.PocMan;

/**
 * Plays multiple roles as an intersection intermediate and game prop
 * 
 * @author Oracle
 */
public class Pellet extends Entity {
	
	/**
	 * Constructs a new pellet
	 * @param x
	 * @param y
	 * @param size
	 */
	public Pellet(int x, int y, int size) {
		super(x, y, 0);
		box = new Collider<Entity>(this, Collision.PELLET, size);
		sprite = new Sprite<Entity>(this, 4, DrawOptions.PAINT_YELLOW);
	}
	
	@Override
	void move() { ; }
}
