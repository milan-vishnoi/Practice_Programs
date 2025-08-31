package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
    
}
