package miscellaneous;

public class TwoPointers {

    public static int[] twoSum(int[] numbers, int target) {

        int index1=0;
        int index2=numbers.length-1;
        int[] result= new int[2];
        
        while(index1<index2)
        {
            if(numbers[index1]+numbers[index2] == target)
            break;
            else if(numbers[index1]+numbers[index2]>target)
            index2--;
            else
            index1++;
        }
        result[0] = index1+1;
        result[1] = index2+1;
        return result;
    }

    
    public static void main(String[] args) {
        
    }
    
}
