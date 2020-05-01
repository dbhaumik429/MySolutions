package com.debu.stack;

/*
 * How would you design a stack which,
 * in addition to push and pop, also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 * */

import java.util.Stack;

public class StackOperation {

    private Stack<Node> stack;

    class Node {
        int value;
        Node previous;

        Node() {
        }

        Node(int x, Node previous) {
            value = x;
            this.previous = previous;
        }
    }

    public Node pop() {
        Node n = stack.pop();

        if(!stack.isEmpty())
        {

        }
        return n;
    }

    public void push(int x) {

        Node prev=null;
        if(!stack.isEmpty())
        {
            prev = stack.peek();
        }

        Node n = new Node(x, prev);
        stack.push(n);
    }

    public Boolean isEmpty() {
        return stack.isEmpty();
    }

    public Node peek() {
        Node n = stack.peek();
        return n;
    }

    public static void main(String[] args) {

    }
}
