//package Maestus.PocMan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * The board class holds information about the game grid, its boundaries, and its entities
 * @author Oracle, Vincent Ndokaj
 *
 */
public final class Board {
	
	static int BOARD_PIECE_SIZE = 30;
	static boolean initDone = false;
	private static HashMap<Vector2, Entity> boardEntities;
	private static LinkedList<Entity> nonBoardEntities;
	
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
			{false, false, false, false, false, /**/false, /**/true, true, true, true, false, false, false, false, false, false, false, false, true, true, true, true, /**/false,/**/ false, false, false, false, false}, //teleporting row
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
	
	static int BOARD_HEIGHT = BOARD_PIECE_SIZE*board[0].length;
	static int BOARD_WIDTH = BOARD_PIECE_SIZE*board.length;
	
	/*
	 * Constructs a new board
	 */
	public Board() {
		boardEntities = new HashMap<Vector2, Entity>();
		nonBoardEntities = new LinkedList<Entity>();
	}

	/**
	 * Initializes board and pellet placement using a standard size for board
	 * pieces.
	 */
	static void initBoard() {
		boardEntities = new HashMap<Vector2, Entity>();
		nonBoardEntities = new LinkedList<Entity>();
		int arr = board.length;
		int arrLong = board[0].length;
		
		if (!initDone) {
			for (int i = 0; i < arr; i++) {
				for (int j = 0; j < arrLong; j++) {
					if (board[i][j]) {
						Pellet p = new Pellet(i*BOARD_PIECE_SIZE, j*BOARD_PIECE_SIZE, BOARD_PIECE_SIZE);
						DrawCanvas.addEntity(p);
						boardEntities.put(new Vector2(i, j), p);
						GameManager.notifyPelletGain();
					} else {
						Wall w = new Wall(i*BOARD_PIECE_SIZE, j*BOARD_PIECE_SIZE, 4);
						//DrawCanvas.addEntity(w);
						boardEntities.put(new Vector2(i, j), w);
					}
				}
			}
		}
		
		//Entity wallpaper = new Plane(BOARD_PIECE_SIZE*arr/2, BOARD_PIECE_SIZE*arrLong/2, BOARD_PIECE_SIZE*arr, BOARD_PIECE_SIZE*arrLong);
		//DrawCanvas.addEntity(wallpaper);
		
		ArrayList<Vector4> drawOptimization = BoardWalls.optimalBorders(arr, arrLong);
		for (Vector4 d : drawOptimization) {
			Plane optimalWall = new Plane((d.x + d.z)*BOARD_PIECE_SIZE/2, (d.y + d.w)*BOARD_PIECE_SIZE/2, (d.z - d.x + 1)*BOARD_PIECE_SIZE, (d.w - d.y + 1)*BOARD_PIECE_SIZE);
			DrawCanvas.addEntity(optimalWall);
			nonBoardEntities.add(optimalWall);
		}
		
		initDone = true;
		GameManager.notifyInitDone();
	}
	
	/**
	 * Removes all references to current board
	 */
	static void destroyBoard() {
		int arr = board.length;
		int arrLong = board[0].length;

		for (int i = 0; i < arr; i++) {
			for (int j = 0; j < arrLong; j++) {
				Entity e = boardEntities.get(new Vector2(i, j));
				DrawCanvas.removeEntity(e);
			}
		}
		
		for (Entity ne : nonBoardEntities) {
			DrawCanvas.removeEntity(ne);
		}

		boardEntities = new HashMap<Vector2, Entity>();
		nonBoardEntities = new LinkedList<Entity>();
		initDone = false;
	}
	
	/**Takes in coordinates and checks the grid surrounding it for valid paths. 
	 * Will not go out of bounds if called on a path because of border of zeroes.
	 * 
	 * @param x row that the entity is in
	 * @param y column that the entity is in
	 * @return An ArrayList<Direction> of valid directions
	 */
	static ArrayList<Direction> queryChoices(int x, int y){
		ArrayList<Direction> choices = new ArrayList<Direction>();
		boolean drawDebugPaths = false;
		
		if (drawDebugPaths) {
			DebugSquare d = new DebugSquare(x*BOARD_PIECE_SIZE, y*BOARD_PIECE_SIZE, Board.BOARD_PIECE_SIZE - 4);
			DrawCanvas.addEntity(d);
		}
		
		if (y > 1)
			if(board[x][y-1])
				choices.add(Direction.UP);
		if (y < board[0].length - 1)
			if(board[x][y+1])
				choices.add(Direction.DOWN);
		if (x > 1)
			if(board[x-1][y])
				choices.add(Direction.LEFT);
		if (x < board.length - 1)
			if(board[x+1][y])
				choices.add(Direction.RIGHT);
		
		return choices;
			
	}
	
	/**
	 * Queries available directions from raw coordinates
	 * @param x
	 * @param y
	 * @return Directions
	 */
	static ArrayList<Direction> queryCoords(int x, int y) {
		int gridX = x / BOARD_PIECE_SIZE;
		int gridY = y / BOARD_PIECE_SIZE;
		
		return queryChoices(gridX, gridY);
	}
	
	/**
	 * Queries axis from raw coordinates
	 * @param x
	 * @param y
	 * @return Axis
	 */
	static Vector2 queryAxis(int x, int y) {
		int gridX = (x + BOARD_PIECE_SIZE / 2) / BOARD_PIECE_SIZE;
		int gridY = (y + BOARD_PIECE_SIZE / 2) / BOARD_PIECE_SIZE;
		
		return new Vector2(gridX, gridY);
	}
	
	/**
	 * Queries entity occupying axis coordinate
	 * @param x
	 * @param y
	 * @return Entity
	 */
	static Entity queryEntity(int x, int y) {
		return boardEntities.get(new Vector2(x, y));
	}
	
	/**
	 * Removes entity occupying axis coordinate
	 * @param x
	 * @param y
	 */
	static void removeEntity(int x, int y) {
		boardEntities.remove(new Vector2(x,y));
	}
	
	/**
	 * Takes in coordinates and checks whether or not it is a valid path
	 * @param x row index to be checked
	 * @param y column index to be checked
	 * @return true if coordinate is valid path on board
	 */
	static boolean isValid(int x, int y) {
		return board[x][y];
	}
}
