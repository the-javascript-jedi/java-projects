/*
 * Problem: Largest and Smallest Element in an Array
 * Given an array of integers, find both the largest and smallest elements.
 *
 * Input:  int[] nums = {2, 101, 20, 3, 44, 1}
 * Output: [101, 1]  (max, min)
 *
 * Approach: Track running max and min — both start at nums[0], scan the
 * rest of the array, updating max whenever a bigger element is found and
 * min whenever a smaller element is found.
 * Time complexity: O(n)
 */
package progression.arrays;

import java.util.Arrays;

public class LargestAndSmallestArrayElement {

    public int[] findLargestAndSmallestArrayElement(int[] nums) {
        // Guard against invalid input — nums[0] below would throw otherwise
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must not be null or empty");
        }

        // Start with the first element as both the current max and min
        int max = nums[0];
        int min = nums[0];

        // Scan the rest of the array, updating max or min as we go.
        // Safe to use else-if here: min <= max always holds, so an
        // element smaller than min can never also be greater than max.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        LargestAndSmallestArrayElement large = new LargestAndSmallestArrayElement();
        int[] nums = {2, 101, 20, 3, 44, 1};
        System.out.println("findLargestAndSmallestArrayElement :"+Arrays.toString(large.findLargestAndSmallestArrayElement(nums))); // [101, 1]
    }
}
