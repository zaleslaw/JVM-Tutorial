package pools.string;

/**
 *
 */
public class StringPoolingExample {
    public static void main(String[] args) {
        System.out.println(new String("London") == new String("London"));  // false
        System.out.println(new String("Moscow").equals(new String("Moscow"))); // true


        // What is about?
        System.out.println("Paris" == "Paris"); // true
        // Why true?

        // Answer: the reason is String Pool
        // To put in String pool is easy with intern() cal
        System.out.println(("War" + "saw").intern() == "Warsaw");          // true

        // What is about?
        System.out.println(new String("Budapest").intern() == "Budapest"); //true

        System.out.println("Budapest".intern());

    }
}
