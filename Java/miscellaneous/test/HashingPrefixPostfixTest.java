package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import miscellaneous.HashingPrefixPostfix;

public class HashingPrefixPostfixTest {

    // --- Test Cases for subarraySum (LeetCode 560) ---

    @Test
    void testSubarraySum_Example1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_Example2() {
        int[] nums = {1, 2, 3};
        int k = 3;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_WithNegativeNumbers() {
        int[] nums = {1, -1, 0};
        int k = 0;
        int expected = 3;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_AllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_AllNegative() {
        int[] nums = {-1, -2, -3, -4, -5};
        int k = -3;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_SingleElementArray_Match() {
        int[] nums = {5};
        int k = 5;
        int expected = 1;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_SingleElementArray_NoMatch() {
        int[] nums = {5};
        int k = 0;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_NoMatch() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 100;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_ZeroKWithZeros() {
        int[] nums = {0, 0, 0, 0, 0};
        int k = 0;
        int expected = 15;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_MixedNumbersComplex() {
        int[] nums = {1, -1, 1, -1, 1};
        int k = 0;
        int expected = 6;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_LongArray() {
        int[] nums = new int[20000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i % 2 == 0) ? 1 : -1;
        }
        int k = 0;
        int expected = 100000000;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_LargeValuesOfK() {
        int[] nums = {1_000, 1_000, 1_000, 1_000, 1_000};
        int k = 3_000;
        int expected = 3;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_MinMaxValues() {
        int[] nums = {1000, -1000, 1000, -1000, 1000, -1000};
        int k = 1000;
        int expected = 6;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_NullArray() {
        int[] nums = null;
        int k = 0;
        assertThrows(NullPointerException.class, () -> HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_EmptyArray() {
        int[] nums = {};
        int k = 0;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    // --- Test Cases for findMaxLength (LeetCode 525) ---

    @Test
    void testFindMaxLength_Example1() {
        int[] nums = {0, 1};
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_Example2() {
        int[] nums = {0, 1, 0};
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_AllZeros() {
        int[] nums = {0, 0, 0, 0};
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_AllOnes() {
        int[] nums = {1, 1, 1, 1};
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_Alternating() {
        int[] nums = {0, 1, 0, 1};
        int expected = 4;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_ComplexMixed() {
        int[] nums = {0, 0, 1, 0, 0, 0, 1, 1};
        int expected = 6;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_SingleElementZero() {
        int[] nums = {0};
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_SingleElementOne() {
        int[] nums = {1};
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_NoEqualSubarray() {
        int[] nums = {0, 0, 1, 0, 0};
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_LongArray() {
        int[] nums = new int[100000];
        for (int i = 0; i < 50000; i++) {
            nums[2 * i] = 0;
            nums[2 * i + 1] = 1;
        }
        int expected = 100000;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_LongArrayWithShift() {
        int[] nums = new int[100000];
        nums[0] = 0; // Extra zero at start
        for (int i = 0; i < 49999; i++) {
            nums[2 * i + 1] = 0;
            nums[2 * i + 2] = 1;
        }
        int expected = 99998; // From index 1 to end
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_NullArray() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> HashingPrefixPostfix.findMaxLength(nums));
    }

    @Test
    void testFindMaxLength_EmptyArray() {
        int[] nums = {};
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.findMaxLength(nums));
    }

   // --- Test Cases for subarraysDivByK (LeetCode 974) ---

    @Test
    void testSubarraysDivByK_Example1() {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int expected = 7;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_Example2() {
        int[] nums = {5};
        int k = 9;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_AllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int expected = 7;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_AllNegative() {
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 3;
        int expected = 7;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_ContainsZero() {
        int[] nums = {0, 0, 0, 0};
        int k = 2;
        int expected = 10;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_NoDivisible() {
        int[] nums = {1, 2, 3, 4};
        int k = 50;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_KIsLarge() {
        int[] nums = {10, 20, 30};
        int k = 5;
        int expected = 6;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_ComplexNegativeRemainder() {
        int[] nums = {-1, 2, 9};
        int k = 2;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_NullArray() {
        int[] nums = null;
        int k = 5;
        assertThrows(NullPointerException.class, () -> HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    @Test
    void testSubarraysDivByK_EmptyArray() {
        int[] nums = {};
        int k = 5;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraysDivByK(nums, k));
    }

    // --- Test Cases for numSubarraysWithSum (LeetCode 930) ---

    @Test
    void testNumSubarraysWithSum_Example1() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int expected = 4;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_Example2() {
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
        int expected = 15;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_SingleElement_Match() {
        int[] nums = {1};
        int goal = 1;
        int expected = 1;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_SingleElement_NoMatch() {
        int[] nums = {0};
        int goal = 1;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_AllOnes() {
        int[] nums = {1, 1, 1, 1, 1};
        int goal = 3;
        int expected = 3;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_AllZeros_GoalOne() {
        int[] nums = {0, 0, 0, 0};
        int goal = 1;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_ComplexMixed() {
        int[] nums = {0, 1, 1, 0, 1, 1, 0};
        int goal = 2;
        int expected = 9;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_GoalIsMaxSum() {
        int[] nums = {1, 1, 1, 1, 1};
        int goal = 5;
        int expected = 1;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_GoalTooHigh() {
        int[] nums = {0, 1, 0, 1};
        int goal = 3;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_LongArray() {
        int[] nums = new int[30000];
        for (int i = 0; i < 30000; i++) {
            nums[i] = i % 2;
        }
        int goal = 15000; 
        int expected = 2; 
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_NullArray() {
        int[] nums = null;
        int goal = 0;
        assertThrows(NullPointerException.class, () -> HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

    @Test
    void testNumSubarraysWithSum_EmptyArray() {
        int[] nums = {};
        int goal = 0;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.numSubarraysWithSum(nums, goal));
    }

}