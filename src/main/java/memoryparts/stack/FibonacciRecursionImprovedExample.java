package memoryparts.stack;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/** It's easy to reproduce StackOverflow with caching of repeatable calculation.
 *  But the limit is around 5000th Fibonacci number on my current machine (depends on your machine)
 *  Let's increase the stack size with option -Xss10m and get possibility to calculate 20000th Fibonacci number, for example
 *
 *  Of course, you should use BigInteger instead long due to type ranges.
 */
public class FibonacciRecursionImprovedExample {
    private static Map<Integer, BigInteger> cache = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(fibonacci(20000));
    }

    private static BigInteger fibonacci(int n) {
        System.out.println("Calc n = " + n);

        if(n <= 0) return BigInteger.ZERO;
        else if(n == 1) return BigInteger.ONE;

        if(cache.containsKey(n)) return cache.get(n);
        else {
            final BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
            cache.put(n, result);
            System.out.println("Result is " + result);
            return result;
        }
    }
}
