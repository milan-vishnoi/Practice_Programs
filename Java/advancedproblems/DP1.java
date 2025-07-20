package advancedproblems;

import java.util.Arrays;

public class DP1 {

    //Leetcode Problem https://leetcode.com/problems/fibonacci-number/
    public static int fib(int n) {
     
     if(n<0)
     throw new IllegalArgumentException();
     if(n==0||n==1)
     return n;

     int prev1=0;
     int prev2 =1;
     int current=1;
     

     for(int i=2;i<=n;i++)
     {
        prev2 = prev1;
        prev1 = current;
        current = prev1 + prev2;
     }

     return current;
        
    }

    // Leetcode Problem https://leetcode.com/problems/climbing-stairs/
    public static int climbStairs(int n) {
        if(n<1)
        throw new IllegalArgumentException();

        if(n<=2)
        return n;
        int prev1=1;
        int prev2=2;
        int result=0;

        for(int i=3;i<=n;i++)
        {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;

        }

        return result;
        
    }

    // Leetcode problem https://leetcode.com/problems/house-robber/
    public static int rob(int[] nums) {

        if(nums.length==1)
        return nums[0];

        // int memo[] = new int[nums.length+1];

        // memo[0]=0;
        // memo[1]=nums[0];        

        // for(int i=1;i<nums.length;i++)
        // memo[i+1] = Math.max(memo[i],memo[i-1]+nums[i]);

        int prev1=0;
        int prev2=0;
        int result=0;

        for(int i=0;i<nums.length;i++)
        {
            result = Math.max(prev1,prev2+nums[i]);
            prev2 = prev1;
            prev1 = result;
        }

        //return memo[nums.length];
        return result;
    }

    // Leetcode Problem https://leetcode.com/problems/house-robber-ii/
    public static int robCircular(int[] nums) {

        int n = nums.length;
        
        if(n==1)
        return nums[0];
        else if(n==2)
        return Math.max(nums[0],nums[1]);
        int memo[] = new int[n+1];

        // First calculate for 0 to n-2
        memo[0] = 0;
        memo[1] = nums[0];
        int result=0;

        for(int i=1;i<n-1;i++)
        memo[i+1] = Math.max(memo[i],memo[i-1]+nums[i]);

        // Saving the max value of 0 to n-2 houses
        result = memo[n-1];
        
        // Resetting the value of array
        Arrays.fill(memo,0);

        // Calculating for 1 to n-1
        memo[2] = nums[1];

        for(int i=2;i<n;i++)
        memo[i+1] = Math.max(memo[i],memo[i-1]+nums[i]);


        return Math.max(memo[n],result);
    }
    
}
