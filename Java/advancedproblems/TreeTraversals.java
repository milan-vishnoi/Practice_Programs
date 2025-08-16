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

    public static List<Integer> inorderResult;
    public static List<Integer> inorderTraversal(TreeNode root) {

        if(root==null)
        return inorderResult;

        inorderTraversal(root.left);
        inorderResult.add(root.val);
        inorderTraversal(root.right);

        return inorderResult;
    }
    
}
