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
    
}
