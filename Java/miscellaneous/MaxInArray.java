package miscellaneous;
public class MaxInArray {

    public static int findMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }
        int largest = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++)
        {
            if(nums[i]>largest)
            largest=nums[i];
        }

        return largest;

    }

    public static void main(String[] args) {
        // Test cases
        int[] test1 = {3, 7, 2, 9, 4};
        int[] test2 = {-10, -3, -1, -7};
        int[] test3 = {42,1000,192,-3000};

        System.out.println(findMax(test1)); // Expected: 9
        System.out.println(findMax(test2)); // Expected: -1
        System.out.println(findMax(test3)); // Expected: 42
    }
}