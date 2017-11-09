package memoryparts.OOME;

import java.util.ArrayList;
import java.util.List;

/**
 * Run it with -Xmx10m. JVM will crashed with OOME
 *
 * After that run with -Xmx30m. No crashes
 *
 * Advanced: -XX:+HeapDumpOnOutOfMemoryError
 *
 * Run jhat java_pid8636.hprof
 *
 * See many Integer objects in histo on localhost:7000
 */
public class ClassicOutOfMemoryInHeap {
    public static void main(String[] args) {
        List<Integer> crashedList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            crashedList.add(i);
            System.out.println(i);
        }
    }
}
