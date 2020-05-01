package com.debu;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;

    private class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEnd;

        TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }

        public boolean containsKey(Character c) {
            return children.containsKey(c);
        }

        public void putKey(Character c) {
            children.put(c, new TrieNode());
        }

        public TrieNode getChildren(Character c) {
            return children.get(c);
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {

        TrieNode node = this.root;

        for (int i = 0; i < word.length(); ++i) {
            Character c = word.charAt(i);

            if(node.children.get(c) == null)
            {
                TrieNode n = new TrieNode();
                n.children = new HashMap<>();
                n.isEnd = false;
                node.children.put(c, n);
            }
            node = node.getChildren(c);
        }

        if(node != null )
        {
            node.setEnd();
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        if (searchUtil(root, word, 0)) {
            return true;
        }

        return false;
    }

    private boolean searchUtil(TrieNode node, String word, Integer index) {

        if (index == word.length()) {
            return node.isEnd();
        }

        Character c = word.charAt(index);

        if (c == '.') {
            //go to the next level using any key
            for (Map.Entry<Character, TrieNode> entrySet :
                    node.getChildren().entrySet()) {
                node = entrySet.getValue();
                if(searchUtil(node, word, index + 1))
                {
                    return true;
                }
            }
        } else {
            if (node.containsKey(c)) {
                node = node.getChildren(c);
                return searchUtil(node, word, index + 1);
            } else {
                return false;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        Trie obj = new Trie();
        obj.addWord("at");
        obj.addWord("and");
        obj.addWord("an");
        obj.addWord("add");

        System.out.println(obj.search("a.d"));
        System.out.println(obj.search("a"));
        System.out.println(obj.search("ab"));
        System.out.println(obj.search(".a"));
        System.out.println(obj.search("a."));
    }

}
