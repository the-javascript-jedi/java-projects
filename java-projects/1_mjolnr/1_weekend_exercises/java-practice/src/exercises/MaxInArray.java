package exercises;

public class MaxInArray {

    // returns the largest value in the array
    public static int findMaxArray(int[] numbers) {
        int max = numbers[0];                    // assume the first element is the max
        for (int i = 1; i < numbers.length; i++) {  // start at 1, compare the rest
            if (numbers[i] > max) {
                max = numbers[i];                // found a bigger one — update
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 19, 7};
        System.out.println(findMaxArray(arr));              // 19

        int[] negatives = {-5, -2, -9, -1};
        System.out.println(findMaxArray(negatives));        // -1 (works with all negatives!)

        int[] single = {42};
        System.out.println(findMaxArray(single));           // 42 (one element)

        int[] sorted = {1, 2, 3, 4, 5};
        System.out.println(findMaxArray(sorted));           // 5
    }
}