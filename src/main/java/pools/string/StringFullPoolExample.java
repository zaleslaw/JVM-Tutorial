package pools.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Step 1: Run with  -XX:StringTableSize=3 and get StringTable size of 3 is invalid; must be between 1009 and 2305843009213693951
 * Step 2: -XX:+PrintStringTableStatistics -XX:StringTableSize=1009
 * Step 3: Limit heap with -Xmx20m -XX:+HeapDumpOnOutOfMemoryError and run it with first section - you can see a tiny amount of entries due to GC
 * Step 4: Comment section 1 and uncomment section 2 and run
 * Step 5: As a result get java.lang.OutOfMemoryError: GC overhead limit exceeded and produced hea dump
 * Step 7: Analyze heap dump with $jhat -path-to-file and open on http://localhost:7000/
 * Step 8: Go to http://localhost:7000/showInstanceCounts/includePlatform/ and open instances of String and find there PooledString#countNumber
 */
public class StringFullPoolExample {
    public static void main(String[] args) {

        // 1 section
/*        for (int i = 0; i < 1_000_000; i++) {
            new String(new Integer(i).toString()).intern();
        }*/

        // 2 section
        List<String> cachedString = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            cachedString.add(new String("PooledString" + new Integer(i).toString()).intern());
        }

        // What is about?
        System.out.println(new String("Budapest").intern() == "Budapest"); //true

    }
}
