//package Maestus.PocMan;

/**
 * Class for PocMans "food" an entity to be placed across traversable spaces
 * @author Oracle
 *
 */
public class Pellet extends Entity {
	
	public Pellet(int _x, int _y, int size) {
		super(_x, _y, 0);
		box = new Collider<Entity>(this, Collision.PELLET, size);
		sprite = new Sprite<Entity>(this, 4, DrawOptions.PAINT_YELLOW);
	}
	
	@Override
	void move() {
		;
	}
}
