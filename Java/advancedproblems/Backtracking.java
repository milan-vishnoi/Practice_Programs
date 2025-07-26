package advancedproblems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Backtracking {

    static Backtracking object = new Backtracking();

    //Leetcode Problem https://leetcode.com/problems/subsets/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        object.calcSubSet(0, nums, result, subset);
        return result;

    }

    /* The subset problem can be solved by using Bitmasking as well as below
    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset;
        int subsetCount = 1<<nums.length; // i.e. 1*2^n = 2^n
        for(int mask=0;mask<subsetCount;mask++)
        {
            subset = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                if((mask & (1<<i)) !=0)
                subset.add(nums[i]);
            }

            result.add(subset);
        }

        return result;
    }
     */


    public void calcSubSet(int i, int[] nums, List<List<Integer>> result, List<Integer> subset) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        calcSubSet(i + 1, nums, result, subset);

        subset.remove(subset.size() - 1);
        calcSubSet(i + 1, nums, result, subset);
    }
    
    //Leetcode Problem https://leetcode.com/problems/subsets-ii/
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        object.findPowerSet(0,nums,result,new ArrayList<>(),false);
        return result;
    }

    public void findPowerSet(int i , int[] nums, List<List<Integer>> result, List<Integer> subset, boolean prevIncluded) {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(subset));
            return;
        }

        if(i==0 ||  nums[i]!=nums[i-1] || !!prevIncluded )
        {
        subset.add(nums[i]);
        findPowerSet(i+1,nums,result,subset,true);

        subset.remove(subset.size()-1);
        }

        findPowerSet(i+1,nums,result,subset,false);
    }
}
