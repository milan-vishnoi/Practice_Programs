package miscellaneous;

public class KadaneMaxSumSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length;i++)
        {   
            if(currentSum < 0 && currentSum < nums[i]) //Checking if sum is negative and less then current number.
              currentSum = nums[i]; // Reset the start of subarray if the sum is -ve, start from the current number it is larger than sum 
            else
               currentSum+= nums[i]; // Expand the subarray i.e. Add the value only if they are positive
    
            if(maxSum < currentSum)
                maxSum = currentSum; //Update maxSum only if its less than currentSum

            
        }

        return maxSum;
        
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("Max subarray sum:"+maxSubArray(nums));
    }
    
}
