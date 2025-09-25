package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import advancedproblems.TreeProblems1;
import advancedproblems.TreeTraversals;
import advancedproblems.TreeProblems1;

public class TreeProblems1Test {

    // --- Test Cases for maxDepth (LeetCode 104) ---

    @Test
    void testMaxDepth_Example1() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(3);
        root.left = new TreeProblems1.TreeNode(9);
        root.right = new TreeProblems1.TreeNode(20);
        root.right.left = new TreeProblems1.TreeNode(15);
        root.right.right = new TreeProblems1.TreeNode(7);
        int expected = 3;
        assertEquals(expected, TreeProblems1.maxDepth(root));
    }

    @Test
    void testMaxDepth_Example2() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        root.right = new TreeProblems1.TreeNode(2);
        int expected = 2;
        assertEquals(expected, TreeProblems1.maxDepth(root));
    }

    @Test
    void testMaxDepth_EmptyTree() {
        TreeProblems1.TreeNode root = null;
        int expected = 0;
        assertEquals(expected, TreeProblems1.maxDepth(root));
    }

    @Test
    void testMaxDepth_SingleNodeTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(0);
        int expected = 1;
        assertEquals(expected, TreeProblems1.maxDepth(root));
    }

    @Test
    void testMaxDepth_FullBinaryTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        root.left = new TreeProblems1.TreeNode(2);
        root.right = new TreeProblems1.TreeNode(3);
        root.left.left = new TreeProblems1.TreeNode(4);
        root.left.right = new TreeProblems1.TreeNode(5);
        root.right.left = new TreeProblems1.TreeNode(6);
        root.right.right = new TreeProblems1.TreeNode(7);
        int expected = 3;
        assertEquals(expected, TreeProblems1.maxDepth(root));
    }

    @Test
    void testMaxDepth_LeftSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        root.left = new TreeProblems1.TreeNode(2);
        root.left.left = new TreeProblems1.TreeNode(3);
        root.left.left.left = new TreeProblems1.TreeNode(4);
        int expected = 4;
        assertEquals(expected, TreeProblems1.maxDepth(root));
    }

    // --- Test Cases for isSameTree (LeetCode 100) ---

    @Test
    void testIsSameTree_Example1() {
        // p = [1,2,3], q = [1,2,3]
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), new TreeProblems1.TreeNode(3));
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), new TreeProblems1.TreeNode(3));
        assertTrue(TreeProblems1.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_Example2() {
        // p = [1,2], q = [1,null,2]
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), null);
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(1, null, new TreeProblems1.TreeNode(2));
        assertFalse(TreeProblems1.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_Example3() {
        // p = [1,2,1], q = [1,1,2]
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), new TreeProblems1.TreeNode(1));
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(1), new TreeProblems1.TreeNode(2));
        assertFalse(TreeProblems1.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_BothEmpty() {
        TreeProblems1.TreeNode p = null;
        TreeProblems1.TreeNode q = null;
        assertTrue(TreeProblems1.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_OneEmpty() {
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1);
        TreeProblems1.TreeNode q = null;
        assertFalse(TreeProblems1.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_DifferentValues() {
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), new TreeProblems1.TreeNode(3));
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), new TreeProblems1.TreeNode(4));
        assertFalse(TreeProblems1.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_DifferentStructure() {
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2, new TreeProblems1.TreeNode(3), null), null);
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), null);
        assertFalse(TreeProblems1.isSameTree(p, q));
    }

    @Test
    void testIsSameTree_DeepIdenticalTrees() {
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3,
                        new TreeProblems1.TreeNode(6),
                        new TreeProblems1.TreeNode(7))
        );
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3,
                        new TreeProblems1.TreeNode(6),
                        new TreeProblems1.TreeNode(7))
        );
        assertTrue(TreeProblems1.isSameTree(p, q));
    }

    // --- Test Cases for invertTree (LeetCode 226) ---

    @Test
    void testInvertTree_Example1() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(4,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(1),
                        new TreeProblems1.TreeNode(3)),
                new TreeProblems1.TreeNode(7,
                        new TreeProblems1.TreeNode(6),
                        new TreeProblems1.TreeNode(9))
        );
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(4,
                new TreeProblems1.TreeNode(7,
                        new TreeProblems1.TreeNode(9),
                        new TreeProblems1.TreeNode(6)),
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3),
                        new TreeProblems1.TreeNode(1))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.invertTree(root)));
    }

    @Test
    void testInvertTree_Example2() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(2,
                new TreeProblems1.TreeNode(1),
                new TreeProblems1.TreeNode(3)
        );
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(2,
                new TreeProblems1.TreeNode(3),
                new TreeProblems1.TreeNode(1)
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.invertTree(root)));
    }

    @Test
    void testInvertTree_EmptyTree() {
        TreeProblems1.TreeNode root = null;
        TreeProblems1.TreeNode expected = null;
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.invertTree(root)));
    }

    @Test
    void testInvertTree_SingleNodeTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1);
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.invertTree(root)));
    }

    @Test
    void testInvertTree_LeftSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null
        );
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                null,
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3,
                                null,
                                new TreeProblems1.TreeNode(4)))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.invertTree(root)));
    }

    @Test
    void testInvertTree_RightSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                null,
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3,
                                null,
                                new TreeProblems1.TreeNode(4)))
        );
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.invertTree(root)));
    }

    // --- Test Cases for isSymmetric (LeetCode 101) ---

    @Test
    void testIsSymmetric_Example1() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3),
                        new TreeProblems1.TreeNode(4)),
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(3))
        );
        assertTrue(TreeProblems1.isSymmetric(root));
    }

    @Test
    void testIsSymmetric_Example2() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3)),
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3))
        );
        assertFalse(TreeProblems1.isSymmetric(root));
    }

    @Test
    void testIsSymmetric_EmptyTree() {
        TreeProblems1.TreeNode root = null;
        assertTrue(TreeProblems1.isSymmetric(root));
    }

    @Test
    void testIsSymmetric_SingleNodeTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        assertTrue(TreeProblems1.isSymmetric(root));
    }

    @Test
    void testIsSymmetric_AsymmetricTree_OneSideMissing() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2),
                null);
        assertFalse(TreeProblems1.isSymmetric(root));
    }

    @Test
    void testIsSymmetric_AsymmetricTree_DifferentValues() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3),
                        new TreeProblems1.TreeNode(4)),
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3),
                        new TreeProblems1.TreeNode(5))
        );
        assertFalse(TreeProblems1.isSymmetric(root));
    }

    @Test
    void testIsSymmetric_AsymmetricTree_DeepNodes() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3,
                                null,
                                new TreeProblems1.TreeNode(4)))
        );
        assertTrue(TreeProblems1.isSymmetric(root));
    }

    @Test
    void testIsSymmetric_ComplexSymmetricTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(10,
                new TreeProblems1.TreeNode(5,
                        new TreeProblems1.TreeNode(1, null, null),
                        new TreeProblems1.TreeNode(7, null, null)),
                new TreeProblems1.TreeNode(5,
                        new TreeProblems1.TreeNode(7, null, null),
                        new TreeProblems1.TreeNode(1, null, null))
        );
        assertTrue(TreeProblems1.isSymmetric(root));
    }

    // --- Test Cases for buildTree (LeetCode 105) ---

    @Test
    void testBuildTree_Example1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(3,
                new TreeProblems1.TreeNode(9),
                new TreeProblems1.TreeNode(20,
                        new TreeProblems1.TreeNode(15),
                        new TreeProblems1.TreeNode(7))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree(preorder, inorder)));
    }

    @Test
    void testBuildTree_Example2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(-1);
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree(preorder, inorder)));
    }

    @Test
    void testBuildTree_EmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        TreeProblems1.TreeNode expected = null;
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree(preorder, inorder)));
    }

    @Test
    void testBuildTree_FullBinaryTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3,
                        new TreeProblems1.TreeNode(6),
                        new TreeProblems1.TreeNode(7))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree(preorder, inorder)));
    }

    @Test
    void testBuildTree_LeftSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null);
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree(preorder, inorder)));
    }

    @Test
    void testBuildTree_RightSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                null,
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3,
                                null,
                                new TreeProblems1.TreeNode(4)))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree(preorder, inorder)));
    }

    // --- Test Cases for buildTree2 (LeetCode 106) ---

    @Test
    void testBuildTree2_Example1() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(3,
                new TreeProblems1.TreeNode(9),
                new TreeProblems1.TreeNode(20,
                        new TreeProblems1.TreeNode(15),
                        new TreeProblems1.TreeNode(7))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree2(inorder, postorder)));
    }

    @Test
    void testBuildTree2_Example2() {
        int[] inorder = {-1};
        int[] postorder = {-1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(-1);
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree2(inorder, postorder)));
    }

    @Test
    void testBuildTree2_EmptyArrays() {
        int[] inorder = {};
        int[] postorder = {};
        TreeProblems1.TreeNode expected = null;
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree2(inorder, postorder)));
    }

    @Test
    void testBuildTree2_FullBinaryTree() {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3,
                        new TreeProblems1.TreeNode(6),
                        new TreeProblems1.TreeNode(7))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree2(inorder, postorder)));
    }

    @Test
    void testBuildTree2_LeftSkewedTree() {
        int[] inorder = {4, 3, 2, 1};
        int[] postorder = {4, 3, 2, 1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null);
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree2(inorder, postorder)));
    }

    @Test
    void testBuildTree2_RightSkewedTree() {
        int[] inorder = {1, 2, 3, 4};
        int[] postorder = {4, 3, 2, 1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                null,
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3,
                                null,
                                new TreeProblems1.TreeNode(4)))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.buildTree2(inorder, postorder)));
    }

    // --- Test Cases for constructFromPrePost (LeetCode 889) ---

    @Test
    void testConstructFromPrePost_Example1() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3,
                        new TreeProblems1.TreeNode(6),
                        new TreeProblems1.TreeNode(7))
        );
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.constructFromPrePost(preorder, postorder)));
    }

    @Test
    void testConstructFromPrePost_Example2() {
        int[] preorder = {1, 2, 3};
        int[] postorder = {2, 3, 1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2, null, null),
                new TreeProblems1.TreeNode(3, null, null));
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.constructFromPrePost(preorder, postorder)));
    }

    @Test
    void testConstructFromPrePost_EmptyArrays() {
        int[] preorder = {};
        int[] postorder = {};
        TreeProblems1.TreeNode expected = null;
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.constructFromPrePost(preorder, postorder)));
    }

    @Test
    void testConstructFromPrePost_SingleNode() {
        int[] preorder = {1};
        int[] postorder = {1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1);
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.constructFromPrePost(preorder, postorder)));
    }

    @Test
    void testConstructFromPrePost_LeftSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] postorder = {4, 3, 2, 1};
        TreeProblems1.TreeNode expected = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null);
        assertTrue(TreeProblems1.isSameTree(expected, TreeProblems1.constructFromPrePost(preorder, postorder)));
    }

    // --- Test Cases for rightSideView (LeetCode 199) ---

    @Test
    void testRightSideView_Example1() {
        // [1,2,3,null,5,null,4]
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2, null, new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3, null, new TreeProblems1.TreeNode(4))
        );
        List<Integer> expected = Arrays.asList(1, 3, 4);
        assertEquals(expected, TreeProblems1.rightSideView(root));
    }

    @Test
    void testRightSideView_Example2() {
        // [1,null,3]
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                null,
                new TreeProblems1.TreeNode(3)
        );
        List<Integer> expected = Arrays.asList(1, 3);
        assertEquals(expected, TreeProblems1.rightSideView(root));
    }

    @Test
    void testRightSideView_EmptyTree() {
        TreeProblems1.TreeNode root = null;
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, TreeProblems1.rightSideView(root));
    }

    @Test
    void testRightSideView_SingleNodeTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, TreeProblems1.rightSideView(root));
    }

    @Test
    void testRightSideView_FullBinaryTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3,
                        new TreeProblems1.TreeNode(6),
                        new TreeProblems1.TreeNode(7))
        );
        List<Integer> expected = Arrays.asList(1, 3, 7);
        assertEquals(expected, TreeProblems1.rightSideView(root));
    }

    @Test
    void testRightSideView_LeftSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null
        );
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, TreeProblems1.rightSideView(root));
    }

    @Test
    void testRightSideView_RightSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                null,
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3,
                                null,
                                new TreeProblems1.TreeNode(4)))
        );
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, TreeProblems1.rightSideView(root));
    }

    // --- Test Cases for hasPathSum (LeetCode 112) ---

    @Test
    void testHasPathSum_Example1() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(5,
                new TreeProblems1.TreeNode(4,
                        new TreeProblems1.TreeNode(11,
                                new TreeProblems1.TreeNode(7),
                                new TreeProblems1.TreeNode(2)),
                        null),
                new TreeProblems1.TreeNode(8,
                        new TreeProblems1.TreeNode(13),
                        new TreeProblems1.TreeNode(4,
                                null,
                                new TreeProblems1.TreeNode(1)))
        );
        int targetSum = 22;
        assertTrue(TreeProblems1.hasPathSum(root, targetSum));
    }

    @Test
    void testHasPathSum_Example2() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2),
                new TreeProblems1.TreeNode(3)
        );
        int targetSum = 5;
        assertFalse(TreeProblems1.hasPathSum(root, targetSum));
    }

    @Test
    void testHasPathSum_EmptyTree() {
        TreeProblems1.TreeNode root = null;
        int targetSum = 0;
        assertFalse(TreeProblems1.hasPathSum(root, targetSum));
    }

    @Test
    void testHasPathSum_SingleNodeTree_True() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        int targetSum = 1;
        assertTrue(TreeProblems1.hasPathSum(root, targetSum));
    }

    @Test
    void testHasPathSum_SingleNodeTree_False() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        int targetSum = 0;
        assertFalse(TreeProblems1.hasPathSum(root, targetSum));
    }

    @Test
    void testHasPathSum_LeftSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null);
        int targetSum = 10;
        assertTrue(TreeProblems1.hasPathSum(root, targetSum));
    }

    @Test
    void testHasPathSum_NegativeNumbers_True() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(-5),
                        null),
                new TreeProblems1.TreeNode(3));
        int targetSum = -2;
        assertTrue(TreeProblems1.hasPathSum(root, targetSum));
    }

    @Test
    void testHasPathSum_NoPathExists() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(5,
                new TreeProblems1.TreeNode(4,
                        new TreeProblems1.TreeNode(11,
                                new TreeProblems1.TreeNode(7),
                                new TreeProblems1.TreeNode(2)),
                        null),
                new TreeProblems1.TreeNode(8,
                        new TreeProblems1.TreeNode(13),
                        new TreeProblems1.TreeNode(4,
                                null,
                                new TreeProblems1.TreeNode(1)))
        );
        int targetSum = 20;
        assertFalse(TreeProblems1.hasPathSum(root, targetSum));
    }

    // --- Test Cases for pathSum (LeetCode 113) ---

    @Test
    void testPathSum_Example1() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(5,
                new TreeProblems1.TreeNode(4,
                        new TreeProblems1.TreeNode(11,
                                new TreeProblems1.TreeNode(7),
                                new TreeProblems1.TreeNode(2)),
                        null),
                new TreeProblems1.TreeNode(8,
                        new TreeProblems1.TreeNode(13),
                        new TreeProblems1.TreeNode(4,
                                new TreeProblems1.TreeNode(5),
                                new TreeProblems1.TreeNode(1)))
        );
        int targetSum = 22;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(5, 4, 11, 2),
                Arrays.asList(5, 8, 4, 5)
        );
        assertEquals(expected, TreeProblems1.pathSum(root, targetSum));
    }

    @Test
    void testPathSum_Example2() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2),
                new TreeProblems1.TreeNode(3)
        );
        int targetSum = 5;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(expected, TreeProblems1.pathSum(root, targetSum));
    }

    @Test
    void testPathSum_EmptyTree() {
        TreeProblems1.TreeNode root = null;
        int targetSum = 0;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(expected, TreeProblems1.pathSum(root, targetSum));
    }

    @Test
    void testPathSum_SingleNode_True() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        int targetSum = 1;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1));
        assertEquals(expected, TreeProblems1.pathSum(root, targetSum));
    }

    @Test
    void testPathSum_SingleNode_False() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        int targetSum = 2;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(expected, TreeProblems1.pathSum(root, targetSum));
    }

    @Test
    void testPathSum_LeftSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null);
        int targetSum = 10;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3, 4)
        );
        assertEquals(expected, TreeProblems1.pathSum(root, targetSum));
    }

    @Test
    void testPathSum_NegativeNumbers() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(10,
                new TreeProblems1.TreeNode(5,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(3),
                                new TreeProblems1.TreeNode(-2)),
                        new TreeProblems1.TreeNode(2,
                                null,
                                new TreeProblems1.TreeNode(1))),
                new TreeProblems1.TreeNode(-3,
                        null,
                        new TreeProblems1.TreeNode(11)));
        int targetSum = 18;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(10, 5, 2,1),
                Arrays.asList(10, -3,11)
        );
        assertEquals(expected, TreeProblems1.pathSum(root, targetSum));
    }

    // --- Test Cases for diameterOfBinaryTree (LeetCode 543) ---

    @Test
    void testDiameterOfBinaryTree_Example1() {
        // [1,2,3,4,5]
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(4),
                        new TreeProblems1.TreeNode(5)),
                new TreeProblems1.TreeNode(3)
        );
        int expected = 3;
        assertEquals(expected, TreeProblems1.diameterOfBinaryTree(root));
    }

    @Test
    void testDiameterOfBinaryTree_Example2() {
        // [1,2]
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1, new TreeProblems1.TreeNode(2), null);
        int expected = 1;
        assertEquals(expected, TreeProblems1.diameterOfBinaryTree(root));
    }

    @Test
    void testDiameterOfBinaryTree_EmptyTree() {
        TreeProblems1.TreeNode root = null;
        int expected = 0;
        assertEquals(expected, TreeProblems1.diameterOfBinaryTree(root));
    }

    @Test
    void testDiameterOfBinaryTree_SingleNodeTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1);
        int expected = 0;
        assertEquals(expected, TreeProblems1.diameterOfBinaryTree(root));
    }

    @Test
    void testDiameterOfBinaryTree_LeftSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(3,
                                new TreeProblems1.TreeNode(4),
                                null),
                        null),
                null
        );
        int expected = 3;
        assertEquals(expected, TreeProblems1.diameterOfBinaryTree(root));
    }

    @Test
    void testDiameterOfBinaryTree_RightSkewedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(1,
                null,
                new TreeProblems1.TreeNode(2,
                        null,
                        new TreeProblems1.TreeNode(3,
                                null,
                                new TreeProblems1.TreeNode(4)))
        );
        int expected = 3;
        assertEquals(expected, TreeProblems1.diameterOfBinaryTree(root));
    }

    @Test
    void testDiameterOfBinaryTree_UnbalancedTree() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(10,
                new TreeProblems1.TreeNode(5,
                        new TreeProblems1.TreeNode(3),
                        new TreeProblems1.TreeNode(7,
                                null,
                                new TreeProblems1.TreeNode(8))),
                new TreeProblems1.TreeNode(15)
        );
        int expected = 4;
        assertEquals(expected, TreeProblems1.diameterOfBinaryTree(root));
    }

    // --- Test Cases for lowestCommonAncestor (LeetCode 236) ---

    @Test
    void testLowestCommonAncestor_Example1() {
        // [3,5,1,6,2,0,8,null,null,7,4]
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(3);
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(5);
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(1);

        root.left = p;
        root.right = q;
        p.left = new TreeProblems1.TreeNode(6);
        p.right = new TreeProblems1.TreeNode(2,
                new TreeProblems1.TreeNode(7),
                new TreeProblems1.TreeNode(4));
        q.left = new TreeProblems1.TreeNode(0);
        q.right = new TreeProblems1.TreeNode(8);

        TreeProblems1.TreeNode result = TreeProblems1.lowestCommonAncestor(root, p, q);
        assertEquals(3, result.val);
    }

    @Test
    void testLowestCommonAncestor_Example2() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(3);
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(5);
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(4);

        root.left = p;
        root.right = new TreeProblems1.TreeNode(1,
                new TreeProblems1.TreeNode(0),
                new TreeProblems1.TreeNode(8));
        p.left = new TreeProblems1.TreeNode(6);
        p.right = new TreeProblems1.TreeNode(2,
                new TreeProblems1.TreeNode(7),
                q);

        TreeProblems1.TreeNode result = TreeProblems1.lowestCommonAncestor(root, p, q);
        assertEquals(5, result.val);
    }

    @Test
    void testLowestCommonAncestor_Example3() {
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(1);
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(2);
        p.left = q;

        TreeProblems1.TreeNode result = TreeProblems1.lowestCommonAncestor(p, p, q);
        assertEquals(1, result.val);
    }

    @Test
    void testLowestCommonAncestor_OneNodeIsRoot() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(10,
                new TreeProblems1.TreeNode(5),
                new TreeProblems1.TreeNode(15)
        );
        TreeProblems1.TreeNode p = root.left;
        TreeProblems1.TreeNode q = root;
        TreeProblems1.TreeNode result = TreeProblems1.lowestCommonAncestor(root, p, q);
        assertEquals(10, result.val);
    }

    @Test
    void testLowestCommonAncestor_P_and_Q_SameNode() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(10,
                new TreeProblems1.TreeNode(5),
                new TreeProblems1.TreeNode(15)
        );
        TreeProblems1.TreeNode p = root.left;
        TreeProblems1.TreeNode q = root.left;
        TreeProblems1.TreeNode result = TreeProblems1.lowestCommonAncestor(root, p, q);
        assertEquals(5, result.val);
    }

    @Test
    void testLowestCommonAncestor_P_Ancestor_of_Q() {
        TreeProblems1.TreeNode p = new TreeProblems1.TreeNode(10);
        TreeProblems1.TreeNode q = new TreeProblems1.TreeNode(5);
        p.left = q;
        TreeProblems1.TreeNode result = TreeProblems1.lowestCommonAncestor(p, p, q);
        assertEquals(10, result.val);
    }

    @Test
    void testLowestCommonAncestor_P_and_Q_in_Different_Subtrees() {
        TreeProblems1.TreeNode root = new TreeProblems1.TreeNode(6,
                new TreeProblems1.TreeNode(2,
                        new TreeProblems1.TreeNode(0),
                        new TreeProblems1.TreeNode(4)),
                new TreeProblems1.TreeNode(8,
                        new TreeProblems1.TreeNode(7),
                        new TreeProblems1.TreeNode(9))
        );
        TreeProblems1.TreeNode p = root.left.left;
        TreeProblems1.TreeNode q = root.right.right;
        TreeProblems1.TreeNode result = TreeProblems1.lowestCommonAncestor(root, p, q);
        assertEquals(6, result.val);
    }
    
}
