package miscellaneous;

public class TwoPointers2 {

    //Leetcode Problem https://leetcode.com/problems/remove-duplicates-from-sorted-array
    public static int removeDuplicates(int[] nums) {

        int start = 0;

        if(nums == null || nums.length==0)
        return start;

        for(int end=0; end<nums.length;end++)
        {
            if(nums[start]!=nums[end])
            {
                nums[start+1] = nums[end];
                start++;
            }
        }

        return start+1;
        
    }
    
    //Leetcode Problem https://leetcode.com/problems/move-zeroes/
    public static void moveZeroes(int[] nums) {
        int start = 0;
        if(nums==null)
        throw new NullPointerException("You have given a null array!!");

        for(int end=0; end<nums.length;end++)
        {
            if(nums[end]!=0)
            {
                nums[start]=nums[end];
                start++;
            }
        }
        for(int i = start;i<nums.length;i++)
        nums[i]=0;
    }
    
    public static int removeElement(int[] nums, int val) {
        int start=0;
        if(nums==null)
        throw new NullPointerException("You have given a null array!!");

        for(int end=0; end<nums.length;end++)
        {
            if(nums[end]!=val)
            {
                nums[start] = nums[end];
                start++;
            }
        }
        
        return start;
    }
    
   public static boolean backspaceCompare(String s, String t) {

    if(s==null || t==null)
    throw new NullPointerException();
        int bs1 = 0;
        int bs2 = 0;
        int i = s.length()-1;
        int j = t.length()-1;

        while(i>=0 || j>=0)
        {
            while(i>=0)
            {
            if(s.charAt(i)=='#') 
            {
               bs1++;
               i--;
            }   
            else if(bs1>0)
            {
                i--;
                bs1--;
            }
            else
            break;
            }


            while(j>=0)
            {
            if(t.charAt(j)=='#')
            {
               bs2++;
               j--;
            }
            else if( bs2>0)
               {
                bs2--;
                j--;
               }
               else
               break;
            }

            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))
            return false;

            if((i>=0) != (j>=0))
            return false;

            i--;
            j--;
        }
        
        return true;
        
    }

    public static boolean validPalindrome(String s) {

        if(s==null || s.isEmpty())
        throw  new NullPointerException();
        else if(s.length()==1)
        return true;

        int i = 0;
        int j = s.length()-1;

        while(i<j)
        {
           if(s.charAt(i)!=s.charAt(j))
           return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);

           i++;
           j--;
        }

        return true;
        
    }

    private static boolean isPalindrome(String s, int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            return false;

            start++;
            end--;
        }

        return true;
    }   

    public static void main(String[] args) {
        
    }
    
}
