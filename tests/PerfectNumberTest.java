import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectNumberTest {

    @Test
    public void test6Perfect() {
        assertEquals(PerfectNumber.STATE.PERFECT, PerfectNumber.process(6));
    }

    @Test
    public void test8Deficient() {
        assertEquals(PerfectNumber.STATE.DEFICIENT, PerfectNumber.process(8));
    }

    @Test
    public void test20Abundant() {
        assertEquals(PerfectNumber.STATE.ABUNDANT, PerfectNumber.process(20));
    }

    @Test
    public void test16DeficientWithIntSqrt() {
        assertEquals(PerfectNumber.STATE.DEFICIENT, PerfectNumber.process(16));
    }

    @Test
    public void test1Deficient() {
        assertEquals(PerfectNumber.STATE.DEFICIENT, PerfectNumber.process(1));
    }

    @Test
    public void testDivisors1() {
        Object[] expected = new Integer[]{1};
        int n = 1;
        assertArrayEquals(expected, PerfectNumber.divisors(n).toArray());
    }

    @Test
    public void testDivisors6() {
        Object[] expected = new Integer[]{1, 2, 3, 6};
        int n = 6;
        assertArrayEquals(expected, PerfectNumber.divisors(n).toArray());
    }

    @Test
    public void testDivisors8() {
        Object[] expected = new Integer[]{1, 2, 4, 8};
        int n = 8;
        assertArrayEquals(expected, PerfectNumber.divisors(n).toArray());
    }
}
