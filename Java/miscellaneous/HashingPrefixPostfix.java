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
}
