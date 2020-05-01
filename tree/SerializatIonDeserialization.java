package com.debu.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializatIonDeserialization {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null)
            return null;

        //need stack for this kind of op
        StringBuilder res = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node != null) {
                res.append(node.val + " ");

                q.add(node.left);
                q.add(node.right);

            } else {
                res.append("null ");
            }


        }

        System.out.println(res);

        return res.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) return null;

        String[] tokens = data.split(" ");

        if (tokens[0] == null) return null;

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        for (int i = 1; i < tokens.length; ++i) {

            TreeNode node = q.poll();

            if (!tokens[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(tokens[i].trim()));
                node.left = left;
                ((LinkedList<TreeNode>) q).add(left);
            }

            if (!tokens[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(tokens[i].trim()));
                node.right = right;
                ((LinkedList<TreeNode>) q).add(right);
            }
        }

        return root;


    }


    public static void main(String[] args) {

        SerializatIonDeserialization serializatIonDeserialization = new SerializatIonDeserialization();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = null;
        node.left.right = null;
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);


        String data = serializatIonDeserialization.serialize(node);

        serializatIonDeserialization.deserialize(data);

    }
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
