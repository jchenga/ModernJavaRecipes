package functionpackage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;

public class ImplementSupplier {
    public static void main(String[] args) {
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };

        // Lambda expression
        randomSupplier = () -> Math.random();

        // Method reference
        randomSupplier = Math::random;

        System.out.println(randomSupplier.getAsDouble());

        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara", "Zoe", "Jayne",
                "Simon", "River", "Shepherd Book");

        Optional<String> first = names.stream()
                                    .filter(name -> name.startsWith("C"))
                                    .findFirst();
        System.out.println(first);
        System.out.println(first.orElse("None"));

        System.out.println(first.orElse(String.format("No result found in %s", names.stream().collect(Collectors.toList()))));

        System.out.println(first.orElseGet(() -> String.format("No result found in %s", names.stream().collect(Collectors.toList()))));

    }
}
