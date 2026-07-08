package exercises;

public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz();   // run the FizzBuzz logic
    }

    public static void fizzBuzz() {
        // loop through numbers 1 to 100 (inclusive)
        for (int i = 1; i <= 100; i++) {

            // check the "both" case FIRST — divisible by 3 AND 5.
            // if we checked 3 or 5 first, this case would never be reached.
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");

                // divisible by 3 only
            } else if (i % 3 == 0) {
                System.out.println("Fizz");

                // divisible by 5 only
            } else if (i % 5 == 0) {
                System.out.println("Buzz");

                // not divisible by 3 or 5 — print the number itself
            } else {
                System.out.println(i);
            }
        }
    }
}