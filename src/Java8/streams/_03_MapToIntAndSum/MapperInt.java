package Java8.streams._03_MapToIntAndSum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperInt {
    public static void main(String[] args) {
        List<String> namesList= Arrays.asList(
                "Bibhuti","Bhusan","Bonty","Name"
        );

        List<MapperInt.User> userList= namesList
                .stream()
                .filter(MapperInt::startsWithB)
                .map(MapperInt.User::new)
                .collect(Collectors.toList());

        int ageSum=userList
                .stream()
                .mapToInt(user->user.getAge())
                .sum(); // Terminal operation

        System.out.println("Sum of ages of all the filtered person are "+ageSum);
    }

    private static boolean startsWithB(String name) {
        return name.startsWith("B");
    }

    static class User{
        private String name;
        private Integer age=30;

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
