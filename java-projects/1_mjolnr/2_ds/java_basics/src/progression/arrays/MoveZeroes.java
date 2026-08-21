package progression.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void MoveZeroes(int[] nums) {
        // insertPos = index where the next non-zero value should be written.
        // It only moves forward when we actually place a value, so it's
        // always <= i, meaning we never overwrite a value before we've read it.
        int insertPos = 0;

        // Pass 1: scan the whole array and pack all non-zero values
        // to the front, in their original order.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // Pass 2: everything from insertPos to the end is now "leftover"
        // (either old duplicate values or already zero) - overwrite it with 0.
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6};
        MoveZeroes(nums);

    }
}

/*
* in javascript
* const nonZeros = nums.filter(n => n !== 0);
    const result = [...nonZeros, ...Array(nums.length - nonZeros.length).fill(0)];
* */