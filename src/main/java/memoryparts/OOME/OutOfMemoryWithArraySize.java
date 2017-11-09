package memoryparts.OOME;

import java.util.ArrayList;
import java.util.List;

/**
 * Run it with -Xmx10m. JVM will crashed with classic OOME
 */
public class OutOfMemoryWithArraySize {
    public static void main(String[] args) {
        // Step - 1: Run it with -Xmx10m. JVM will crashed here with classic OOME
        int[] arr1 = new int[10_000_000];
        System.out.println("Arr1 has " + arr1.length + " elements");
        // Step - 2: Run with -Xmx1024m. JVM will crashed here with classic OOME
        int[] arr2 = new int[Integer.MAX_VALUE-2];
        System.out.println("Arr2 has " + arr2.length + " elements");
        // Step - 3: Run with -Xmx16000m. JVM will crashed here with Requested array size exceeds VM limit
        int[] arr3 = new int[Integer.MAX_VALUE-1];
        System.out.println("Arr3 has " + arr3.length + " elements");
    }
}
