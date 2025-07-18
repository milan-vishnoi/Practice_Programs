package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

    // Leetcode Problem https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public static int[] twoSum(int[] numbers, int target) {

        int index1=0;
        int index2=numbers.length-1;
        int[] result= new int[2];
        
        while(index1<index2)
        {
            if(numbers[index1]+numbers[index2] == target)
            break;
            else if(numbers[index1]+numbers[index2]>target)
            index2--;
            else
            index1++;
        }
        result[0] = index1+1;
        result[1] = index2+1;
        return result;
    }

    // Leetcode problems https://leetcode.com/problems/3sum/
    public static List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();

        if(nums == null)
        return result;

        int index1, index2;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {   
            if(i>0 && nums[i]==nums[i-1] || nums[i]>0)
            continue;

            index1 = i+1;
            index2 = nums.length-1;
             while(index1<index2 && i!=index1 && i!=index2)
             {
                if(nums[index1]+nums[index2]+nums[i]==0)
                { 
                   result.add(Arrays.asList(nums[i],nums[index1],nums[index2]));

                   while(index1<index2 && nums[index1]==nums[index1+1])
                   index1++;

                   while(index1<index2 && nums[index2]==nums[index2-1])
                   index2--;

                   index1++;
                   index2--;
                }
                else if(nums[index1]+nums[index2]+nums[i]<0)
                index1++;
                else
                index2--;
             }
        }

        return result;
        
    }

    // Leetcode Problem https://leetcode.com/problems/container-with-most-water/
    public static int maxArea(int[] height) {
        int maxArea = 0;
        if(height == null || height.length < 2)
        return maxArea;
        int start=0;
        int end = height.length - 1;

        while(start<end)
        {
            if(height[start]<height[end])
            {
              maxArea = Math.max(maxArea,(end-start)*height[start]);
              start++;
            }
            else
            {
             maxArea = Math.max(maxArea,(end-start)* height[end]);
             end--;            
            }
        }

        return maxArea;
        
    }    

    
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    
}
