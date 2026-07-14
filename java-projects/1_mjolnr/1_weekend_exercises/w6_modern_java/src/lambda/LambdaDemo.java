/*
 * Topic: Lambdas and Functional Interfaces
 * Lambdas are shorthand functions — same as JS arrow functions.
 * Java has 4 built-in functional interfaces, each with one fixed method:
 *
 * Predicate<T>     — takes T, returns boolean   → .test()
 * Function<T, R>   — takes T, returns R          → .apply()
 * Consumer<T>      — takes T, returns nothing    → .accept()
 * Supplier<T>      — takes nothing, returns T    → .get()
 *
 * Examples:
 * Predicate<Integer> isEven = n -> n % 2 == 0;   isEven.test(10) → true
 * Function<String, String> upper = s -> s.toUpperCase();  upper.apply("alice") → "ALICE"
 * Consumer<String> greet = s -> System.out.println("Hello, " + s + "!");
 * Supplier<String> name = () -> "Unknown";   name.get() → "Unknown"
 *
 * Output:
 * Is 10 even? true
 * ALICE
 * Hello, Alice!
 * Default name: Unknown
 */
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
