//package Maestus.PocMan;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Implements JUnit 4 to unit test each file in a framework
 * @author Oracle
 *
 */
public class UnitTest {

    private Direction right;
    private Direction left;

    @Before
    public void setup() {
        right = Direction.RIGHT;
        left = Direction.LEFT;
    }

    @Ignore
    @Test
    public void backwardsDirection() {
        assertEquals(right, Direction.backwards(left));
    }
    
    @Test
    public void isIntersecting() {
    	Entity one = new Entity(2, 2, 0);
    	Entity two = new Entity(5, 5, 0);
    	assertTrue(one.box.getBounds().intersects(two.box.getBounds()));
    }

    @Test
    public void isIntersecting2() {
    	Entity one = new Entity(12, 12, 0);
    	Entity two = new Entity(12, 15, 0);
    	assertTrue(one.box.getBounds().intersects(two.box.getBounds()));
    }
    
    @Test
    public void isNotIntersecting() {
    	Entity one = new Entity(0, 0, 0);
    	Entity two = new Entity(4, 4, 0);
    	Entity three = new Entity(11, 11, 0);
    	assertFalse(one.box.getBounds().intersects(two.box.getBounds()));
    }

    @Test
    public void isNotIntersecting2() {
    	Entity two = new Entity(4, 4, 0);
    	Entity three = new Entity(8, 4, 0);
    	assertFalse(three.box.getBounds().intersects(two.box.getBounds()));
    }
    
    @Test
    public void isAtIntersection() {
    	Player one = new Player(30, 30, 0);
    	Pellet two = new Pellet(30, 30, 4);
    	assertTrue(one.box.getBounds().equals(two.box.getBounds()));
    }

    @Test
    public void isAtIntersection2() {
    	Player one = new Player(60, 60, 0);
    	Pellet two = new Pellet(60, 60, 4);
    	int state = one.box.colliding(two);
    	assertTrue(state == 4);
    }
    
    @Test
    public void stopAtWall() {
    	Board b = new Board();
    	Player no = new Player(100, 100, 3);
    	Pellet u = new Pellet(100, 100, 4);
    	no.facing = Direction.UP;
    	no.bufferDirection(Direction.UP);
    	no.move();
    	no.move();
    	no.move();

    	System.out.println(no.x);
    	assertTrue(no.velocity == 0);
    }
}