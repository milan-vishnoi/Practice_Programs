package advancedproblems;

import java.util.ArrayList;
import java.util.List;


public class TreeTraversals {

   public static class TreeNode {
       public int val;
       public TreeNode left;
       public TreeNode right;
       public TreeNode() {}
       public TreeNode(int val) { this.val = val; }
       public TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

    public static List<Integer> result;

    //Leetcode Problem https://leetcode.com/problems/binary-tree-inorder-traversal/
    public static List<Integer> inorderTraversal(TreeNode root) {

        if(root==null)
        return result;

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }

    //Leetcode problem https://leetcode.com/problems/binary-tree-preorder-traversal/
    public static List<Integer> preorderTraversal(TreeNode root) {

        if(root==null)
        return result;

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
        
    }

    //Leetcode problem https://leetcode.com/problems/binary-tree-postorder-traversal/
    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
        return result;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);

        return result;
        
    }
    
}
