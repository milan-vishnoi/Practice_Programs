package miscellaneous;

public class MathAndSimulation {

    // Leetcode Problem https://leetcode.com/problems/plus-one/
    public static int[] plusOne(int[] digits) {

        int carry = 0;
        int length = digits.length;
        digits[length-1] = digits[length-1]+1;
        if(digits[length-1]<=9)
        return digits;
        else
        {
          carry = digits[length-1]/10;
          digits[length-1] = digits[length-1]%10;
        }

        for(int i=digits.length-2;i>=0;i--)
        {
            digits[i] = digits[i]+carry;
            if(digits[i]>9)
            {
                carry = digits[i]/10;
                digits[i] = digits[i]%10;
            }
            else
            return digits;
        }

        if(carry==0)
        return digits;
        
        int[] results = new int[length+1];
        results[0] = carry;
        for(int i=0;i<length;i++)
        results[i+1]=digits[i];
        
        return results;
        
    }
    
}
