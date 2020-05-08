//package Maestus.PocMan;

import java.awt.Rectangle;

public class Collider<T extends Entity> {
    private final int width;
    private final int height;
    private final T parent;
    private final Collision layer;
    
    public Collider(T _parent, Collision mask, int size) {
    	this.parent = _parent;
    	layer = mask;
    	width = size;
    	height = size;
    }

    public Rectangle getBounds() {
        return new Rectangle(parent.x - width/2, parent.y - height/2, width, height);
    }
}
