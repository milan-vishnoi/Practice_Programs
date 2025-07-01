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

    // Variant of above problem (not present on Leetcode)
    public static int longestSubarrayWithEqual012(int[] nums) {
    int maxLen = 0;
    int count0 = 0, count1 = 0, count2 = 0;

    // Map to store the first index where (count1 - count0, count2 - count1) occurred
    Map<String, Integer> map = new HashMap<>();
    map.put("0#0", -1); // base case: diff0 and diff1 both 0 at index -1

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) count0++;
        else if (nums[i] == 1) count1++;
        else count2++;

        int diff1 = count1 - count0;
        int diff2 = count2 - count1;
        String key = diff1 + "#" + diff2;

        if (map.containsKey(key)) {
            maxLen = Math.max(maxLen, i - map.get(key));
        } else {
            map.put(key, i);
        }
    }

    return maxLen;
    }

    // Leetcode problem https://leetcode.com/problems/subarray-sums-divisible-by-k/
    public static int subarraysDivByK(int[] nums, int k) {

        if(nums == null)
        throw new NullPointerException();

        // Map<Integer, Integer> count = new HashMap<>();
        int count[] = new int[10000];
        int currentSum =0;
        int result=0;
        // count.put(0,1);
        count[0] = 1;
        int rem;

        for(int i=0;i<nums.length;i++)
        {
            currentSum+=nums[i];
            // To handle -ve modulo. Eg if currentSum is -1 then if we have 4 in prefix, we can get div by 5 after removing it 
            rem = (currentSum%k + k)%k;
            //result+= count.getOrDefault(rem,0);
            result+= count[rem];

            //count.put(rem,count.getOrDefault(rem,0)+1);
            count[rem]++;
        }

        return result;
    }

    // Leetcode Problem https://leetcode.com/problems/binary-subarrays-with-sum/
    public static int numSubarraysWithSum(int[] nums, int goal) {

    int count[] = new int[30000];
    //Map<Integer, Integer> count = new HashMap<>(); 
    int currentSum = 0;
    int result = 0;
    //count.put(0,1);
    count[0]=1;

    for(int i=0;i<nums.length;i++)
    {
        currentSum+=nums[i];
        if(currentSum>=goal)
        result+=count[currentSum-goal];
        //result+= count.getOrDefault(currentSum-goal,0);
        //count.put(currentSum,count.getOrDefault(currentSum,0)+1);

        count[currentSum]++;
    }

    return result;
        
    }

    // Leetcode Problems https://leetcode.com/problems/count-number-of-nice-subarrays/
    public static int numberOfSubarrays(int[] nums, int k) {

        int result =0;
        int currentSum=0;
        //Map<Integer,Integer> count = new HashMap<>();
        int count[] = new int[50000];
        //count.put(0,1);
        count[0] = 1;
        // for(int i=0;i<nums.length;i++)
        //  nums[i] = nums[i]%2;

         for(int i =0;i<nums.length;i++)
         {
            currentSum+=nums[i]%2;
            //result+=count.getOrDefault(currentSum-k,0);
            //count.put(currentSum,count.getOrDefault(currentSum,0)+1);
            if(currentSum>=k)
            result+=count[currentSum-k];
            count[currentSum]++;
         }

         return result;
    }
}
