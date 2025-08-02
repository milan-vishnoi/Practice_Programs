package advancedproblems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Backtracking {

    static Backtracking backtracking = new Backtracking();

    //Leetcode Problem https://leetcode.com/problems/subsets/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        backtracking.calcSubSet(0, nums, result, subset);
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


    private void calcSubSet(int i, int[] nums, List<List<Integer>> result, List<Integer> subset) {
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
        backtracking.findPowerSet(0,nums,result,new ArrayList<>(),false);
        return result;
    }

    private void findPowerSet(int i , int[] nums, List<List<Integer>> result, List<Integer> subset, boolean prevIncluded) {
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

    //Leetcode Problem https://leetcode.com/problems/letter-case-permutation/
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();
        char[] permutation = new char[s.length()];
        backtracking.calcPermutation(0, s, result, permutation);
        return result;
    }

    private void calcPermutation(int i, String s, List<String> result, char[] permutation) {
        if (i == s.length()) {
            result.add(new String(permutation));
            return;
        }
        char ch = s.charAt(i);
        permutation[i] = ch;
        calcPermutation(i + 1, s, result, permutation);
        if (ch >= 65 && ch <= 90) {  //if it is upper case
            permutation[i] = (char) (ch + 32);  //convert to lower case
            calcPermutation(i + 1, s, result, permutation);
        }

        else if (ch >= 97 && ch <= 122) {  //if it is lower case convert it to upper case
            permutation[i] = (char) (ch - 32);
            calcPermutation(i + 1, s, result, permutation);
        }

    }

    //Leetcode Problem https://leetcode.com/problems/expression-add-operators/
    public static List<String> addOperators(String num, int target) 
    {
        List<String> result = new ArrayList<>();
        
        backtracking.findExpression(0,num,target,0,0,"",result);

        return result;
        
    }

    private void findExpression(int index,String num,int target, long eval, long prev, String path, List<String> result)
    {

    if(index==num.length())
        {
          if(eval==target)
            result.add(path);

            return;
        }
    
       String currStr;
       long currNum;
       for(int i=index;i<num.length();i++)  //for generating digits with multiple numbers
       {
        if(i!=index && num.charAt(index)=='0')  // if there arev more than 1 digit and leading is 0 the skip that path
        break;
        currStr = num.substring(index,i+1);
        currNum = Long.parseLong(currStr);

         if(index==0)
         findExpression(i+1,num,target,currNum,currNum,currStr,result); // for 0th index there won't be any operator
         else
         {
            // for addition
            findExpression(i+1,num,target,eval+currNum,currNum,path+'+'+currStr,result);

            //for subtractiom
            findExpression(i+1,num,target,eval-currNum,-currNum,path+'-'+currStr,result);

            //for multiplication
            findExpression(i+1,num,target,(eval-prev)+(prev*currNum),prev*currNum,path+'*'+currStr,result);
         }
       }
  
    }

    //Leetcode problem https://leetcode.com/problems/combination-sum/
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking.findSum(0,candidates,target,new ArrayList<>(),result);

        return result;
        
    }

    private void findSum(int i, int[] candidates, int target, List<Integer> combination, List<List<Integer>> result)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(combination));
            return;
        }
        else if(target<0)
        return;

      for(int index=i;index<candidates.length;index++)
      {
        combination.add(candidates[index]);
        findSum(index,candidates,target-candidates[index],combination,result);
        combination.remove(combination.size()-1);
      }

    }
}
