/*
 * Problem: Two Sum
 * Given an array of integers and a target, return the indices
 * of the two numbers that add up to the target.
 * Exactly one solution is guaranteed.
 *
 * Input:  int[] nums = {2, 7, 11, 15}, int target = 9
 * Output: [0, 1]  → nums[0] + nums[1] = 2 + 7 = 9
 *
 * Approach: Brute force — two nested loops, check every pair
 * Time complexity: O(n²)
 */

package array_basics;

import java.util.Arrays;

public class two_sum {

    public static int[] twoSum(int[] nums, int target) {
        // Check every pair (i, j) where j is always ahead of i
        // This avoids using the same element twice and skips duplicate pairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If these two elements add up to target, return their indices
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Arrays.toString() needed because println on an array prints a memory address e.g. [I@6d06d69c
        System.out.println(Arrays.toString(twoSum(nums, target))); // [0, 1]
    }
}