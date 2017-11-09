package classloading;


interface Animal {
    default void see() {
        System.out.println("I see something edible");
    }
}

class Dinosaur implements Animal {
    static {
        System.out.println("I'm ancient creature");
    }
}

class TRex extends Dinosaur {
    static {
        System.out.println("My poor short hands");
    }
}

/**
 * Add  -XX:+TraceClassLoading
 */
public class ClassHierarchyLoading {
    public static void main(String[] args) {
        // Step - 1
         new TRex().see();
        /*
         Question: what will be printed?

         All classes from rt.jar +

         [Loaded classloading.Animal from file:/C:/home/Projects/JVM-Tutorial/target/classes/]
         [Loaded classloading.Dinosaur from file:/C:/home/Projects/JVM-Tutorial/target/classes/]
         [Loaded classloading.TRex from file:/C:/home/Projects/JVM-Tutorial/target/classes/]
          I'm ancient creature
          My poor short hands
          I see something edible

          */
        // Step - 2: Comment previous code row and run next
         new Dinosaur().see();
        /*
         Question: what will be printed?

         All classes from rt.jar +

         [Loaded classloading.Animal from file:/C:/home/Projects/JVM-Tutorial/target/classes/]
         [Loaded classloading.Dinosaur from file:/C:/home/Projects/JVM-Tutorial/target/classes/]
          I'm ancient creature
          I see something edible

          */
        // Step - 3: Comment previous code rows and run next
         /*
         Question: what will be printed?

         All classes from rt.jar + nothing about your classes and their print outs

          */

    }
}
