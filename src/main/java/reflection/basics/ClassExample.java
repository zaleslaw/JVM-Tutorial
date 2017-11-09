package reflection.basics;

public class ClassExample {

    class AbstractAnimal {}

    private final class Animal1 extends AbstractAnimal implements Cloneable {}

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> animalClass1 = Animal1.class;
        //Class<?> animalClass2 = Class.forName("Fish");
        System.out.println(animalClass1);

        System.out.println(animalClass1.getSuperclass().getCanonicalName());
        final Class<?>[] interfaces = animalClass1.getInterfaces();
        for (Class<?> inter : interfaces){
            System.out.println(inter.getCanonicalName());
        }
    }

}
