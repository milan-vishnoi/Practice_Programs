package BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void singleArrayFound() {
        int arr[] = { 4 };
        int element = 4;
        Assert.assertTrue(BinarySearch.binarySearch(arr, element));
    }

    @Test
    public void singleArrayNotFound() {
        int arr[] = { 10 };
        int element = 4;
        Assert.assertFalse(BinarySearch.binarySearch(arr, element));
    }

    @Test
    public void normalArrayNotFound() {
        int arr[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int element = 5;
        Assert.assertFalse(BinarySearch.binarySearch(arr, element));
    }

    @Test
    public void normalArrayFound() {
        int arr[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int element = 4;
        Assert.assertTrue(BinarySearch.binarySearch(arr, element));
    }

    @Test
    public void emptyArray() {
        int arr[] = {};
        int element = 4;
        Assert.assertFalse(BinarySearch.binarySearch(arr, element));
    }
}
