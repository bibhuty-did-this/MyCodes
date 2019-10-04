package Java8.Reflections._02_Classes;


import Java8.Reflections.Data.Cat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sample{
    public static void main(String[] args) throws ClassNotFoundException{
        // The class object
        Class catObject= Cat.class;
        Class animalObject=Class.forName("Java8.Reflections.Data.Animal");
        System.out.println(
                "The name of catObject is "+catObject+"\n"+
                "The name of animalObject is "+animalObject
        );

        // Getting the fully qualified class name
        System.out.println("\nThe fully classified name of `Cat` class is "+Cat.class.getName());

        // Getting the simple name of the class
        System.out.println("\nThe simple name of `Cat` class is "+Cat.class.getSimpleName());

        // Getting modifiers
        // The modifiers are packed into an int where each modifier is a flag bit that is either set or
        // cleared. Following methods could be used to get the same
        int modifiers=catObject.getModifiers();
        System.out.println("\nmodifiers has the value: "+modifiers);
        System.out.println("Let's see if public modifiers are present: "+Modifier.isPublic(modifiers));

        // Getting package info
        Package packageInfo=catObject.getPackage();
        System.out.println("\nThe package info for `Cat` class is "+packageInfo);

        // Superclass information
        Class superClassOfCat=catObject.getSuperclass();
        System.out.println("\nSuperclass of `Cat` class is "+superClassOfCat);

        // Getting information of implemented interfaces of immediate class
        // (doesn't include interfaces of superclass)
        System.out.println("\nAlthough the superclass of cat implements an interface" +
                " but the interfaces of `Cat` using reflections are "+
                Arrays.stream(catObject.getInterfaces()).collect(Collectors.toList())
        );
        System.out.println("Now time to get the interfaces of superclass"+
                Arrays.stream(animalObject.getInterfaces()).collect(Collectors.toList()));

        // Getting constructor information
        Constructor[] constructors=catObject.getConstructors();
        System.out.println("\nConstructor(s) inside `Cat` class is ");
        Arrays.stream(constructors).forEach(System.out::println);

        // Getting methods inside a class
        Method[] methods=catObject.getMethods();
        System.out.println("\nMethods inside `Cat` class are: ");
        Arrays.stream(methods).forEach(System.out::println);

        // Fields inside a class(only public fields)
        Field[] fields=catObject.getFields();
        System.out.println("\nFields inside a class");
        Arrays.stream(fields).map(Field::getName).forEach(System.out::println);

        // Getting annotations(annotations in class level not in field)
        Annotation[] annotations=catObject.getAnnotations();
        System.out.println("\nAnnotations inside a class");
        Arrays.stream(annotations).forEach(System.out::println);
    }
}
