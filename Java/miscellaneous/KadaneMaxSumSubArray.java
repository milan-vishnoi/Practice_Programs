package miscellaneous;

import java.util.Arrays;

// Problem : https://leetcode.com/problems/maximum-subarray/
public class KadaneMaxSumSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;
        int startIndex = 0;
        int currentStartIndex = 0;
        int endIndex = 0;

        if(nums.length == 0)
        return 0;

        for(int i=0; i<nums.length;i++)
        {   
            if(currentSum < 0) //Checking if sum is negative, if yes then start from there
            {
                currentSum = nums[i]; // Reset the start of subarray if the sum is -ve, start from the current number it is larger than sum 
                currentStartIndex = i;
            }
              
            else
               currentSum+= nums[i]; // Expand the subarray i.e. Add the value only if they are positive
    
            if(maxSum < currentSum)
            { 
                maxSum = currentSum; //Update maxSum only if its less than currentSum
                startIndex = currentStartIndex;
                endIndex = i;
            }
        }
        
        System.out.print("Subarray with Max Sum:");

        for(int i=startIndex; i <= endIndex; i++)
        System.out.print(nums[i]+" ");


        return maxSum;
        
    }
/* Problem: https://leetcode.com/problems/maximum-sum-circular-subarray/
* To calculate the max sum  in circular array we need to calculate the max Kadane sum,
* Calculate total sum and remove the min kadane sum (to remove the min sum array)
* Then we need to compare which one is larger.
*/
    public static int maxSubarraySumCircular(int[] nums) {
        int maxKadaneSum = Integer.MIN_VALUE;
        int currentMaxSum = Integer.MIN_VALUE;
        int minKadaneSum = Integer.MAX_VALUE;
        int currentMinSum = Integer.MAX_VALUE;
        int totalSum = 0;

        if(nums.length == 0)
        return 0;

        for(int i=0; i< nums.length;i++)
        {  
            totalSum+=nums[i];

            if(currentMaxSum < 0 )
                currentMaxSum = nums[i]; 
            else
                currentMaxSum+= nums[i];

            if(currentMinSum > 0)
                currentMinSum = nums[i];
            else
                currentMinSum+=nums[i];

            if(maxKadaneSum < currentMaxSum)
             maxKadaneSum = currentMaxSum;

            if(minKadaneSum > currentMinSum)
             minKadaneSum = currentMinSum;
        }

        if(maxKadaneSum > totalSum-minKadaneSum || totalSum == minKadaneSum)
        return maxKadaneSum;
        else
        return (totalSum-minKadaneSum);
        
    }

    public static void main(String[] args) {
        int[][] numsArray = {{-2, 1, -3, 4, -1, 2, 1, -5, 4},
                             {1, 2, 3, 4, 5},
                            {-1, -2, -3, -4, -5},
                        {}, {5},{-5, -2, -10, 0, -1},{8, 7, -5, 1, 2, -10},{-10, 1, 2, -5, 8, 7},{-10, 1, 2, -5, 8, 7}
};

        for(int[] nums:numsArray)
        {
        System.out.println("Array:"+Arrays.toString(nums));
        System.out.println("\nMax subarray sum:"+maxSubArray(nums));
        System.out.println("Max subarray sum for circular array:"+maxSubarraySumCircular(nums)+"\n");
        }


    }
    
}
