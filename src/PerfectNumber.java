import java.util.Set;
import java.util.TreeSet;

public class PerfectNumber {
    public enum STATE {
        ABUNDANT, DEFICIENT, PERFECT;
    }

    public static PerfectNumber.STATE process(int number) {
        Set<Integer> divisors = PerfectNumber.divisors(number);
        Integer[] array = divisors.toArray(new Integer[0]);
        int sum = 0;

        for (int i = 0; i < array.length - 1; i++) {
            sum += array[i];
        }

        if (sum < number) {
            return STATE.DEFICIENT;
        } else if (sum > number) {
            return STATE.ABUNDANT;
        } else {
            return STATE.PERFECT;
        }
    }

    public static Set<Integer> divisors(int number) {
        TreeSet<Integer> result = new TreeSet<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }

        return result;
    }
}