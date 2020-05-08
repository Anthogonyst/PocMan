//package Maestus.PocMan;

public class DebugSquare extends Entity {

	public DebugSquare(int _x, int _y, int size) {
		super(_x, _y, 0);
		sprite = new Sprite<Entity>(this, size, DrawOptions.PAINT_PURPLE);
	}
}
