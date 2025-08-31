package advancedproblems;

public class TreeProblems1 {
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

    //Leetcode Problem https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public static int maxDepth(TreeNode root) {
        
        if(root==null)
        return 0;

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //Leetcode Problem https://leetcode.com/problems/same-tree/
     public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null || q==null)
        return p==q;
        if(p.val!=q.val)
        return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }

    //Leetcode Problem https://leetcode.com/problems/invert-binary-tree/
   public static TreeNode invertTree(TreeNode root) {

        if(root==null)
        return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
        
    }
    
}
