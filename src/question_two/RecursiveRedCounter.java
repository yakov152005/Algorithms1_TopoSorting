package question_two;

import java.util.HashMap;
import java.util.Map;

public class RecursiveRedCounter {

    static Map<String, Integer> memo = new HashMap<>();

    public static int countEvenRed(int n, boolean even) {
        if (n == 0) return even ? 1 : 0;

        String key = n + "-" + even;
        if (memo.containsKey(key)) return memo.get(key);


        int red = countEvenRed(n - 1, !even);


        int other = 2 * countEvenRed(n - 1, even);

        int result = red + other;
        memo.put(key, result);
        return result;
    }

}
