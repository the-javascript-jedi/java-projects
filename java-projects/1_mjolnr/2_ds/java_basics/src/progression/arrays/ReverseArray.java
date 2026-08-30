package progression.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void reverse(int[] nums) {
        // Two pointers — one from the left, one from the right
        int left = 0;
        int right = nums.length - 1;

        // Move pointers toward each other, swapping as they go
        while (left < right) {
            // Swap nums[left] and nums[right]
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
        // No return needed — array is passed by reference, original is modified in place
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
        System.out.println(Arrays.toString(nums)); // [5, 4, 3, 2, 1]
    }
}
