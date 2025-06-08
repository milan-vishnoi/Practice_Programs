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

    public static void main(String[] args) {
        
    }
    
}
