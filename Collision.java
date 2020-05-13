//package Maestus.PocMan;

/**
 * Enumeration of the types of collision for the <code>Collider</code> class
 * Currently set up so that collision generally only checks one way
 * 
 * @author Oracle
 *
 */
enum Collision {
	WALL,
	PLAYER,
	GHOST,
	PELLET,
	NONE;
	
	Collision touch(Collision other) {
		switch (this) {
		case WALL: return Collision.NONE; // ignore this
		case PLAYER: return touching(this, other);
		case GHOST: return touching(this, other);
		case PELLET: return Collision.PELLET; // something touched a node so query a choice for other
		default: { System.out.println("This collision shouldn't be reached."); return Collision.NONE; }
	}
	}
	
	private static Collision touching(Collision _this, Collision other) {
		switch (other) {
		case WALL: return Collision.WALL; // something touched a wall, turn _this away please
		case PLAYER: return Collision.PLAYER; // a ghost touched a player, start game over or get eaten; may break with multiplayer
		case GHOST: return Collision.NONE; // ignore this
		case PELLET: return Collision.PELLET; // something touched an intersection
		default: { System.out.println("Other collision shouldn't be reached."); return Collision.NONE; }
		}
	}
}

