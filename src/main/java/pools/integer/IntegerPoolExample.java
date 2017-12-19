package pools.integer;


/**
 * Run with -XX:AutoBoxCacheMax=3000 to include 1000 in integer cache
 * NOTE: this option helps to increase cache size (not reduce)
 */
public class IntegerPoolExample {
    public static void main(String[] args) {
        Integer ten = 10;
        Integer anotherTen = 10;

        // What will be printed?
        System.out.println(ten.equals(anotherTen));
        // true
        System.out.println(ten == anotherTen);
        // true

        Integer thousand = 1000;
        Integer anotherThousand = 1000;

        // What will be printed?
        System.out.println(thousand.equals(anotherThousand));
        // true
        System.out.println(thousand == anotherThousand);
        // false



        // ok, what is about eleven?
        Integer eleven = new Integer(11);
        Integer anotherEleven = new Integer(11);

        // What will be printed?
        System.out.println(eleven.equals(anotherEleven));
        // true
        System.out.println(eleven == anotherEleven);
        // false

        // Yes, it's not String Pool
        // For strings, only compile-time constants are interned - whereas for the wrapper types for integer types, any boxing operation will always use the pool if it's applicable for that value.
    }
}
