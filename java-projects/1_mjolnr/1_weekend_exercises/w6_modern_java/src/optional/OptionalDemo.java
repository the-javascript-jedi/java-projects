package optional;

import java.util.Optional;

public class OptionalDemo {
/**Create an Optional<String> with a value "Nithin"
 Create an Optional<String> that is empty
 Check isPresent() on both and print
 Use orElse() on the empty one to return "Guest"
 Use ifPresent() to print the name in uppercase
 Create an Optional<String> with ofNullable() — pass null and use orElse()*/

    public static void main(String[] args){
        // Optional.of() wraps a non-null value. Throws NullPointerException if you pass null -
        // use it only when you're sure the value can never be null.
        Optional<String> name=Optional.of("Batman");
        // Optional.empty() gives back a shared, reusable empty Optional - represents "no value".
        Optional<String> emptyName =Optional.empty();

        // isPresent() tells you whether the Optional holds a value (true) or is empty (false).
        boolean nameIsPresent=name.isPresent();
        boolean emptyIsPresent=emptyName .isPresent();
        System.out.println("nameIsPresent: "+name.isPresent());
        System.out.println("emptyIsPresent: "+emptyName .isPresent());
        // orElse() returns the contained value if present, otherwise falls back to the given default.
        // Since emptyName has no value, this returns "Guest".
        String guestName = emptyName.orElse("Guest");
        System.out.println("Name: " + guestName);

        // ifPresent() runs the lambda only if a value exists; does nothing if the Optional is empty.
        // This avoids manually checking isPresent() then calling get().
        name.ifPresent(value -> System.out.println(value.toUpperCase()));
        // ofNullable() is a safe way to wrap a value that might be null: if the argument is null,
        // it produces Optional.empty() instead of throwing (unlike Optional.of()).
        Optional<String> nullableName = Optional.ofNullable(null);
        System.out.println("Nullable name: " + nullableName.orElse("Guest"));
    }
}
//O/P
//nameIsPresent: true
//emptyIsPresent: false
//Name: Guest
//        BATMAN
//Nullable name: Guest

