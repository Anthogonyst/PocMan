import java.util.ArrayList;

/**
 * Handles the draw call for a specific board setup
 * Optimizes the poly count
 * Is hardcoded
 * @author Oracle
 *
 */
public final class BoardWalls {

	/**
	 * Returns the optimized board walls
	 * @param height
	 * @param width
	 * @return board walls
	 */
	final static ArrayList<Vector4> optimalBorders(int m, int n) {
		ArrayList<Vector4> draw = new ArrayList<Vector4>();
		
		draw.add(new Vector4(0, 0, m-1, 0));
		draw.add(new Vector4(0, 1, 0, n-2));
		draw.add(new Vector4(0, n-1, m-1, n-1));
		draw.add(new Vector4(m-1, 1, m-1, n-2));

		draw.add(new Vector4(1, 13, 4, 14));
		
		draw.add(new Vector4(2, 2, 4, 5));
		draw.add(new Vector4(2, 7, 4, 11));
		draw.add(new Vector4(2, 16, 4, 20));
		draw.add(new Vector4(2, 22, 4, 25));
		
		draw.add(new Vector4(6, 2, 7, 5));
		draw.add(new Vector4(6, 7, 13, 8));
		draw.add(new Vector4(6, 10, 7, 17));
		draw.add(new Vector4(6, 19, 13, 20));
		draw.add(new Vector4(6, 22, 7, 25));

		draw.add(new Vector4(8, 13, 10, 14));
		
		draw.add(new Vector4(9, 1, 19, 5));
		draw.add(new Vector4(9, 9, 10, 11));
		draw.add(new Vector4(9, 16, 10, 18));
		draw.add(new Vector4(9, 22, 19, 26));
		
		draw.add(new Vector4(12, 10, 16, 17));
		
		draw.add(new Vector4(15, 7, 19, 8));
		draw.add(new Vector4(15, 19, 19, 20));
		
		draw.add(new Vector4(18, 10, 19, 17));

		draw.add(new Vector4(20, 13, 22, 14));
		
		draw.add(new Vector4(21, 2, 22, 5));
		draw.add(new Vector4(21, 7, 22, 11));
		draw.add(new Vector4(21, 16, 22, 20));
		draw.add(new Vector4(21, 22, 22, 25));
		

		draw.add(new Vector4(23, 4, 25, 5));
		draw.add(new Vector4(23, 22, 25, 23));

		draw.add(new Vector4(24, 1, 25, 2));
		draw.add(new Vector4(24, 7, 26, 8));
		draw.add(new Vector4(24, 10, 25, 17));
		draw.add(new Vector4(24, 19, 26, 20));
		draw.add(new Vector4(24, 25, 25, 26));

		draw.add(new Vector4(27, 2, 28, 11));
		draw.add(new Vector4(27, 13, 28, 14));
		draw.add(new Vector4(27, 16, 28, 25));
		return draw;
	}
}
