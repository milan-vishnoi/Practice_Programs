package Trees;

public class TreeTraversal {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> leftChild;
        BinaryTreeNode<T> rightChild;

        BinaryTreeNode(T data){
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    public static void preOrder(BinaryTreeNode<?> root) {
              if(root == null)
              return;

             System.out.print(root.data+" ");
             preOrder(root.leftChild);
             preOrder(root.rightChild);
    }

    public static void inOrder(BinaryTreeNode<?> root){
        if(root == null)
        return;

        inOrder(root.leftChild);
        System.out.print(root.data+" ");
        inOrder(root.rightChild);
    }

    public static void postOrder(BinaryTreeNode<?> root)
    {
        if(root == null)
        return;
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data+" ");

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        root.leftChild = new BinaryTreeNode<Integer>(2);
        root.rightChild = new BinaryTreeNode<Integer>(3);
        root.leftChild.leftChild = new BinaryTreeNode<Integer>(4);
        root.leftChild.rightChild = new BinaryTreeNode<Integer>(5);
        root.rightChild.leftChild = new BinaryTreeNode<Integer>(6);
        root.rightChild.rightChild = new BinaryTreeNode<Integer>(7);

       System.out.print("PreOrder:");
       preOrder(root);
       System.out.print("\nInOrder:");
       inOrder(root);
       System.out.print("\nPostOrder:");
       postOrder(root);
    }



}
