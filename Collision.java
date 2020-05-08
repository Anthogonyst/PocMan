//package Maestus.PocMan;

enum Collision {
	WALL,
	PLAYER,
	GHOST,
	PELLET;
	
	/* Action? */ int touch(Collision other) {
		switch (this) {
		case WALL: return -1; // ignore this
		case PLAYER: return touching(this, other);
		case GHOST: return touching(this, other);
		case PELLET: return 3; // something touched a node so query a choice for other
		default: { System.out.println("This collision shouldn't be reached."); return -1; }
	}
	}
	
	private static int touching(Collision _this, Collision other) {
		switch (_this) {
		case WALL: return 1; // something touched a wall, turn _this away please
		case PLAYER: return 2; // a ghost touched a player, start game over or get eaten; may break with multiplayer
		case GHOST: return -1; // ignore this
		case PELLET: return 4; // something touched an intersection
		default: { System.out.println("Other collision shouldn't be reached."); return -1; }
		}
	}
}

