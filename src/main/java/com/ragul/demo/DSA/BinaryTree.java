package com.ragul.demo.DSA;

public class BinaryTree {

    TreeNode root;

    public void findAllNodes(TreeNode root){
        if(root!=null){
            findAllNodes(root.left);
             System.out.println(root.data); // PRINT ALL DATA - print left, root, right  - IN ORDER TRAVERSAL
            findAllNodes(root.right);
            if(root.left==null && root.right==null){ // LEAF NODES
//                System.out.println(root.data); //PRINT ONLY LEAF NODES
            }
        }
    }
}
