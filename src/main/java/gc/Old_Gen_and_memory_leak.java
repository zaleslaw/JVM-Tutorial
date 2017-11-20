package gc;

import java.util.ArrayList;
import java.util.List;

public class Old_Gen_and_memory_leak {
    public static void main(String[] args) {
        List objectPool = new ArrayList();
        while (true) {
            objectPool.add(new byte[1024]);
        }
    }
}
