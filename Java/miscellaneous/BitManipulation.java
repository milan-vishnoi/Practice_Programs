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

    // Leetcode Problem https://leetcode.com/problems/counting-bits/
    public static int[] countBits(int n) {

        int result[] = new int[n+1];
        result[0] = 0;
        if(n<1)
        return result;

        result[1]=1;
        int lastSet=1;


        for(int i=2; i<=n;i++)
        {
            if(lastSet*2==i)
            {
                lastSet = i;
                result[i] = 1;
            }
            else {
                result[i] = 1 + result[i-lastSet];
            }
        }

        return result;
        
    }

    // Leetcode Problem https://leetcode.com/problems/sum-of-two-integers/
    public static int getSum(int a, int b) {

        int carry;
        while(b!=0)
        {
          carry = a&b;
           a = a^b;
           b = carry<<1;
        }
        return a;
        
    }

    // Leetcode problem https://leetcode.com/problems/single-number-ii/
    public static int singleNumberTriple(int[] nums) {

        if(nums.length==0)
        throw new ArrayIndexOutOfBoundsException();

        int[] bitCount = new int[32];
        int result=0;
        for(int num:nums)          //Made this as outer loop for better caching
        {
            for(int i = 0; i<32;i++)
              {
               //if(((num>>i)&1)==1)   This can be replaced by below logic as we are adding 1 otherwise it will be 0
                bitCount[i]+= (num>>i)&1;
             }
        }

        for(int i =0;i<32;i++)
        {
            if(bitCount[i]%3==1)
                 {
                    result |= (1<<i); // Used | instead of ^ because the unset bit will remain unset and required unset will get set 
                 }
        }

        return result;
    }

    public static int rangeBitwiseAnd(int left, int right) {

        int shift=0;

        while(left<right)
        {
            // Right shifting left and right until we find the common number in which case we retun that number
            left>>=1;
            right>>=1;
            shift++;
        }
        // left shift the left in order to return the number
        return left<<shift;
    }
    
}
