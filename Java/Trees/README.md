# Tree Traversal
There are three ways in which we cn traverse the binary tree.

1. Pre-order Traversal

**Process**: Visit the current node first, then recursively traverse the left subtree, and finally recursively traverse the right subtree.   
**Order**: Root -> Left -> Right
**Use Cases**: Pre-order traversal is often used to create a prefix expression (Polish notation) from an expression tree. It can also be used to create a copy of the tree.

2. In-order Traversal

**Process**: Recursively traverse the left subtree, then visit the current node, and finally recursively traverse the right subtree.
**Order**: Left -> Root -> Right
**Use Cases**: For a Binary Search Tree (BST), in-order traversal visits the nodes in ascending order of their values. It's commonly used to get a sorted sequence from a BST.

3. Post-order Traversal

**Process**: Recursively traverse the left subtree, then recursively traverse the right subtree, and finally visit the current node.
**Order**: Left -> Right -> Root
**Use Cases**: Post-order traversal is useful in scenarios like evaluating postfix expressions (Reverse Polish Notation) or when you need to process the children of a node before processing the node itself (e.g., deleting a tree).