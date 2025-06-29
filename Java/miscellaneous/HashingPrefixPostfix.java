package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class HashingPrefixPostfix {
    
    //Leet code problem https://leetcode.com/problems/subarray-sum-equals-k/
    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int currentSum = 0;
        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);

        for(int i = 0;i<nums.length;i++)
        {
            currentSum+=nums[i];
            if(prefixSum.containsKey(currentSum-k))
            {
                result+=prefixSum.get(currentSum-k);
            }
            prefixSum.put(currentSum,prefixSum.getOrDefault(currentSum,0)+1);
        }

        return result;
    }

    //Leetcode Problem https://leetcode.com/problems/contiguous-array/
    public static int findMaxLength(int[] nums) {

        if(nums==null)
        throw new NullPointerException();
        
        Map<Integer,Integer> present = new HashMap<>();
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==0)
            nums[i]=-1;
        }
        int currentSum =0;
        int maxCount=0;
        present.put(0,-1); // Setting it to -1 because before the array starts, the sum is -1

        for(int i=0;i<nums.length;i++)
        {
            currentSum+=nums[i];
            if(present.containsKey(currentSum))
                maxCount=Math.max(maxCount,i-present.get(currentSum)); //Calculating the length from the first occurence of the sum
            else
             present.put(currentSum,i);  //Putting the last index if not present
        }

        return maxCount;
        
    }
}
