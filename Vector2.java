//package Maestus.PocMan;

/**
 * An immutable two int value vector
 * Its values are (x, y)
 * 
 * @author Oracle
 */
public class Vector2 {
	final int x;
	final int y;
	
	/**
	 * Constructs a new immutable vector of two length
	 * @param _x
	 * @param _y
	 */
	public Vector2(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	@Override
	public int hashCode() {
		return (int) x * 3 + y * 7;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vector2))
			return false;
		else if (((Vector2) obj).x == this.x && ((Vector2) obj).y == this.y ){
			return true;
		} else return false;
	}
	
	@Override
	public String toString() {
		return "<" + x + ", " + y + ">";
	}
}
