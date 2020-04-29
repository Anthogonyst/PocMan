package Maestus.PocMan;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implements JUnit 4 to unit test each file in a framework
 * @author Oracle
 *
 */
public class UnitTest {

    private Direction one;
    private Direction two;

    @Before
    public void setup() {
        one = Direction.RIGHT;
        two = Direction.LEFT;
    }

    //@Ignore
    @Test
    public void backwardsDirection() {
        assertEquals(one, Direction.backwards(two));
    }
}