package advancedproblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


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

    /* Using Stack and iteration
    public static List<Integer> inorderTraversal(TreeNode root) {
        //List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // go as left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // process the node
            current = stack.pop();
            result.add(current.val);
            // now go right
            current = current.right;
        }

        return result;
    }*/


    //Leetcode problem https://leetcode.com/problems/binary-tree-preorder-traversal/
    public static List<Integer> preorderTraversal(TreeNode root) {

        if(root==null)
        return result;

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
        
    }
 
    /*
    List<Integer> preorderIter(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);  // visit root (same as recursion)

        // Push right first (so left is processed first)
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
    return result;
} */



    //Leetcode problem https://leetcode.com/problems/binary-tree-postorder-traversal/
    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
        return result;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);

        return result;
        
    }
    /* 
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }

        return res;
    }*/


    //Leetcode Problem https://leetcode.com/problems/binary-tree-level-order-traversal/
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
        return result;
        TreeNode[] nodeQueue = new TreeNode[2000];
        int front=-1,rear=-1;
        //Queue<TreeNode> nodeQueue = new ArrayDeque<>(); // can use LinkedList<>() also
        List<Integer> nodeList;
        TreeNode node;
        int size;

        //nodeQueue.add(root);
        nodeQueue[++rear] = root;
        front++;

        //while(!nodeQueue.isEmpty())
        while(front<=rear)
        {
           nodeList = new ArrayList<>();

           size = rear-front+1;
          //size = nodeQueue.size();


          for(int i=0;i<size;i++)
          {
           node = nodeQueue[front++];
           //node = nodeQueue.poll();
           nodeList.add(node.val);
           if(node.left!=null)
           nodeQueue[++rear] = node.left;
           //nodeQueue.add(node.left);
           if(node.right!=null)
           nodeQueue[++rear] = node.right;
           //nodeQueue.add(node.right);
          }

           result.add(nodeList);
        }

        return result;
    }

    //Leetcode problem https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
        return result;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        List<Integer> nodeList ;
        TreeNode node;
        int size;

        nodeQueue.add(root);

        while(!nodeQueue.isEmpty())
        {
           nodeList = new ArrayList<>();
           size = nodeQueue.size();

           for(int i=0;i<size;i++)
           {
            node = nodeQueue.poll();
            nodeList.add(node.val);
            if(node.left!=null)
            nodeQueue.add(node.left);
            if(node.right!=null)
            nodeQueue.add(node.right);
           }

           result.add(0,nodeList);
        }

        return result;
        
    }

    //Leetcode Problem https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
        return result;
        Queue<TreeNode> nodeQue = new ArrayDeque<>();
        List<Integer> nodelist;
        int size;
        TreeNode node;
        boolean startLeft= true;
        nodeQue.add(root);

        while(!nodeQue.isEmpty())
        {
            nodelist = new ArrayList<>();
            size = nodeQue.size();

            for(int i=0;i<size;i++)
            {
                node = nodeQue.poll();

                nodelist.add(node.val);

                if(node.left!=null)
                nodeQue.add(node.left);
                if(node.right!=null)
                nodeQue.add(node.right);
            }
            
            if(!startLeft)
            Collections.reverse(nodelist);

            result.add(nodelist);
            startLeft=!startLeft;
        }

        return result;
        
    }
    
}
