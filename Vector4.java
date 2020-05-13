
/**
 * An immutable four int value vector
 * Its values are (x, y, z, w)
 * 
 * @author Oracle
 */
public class Vector4 {
	final int x;
	final int y;
	final int z;
	final int w;
	
	/**
	 * Constructs a new immutable vector of length four
	 * @param _x
	 * @param _y
	 * @param _z
	 * @param _w
	 */
	public Vector4(int _x, int _y, int _z, int _w) {
		x = _x;
		y = _y;
		z = _z;
		w = _w;
	}

}
