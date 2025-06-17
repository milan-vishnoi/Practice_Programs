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

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null)
        throw new NullPointerException();
        
        if(nums1.length > nums2.length)
        return findMedianSortedArrays(nums2,nums1);

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        int i,j;
        int maxleft1, minright1;
        int maxleft2, minright2;

        while(low<=high)
        {
            i = (low+high)/2;
            j = (m+n+1)/2 - i;

            maxleft1 = (i==0)? Integer.MIN_VALUE:nums1[i-1];
            minright1 = (i==m)?Integer.MAX_VALUE:nums1[i];

            maxleft2 = (j==0)?Integer.MIN_VALUE:nums2[j-1];
            minright2 = (j==n)?Integer.MAX_VALUE:nums2[j];

            if(maxleft1<=minright2 && maxleft2<=minright1)
            {
                if((n+m)%2!=0)
                return Math.max(maxleft1,maxleft2);
                else
                return (Math.max(maxleft1,maxleft2)+Math.min(minright1,minright2))/2.0;
            }
            else if(maxleft1>minright2)
            high = i-1;
            else
            low = i+1;
        }

        return 0.0;
        
    }

    public static int shipWithinDays(int[] weights, int days) {

        if(weights == null)
        throw new NullPointerException();

        int maxWeight = weights[0];
        int sum = 0;
        for(Integer weight:weights)
        {
            maxWeight = Math.max(maxWeight,weight);
            sum+=weight;
        }

        int low = maxWeight;
        int high = sum;
        int mid,d;
        int currentSum;

        while(low<=high)
        {
            mid = (low+high)/2;
            d = 1;
            currentSum = 0;

            for(int i = 0 ;i<weights.length;i++)
            {
                currentSum+= weights[i];
                if(currentSum > mid)
                {
                    d++;
                    currentSum = weights[i];
                }
            }
            if(d<=days)
            {
                high = mid - 1;
            }
            else 
            low = mid + 1 ;
        }

        return low;
        
    }
    
}
