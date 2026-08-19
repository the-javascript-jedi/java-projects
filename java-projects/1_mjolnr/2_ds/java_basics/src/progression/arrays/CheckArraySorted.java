/*
 * Problem: Check if an Array is Sorted
 * Given an array of integers, determine whether it is sorted in
 * ascending order.
 *
 * Input:  int[] nums = {1, 3, 4, 5, 12, 21, 22}
 * Output: true
 *
 * Approach: Walk the array comparing each element to its neighbor.
 * We check for the "false" case (nums[i] > nums[i + 1]) first because
 * a single out-of-order pair is enough to prove the array isn't sorted
 * — we can return false immediately without scanning the rest, whereas
 * "sorted" can only be confirmed after every pair has been checked.
 * Time complexity: O(n), with early exit on the first inversion found.
 */
package progression.arrays;

public class CheckArraySorted {

    public boolean checkArraySorted(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 5, 12, 21, 22};

        CheckArraySorted sort = new CheckArraySorted();
        System.out.println("Array Sorted" + sort.checkArraySorted(nums));
    }
}