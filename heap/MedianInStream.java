package com.debu.heap;

import java.util.Scanner;

public class MedianInStream {

    public static class Node {
        int number;
        Node left;
        Node right;
        Node parent;
    }

    public static class MinHeap {
        static Node root;
        static int countOfNodes;

        public static Node getRoot() {
            return root;
        }

        public static Node getLeft() {
            return root.left;
        }

        public static Node addNode(Node root, int i) {

            if (root != null) {
                if (i <= root.number) {
                    root.left = addNode(root.left, i);
                } else {
                    root.right = addNode(root.right, i);
                }
            } else {
                root = new Node();
                root.number = i;
                root.left = null;
                root.right = null;
                root.parent = null;
                MinHeap.countOfNodes++;

                if (MinHeap.root == null) {
                    MinHeap.root = root;
                }
            }

            return root;
        }

        public static void heapify(Node root, Node node) {

            if (root != null && node != null) {
                if (node.number > root.number) {
                    Node temp = node;
                    node = root;
                    root = temp;

                    heapify(root.parent, root);
                }
            }
        }
    }

    public static Integer findMedian(int i) {
        int median;
        MinHeap.addNode(MinHeap.root, i);

        //MinHeap.heapify(MinHeap.getRoot(),);
        if (MinHeap.countOfNodes % 2 == 0) //even
        {
            Integer sum = MinHeap.getRoot().number + MinHeap.getLeft().number;

            Double d = Math.floor(sum / 2);
            median = d.intValue();
        } else {
            median = MinHeap.getRoot().number;
        }

        return median;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            while (n-- > 0) {
                int i = scanner.nextInt();

                System.out.println(findMedian(i));
            }
        }
    }

}
