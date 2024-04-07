package com.ragul.demo.DSA;

public class BinaryTree {

    TreeNode root;

    public void findAllNodes(TreeNode root){
        if(root!=null){
            findAllNodes(root.left); // print left, root, right  - IN ORDER TRAVERSAL
            System.out.println(root.data);
            findAllNodes(root.right);
        }
    }
}
