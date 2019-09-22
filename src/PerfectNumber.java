import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {
    private static final HashMap<Integer, STATE> map = new HashMap() {{
        put(-1, STATE.DEFICIENT);
        put(0, STATE.PERFECT);
        put(1, STATE.ABUNDANT);
    }};

    public enum STATE {
        ABUNDANT, DEFICIENT, PERFECT;
    }

    public static PerfectNumber.STATE process(int number) {
        return map.get(getKeyValue(divisors(number).stream().mapToInt(i -> i).sum() / 2 - number));
    }

    public static Set<Integer> divisors(int number) {
        Set<Integer> result = IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(x -> number % x == 0)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> afterSqrt = result.stream()
                .map(x -> number / x)
                .collect(Collectors.toSet());
        result.addAll(afterSqrt);
        return result;
    }

    private static int getKeyValue(int difference) {
        return boolToInt(isBelowZero(difference)) * -1 + boolToInt(isAboveZero(difference));
    }

    private static int boolToInt(boolean b) {
        return Boolean.compare(b, false);
    }

    private static boolean isBelowZero(int difference) {
        return difference < 0;
    }

    private static boolean isAboveZero(int difference) {
        return difference > 0;
    }

}