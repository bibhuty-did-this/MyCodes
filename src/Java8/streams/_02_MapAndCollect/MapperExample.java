package Java8.streams._02_MapAndCollect;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {

    public static void main(String[] args) {
        List<String> namesList= Arrays.asList(
                "Bibhuti","Bhusan","Bonty","Name"
        );

        // Mapper example
        namesList
                .stream()
                .filter(MapperExample::startsWithB)
                .map(User::new) // Functional interface inside it
                .forEach(System.out::println); // Terminal operation(nothing allowed after that)
        // Collector example
        List<User> users= namesList
                .stream()
                .filter(MapperExample::startsWithB)
                .map(User::new)
                .collect(Collectors.toList()); // Terminal operation(nothing allowed after that)
    }

    private static boolean startsWithB(String name) {
        return name.startsWith("B");
    }

    static class User{
        private String name;
        private Integer age;

        public User(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
