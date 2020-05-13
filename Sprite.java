//package Maestus.PocMan;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * The drawing associated with a sprite to be rendered in the <code>DrawCanvas</code> class
 * @author Oracle
 *
 * @param <T> of <code>Entity</code>
 */
public class Sprite<T extends Entity> {
	private final int width;
	private final int height;
	private final T parent;
	private final JPanel canvas;
	private final DrawOptions color;
	private boolean visible;
	
	/**
	 * Constructs a new red sprite
	 * @param parent
	 * @param size
	 */
	public Sprite(T _parent, int size) {
		parent = _parent;
		width = size;
		height = size;
		visible = true;
		color = DrawOptions.PAINT_RED;
		canvas = DrawCanvas.getInstance();
	}

	/**
	 * Constructs a new square sprite
	 * @param parent
	 * @param size
	 * @param color or graphic of <code>DrawOptions</code>
	 */
	public Sprite(T _parent, int size, DrawOptions _color) {
		parent = _parent;
		width = size;
		height = size;
		visible = true;
		color = _color;
		canvas = DrawCanvas.getInstance();
	}

	/**
	 * Constructs a new rectangular sprite
	 * @param parent
	 * @param width
	 * @param height
	 * @param color or graphic of <code>DrawOptions</code>
	 */
	public Sprite(T _parent, int _width, int _height, DrawOptions _color) {
		parent = _parent;
		width = _width;
		height = _height;
		visible = true;
		color = _color;
		canvas = DrawCanvas.getInstance();
	}
	
	/**
	 * Accessor method for visibility of sprite
	 * 
	 * @return is visible?
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Mutator method for visibility of sprite
	 * 
	 * @param set visible else invisible
	 */
	public void setVisible(boolean _visible) {
		visible = _visible;
	}
	
	/**
	 * Paints sprite based on the <code>DrawOptions</code> used
	 * 
	 * @param graphics
	 */
	protected void paintComponent(Graphics g) {
		switch (color) {
		case SINGLE: Assets.medPocMan2.paintIcon(canvas, g, parent.x, parent.y); return;
		case MULTI: return;
		case PAINT_RED: g.setColor(Color.RED); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_BLUE: Color blueish = new Color(0, 0, 255, 127); g.setColor(blueish); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_YELLOW: g.setColor(Color.YELLOW); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_WHITE: g.setColor(Color.WHITE); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PAINT_PURPLE: Color purpleish = new Color(255, 0, 255, 127); g.setColor(purpleish); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		case PLAYER: g.drawImage(Assets.pocman, parent.x, parent.y, null);//please check and fix if not correct
		default: g.setColor(Color.RED); g.fillRect(parent.x - width/2, parent.y - height/2, width, height); return;
		}
	}
}
