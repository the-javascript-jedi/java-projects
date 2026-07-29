/*
 * Problem: Count Even and Odd Elements in an Array
 * Given an array of integers, count how many elements are even and how
 * many are odd.
 *
 * Input:  int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
 * Output: [5, 6]  (evenCount, oddCount)
 *
 * Approach: Scan the array once, checking each element's remainder when
 * divided by 2 — incrementing evenCount when it's 0, oddCount otherwise.
 * Time complexity: O(n)
 */
package progression.arrays;

public class CountEvenOdd {
    public static int[] countEvenOdd(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return new int[]{evenCount, oddCount};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] result = countEvenOdd(nums);
        System.out.println("Even Count:" + result[0]);
        System.out.println("Odd Count:" + result[1]);
    }
}
