package com.ragul.demo.Trie;

import java.util.HashMap;

public class TrieImpl {
    TrieNode root;
    int dummyInt;

    TrieImpl(){
        root = new TrieNode();
        dummyInt=0;
    }


    public void insertData(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node==null){
                TrieNode newNode = new TrieNode();
                node=newNode;
                dummyInt++;
                current.value=c+" "+"("+dummyInt+")"; //test
                current.children.put(c,newNode); //inserts in memory in prev node also
            }

            current=node; //traversing
        }
        current.isEndOfString=true; //here current will be i=word.length-1

    }

    public void printAll() {
        int wordsCount=0;
        System.out.print(root.value + "->");
       wordsCount =  printChild(root,wordsCount);
//        for(Character key:current.children.keySet()){
//            while(current.isEndOfString!=true) {
//                TrieNode currentChild = current.children.get(key);
//                System.out.print(currentChild.value+"->");
//                current = currentChild;
//            }
//            wordsCount++;
//            System.out.println(" ");
//        }
        System.out.println("Done with printing. Total words: "+wordsCount);
    }

    public int printChild(TrieNode currentParent, int wordsCount){

        for(Character key:currentParent.children.keySet()) {
                    TrieNode currentChild = currentParent.children.get(key);
            if (currentChild.isEndOfString != true) {
                System.out.print(currentChild.value + "->");
//                System.out.println("BEFORE CALLING "+currentParent);
//                System.out.println("DURING CALLING "+currentChild);
              //  TrieNode temp = currentParent;
                printChild(currentChild,wordsCount);
            //  currentParent=temp;
//                System.out.println("AFTER CALLING "+currentParent);


                //  current = currentChild;

            }
            wordsCount++;
//return;
        }
        return wordsCount;

    }

    public boolean contains(String word) {
        TrieNode current = root;

        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null){
                return false; //means char is not there
            }
            current = node;
        }
        if(current.isEndOfString==true){
            return true;
        }
        return false;

    }
}
