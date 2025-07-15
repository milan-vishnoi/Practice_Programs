package miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
            while(currentSum >= target)
            {
                // if(i-startIndex+1 < minSize)
                //   minSize = i-startIndex+1;
                minSize = Math.min(minSize,i-startIndex+1); // The above logic is equal to this line
                currentSum-=nums[startIndex];
                startIndex++;
            }
        }

        if(minSize == Integer.MAX_VALUE)
        minSize = 0;

        return minSize;
        
    }

    //Leetcode Problem https://leetcode.com/problems/longest-substring-without-repeating-characters
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> indexTracker = new HashMap<>();
        int startIndex = 0;
        int maxLength = 0;

        for(int i=0;i<s.length();i++)
        {   
            char currentChar = s.charAt(i);
            if(indexTracker.containsKey(currentChar))
            {
                  startIndex = Math.max(startIndex,indexTracker.get(currentChar)+1);
            }

            indexTracker.put(currentChar,i);
            maxLength = Math.max(maxLength,i-startIndex+1);

        }
        return maxLength;
        
    }
    
    //Problem : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
    public static int lengthOfLongestSubstringKDistinct(String s, int k)
    {
        int maxLength = 0;
        int startWindow = 0;
        int distinctChars = 0;
        Map<Character,Integer> distinctCharIdxTracker = new HashMap<>();
        char currentChar, firstDistinctChar;

        if(s== null ||s.isEmpty()|| k == 0)
        return 0;

        firstDistinctChar=s.charAt(0);

        for(int endWindow=0; endWindow<s.length(); endWindow++)
        {
             currentChar = s.charAt(endWindow);
             if(!distinctCharIdxTracker.containsKey(currentChar))
             {
                distinctChars++;
                while(distinctChars>k)
                {
                    firstDistinctChar = s.charAt(startWindow);
                    while(firstDistinctChar==s.charAt(startWindow))
                    startWindow++;
                    if(distinctCharIdxTracker.get(firstDistinctChar) < startWindow)
                    {
                        distinctCharIdxTracker.remove(firstDistinctChar);
                        distinctChars--;
                   }
                }

             }
             distinctCharIdxTracker.put(currentChar,endWindow);
             maxLength = Math.max(maxLength,endWindow-startWindow+1);
        }


        return maxLength;
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
