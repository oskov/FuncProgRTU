import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumTest {

    @Test
    void superDigit() {
        assertEquals(29, DigitSum.superDigit(9875));
        assertEquals(5, DigitSum.superDigit(5));
    }
}