package lambda;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaDemo {
    public static void main(String[] args) {

        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        Function<String, String> toUpperCase = name -> name.toUpperCase();
        System.out.println(toUpperCase.apply("alice"));

        Consumer<String> greeting = name -> System.out.println("Hello, " + name + "!");
        greeting.accept("Alice");

        Supplier<String> defaultName = () -> "Unknown";
        System.out.println("Default name: " + defaultName.get());
    }
}
//O/P
//Is 10 even? true
//ALICE
//Hello, Alice!
//Default name: Unknown
