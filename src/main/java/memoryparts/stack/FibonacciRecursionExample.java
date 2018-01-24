package memoryparts.stack;

/** It's more difficult to achieve StackOverflow recursion in opposite Factorial Recursion. What's the reason?
 * The reason is calculating from the zero of all elements  */
public class FibonacciRecursionExample {
    public static void main(String[] args) {
        System.out.println(fibonacci(20));
    }

    private static long fibonacci(int n) {
        System.out.println("Calc n = " + n);
        if(n < 1) return 0;
        else if(n == 1) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}
