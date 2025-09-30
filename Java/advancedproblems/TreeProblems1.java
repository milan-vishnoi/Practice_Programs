package advancedproblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

    //Leetcode Problem https://leetcode.com/problems/binary-tree-right-side-view/
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
        return result;
        Deque<TreeNode> nodeQue = new ArrayDeque<>();
        nodeQue.add(root);

        int size;

        while(!nodeQue.isEmpty())
        {
            size = nodeQue.size();
            result.add(nodeQue.peekLast().val);
            for(int i=0;i<size;i++)
            {
                TreeNode node = nodeQue.pollFirst();
                if(node.left!=null)
                nodeQue.add(node.left);
                if(node.right!=null)
                nodeQue.add(node.right);
            }
        }

        return result;
    }


    //Leetcode Problem https://leetcode.com/problems/path-sum/
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        return false;

       targetSum = targetSum-root.val;
        if(root.left==null&&root.right==null && targetSum==0)
            return true;
        boolean leftPath=false, rightPath=false;
        if(root.left!=null)
        leftPath = hasPathSum(root.left,targetSum);

        if(root.right!=null)
         rightPath = hasPathSum(root.right,targetSum);


        return leftPath || rightPath;
        
    }

    //Leetcode Problem https://leetcode.com/problems/path-sum-ii/
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        return result;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);

        calculateSum(root,targetSum,path,result);
        return result;
    }

    private static void calculateSum(TreeNode root, int targetSum, List<Integer> path,List<List<Integer>> result)
    {
        targetSum = targetSum - root.val;

        if(root.left==null && root.right==null && targetSum==0)
        {
           result.add(new ArrayList<>(path));
           return;
        }

        if(root.left!=null)
        {
          path.add(root.left.val);
          calculateSum(root.left,targetSum,path,result);
          path.remove(path.size()-1);
        }


        if(root.right!=null)
        {
        path.add(root.right.val);
        calculateSum(root.right,targetSum,path,result);
        path.remove(path.size()-1);
        }
    }

    //Leetcode problem https://leetcode.com/problems/diameter-of-binary-tree/
    static int diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;

        diameter= 0;

        calculateHeight(root);

        return diameter;
        
    }

    private static int calculateHeight(TreeNode root)
    {
        if(root==null)
        return 0;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        diameter = Math.max(diameter,leftHeight+rightHeight);

        return 1+Math.max(leftHeight,rightHeight);
    }

    //Leetcode Problem https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)
        return null;
        if( root==p || root==q)
        return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right != null)
        return root;

        if(left!=null)
        return left;
        else
        return right;
        
    }

    //Leetcode Problem https://leetcode.com/problems/binary-tree-maximum-path-sum/
    static int maxSum;
    public static int maxPathSum(TreeNode root) {
        if(root==null)
        return 0;

        maxSum = Integer.MIN_VALUE;

       calculateSum(root);

        return maxSum;
        
    }

    private static int calculateSum(TreeNode root)
    {
       if(root==null)
        return 0;
        int leftSum = Math.max(0,calculateSum(root.left));
        int rightSum = Math.max(0,calculateSum(root.right));
        int currentSum = root.val + Math.max(leftSum,rightSum);
        maxSum = Math.max(maxSum,root.val+leftSum+rightSum);

        return currentSum;
    }

    //Leetcode Problem https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ (part1)
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> nodeq = new LinkedList<>();
        nodeq.add(root);
        int size;
        int actualLength=0;
        while (!nodeq.isEmpty()) {
            size = nodeq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeq.poll();
                if (node == null) {
                    sb.append("#,");
                } else {
                    sb.append(Integer.toString(node.val)+",");
                    actualLength = sb.length()-1;
                    nodeq.add(node.left);
                    nodeq.add(node.right);
                }

            }
        }
        String s = sb.substring(0,actualLength).toString();
        return s;

    }

    //Leetcode Problem https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ (part2)
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data == "")
            return null;
        String[] serialized = data.split(",");
        Queue<TreeNode> nodeq = new ArrayDeque<>();

        TreeNode root = new TreeNode(Integer.parseInt(serialized[0]));
        TreeNode node;
        nodeq.add(root);
        for(int i=1;i<serialized.length;i++)
        {
            node = nodeq.poll();
            if(!serialized[i].equals("#"))
            {
                node.left = new TreeNode(Integer.parseInt(serialized[i]));
                nodeq.add(node.left);
            }
            i++;
            if(i<serialized.length && !serialized[i].equals("#"))
            {
            node.right= new TreeNode(Integer.parseInt(serialized[i]));
            nodeq.add(node.right);
            }

        }
        return  root;
    }
}
