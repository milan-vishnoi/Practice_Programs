package miscellaneous;

public class TwoPointers2 {

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

    public static void main(String[] args) {
        
    }
    
}
