
/**
 * A drawing plane for graphics
 * 
 * @author Oracle
 */
public class Plane extends Entity {
	
	/**
	 * Constructs a new plane
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 */
	public Plane(int x, int y, int length, int width) {
		super(x, y, 0);
		sprite = new Sprite<Entity>(this, length, width, DrawOptions.PAINT_BLUE);
	}
	
	@Override
	public void move() { ; }
}
