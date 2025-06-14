package miscellaneous;

public class BinarySearchOnAnswers {

    // Leetcode Problem https://leetcode.com/problems/koko-eating-bananas/
    public static int minEatingSpeed(int[] piles, int h) {

        if(piles == null)
        throw new NullPointerException();

        int k;

        int largest = 0;
        int low = 1;
        long sum;
        for(int i = 0; i<piles.length;i++)
        largest = Math.max(largest,piles[i]);

        int result = largest;

        while(low<=largest)
        {
            k = low+(largest-low)/2;
            sum = 0;
            for(int i=0; i<piles.length;i++)
            {
               sum+= (piles[i]+k-1)/k;
            }

            if(sum<=h)
            {
                result = k;
                largest = k-1;
            }
            else {
                low = k+1;
            }
        }
        return result;
        
    }

    public static int splitArray(int[] nums, int k) {

        if(nums == null)
        throw new NullPointerException("You provided an empty array ?!");

        int lowest=0;
        int largest=0;
        int max = 0;
        long currentSum;
        int count;

        for(int i =0 ; i< nums.length;i++)
        {
            largest+=nums[i];
            lowest = Math.max(lowest,nums[i]);
        }

        while(lowest<=largest)
        {
             max = (largest+lowest)/2;
             currentSum = 0;
             count = 1;
             for(int i =0 ; i<nums.length;i++)
             { 
                if(currentSum+nums[i]<=max)
                {
                    currentSum+=nums[i];
                }else{
                    count++;
                    currentSum=nums[i];
                }
             }
             if(count <= k)
             {
                 largest = max-1;
             }
             else {
                lowest = max+1;
             }
        }

        return lowest;
        
    }
    
}
