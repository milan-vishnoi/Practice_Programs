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

    // Leetcode Problem https://leetcode.com/problems/add-binary/
    public static String addBinary(String a, String b) {

        if(a.isBlank() || b.isBlank())
        throw new StringIndexOutOfBoundsException(b);

        if(a.length()<b.length())
        return addBinary(b,a);
        
        int maxLength = a.length();
        String padding ="";
        int carry=0, sum;
        int aChar, bChar;
        StringBuilder result = new StringBuilder("");
        int diff = maxLength-b.length();

        for(int i=1;i<=diff;i++)
        padding+='0';
        
        b = padding + b;

        for(int i=maxLength-1;i>=0;i--)
        {
           aChar = a.charAt(i) -'0';
           bChar = b.charAt(i) - '0';

           sum = (aChar^bChar)^carry;
           carry = (aChar&bChar)|(aChar&carry)|(bChar&carry);

           result.append(sum);
        }

        if(carry==0)
        return result.reverse().toString();

        return result.append('1').reverse().toString();
     
    }
    
}
