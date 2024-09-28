package com.ragul.demo.Tree;


//LEAF NODE - node for which left==null and right==null
public class BinaryTree {

    TreeNode root;
//TYPE OF TRAVERSAL
    //PRE ORDER - root->left->right (I mostly use)
    //IN ORDER left root right
    //POST ORDER - left-right root
    public void printAllNodes(TreeNode root){
        if(root!=null){
            printAllNodes(root.left); //CHNAGE L14 TO 16 BASED ON TYPE OF TRVAERSAL IN WHICH WE WANT TO PRINT
             System.out.println(root.data); // PRINT ALL DATA - print left, root, right  - IN ORDER TRAVERSAL
            printAllNodes(root.right);
            if(root.left==null && root.right==null){ // LEAF NODES
//                System.out.println(root.data); //PRINT ONLY LEAF NODES
            }
        }
    }
}
