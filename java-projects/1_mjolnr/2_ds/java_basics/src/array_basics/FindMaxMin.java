/*
 * Problem: Find Max and Min
 * Given an array of integers, find and return the largest and smallest values.
 *
 * Input:  int[] nums = {3, 1, 7, 2, 9}
 * Output: Max: 9, Min: 1
 *
 * Example 2:
 * Input:  int[] nums = {-5, 0, 3, -1, 8}
 * Output: Max: 8, Min: -5
 *
 * Approach: Walk through the array once, track the current max and min
 * Time complexity: O(n)
 */
package array_basics;

import java.util.Arrays;

public class FindMaxMin {

    public static int[] fnFindMaxMin(int[] numbers) {
        // Start both max and min at the first element
        // If we used 0, negative arrays would give wrong results
        int max = numbers[0];
        int min = numbers[0];

        // Walk through the array, updating max and min as we go
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        return new int[]{max, min}; // [max, min]
    }

    public static void main(String[] args) {
        int[] nums = {-5, 0, 3, -1, 8};
        // Arrays.toString() needed — println on an array prints a memory address
        System.out.println(Arrays.toString(fnFindMaxMin(nums))); // [8, -5]
    }
}