//package Maestus.PocMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 
 * @author Oracle
 *
 * @param <T>
 */
public class Sprite<T extends Entity> {
	private final int width;
	private final int height;
	private final T parent;
	
	private DrawOptions color;
	private boolean visible;
	
	public Sprite(T _parent, int size) {
		parent = _parent;
		width = size;
		height = size;
		visible = true;
		color = DrawOptions.PAINT_RED;
	}

	public Sprite(T _parent, int size, DrawOptions _color) {
		parent = _parent;
		width = size;
		height = size;
		visible = true;
		color = _color;
	}
	
	public Sprite(T _parent, int _width, int _height, DrawOptions _color) {
		parent = _parent;
		width = _width;
		height = _height;
		visible = true;
		color = _color;
	}
	
	/**
	 * Accessor method for visibility of sprite
	 * 
	 * @return boolean value of visibility
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Mutator method for visibility of sprite
	 * 
	 * @param _visible boolean value to set visibility to
	 */
	public void setVisible(boolean _visible) {
		visible = _visible;
	}
	
	/**
	 * Paints sprite based on the color of the sprite
	 * 
	 * @param g graphic to be painted
	 */
	protected void paintComponent(Graphics g) {
		switch (color) {
		case SINGLE: return;
		case MULTI: return;
		case PAINT_RED: g.setColor(Color.RED); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_BLUE: Color blueish = new Color(0, 0, 255, 127); g.setColor(blueish); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_YELLOW: g.setColor(Color.YELLOW); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_WHITE: g.setColor(Color.WHITE); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_PURPLE: Color purpleish = new Color(255, 0, 255, 127); g.setColor(purpleish); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		default: g.setColor(Color.RED); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		}
	}
}
