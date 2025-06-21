package miscellaneous;

public class BinarySearchOnSortedArray {

    public static int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length-1;
        int mid=0, missing=0;

        while(low<=high)
        {
            mid = low +(high-low)/2;
            missing = arr[mid] - (mid+1);
            if(missing<k)
            low = mid+1;
            else
            high = mid-1;

        }

        return low+k;
        
    }
}
