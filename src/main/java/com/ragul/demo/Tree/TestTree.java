package com.ragul.demo.Tree;

class Tree_Node{
    int data;
    Tree_Node left;
    Tree_Node right;

    public Tree_Node(int data) {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}


class Binary_Tree{
    Tree_Node root;

    public void printAllNodes(Tree_Node node) {

        if(node!=null){
            printAllNodes(node.left);
            printAllNodes(node.right);
            System.out.print(node.data+" ");
        }
    }
}


public class TestTree{
    public static void main(String[] args) {
       Binary_Tree tree = new Binary_Tree();
        Tree_Node root = new Tree_Node(1);

        tree.root = root;

        tree.root.left=new Tree_Node(2);
        tree.root.right=new Tree_Node(3);
        tree.root.left.left=new Tree_Node(4);
        tree.root.left.right=new Tree_Node(5);
        tree.root.right.left=new Tree_Node(6);
        tree.root.right.right=new Tree_Node(7);

        tree.printAllNodes(root);
    }
}