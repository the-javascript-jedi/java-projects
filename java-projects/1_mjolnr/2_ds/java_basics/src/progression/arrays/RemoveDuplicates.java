package progression.arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] nums) {
        return Arrays.stream(nums)
                .distinct().sorted()
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 22, 3, 11, 4, 12, 5, 14, 6, 15, 7, 8, 9, 2, 5, 5, 4, 5};

        int[] uniqueNums = removeDuplicates(nums);

        System.out.println(Arrays.toString(uniqueNums));
    }
}