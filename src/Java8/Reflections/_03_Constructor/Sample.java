package Java8.Reflections._03_Constructor;

import Java8.Reflections.Data.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sample{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{

        // Constructor object(only fetches the public constructors)
        Class catClass= Cat.class;
        Constructor[] constructors=catClass.getConstructors();
        System.out.println("All the public constructors are: ");
        Arrays.stream(constructors).forEach(System.out::println);

        // Getting a particular constructor
        System.out.println("Getting the no argument constructor");
        Constructor noArgsConstructor=catClass.getConstructor(new Class[]{});
        System.out.println(noArgsConstructor);

        // Getting the parameters of constructor
        System.out.println("\nParameters of constructors are: ");
        Arrays.stream(constructors)
                .collect(Collectors.toMap(
                    constructor->constructor,
                    constructor->constructor.getParameterTypes()
                    )
                ).forEach(
                        (k,v)-> System.out.println(
                                    k.getName()+
                                    " -- "+
                                    Arrays.stream(v).collect(Collectors.toList())
                                )
                );

        // Instantiating objects using constructor object
        Cat cat= (Cat) noArgsConstructor.newInstance();
        System.out.println("After instantiation cat object is "+cat.toString());

    }
}
