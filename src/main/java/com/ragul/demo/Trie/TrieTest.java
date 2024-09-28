package com.ragul.demo.Trie;

public class TrieTest {
    //The time complexity for creating a Trie is O(WL), where W is the number of words, and L is an average length of the word. This is because, for each word, we are traversing down the path that corresponds to each character in the word, so in total, the runtime comes out to be O(WL).
    //we are storing all the W words of average length L in the Trie, the space complexity also comes out to be O(W*L)
    public static void main(String args[]){
        TrieImpl trie = new TrieImpl();
        trie.insertData("Gold");
        trie.insertData("Gtd");
        trie.insertData("Golf");
        trie.insertData("Gira");
        System.out.println(trie.contains("Gold"));
        System.out.println(trie.contains("Gtd"));
        System.out.println("GET BY PREFIX: "+trie.getPrefix("G"));
        System.out.println("PRINT ENTIRE TRIE: ");
        trie.printAll();
    }
}
