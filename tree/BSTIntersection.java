package com.debu.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspire V3 on 05-06-2017.
 */

class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    List<Integer> flattenTree(List<Integer> list)
    {
        if(this.left != null)
            list = this.left.flattenTree(list);

        list.add(this.data);

        if(this.right != null)
            list = this.right.flattenTree(list);

        return list;
    }

    void intersectionBST(TreeNode other)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        this.flattenTree(list1);
        other.flattenTree(list2);

        int diff = list1.size() - list2.size();
        List<Integer> smallerList = (diff < 0) ? list2:list1;

        int j=0,i=0;
        while( i<smallerList.size() && j< smallerList.size() )
        {
            if(list1.get(j) == list2.get(i))
            {
                System.out.print(list1.get(j)+",");
                j++;
                i++;
            }
            else if(list1.get(j) < list2.get(i))
                j++;
            else
                ++i;

        }

    }
}



public class BSTIntersection {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.right = new TreeNode(9);

        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(20);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(9);

        //root.inorderTraversal();
        System.out.println("*************************");
        //root1.inorderTraversal();
        System.out.println("*********** intersection **************");
        root1.intersectionBST(root);
    }
}
