
public class Plane extends Entity {
	public Plane(int x, int y, int length, int width) {
		super(x, y, 0);
		sprite = new Sprite<Entity>(this, length, width, DrawOptions.PAINT_BLUE);
	}
}
