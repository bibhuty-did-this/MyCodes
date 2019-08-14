package Java8.streams._04_FlatMapAndOptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlatMapExample {
    public static void main(String[] args) {
        List<User> userList= Arrays.asList(
            new User("User1",30,Arrays.asList("1","2","3")),
            new User("User2",40,Arrays.asList("4","5","6")),
            new User("User3",50,Arrays.asList("8","7","9")),
            new User("User4",20,Arrays.asList("10","12","11"))
        );

        Optional<String> phoneNumberStream=userList
                .stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(
                        phoneNumbers->phoneNumbers.filter(phoneNo->phoneNo.equals("1"))
                ) // Converts stream of one type to another
                .findAny();

        phoneNumberStream.ifPresent(System.out::println);

    }

    static class User{
        private String name;
        private Integer age;
        private List<String> phoneNumbers;

        public User(String name){
            this.name=name;
        }

        public User(String name, Integer age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
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


        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", phoneNumbers=" + phoneNumbers +
                    '}';
        }
    }
}
