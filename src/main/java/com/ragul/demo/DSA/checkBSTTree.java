package com.ragul.demo.DSA;

//Time Complexity - O(N)
//Space complexity - O(1)
public class checkBSTTree {
    public static void main(String args[]){
       BinaryTree binaryTree = new BinaryTree();
       binaryTree.root = new TreeNode(4);
       binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(5);
        binaryTree.root.left.left = new TreeNode(1);
        binaryTree.root.left.right = new TreeNode(3);
        binaryTree.findAllNodes(binaryTree.root); //print All Nodes

        System.out.println("Is BST - "+ isBST(binaryTree.root,true));
    }

    private static Boolean isBST(TreeNode root, Boolean isBST) {
        if(root!=null){
            int rootData= root.data;
            if(root.left!=null && root.right!=null && (root.left.data>rootData || root.right.data<rootData)) {
                isBST =  false;
            }
            if(isBST.equals(true)){
                isBST = isBST(root.left,isBST); //doubt why left assignment is needed?
                isBST = isBST(root.right,isBST);
            }
        }
        return isBST;
    }
}
