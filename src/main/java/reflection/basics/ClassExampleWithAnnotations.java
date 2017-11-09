package reflection.basics;




import java.lang.reflect.InvocationTargetException;

public class ClassExampleWithAnnotations {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> animalClass1 = reflection.basics.annotation.intro.AnnotatedClass.class;
        //Class<?> animalClass2 = Class.forName("Fish");
        System.out.println(animalClass1);

        System.out.println(animalClass1.getDeclaredAnnotations());




        Object animal = 	animalClass1.newInstance();
        System.out.println(animal.toString());





    }
}
