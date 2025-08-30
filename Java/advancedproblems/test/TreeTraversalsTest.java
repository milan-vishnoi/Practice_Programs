package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import advancedproblems.TreeTraversals;

public class TreeTraversalsTest {

    @BeforeEach
    void setup() {
        TreeTraversals.result = new ArrayList<>();
    }

    // --- Test Cases for inorderTraversal (LeetCode 94) ---

    @Test
    void testInorderTraversal_Example1() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.right = new TreeTraversals.TreeNode(2);
        root.right.left = new TreeTraversals.TreeNode(3);
        List<Integer> expected = Arrays.asList(1, 3, 2);
        assertEquals(expected, TreeTraversals.inorderTraversal(root));
    }

    @Test
    void testInorderTraversal_EmptyTree() {
        TreeTraversals.TreeNode root = null;
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, TreeTraversals.inorderTraversal(root));
    }

    @Test
    void testInorderTraversal_SingleNodeTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, TreeTraversals.inorderTraversal(root));
    }

    @Test
    void testInorderTraversal_FullBinaryTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.left.right = new TreeTraversals.TreeNode(5);
        root.right.left = new TreeTraversals.TreeNode(6);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<Integer> expected = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        assertEquals(expected, TreeTraversals.inorderTraversal(root));
    }

    @Test
    void testInorderTraversal_LeftSkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.left.left = new TreeTraversals.TreeNode(3);
        root.left.left.left = new TreeTraversals.TreeNode(4);
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, TreeTraversals.inorderTraversal(root));
    }

    @Test
    void testInorderTraversal_RightSkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.right = new TreeTraversals.TreeNode(2);
        root.right.right = new TreeTraversals.TreeNode(3);
        root.right.right.right = new TreeTraversals.TreeNode(4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, TreeTraversals.inorderTraversal(root));
    }

    // --- Test Cases for preorderTraversal (LeetCode 144) ---

    @Test
    void testPreorderTraversal_Example1() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.right = new TreeTraversals.TreeNode(2);
        root.right.left = new TreeTraversals.TreeNode(3);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, TreeTraversals.preorderTraversal(root));
    }

    @Test
    void testPreorderTraversal_EmptyTree() {
        TreeTraversals.TreeNode root = null;
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, TreeTraversals.preorderTraversal(root));
    }

    @Test
    void testPreorderTraversal_SingleNodeTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, TreeTraversals.preorderTraversal(root));
    }

    @Test
    void testPreorderTraversal_FullBinaryTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.left.right = new TreeTraversals.TreeNode(5);
        root.right.left = new TreeTraversals.TreeNode(6);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<Integer> expected = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        assertEquals(expected, TreeTraversals.preorderTraversal(root));
    }

    @Test
    void testPreorderTraversal_LeftSkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.left.left = new TreeTraversals.TreeNode(3);
        root.left.left.left = new TreeTraversals.TreeNode(4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, TreeTraversals.preorderTraversal(root));
    }

    @Test
    void testPreorderTraversal_RightSkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.right = new TreeTraversals.TreeNode(2);
        root.right.right = new TreeTraversals.TreeNode(3);
        root.right.right.right = new TreeTraversals.TreeNode(4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, TreeTraversals.preorderTraversal(root));
    }

    // --- Test Cases for postorderTraversal (LeetCode 145) ---

    @Test
    void testPostorderTraversal_Example1() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.right = new TreeTraversals.TreeNode(2);
        root.right.left = new TreeTraversals.TreeNode(3);
        List<Integer> expected = Arrays.asList(3, 2, 1);
        assertEquals(expected, TreeTraversals.postorderTraversal(root));
    }

    @Test
    void testPostorderTraversal_EmptyTree() {
        TreeTraversals.TreeNode root = null;
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, TreeTraversals.postorderTraversal(root));
    }

    @Test
    void testPostorderTraversal_SingleNodeTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, TreeTraversals.postorderTraversal(root));
    }

    @Test
    void testPostorderTraversal_FullBinaryTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.left.right = new TreeTraversals.TreeNode(5);
        root.right.left = new TreeTraversals.TreeNode(6);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<Integer> expected = Arrays.asList(4, 5, 2, 6, 7, 3, 1);
        assertEquals(expected, TreeTraversals.postorderTraversal(root));
    }

    @Test
    void testPostorderTraversal_LeftSkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.left.left = new TreeTraversals.TreeNode(3);
        root.left.left.left = new TreeTraversals.TreeNode(4);
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, TreeTraversals.postorderTraversal(root));
    }

    @Test
    void testPostorderTraversal_RightSkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.right = new TreeTraversals.TreeNode(2);
        root.right.right = new TreeTraversals.TreeNode(3);
        root.right.right.right = new TreeTraversals.TreeNode(4);
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, TreeTraversals.postorderTraversal(root));
    }

    // --- Test Cases for levelOrder (LeetCode 102) ---

    @Test
    void testLevelOrder_Example1() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(3);
        root.left = new TreeTraversals.TreeNode(9);
        root.right = new TreeTraversals.TreeNode(20);
        root.right.left = new TreeTraversals.TreeNode(15);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );
        assertEquals(expected, TreeTraversals.levelOrder(root));
    }

    @Test
    void testLevelOrder_EmptyTree() {
        TreeTraversals.TreeNode root = null;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(expected, TreeTraversals.levelOrder(root));
    }

    @Test
    void testLevelOrder_SingleNodeTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );
        assertEquals(expected, TreeTraversals.levelOrder(root));
    }

    @Test
    void testLevelOrder_FullBinaryTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.left.right = new TreeTraversals.TreeNode(5);
        root.right.left = new TreeTraversals.TreeNode(6);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6, 7)
        );
        assertEquals(expected, TreeTraversals.levelOrder(root));
    }

    @Test
    void testLevelOrder_SkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.left.left = new TreeTraversals.TreeNode(3);
        root.left.left.left = new TreeTraversals.TreeNode(4);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4)
        );
        assertEquals(expected, TreeTraversals.levelOrder(root));
    }

    @Test
    void testLevelOrder_ZigZagTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.right = new TreeTraversals.TreeNode(4);
        root.right.left = new TreeTraversals.TreeNode(5);
        root.left.right.left = new TreeTraversals.TreeNode(6);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6)
        );
        assertEquals(expected, TreeTraversals.levelOrder(root));
    }

    // --- Test Cases for levelOrderBottom (LeetCode 107) ---

    @Test
    void testLevelOrderBottom_Example1() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(3);
        root.left = new TreeTraversals.TreeNode(9);
        root.right = new TreeTraversals.TreeNode(20);
        root.right.left = new TreeTraversals.TreeNode(15);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(15, 7),
                Arrays.asList(9, 20),
                Arrays.asList(3)
        );
        assertEquals(expected, TreeTraversals.levelOrderBottom(root));
    }

    @Test
    void testLevelOrderBottom_EmptyTree() {
        TreeTraversals.TreeNode root = null;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(expected, TreeTraversals.levelOrderBottom(root));
    }

    @Test
    void testLevelOrderBottom_SingleNodeTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );
        assertEquals(expected, TreeTraversals.levelOrderBottom(root));
    }

    @Test
    void testLevelOrderBottom_FullBinaryTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.left.right = new TreeTraversals.TreeNode(5);
        root.right.left = new TreeTraversals.TreeNode(6);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(2, 3),
                Arrays.asList(1)
        );
        assertEquals(expected, TreeTraversals.levelOrderBottom(root));
    }

    @Test
    void testLevelOrderBottom_SkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.left.left = new TreeTraversals.TreeNode(3);
        root.left.left.left = new TreeTraversals.TreeNode(4);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4),
                Arrays.asList(3),
                Arrays.asList(2),
                Arrays.asList(1)
        );
        assertEquals(expected, TreeTraversals.levelOrderBottom(root));
    }

    @Test
    void testLevelOrderBottom_ZigZagTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.right = new TreeTraversals.TreeNode(4);
        root.right.left = new TreeTraversals.TreeNode(5);
        root.left.right.left = new TreeTraversals.TreeNode(6);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(6),
                Arrays.asList(4, 5),
                Arrays.asList(2, 3),
                Arrays.asList(1)
        );
        assertEquals(expected, TreeTraversals.levelOrderBottom(root));
    }

    // --- Test Cases for zigzagLevelOrder (LeetCode 103) ---

    @Test
    void testZigzagLevelOrder_Example1() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(3);
        root.left = new TreeTraversals.TreeNode(9);
        root.right = new TreeTraversals.TreeNode(20);
        root.right.left = new TreeTraversals.TreeNode(15);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(20, 9),
                Arrays.asList(15, 7)
        );
        assertEquals(expected, TreeTraversals.zigzagLevelOrder(root));
    }

    @Test
    void testZigzagLevelOrder_EmptyTree() {
        TreeTraversals.TreeNode root = null;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(expected, TreeTraversals.zigzagLevelOrder(root));
    }

    @Test
    void testZigzagLevelOrder_SingleNodeTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );
        assertEquals(expected, TreeTraversals.zigzagLevelOrder(root));
    }

    @Test
    void testZigzagLevelOrder_FullBinaryTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.left.right = new TreeTraversals.TreeNode(5);
        root.right.left = new TreeTraversals.TreeNode(6);
        root.right.right = new TreeTraversals.TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)
        );
        assertEquals(expected, TreeTraversals.zigzagLevelOrder(root));
    }

    @Test
    void testZigzagLevelOrder_SkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.left.left = new TreeTraversals.TreeNode(3);
        root.left.left.left = new TreeTraversals.TreeNode(4);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4)
        );
        assertEquals(expected, TreeTraversals.zigzagLevelOrder(root));
    }

    @Test
    void testZigzagLevelOrder_ComplexZigzag() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.right.right = new TreeTraversals.TreeNode(5);
        root.left.left.left = new TreeTraversals.TreeNode(6);
        root.right.right.right = new TreeTraversals.TreeNode(7);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5),
                Arrays.asList(7, 6)
        );
        assertEquals(expected, TreeTraversals.zigzagLevelOrder(root));
    }

    // --- Test Cases for maxDepth (LeetCode 104) ---

    @Test
    void testMaxDepth_Example1() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(3);
        root.left = new TreeTraversals.TreeNode(9);
        root.right = new TreeTraversals.TreeNode(20);
        root.right.left = new TreeTraversals.TreeNode(15);
        root.right.right = new TreeTraversals.TreeNode(7);
        int expected = 3;
        assertEquals(expected, TreeTraversals.maxDepth(root));
    }

    @Test
    void testMaxDepth_Example2() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.right = new TreeTraversals.TreeNode(2);
        int expected = 2;
        assertEquals(expected, TreeTraversals.maxDepth(root));
    }

    @Test
    void testMaxDepth_EmptyTree() {
        TreeTraversals.TreeNode root = null;
        int expected = 0;
        assertEquals(expected, TreeTraversals.maxDepth(root));
    }

    @Test
    void testMaxDepth_SingleNodeTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(0);
        int expected = 1;
        assertEquals(expected, TreeTraversals.maxDepth(root));
    }

    @Test
    void testMaxDepth_FullBinaryTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.right = new TreeTraversals.TreeNode(3);
        root.left.left = new TreeTraversals.TreeNode(4);
        root.left.right = new TreeTraversals.TreeNode(5);
        root.right.left = new TreeTraversals.TreeNode(6);
        root.right.right = new TreeTraversals.TreeNode(7);
        int expected = 3;
        assertEquals(expected, TreeTraversals.maxDepth(root));
    }

    @Test
    void testMaxDepth_LeftSkewedTree() {
        TreeTraversals.TreeNode root = new TreeTraversals.TreeNode(1);
        root.left = new TreeTraversals.TreeNode(2);
        root.left.left = new TreeTraversals.TreeNode(3);
        root.left.left.left = new TreeTraversals.TreeNode(4);
        int expected = 4;
        assertEquals(expected, TreeTraversals.maxDepth(root));
    }

    // --- Test Cases for isSameTree (LeetCode 100) ---

    @Test
    void testIsSameTree_Example1() {
        // p = [1,2,3], q = [1,2,3]
        TreeTraversals.TreeNode p = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2), new TreeTraversals.TreeNode(3));
        TreeTraversals.TreeNode q = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2), new TreeTraversals.TreeNode(3));
        assertTrue(TreeTraversals.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_Example2() {
        // p = [1,2], q = [1,null,2]
        TreeTraversals.TreeNode p = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2), null);
        TreeTraversals.TreeNode q = new TreeTraversals.TreeNode(1, null, new TreeTraversals.TreeNode(2));
        assertFalse(TreeTraversals.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_Example3() {
        // p = [1,2,1], q = [1,1,2]
        TreeTraversals.TreeNode p = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2), new TreeTraversals.TreeNode(1));
        TreeTraversals.TreeNode q = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(1), new TreeTraversals.TreeNode(2));
        assertFalse(TreeTraversals.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_BothEmpty() {
        TreeTraversals.TreeNode p = null;
        TreeTraversals.TreeNode q = null;
        assertTrue(TreeTraversals.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_OneEmpty() {
        TreeTraversals.TreeNode p = new TreeTraversals.TreeNode(1);
        TreeTraversals.TreeNode q = null;
        assertFalse(TreeTraversals.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_DifferentValues() {
        TreeTraversals.TreeNode p = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2), new TreeTraversals.TreeNode(3));
        TreeTraversals.TreeNode q = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2), new TreeTraversals.TreeNode(4));
        assertFalse(TreeTraversals.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_DifferentStructure() {
        TreeTraversals.TreeNode p = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2, new TreeTraversals.TreeNode(3), null), null);
        TreeTraversals.TreeNode q = new TreeTraversals.TreeNode(1, new TreeTraversals.TreeNode(2), null);
        assertFalse(TreeTraversals.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_DeepIdenticalTrees() {
        TreeTraversals.TreeNode p = new TreeTraversals.TreeNode(1,
                new TreeTraversals.TreeNode(2,
                        new TreeTraversals.TreeNode(4),
                        new TreeTraversals.TreeNode(5)),
                new TreeTraversals.TreeNode(3,
                        new TreeTraversals.TreeNode(6),
                        new TreeTraversals.TreeNode(7))
        );
        TreeTraversals.TreeNode q = new TreeTraversals.TreeNode(1,
                new TreeTraversals.TreeNode(2,
                        new TreeTraversals.TreeNode(4),
                        new TreeTraversals.TreeNode(5)),
                new TreeTraversals.TreeNode(3,
                        new TreeTraversals.TreeNode(6),
                        new TreeTraversals.TreeNode(7))
        );
        assertTrue(TreeTraversals.isSameTree(p, q));
    }
    
}
