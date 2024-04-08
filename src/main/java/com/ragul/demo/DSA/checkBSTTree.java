package com.ragul.demo.DSA;

import static java.lang.Math.max;

//Time Complexity - O(N)
//Space complexity - O(1)
public class checkBSTTree {
    public static void main(String args[]){
       BinaryTree binaryTree = new BinaryTree();
       binaryTree.root = new TreeNode(4);
       binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(6);
        binaryTree.root.left.left = new TreeNode(1);
        binaryTree.root.left.right = new TreeNode(3);
        binaryTree.root.right.left = new TreeNode(5);
        binaryTree.root.right.right = new TreeNode(7);
        binaryTree.findAllNodes(binaryTree.root); //print All Nodes

        System.out.println("Is BST - "+ isBST(binaryTree.root,true));
        System.out.println("Height of tree - "+ height(binaryTree.root));
        System.out.println("Diameter of tree - "+ diameter(binaryTree.root));

    }

    //number of nodes on the longest path between two end nodes.
    private static int diameter(TreeNode root) {
        if(root==null){ //else null pointer will be thrown
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right
          subtree + 1
         */
        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    //. Height is the number of nodes along the longest path from
    // the root node down to the farthest leaf node.
    private static int height(TreeNode root) {
        if(root==null){ //else null pointer will be thrown
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }

    private static Boolean isBST(TreeNode root, Boolean isBST) {
        if(root!=null){
            int rootData= root.data;
            if(root.left!=null && root.right!=null && (root.left.data>rootData || root.right.data<rootData)) {
                isBST =  false;
            }
            if(isBST.equals(true)){ //to minimise unnecessary execution
                isBST = isBST(root.left,isBST); //doubt why left assignment is needed?
                isBST = isBST(root.right,isBST);
            }
        }
        return isBST;
    }
}
