package reflection.basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassExample2 {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> animalClass1 = Animal.class;
        //Class<?> animalClass2 = Class.forName("Fish");
        System.out.println(animalClass1);

        Object animal = 	animalClass1.newInstance();
        System.out.println(animal.toString());


        Constructor<?> animalConstructor = 	animalClass1.getConstructor(String.class);
        animal = animalConstructor.newInstance("Sharik");

        System.out.println(animal.toString());

    }

}
