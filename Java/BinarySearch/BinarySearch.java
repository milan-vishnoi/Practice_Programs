package BinarySearch;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String args[]) {
        int arr[] = { 2, 45, 57, 78, 109, 113, 115, 117 };
        int element;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to be searched:");
        element = sc.nextInt();
        sc.close();
        boolean found = binarySearch(arr, element);

        if (found)
            System.out.println("Element found!!");
        else
            System.out.println("Element not found in array!!");
    }

    public static boolean binarySearch(int arr[], int element) {
        for (int low = 0, high = arr.length - 1; low <= high;) {
            int middle = (low + high) / 2;
            if (element == arr[middle])
                return true;
            else if (element > arr[middle])
                low = middle + 1;
            else
                high = middle - 1;
        }
        return false;
    }

}
