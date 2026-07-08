public class variable_and_types {

    public static void main(String[] args) {
        // --- declaring variables of different types ---
        int age = 30;            // whole number
        String name = "Mario";   // text

        // --- calling a void method (does something, returns nothing) ---
        greet(name);

        // --- calling methods that RETURN a value, then storing & printing it ---
        int doubled = doubleNumber(age);          // catch the returned int in 'doubled'
        System.out.println("Doubled: " + doubled);

        int cubed = cubeNumber(age);
        System.out.println("Cubed: " + cubed);

        // --- passing two arguments into one method ---
        int num1 = 10, num2 = 30;                 // two ints declared on one line
        int maxNumber = maxNumber(num1, num2);
        System.out.println("maxNumber: " + maxNumber);

        // --- absolute value example ---
        int normalNum = -20;
        int absoluteNumber = absoluteNumber(normalNum);
        System.out.println("absoluteNumber: " + absoluteNumber);
    }

    // takes a String, returns nothing (void) — just prints
    public static void greet(String personName) {
        System.out.println("Hello, " + personName);
    }

    // takes an int, returns that int multiplied by 2
    public static int doubleNumber(int number) {
        return number * 2;
    }

    // takes an int, returns its cube (n × n × n) — fixed from n * 3
    public static int cubeNumber(int number) {
        return number * number * number;
    }

    // returns the larger of two ints using a ternary:
    // (condition) ? valueIfTrue : valueIfFalse
    public static int maxNumber(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    // returns the number without its sign:
    // if it's negative, negate it to make it positive
    public static int absoluteNumber(int normalNum) {
        return (normalNum > 0) ? normalNum : -normalNum;
    }
}
