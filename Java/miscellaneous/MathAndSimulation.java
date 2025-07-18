package miscellaneous;

import java.util.List;
import java.util.ArrayList;

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

   // Leetcode Problem https://leetcode.com/problems/spiral-matrix/
   public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if(matrix.length==0)
        return result;

        int top=0,bottom=matrix.length-1;
        int left=0,right=matrix[0].length-1;

        while(top<=bottom && left<=right)
        {
            for(int i=left;i<=right;i++)
            result.add(matrix[top][i]);

            top++;

            for(int i=top;i<=bottom;i++)
            result.add(matrix[i][right]);

            right--;

         if(top<=bottom)
         {
            for(int i=right;i>=left;i--)
            result.add(matrix[bottom][i]);

            bottom--;
         }

        if(left<=right)
        {
            for(int i=bottom;i>=top;i--)
            result.add(matrix[i][left]);
            
            left++;
        }

        }
        return result;
    }

    // Leetcode Problems https://leetcode.com/problems/set-matrix-zeroes/
    public static void setZeroes(int[][] matrix) {

        if(matrix.length==0)
        return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        // int rows[] = new int[m];
        // int columns[] = new int[n];

        for(int i=0;i<m;i++)
        {
            if(matrix[i][0]==0)
            {
                firstColumnHasZero= true;
                break;
            }
        }

        for(int j=0;j<n;j++)
        {
            if(matrix[0][j]==0)
            {
                firstRowHasZero = true;
                break;
            }
        }

        for(int i=1;i<m;i++)
        { 
            for(int j=1;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[0][j]==0 || matrix[i][0]==0)
                matrix[i][j]=0;
            }
        }

        if(firstRowHasZero)
        {
            for(int j =0;j<n;j++)
            matrix[0][j]=0;
        }

        if(firstColumnHasZero)
        {
            for(int i=0;i<m;i++)
            matrix[i][0]=0;
        }
    }

    // Leetcode Problem https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int x) {

        if(x<0)
        return false;

        int temp = x;
        int reverse=0;

        while(temp>0)
        {
          reverse = reverse*10+ temp%10;
          temp/=10;
        }
        return reverse==x; 
    }

    // Leetcode Problem https://leetcode.com/problems/excel-sheet-column-number/
    public static int titleToNumber(String columnTitle) {

        int result=0;

        for(int i=0;i<columnTitle.length();i++)
         result = result*26 + columnTitle.charAt(i)-64;

        return result;
    }
    
}
