package memoryparts.OOME;

import beans.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 *
 * Run through java -Xmx1m -Xms1m -XX:+HeapDumpOnOutOfMemoryError  StreamSample
 * -Xmx1m -Xms1m -XX:+HeapDumpOnOutOfMemoryError
 */
public class StreamSample {
    public static void main(String[] args) {

        List list = new ArrayList(1000);

        IntStream.iterate(1, i -> i*10)
                .filter(i -> i % 2 == 0)
                .map(i -> {
                            final Employee[] e = new Employee[i];
                            for (int j = 0; j < e.length; j++) {
                                e[j] = new Employee();
                            }
                            list.add(e);
                            return e.length;
                        }
                )
                .map(elem -> elem * new Integer(ThreadLocalRandom.current().nextInt(10)))
                .forEach(System.out::println);

    }
}
