import java.util.ArrayList;

/**
 * The AI for an <code>Entity</code> in a <code>Board</code> environment
 * @author Oracle
 *
 * @param <T> of <code>Entity</code>
 */
abstract class EntityStrategy<T extends Entity> {
	final T parent;
	
	public EntityStrategy(T _parent) {
		parent = _parent;
	}
	
	abstract Direction newDirection(ArrayList<Direction> dirs);
}
