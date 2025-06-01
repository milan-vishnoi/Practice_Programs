package miscellaneous;

import java.util.Arrays;

public class SlidingWindow {

    public static int maxSumKSubArray(int[] nums, int k) {
        int maxSum;
        int currentSum = 0;

        if(nums == null || k > nums.length || k < 1)
        throw new IllegalArgumentException();

        for(int i=0;i<k;i++)
        currentSum+=nums[i];

        maxSum = currentSum;

        for(int i=k; i< nums.length; i++)
        {
          currentSum+=nums[i] - nums[i-k];

          if(maxSum < currentSum)
          maxSum = currentSum;
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[][] numsArray = {{-2, 1, -3, 4, -1, 2, 1, -5, 4},
                             {1, 2, 3, 4, 5},
                            {-1, -2, -3, -4, -5},{-5, -2, -10, 0, -1},{8, 7, -5, 1, 2, -10},{-10, 1, 2, -5, 8, 7},{-10, 1, 2, -5, 8, 7}
};

        for(int[] nums:numsArray)
        {
        System.out.println("Array:"+Arrays.toString(nums));
        System.out.println("\nMax subarray sum:"+maxSumKSubArray(nums,2));
        }


    }
}
