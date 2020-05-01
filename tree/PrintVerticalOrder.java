package com.debu.tree;

import com.sun.javaws.jnl.LibraryDesc;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class PrintVerticalOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }

        Map<Integer, List<TreeNode>> nodeMap = new HashMap<>();
        Map<Integer, List<TreeNode>> levelMap = new HashMap<>();

        //verticalTraversalUtil(root, 0, nodeMap);

        List<List<Integer>> result = new LinkedList<>();

        SortedMap<Integer, List<TreeNode>> sortedMap = new TreeMap<>(nodeMap);

        for (Map.Entry i : sortedMap.entrySet()) {

            List<TreeNode> n = (List<TreeNode>) i.getValue();

            Integer key = (Integer) i.getKey();

            List<Integer> resultListNode = n.stream().map(x -> {
                return x.val;
            }).collect(Collectors.toList());

            result.add(resultListNode);
        }

        return result;

    }

    private void verticalTraversalUtil(TreeNode node,
                                       Integer distance,
                                       Integer level,
                                       Map<Integer, Deque<TreeNode>> nodeMap,
                                       Map<Integer, Integer> levelMap) {

      /*  nodeMap.putIfAbsent(distance, new LinkedList<>());
        levelMap.putIfAbsent(node.val, level);

        Deque<TreeNode> nodes = nodeMap.get(distance);
        nodes.add(node);

        LinkedList<TreeNode> sortedNodes = nodes.stream().sorted(Comparator.comparingInt(value -> {
            return level - levelMap.get(value.val);
        })).collect(Collectors.toList());

        nodeMap.put(distance, sortedNodes);

        if (node.left != null) {
            verticalTraversalUtil(node.left, distance - 1, nodeMap);
        }

        if (node.right != null) {
            verticalTraversalUtil(node.right, distance + 1, nodeMap);
        }
*/

    }

    public static void main(String[] args) {
/*
*
* [0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]
Output
[[7,9],[5,6],[0,2,4],[1,3],[8]]
Expected
[[9,7],[5,6],[0,2,4],[1,3],[8]]

Input:
[0,1,null,null,2,6,3,null,null,null,4,null,5]
Output:
[[6,1],[0,2],[3],[4],[5]]
Expected:
[[1,6],[0,2],[3],[4],[5]]

Input:
[0,8,1,null,null,3,2,null,4,5,null,null,7,6]
Output:
[[8],[0,3,6],[1,4,5],[7,2]]
Expected:
[[8],[0,3,6],[1,4,5],[2,7]]

* */


        TreeNode treeNode = new PrintVerticalOrder.TreeNode(3);
        treeNode.left = new PrintVerticalOrder.TreeNode(9);
        treeNode.right = new PrintVerticalOrder.TreeNode(20);
        treeNode.right.left = new PrintVerticalOrder.TreeNode(15);
        treeNode.right.right = new PrintVerticalOrder.TreeNode(7);

        System.out.println(new PrintVerticalOrder().verticalTraversal(treeNode));
    }

}
