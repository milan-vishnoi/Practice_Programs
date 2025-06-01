package miscellaneous;

import java.util.Arrays;

public class SlidingWindow {


    // Similar to problem https://leetcode.com/problems/maximum-average-subarray-i/
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

    //Problem : https://leetcode.com/problems/minimum-size-subarray-sum/
    public static int minSubArrayLen(int target, int[] nums) {

        int currentSum = 0;
        int startIndex = 0;
        int minSize = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++)
        {
            currentSum+= nums[i];
            if(currentSum >= target)
            {
            while(currentSum >= target)
            {
                // if(i-startIndex+1 < minSize)
                //   minSize = i-startIndex+1;
                minSize = Math.min(minSize,i-startIndex+1); // The above logic is equal to this line
                currentSum-=nums[startIndex];
                startIndex++;
            }


            }
        }

        if(minSize == Integer.MAX_VALUE)
        minSize = 0;

        return minSize;
        
    }


    public static void main(String[] args) {
        int[][] numsArray = {{-2, 1, -3, 4, -1, 2, 1, -5, 4},
                             {1, 2, 3, 4, 5},
                            {-1, -2, -3, -4, -5},{-5, -2, -10, 0, -1},{8, 7, -5, 1, 2, -10},{-10, 1, 2, -5, 8, 7},{-10, 1, 2, -5, 8, 7}
};

        for(int[] nums:numsArray)
        {
        System.out.println("----------------------------------");
        System.out.println("\nArray:"+Arrays.toString(nums));
        System.out.println("\nMax sum of subarray of length 2:"+maxSumKSubArray(nums,2));
        System.out.println("\nMinimum subarray size for getting target sum:"+minSubArrayLen(7,nums));
        }


    }
}
