package advancedproblems;

import java.util.HashMap;
import java.util.Map;

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

    //Leetcode Problem https://leetcode.com/problems/symmetric-tree/
    public static boolean isSymmetric(TreeNode root) {

        if(root==null)
        return true;

        return checkMirror(root.left,root.right);
        
    }

    private static boolean checkMirror(TreeNode p, TreeNode q)
    {

        if(p==null || q==null)
        return p==q;
        if(p.val!=q.val)
        return false;

        return checkMirror(p.left,q.right) && checkMirror(p.right,q.left);
    }
    
    //Leetcode problem https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    static int preIndex;
    public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        TreeNode result = null;
        preIndex=0;
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        inMap.put(inorder[i],i);
        result = construct(preorder,0,inorder.length-1,inMap);

        return result;        
    }

    private static TreeNode construct(int[] preorder,int inStart, int inEnd, Map<Integer,Integer> inMap)
    {
        if(inStart>inEnd)
        return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int rootIndex = inMap.get(root.val);
        root.left = construct(preorder, inStart, rootIndex-1, inMap);
        root.right = construct(preorder, rootIndex+1, inEnd, inMap);

        return  root;
    }

    //Leetcode Problem https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    static int postIndex;
    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        TreeNode result = null;
        postIndex = postorder.length-1;
        if(postIndex<0)
        return result;
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        inMap.put(inorder[i],i);
        
        result = construct2(postorder,0,inorder.length-1,inMap);

        return result;
    }

    private static TreeNode construct2(int[] postorder,int inStart,int inEnd,Map<Integer,Integer> inMap)
    {
        if(inStart>inEnd)
        return null;

        TreeNode root = new TreeNode(postorder[postIndex--]);
        int rootIndex = inMap.get(root.val);

        root.right = construct2(postorder,rootIndex+1,inEnd,inMap);
        root.left = construct2(postorder,inStart,rootIndex-1,inMap);

        return root;
    }

    //Leetcode Problem https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode result = null;
        Map<Integer,Integer> postMap = new HashMap<>();
        for(int i=0;i<postorder.length;i++)
        postMap.put(postorder[i],i);

        result = construct(preorder,0,preorder.length-1,postorder,0,postorder.length-1,postMap);

        return result;
    }

    private static TreeNode construct(int[] preorder,int preStart, int preEnd,int[] postorder,int postStart, int postEnd,Map<Integer,Integer> postMap)
    {
        if(preStart>preEnd || postStart>postEnd)
        return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart==preEnd)
         return root;

        int leftVal = preorder[preStart+1];
        int leftIndex = postMap.get(leftVal);
        int leftSize = leftIndex - postStart+1; 

        root.left = construct(preorder,preStart+1,preStart+leftSize,postorder,postStart,leftIndex,postMap);
        root.right = construct(preorder,preStart+leftSize+1,preEnd,postorder,leftIndex+1,postEnd-1,postMap);

        return root;

    }

}
