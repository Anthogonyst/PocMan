//package Maestus.PocMan;

public class Wall extends Entity {
	
	Collider bigBox;
	
	public Wall(int _x, int _y, int size) {
		super(_x, _y, 0);
		bigBox = new Collider<Entity>(this, Collision.WALL, size);
		sprite = new Sprite<Entity>(this, Board.BOARD_PIECE_SIZE, DrawOptions.PAINT_BLUE);
	}
	
	@Override
	void move() {
		;
	}
}
