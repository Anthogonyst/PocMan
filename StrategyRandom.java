import java.util.ArrayList;

/**
 * An AI for <code>Entity</code> in a <code>Board</code> environment
 * Will choose a random direction except backwards
 * @author Oracle
 *
 * @param <T> of <code>Entity</code>
 */
class StrategyRandom<T extends Entity> extends EntityStrategy<T> {

	/**
	 * Constructs a new random AI
	 * @param parent
	 */
	StrategyRandom(T parent) {
		super(parent);
	}
	
	/**
	 * Decides any direction given except backwards
	 */
	@Override
	Direction newDirection(ArrayList<Direction> dirs) {
		if (dirs.contains(Direction.backwards(parent.facing))) {
			dirs.remove(Direction.backwards(parent.facing));
		}
		
		if (dirs.size() > 0) {
			int rand = (int)(Math.ceil(dirs.size()*Math.random()) % dirs.size());
			return dirs.get(rand);
		} else return parent.facing;
	}

}
