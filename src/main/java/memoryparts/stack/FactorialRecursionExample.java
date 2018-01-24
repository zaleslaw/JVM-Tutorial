package memoryparts.stack;

import java.math.BigInteger;

public class FactorialRecursionExample {
    public static void main(String[] args) {
        System.out.println(factorial(100000));
    }

    private static BigInteger factorial(int n) {
        if(n < 2) return BigInteger.valueOf(1);
        else return BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}
