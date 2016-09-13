package block_2_JUnit;

import static org.junit.Assert.*;

import org.junit.*;

public class MathFuncTest {
    private MathFunc math;

    @Before
    public void init() { math = new MathFunc(); }
    @After
    public void tearDown() { math = null; }

    @Test
    public void calls() {
        assertEquals(0, math.getCalls());

        math.factorial(1);
        assertEquals(1, math.getCalls());

        math.factorial(1);
        assertEquals(2, math.getCalls());
    }

    @Test
    public void factorial() {
        assertTrue(math.factorial(0) == 1);
        assertTrue(math.factorial(5) == 120);
        assertTrue(math.factorial(8) == 40320);
        assertFalse(math.factorial(5) == 121);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        math.factorial(-1);
    }

    @Test
    public void todo() {
        assertFalse(math.plus(1, 1) == 3);
    }
}