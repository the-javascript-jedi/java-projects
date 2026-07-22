/*
 * Problem: Largest Element in an Array
 * Given an array of integers, find the largest element.
 *
 * Input:  int[] nums = {2, 101, 20, 3, 44}
 * Output: 101
 *
 * Approach: Track the running max — start at nums[0], scan the rest
 * of the array, updating max whenever a bigger element is found.
 * Time complexity: O(n)
 */
package progression.arrays;

public class LargestArrayElement {

    public int findLargestArrayElement(int[] nums) {
        // Guard against invalid input — nums[0] below would throw otherwise
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must not be null or empty");
        }

        // Start with the first element as the current max
        int max = nums[0];

        // Scan the rest of the array, updating max as we go
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestArrayElement large = new LargestArrayElement();
        int[] nums = {2, 101, 20, 3, 44};
        System.out.println(large.findLargestArrayElement(nums)); // 101
    }
}
