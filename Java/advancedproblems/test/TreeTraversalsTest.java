package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    
}
