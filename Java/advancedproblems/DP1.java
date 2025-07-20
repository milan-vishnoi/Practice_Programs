package advancedproblems;

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

        int memo[] = new int[nums.length+1];

        memo[0]=0;
        memo[1]=nums[0];        

        for(int i=1;i<nums.length;i++)
        memo[i+1] = Math.max(memo[i],memo[i-1]+nums[i]);

        return memo[nums.length];
    }
    
}
