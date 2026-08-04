package progression.arrays;

public class SumOfAllElements {
    // add up every element in the array and return the total
    public int sumOfAllElements(int[] nums){
        int sum=0;
        // enhanced for-loop: no need to track an index since we just want each value
        for(int num : nums){
            sum=sum+num;
        }
        return sum;
    }

    public static void main(String[] args){
        SumOfAllElements sum=new SumOfAllElements();
        int[] nums={1,3,5,7,9,10};
        System.out.println("SumOfAllElements - "+sum.sumOfAllElements(nums));
    }
}



