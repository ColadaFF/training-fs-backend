package co.edu.ff.orders;

import co.edu.ff.orders.user.domain.UserAuthRequest;
import co.edu.ff.orders.user.domain.Username;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Luis", 30),
                new Person("Andrés", 28),
                new Person("Juan", 18),
                new Person("Mateo", 21)
        );

        Function<Person, Boolean> isOlderThan21 = person -> person.getAge() > 21;
        Map<Boolean, List<Person>> collect = people.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.groupingBy(isOlderThan21));


        System.out.println(collect);


        Stream.of(
                Pair.of(Username.of("username"), "password"),
                Pair.of(Username.of("username"), "password")
        )
        .map(tuple -> {
            Username left = tuple.getLeft();
            String password = tuple.getRight();
            return UserAuthRequest.from(left, password);

        });

    }



    public static class Person {
        private final String name;
        private final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("{name: %s, age: %s}", name, age);
        }
    }
}
