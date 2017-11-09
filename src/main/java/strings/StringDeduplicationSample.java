package strings;

import java.util.LinkedList;
import java.util.List;

/**
-Xmx256m -XX:+UseG1GC

 it fails after 30 iterations

and with

-Xmx256m -XX:+UseG1GC -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics

and it fail after 50 iteration
 */

// TODO: reduce max heap size nad rewrite to one-level cycle
public class StringDeduplicationSample {
 
  private static final List<String> objects = new LinkedList<>();
 
  public static void main(String[] args) throws Exception {
    int iteration = 0;
    while (true) {
      for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 1000; j++) {
          objects.add(new String("String " + j));
        }
      }
      iteration++;
      System.out.println("Survived Iteration: " + iteration);
      Thread.sleep(100);
    }
  }
}