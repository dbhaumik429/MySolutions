package com.debu.tree;

// Java program to print boundary traversal of binary tree from left to bottom to right

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node {
    int data;
    Node1 left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node1 root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node1 node1)
    {
        if (node1 != null) {
            printLeaves(node1.left);

            // Print it if it is a leaf node1
            if (node1.left == null && node1.right == null)
                System.out.print("l" + node1.data + " ");
            printLeaves(node1.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node1.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node1 node1)
    {
        if (node1 != null) {
            if (node1.left != null) {

                // to ensure top down order, print the node1
                // before calling itself for left subtree
                System.out.print("left" + node1.data + " ");
                printBoundaryLeft(node1.left);
            }
            else if (node1.right != null) {
                System.out.print(node1.data + " ... ");
                printBoundaryLeft(node1.right);
            }

            // do nothing if it is a leaf node1, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node1
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node1 node1)
    {
        if (node1 != null) {
            if (node1.right != null) {
                // to ensure bottom up order, first call for right
                // subtree, then print this node1
                printBoundaryRight(node1.right);
                System.out.print("right" + node1.data + " ");
            }
            else if (node1.left != null) {
                printBoundaryRight(node1.left);
                System.out.print(node1.data + " ");
            }
            // do nothing if it is a leaf node1, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node1 node1)
    {
        if (node1 != null) {
            System.out.print(node1.data + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node1.left);

            // Print all leaf nodes
            printLeaves(node1.left);
            printLeaves(node1.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node1.right);
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node1(20);
        tree.root.left = new Node1(8);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(12);
        tree.root.left.right.left = new Node1(10);
        tree.root.left.right.right = new Node1(14);
        tree.root.right = new Node1(22);
        tree.root.right.right = new Node1(25);
        tree.printBoundary(tree.root);
    }
} 
