package com.debu.Flipkart;

import java.lang.*;


/**
 *
 * Created by Debdatta Bhaumik on 13-06-2018.
 */
public class ExpressionTree {

    static class Node {
        String data;
        Node left, right;

        Node(String d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static Node root;

    public static void main(String[] args) {

        root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("-");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right.left = new Node("100");
        root.right.right = new Node("20");

        System.out.println(evalTree(root));

        root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right = new Node("-");
        root.right.left = new Node("100");
        root.right.right = new Node("/");
        root.right.right.left = new Node("20");
        root.right.right.right = new Node("2");

        System.out.println(evalTree(root));
    }


    public static int evalTree(Node root) {

        if (root != null) {
            if (root.data.equals("+")) {
                return evalTree(root.left) + evalTree(root.right);
            } else if (root.data.equals("-")) {
                return evalTree(root.left) - evalTree(root.right);
            } else if (root.data.equals("*")) {
                return evalTree(root.left) * evalTree(root.right);
            } else if (root.data.equals("/")) {
                return evalTree(root.left) / evalTree(root.right);
            } else {
                Integer data = Integer.parseInt(root.data);
                return data;
            }
        }
        return 0;
    }
}

