package exercises;



public class PrimeNumber {

    public static void main(String[] args) {
        int testPrimeNum=23;
        System.out.println(isPrime(testPrimeNum));
    }

    public static boolean isPrime(int number) {
        // numbers below 2 are not prime (0, 1, negatives)
        if (number < 2) {
            return false;
        }

        // assume prime until proven otherwise
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;   // found a divisor — definitely NOT prime, stop now
            }
        }

        return true;   // loop finished, no divisor found — it IS prime
    }
}
