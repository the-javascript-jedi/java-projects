package week5_exceptions.exceptions;

public class ExceptionDemo {

    public static void main(String[] args) {

        // withdraw() call #1: succeeds, no exception thrown, no try/catch needed
        withdraw(1120.00, 400.00);

        // withdraw() call #2: amount exceeds balance, so withdraw() throws
        // IllegalArgumentException. We wrap the call to catch it here.
        try {
            withdraw(20.00, 400.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        // 1. ArrayIndexOutOfBoundsException: array has 3 elements (valid indexes 0-2),
        // accessing index 10 is out of bounds.
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of range: the array has only 3 elements.");
        } finally {
            // finally always runs, whether or not an exception was thrown
            System.out.println("Array example finished.");
        }

        // 2. NumberFormatException: "abc" is not a valid integer string
        try {
            int number = Integer.parseInt("abc");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("\"abc\" cannot be converted to an integer.");
        }

        // 3. ArithmeticException: integer division by zero is not allowed
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide a number by zero.");
        }
    }

    // Throws its own exception instead of catching it, so the caller decides
    // how to handle a failed withdrawal.
    public static void withdraw(double balance, double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        System.out.println("Withdrawn: " + amount);
    }
}
//O/P
//Withdrawn: 400.0
//Exception Insufficient funds
//Index out of range: the array has only 3 elements.
//Array example finished.
//"abc" cannot be converted to an integer.
//Cannot divide a number by zero.