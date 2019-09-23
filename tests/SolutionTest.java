import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void powerSum() {
        assertEquals(1, Solution.powerSum(13, 2));
        assertEquals(3, Solution.powerSum(100, 2));
        assertEquals(1, Solution.powerSum(35, 2));
    }
}