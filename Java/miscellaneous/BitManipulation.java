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
    
}
