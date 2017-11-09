package reflection.basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassExample4 {


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


        Method getter = 	animalClass1.getDeclaredMethod("getName");
        getter.invoke(animal);

        Method setter = animalClass1.
                getDeclaredMethod("setName", String.class);
        setter.invoke(animal, "Burenka");



        System.out.println(animal.toString());


    }

}
