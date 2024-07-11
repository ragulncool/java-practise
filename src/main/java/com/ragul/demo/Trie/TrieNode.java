package com.ragul.demo.Trie;

import java.util.HashMap;

public class TrieNode {

    char value;
    int nodenumber; //for understanding
    HashMap<Character,TrieNode> children;
    boolean isEndOfString;

    TrieNode()
    {
        children=new HashMap<>();
        isEndOfString=false;
    }
    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + children +
                ", isEndOfString=" + isEndOfString +
                '}';
    }
}
