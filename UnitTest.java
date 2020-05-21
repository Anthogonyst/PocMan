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
    	Entity one = new Ghost(2, 2, 0, null);
    	Entity two = new Ghost(5, 5, 0, null);
    	assertTrue(one.box.getBounds().intersects(two.box.getBounds()));
    }

    @Test
    public void isIntersecting2() {
    	Entity one = new Ghost(12, 12, 0, null);
    	Entity two = new Ghost(12, 15, 0, null);
    	assertTrue(one.box.getBounds().intersects(two.box.getBounds()));
    }
    
    @Test
    public void isNotIntersecting() {
    	Entity one = new Player(0, 0, 0);
    	Entity two = new Pellet(4, 4, 0);
    	Entity three = new Ghost(11, 11, 0, null);
    	assertFalse(one.box.getBounds().intersects(two.box.getBounds()));
    }

    @Test
    public void isNotIntersecting2() {
    	Entity two = new Player(4, 4, 0);
    	Entity three = new Pellet(8, 4, 0);
    	assertFalse(three.box.getBounds().intersects(two.box.getBounds()));
    }
    
    @Test
    public void isAtIntersection() {
    	Player one = new Player(30, 30, 0);
    	Pellet two = new Pellet(30, 30, 4);
    	Collision state = (one.box.colliding(two));
    	assertTrue(state.equals(Collision.PELLET));
    }

    @Test
    public void isAtIntersection2() {
    	Player one = new Player(60, 60, 0);
    	Pellet two = new Pellet(60, 60, 4);
    	Collision state = one.box.colliding(two);
    	assertTrue(state.equals(Collision.PELLET));
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
    
    @Test
    public void testLerp() {
    	Ghost g = new Ghost(Board.BOARD_PIECE_SIZE*5, Board.BOARD_PIECE_SIZE*16, 3, null);
    	int n = 10;
    	
    	for (int i = 0; i < n; i++)
    		g.move();
    	
    	assertTrue(false);
    }
    
    @Test
    public void queryAxis() {
    	assertTrue(Board.queryAxis(Board.BOARD_PIECE_SIZE*5, Board.BOARD_PIECE_SIZE*6).equals(new Vector2(5, 6)));
    }

    @Test
    public void queryAxis2() {
    	Vector2 disp = Direction.drawVector(Direction.DOWN, 5);
    	assertTrue(Board.queryAxis(Board.BOARD_PIECE_SIZE*5 + disp.x, Board.BOARD_PIECE_SIZE*6 + disp.y).equals(new Vector2(5, 6)));
    }

    @Test
    public void queryAxis3() {
    	Vector2 disp = Direction.drawVector(Direction.RIGHT, 5);
    	assertTrue(Board.queryAxis(Board.BOARD_PIECE_SIZE*5 + disp.x, Board.BOARD_PIECE_SIZE*6).equals(new Vector2(5, 6)));
    }
    
    @Test
    public void clampTest() {
        long executionStamp = System.nanoTime();
    	int testNum = 10000;
    	
    	for (int i = 0; i < testNum; i++) {
    		int m = 20;
    		int n = (int)(Math.random()*m);
    		n = (n + m) % m;
    		
    		if (n >= m || n < 0)
    			assertFalse(true);
    	}
    	
    	System.out.println(System.nanoTime() - executionStamp);
    	assertTrue(true);
    }
}