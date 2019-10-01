
public class DigitSum {

    static long superDigit(long x) {
        if (x == 0 ) {
            return 0;
        }
        return x % 10 + superDigit(x / 10);
    }

}
