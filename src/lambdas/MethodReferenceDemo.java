package lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        Stream.of(3,1,4,1,5,9)
                .forEach(System.out::println);

        Stream.of(3,1,4,1,5,9)
                .forEach(x -> System.out.println(x));

        Consumer<Integer> printer = System.out::println;
        Stream.of(3,1,4,1,5,9)
                .forEach(printer);

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        Stream.of("this", "is", "a", "stream", "of", "strings")
                .mapToInt(String::length)
                .forEach(System.out::println);

        Stream.of("this", "is", "a", "stream", "of", "strings")
                .mapToInt((s) -> s.length())
                .forEach(x -> System.out.println(x));

        List<String> sorted = Stream.of("this", "is", "a", "list", "of", "strings")
                .sorted((o1, o2) -> o1.compareTo(o2))
                .collect(Collectors.toList());
        System.out.println(sorted);

        sorted = Stream.of("this", "is", "a", "list", "of", "strings")
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sorted);

    }
}
