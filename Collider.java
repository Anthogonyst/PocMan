//package Maestus.PocMan;

import java.awt.Rectangle;

/**
 * Collision box is bounded by a rectangle
 * Gives an entity collision properties
 * 
 * @author Oracle
 *
 * @param <T> of <code>Entity</code>
 */
public class Collider<T extends Entity> {
    private final int width;
    private final int height;
    private final T parent;
    private final Collision layer;
    
    /**
     * Constructs a new collider
     * @param _parent
     * @param collision mask
     * @param size
     */
    public Collider(T _parent, Collision mask, int size) {
    	this.parent = _parent;
    	layer = mask;
    	width = size;
    	height = size;
    }

    /**
     * Returns the area of the collider
     * @return rectangle
     */
    public Rectangle getBounds() {
        return new Rectangle(parent.x - width/2, parent.y - height/2, width/2, height/2);
    }
    
    /**
     * Returns the type of collision occurring
     * @param other entity
     * @return collision state
     */
    public Collision colliding(Entity other) {
    	if (this.getBounds().intersects(other.box.getBounds()))
    		return layer.touch(other.box.layer);
    	else {
    		return Collision.NONE;
    	}
    }
}
