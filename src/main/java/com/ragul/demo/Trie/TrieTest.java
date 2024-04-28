package com.ragul.demo.Trie;

public class TrieTest {
    public static void main(String args[]){
        TrieImpl trie = new TrieImpl();
        trie.insertData("Gold");
        trie.insertData("Gtd");
        System.out.println(trie.contains("Gold"));
        System.out.println(trie.contains("Gtd"));
        trie.printAll();
    }
}
