package reflection.basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassExample3 {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> animalClass1 = Animal.class;
        //Class<?> animalClass2 = Class.forName("Fish");
        System.out.println(animalClass1);

        System.out.println(animalClass1.getCanonicalName());



        Object animal = 	animalClass1.newInstance();
        System.out.println(animal.toString());


        Constructor<?> animalConstructor = 	animalClass1.getConstructor(String.class);
        animal = animalConstructor.newInstance("Sharik");

        System.out.println(animal.toString());


        Field nameField = 	animalClass1.getDeclaredField("name");

        nameField.setAccessible(true);
        nameField.set(animal, "Murka");
        nameField.get(animal);

        System.out.println(animal.toString());


    }

}
