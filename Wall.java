package Maestus.PocMan;

import Maestus.PocMan.Sprite.DrawOptions;

public class Wall extends Entity {
	
	Collider bigBox;
	
	public Wall(int _x, int _y, int size) {
		super(_x, _y, 0);
		bigBox = new Collider<Entity>(this, Collision.WALL, size);
		sprite = new Sprite<Entity>(this, 30, DrawOptions.PAINT_BLUE);
	}
	
	@Override
	void move() {
		;
	}
}
