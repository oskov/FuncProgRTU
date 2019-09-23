import java.util.HashMap;

public class Solution {
    private static final HashMap<Integer, Integer> cache= new HashMap<>();

    public static int powerSum(int X, int N, int number) {
        int power;
        if (cache.containsKey(number)) {
            power = cache.get(number);
        } else {
            power = (int) Math.pow(number, N);
            cache.put(number, power);
        }
        if (X < power) {
            return 0;
        } else if (X == power) {
            return 1;
        } else {
            return powerSum(X - power, N, number + 1) + powerSum(X, N, number + 1);
        }
    }

    public static int powerSum(int X, int N) {
        return powerSum(X, N, 1);
    }
}
