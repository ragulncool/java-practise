package com.ragul.demo.Trie;

import java.util.*;

public class TrieImpl {
    TrieNode root;
    int dummyInt;

    TrieImpl(){
        root = new TrieNode();
        dummyInt=0;
    }


    public void insertData(String word) {
        System.out.println("=====INSERT OPERATION for "+word+"=====");
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node==null){
                TrieNode newChildNode = new TrieNode();
                node=newChildNode;
                dummyInt++;
                //current.value=c;
                current.nodenumber=dummyInt; //test
                current.children.put(c,newChildNode); //inserts in memory in prev node also
                System.out.println("Insert Node: "+current.value+" Node not exists - new  nodeNumber:"+current.nodenumber+" children: "+current.children.keySet());
            }else{
                System.out.println("Insert Node: "+current.value+" Node already exists in nodeNumber:"+current.nodenumber+" children: "+current.children.keySet());
            }
            current=node; //traversing
        }
        current.isEndOfString=true; //here current will be i=word.length-1
    }

    public void printAll() {
        System.out.println("=====PRINT COMPLETE TRIE=====");
        int wordsCount=0;
    //    System.out.print(root.value +"("+root.nodenumber+")"+"->");
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
            System.out.println("Node: "+key+" nodeNumber:"+currentParent.nodenumber+" children: "+currentChild.children.keySet());
            if (currentChild.isEndOfString != true) {
                wordsCount =  printChild(currentChild,wordsCount);
            }else{
                wordsCount++;
                System.out.print("\n");
            }
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

    public List<String> getSuggestions(String prefix){
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++){

            char c = prefix.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null){
                return Collections.EMPTY_LIST; //means char is not there
            }
        }
        while (current.isEndOfString!=true){

        }
return null;
    }


//    public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
//        if (root.isEndOfString) {
//            list.add(curr.toString());
//        }
//
//        if (root.children == null || root.children.isEmpty())
//            return;
//
//        for (TrieNode child : root.children.values()) {
//            suggestHelper(child, list, curr.append(child.c));
//            curr.setLength(curr.length() - 1);
//        }
//    }
//
//    public List<String> suggest(String prefix) {
//        List<String> list = new ArrayList<>();
//        TrieNode lastNode = root;
//        StringBuffer curr = new StringBuffer();
//        for (char c : prefix.toCharArray()) {
//            lastNode = lastNode.children.get(c);
//            if (lastNode == null)
//                return list;
//            //curr.append(c);
//        }
//        suggestHelper(lastNode, list, curr);
//        return list;
//    }

    public List<String> getPrefix(String prefix){
        TrieNode current = root;
        List<String> wordList = new ArrayList<>();
        char[] prefixArr = prefix.toCharArray();
        String finalWord = "";
        for(int i=0;i<prefixArr.length;) {
            TrieNode child = current.children.get(prefixArr[i]);
            if (child == null) {
                wordList.add(finalWord);
                return wordList; //next char is not there, so no need to check any other charc, return the wordlist to user
            }else{
                finalWord=finalWord+prefixArr[i];
                while (child.isEndOfString!=true){
                    TrieNode current1 = child;
                    TrieNode child1 = current1.children.get(prefixArr[i]);
                    if (child1 == null) {
                        wordList.add(finalWord);
                        return wordList; //next char is not there, so no need to check any other charc, return the wordlist to user
                    }
                }
            }
        }
        return wordList; //change
    }

    private List<String> findOthers(List<String> wordList, String prefix, TrieNode child) {
       // char word;
       // HashMap<Character, TrieNode> child1 = child.children;
//        TrieNode current = child;
////        for(char c: prefix.toCharArray()){
//        for(int i=0;i<prefix.toCharArray().length;i++){
//            if(current==null){
//                break;
//            }else if(current==prefix.charAt(i)){
//                wordList=findOthers(wordList, prefix, child);
//            }else if(child.isEndOfString == true){
//
//            }
        return null;
        }


//        String finalWord=prefix;
//        for (Character c:child.keySet()){
//
//            HashMap<Character, TrieNode> child2;
//            while (child!=null){
//                if(child.isEndOfString==true){
//                    finalWord=finalWord+c;
//                }
//            //    child2=child1.children;
//            }
//            wordList.add(finalWord);
//
//        }
      //return wordList;
   //}
}
