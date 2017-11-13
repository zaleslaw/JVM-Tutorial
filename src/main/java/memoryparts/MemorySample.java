package memoryparts;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * JVM starts with 1/4 of available memory
 * -Xmx1024m -Xms512m
 *
 * Run with -XX:+HeapDumpOnOutOfMemoryError
 */

// TODO: rewrite sample and add more comments
public class MemorySample {
    public static void main(String[] args) throws MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {

        int mb = 1024 * 1024;
        byte[][] arr = new byte[mb][1000]; // used 100 mb

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        //Print used memory
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        //Print free memory
        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);

        //Print total available memory
        // It is possible to read the default JVM heap size programmatically by using totalMemory() method of Runtime class.
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);

        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);


        // Java should have implementation for your platform
        com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean)
                ManagementFactory.getOperatingSystemMXBean();
        long physicalMemorySize = os.getTotalPhysicalMemorySize();

        System.out.println(physicalMemorySize/mb);

        // Another way to monitor
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        Long attribute = (Long) mBeanServer.getAttribute(new ObjectName("java.lang","type","OperatingSystem"), "TotalPhysicalMemorySize");
        System.out.println("Total memory: "+ (attribute/mb) +" B");
    }

}
