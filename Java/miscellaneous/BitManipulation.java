package miscellaneous;

public class BitManipulation {

    // Leetcode problem https://leetcode.com/problems/single-number/
    public static int singleNumber(int[] nums) {

        if(nums.length<1)
        throw new IllegalArgumentException();
       
        int result=0;
        for(int num:nums)
        result^=num;

        return result;
    }

    // Leetcode Problem https://leetcode.com/problems/number-of-1-bits/
    public static int hammingWeight(int n) {

        int result = 0;
        while(n!=0)
        {
            result++;
            n= n&(n-1);
        }
        return result;
        
    }
    
}
