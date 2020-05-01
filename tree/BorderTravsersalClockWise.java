package com.debu.tree;

// Java program to print boundary traversal of binary tree from right to bottom to left

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node1 {
    int data;
    Node1 left, right;

    Node1(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree1 {
    Node1 root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node1 node1) {
        if (node1 != null) {
            printLeaves(node1.right);

            // Print it if it is a leaf node1
            if (node1.left == null && node1.right == null)
                System.out.print("l" + node1.data + " ");
            printLeaves(node1.left);
        }
    }

    // A function to print all left boundry nodes, except a leaf node1.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node1 node1) {
        if (node1 != null) {
            if (node1.left != null) {

                // to ensure bottom up order, print the node1
                // before calling itself for left subtree
                printBoundaryLeft(node1.left);
                System.out.print("left" + node1.data + " ");
            } else if (node1.right != null) {
                printBoundaryLeft(node1.right);
                System.out.print(node1.data + " ... ");
            }

            // do nothing if it is a leaf node1, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node1
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node1 node1) {
        if (node1 != null) {
            if (node1.right != null) {
                // to ensure top down order, first call for right
                // subtree, then print this node1
                System.out.print("right" + node1.data + " ");
                printBoundaryRight(node1.right);
            } else if (node1.left != null) {
                System.out.print(node1.data + " ");
                printBoundaryRight(node1.left);
            }
            // do nothing if it is a leaf node1, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node1 node1) {
        if (node1 != null) {
            System.out.print(node1.data + " ");

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node1.right);

            // Print all leaf nodes
            printLeaves(node1.right);
            printLeaves(node1.left);

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node1.left);

        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        BinaryTree1 tree = new BinaryTree1();
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
