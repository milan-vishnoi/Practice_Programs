package advancedproblems;

import java.util.List;
import java.util.ArrayList;

public class Backtracking {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        calcSubSet(0, nums, result, subset);
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


    public static void calcSubSet(int i, int[] nums, List<List<Integer>> result, List<Integer> subset) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        calcSubSet(i + 1, nums, result, subset);

        subset.remove(subset.size() - 1);
        calcSubSet(i + 1, nums, result, subset);
    }
    
}
