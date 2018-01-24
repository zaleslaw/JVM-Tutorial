package memoryparts.stack;

/**
 *  The main idea is calling of StringBuilder on " " + this.toString and self-recursion.
 *  To explain the recursion effect uncomment row #12
 */
public class StackOverflowExample2 {

    static class StrangeClass {
        String val;
        public String toString() {
            System.out.println("To string calling");
            return val + this; // " " + this.toString
        }
    }

    public static void main(String[] args) {
        System.out.println(new StrangeClass());
    }
}

