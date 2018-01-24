package memoryparts.stack;

/**
 * Exception in thread "main" java.lang.StackOverflowError without recursion
 */
public class StackOverflowExample1 {
    public static void main(String[] args) {
        a();
        b();
    }

    private static void a() {
        System.out.println("Method a was called");
        b();
    }

    private static void b() {
        System.out.println("Method b was called");
        a();
    }
}
