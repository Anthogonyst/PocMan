package Maestus.PocMan;

import java.util.ArrayList;

public class Board {
	
	static int BOARD_PIECE_SIZE = 30;
	static boolean initDone = false;
	
	private final static boolean board[][] = 
		{
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, true, true, true, true, true, true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, false},
			{false, true, false, false, false, false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, true, false},
			{false, true, false, false, false, false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, true, false},
			{false, true, false, false, false, false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, true, false},
			{false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false},
			{false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, true, false},
			{false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, true, false},
			{false, true, true, true, true, true, true, false, false, true, true, true, true, false, false, true, true, true, true, false, false, true, true, true, true, true, true, false},
			{false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, true, true, true, true, true, true, true, true, true, true, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
			{false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, false}, //teleporting row
			{false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, true, true, true, true, true, true, true, true, true, true, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
			{false, true, true, true, true, true, true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, false},
			{false, true, false, false, false, false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, true, false},
			{false, true, false, false, false, false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, true, false},
			{false, true, true, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, true, true, true, false},
			{false, false, false, true, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, true, false, false, false},
			{false, false, false, true, false, false, true, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, true, false, false, false},
			{false, true, true, true, true, true, true, false, false, true, true, true, true, false, false, true, true, true, true, false, false, true, true, true, true, true, true, false},
			{false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false},
			{false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false},
			{false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
		};
	
	/**Takes in coordinates and checks the grid surrounding it for valid paths. 
	 * Will not go out of bounds if called on a path because of border of zeroes.
	 * 
	 * @param x row that the entity is in
	 * @param y column that the entity is in
	 * @return An ArrayList<Direction> of valid directions
	 */
	public static ArrayList<Direction> queryChoices(int x, int y){
		ArrayList<Direction> choices = new ArrayList<Direction>();
		if(board[x-1][y])
			choices.add(Direction.UP);
		if(board[x+1][y])
			choices.add(Direction.DOWN);
		if(board[x][y-1])
			choices.add(Direction.LEFT);
		if(board[x][y+1])
			choices.add(Direction.RIGHT);
		return choices;
			
	}
	
	public static ArrayList<Direction> queryCoords(int x, int y) {
		int gridX = x / BOARD_PIECE_SIZE;
		int gridY = y / BOARD_PIECE_SIZE;
		
		return queryChoices(gridX, gridY);
	}
	
	public static Vector2 queryAxis(int x, int y) {
		int gridX = x / BOARD_PIECE_SIZE;
		int gridY = y / BOARD_PIECE_SIZE;
		
		return new Vector2(gridX, gridY);
	}
	
	public static void initBoard() {
		int arr = board.length;
		int arrLong = board[0].length;
		
		if (!initDone) {
			for (int i = 0; i < arr; i++) {
				for (int j = 0; j < arrLong; j++) {
					if (board[i][j]) {
						Pellet p = new Pellet(j*BOARD_PIECE_SIZE, i*BOARD_PIECE_SIZE, 4);
						DrawCanvas.addEntity(p);
					} else {
						Wall w = new Wall(j*BOARD_PIECE_SIZE, i*BOARD_PIECE_SIZE, BOARD_PIECE_SIZE);
						DrawCanvas.addEntity(w);
					}
				}
			}
		}
		
		
	}
	
	/**Takes in coordinates and checks whether or not it is a valid path
	 * 
	 * @param x row index to be checked
	 * @param y column index to be checked
	 * @return true if coordinate is valid path on board
	 */
	public boolean isValid(int x, int y) {
		return board[x][y];
	}
}
