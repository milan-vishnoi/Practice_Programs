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

        int m = a.length()-1;
        int n = b.length()-1;
        int carry=0, sum;
        StringBuilder result = new StringBuilder("");

        while(m>=0 || n>=0)
        {
            sum = carry;
            if(m>=0)
            sum+=a.charAt(m--)-'0';
            if(n>=0)
            sum+=b.charAt(n--)-'0';

           carry = sum/2;

           result.append(sum%2);
        }

        if(carry==0)
        return result.reverse().toString();

        return result.append('1').reverse().toString();
     
    }

    // Leetcode problem https://leetcode.com/problems/excel-sheet-column-title/
    public static String convertToTitle(int columnNumber) {

        int index;
        StringBuilder result = new StringBuilder("");

        while(columnNumber>0)
        {
            columnNumber--;
            index = columnNumber%26;
            result.append((char)(index+'A'));
            columnNumber/=26;
        } 

        return result.reverse().toString();
    }
    
}
