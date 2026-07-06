package exercises;

public class SumTo {

    // adds up 1 + 2 + ... + n and returns the total
    public static int sumTo(int n) {
        int sum = 0;                       // running total, declared OUTSIDE the loop
        for (int i = 0; i <= n; i++) {     // walk through the numbers up to n
            sum = sum + i;                 // add the current number to the total
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumTo(10));     // 55  (1+2+...+10)
        System.out.println(sumTo(5));      // 15  (1+2+3+4+5)
        System.out.println(sumTo(1));      // 1
        System.out.println(sumTo(0));      // 0   (loop adds only 0)
        System.out.println(sumTo(100));    // 5050
    }
}