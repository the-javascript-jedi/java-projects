package sandbox;

public class TwoSum {
    // Signature — return an int[] where [0] is min and [1] is max
//    int[] findMinMax(int[] nums)


    public void findMinMax(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("max" + max);
        System.out.println("min" + min);
    }

    public static void main(String[] args) {
        TwoSum twosum = new TwoSum();
        int nums[] = {3, 11, 17, 2, 9};
        twosum.findMinMax(nums);
    }
}
