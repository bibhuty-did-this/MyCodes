package Java8.Reflections._01_Intro;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class Sample{

    public static void main(String[] args){

        // class object
        Class PersonClass=Person.class;

        // field object
        System.out.println("FIELD OBJECTS ARE: ");
        Field[] fields=PersonClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);

        // method objects
        System.out.println("\nMETHOD OBJECTS ARE: ");
        Method[] methods=Person.class.getMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

    class Person{
        String firstName;
        String lastName;
        Integer age;

        @Override
        public String toString(){
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(firstName, person.firstName) &&
                    Objects.equals(lastName, person.lastName) &&
                    Objects.equals(age, person.age);
        }

        @Override
        public int hashCode(){
            return Objects.hash(firstName, lastName, age);
        }

        public Person(Person other){
            this.firstName = other.firstName;
            this.lastName = other.lastName;
            this.age = other.age;
        }

        public String getFirstName(){
            return firstName;
        }

        public void setFirstName(String firstName){
            this.firstName = firstName;
        }

        public String getLastName(){
            return lastName;
        }

        public void setLastName(String lastName){
            this.lastName = lastName;
        }

        public Integer getAge(){
            return age;
        }

        public void setAge(Integer age){
            this.age = age;
        }

        private void writeHello(){
            System.out.println("Hello");
        }
    }
}

