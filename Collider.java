package Maestus.PocMan;

import java.awt.Rectangle;

public class Collider<T extends Entity> {
    int width;
    int height;
    T parent;
    Collision layer;
    
    public Collider(T _parent, Collision mask) {
    	this.parent = _parent;
    	layer = mask;
    	width = 4;
    	height = 4;
    }

    public Rectangle getBounds() {
        return new Rectangle(parent.x - width/2, parent.y - height/2, width, height);
    }
}
