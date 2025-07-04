package com.ragul.demo.Tree;

import com.ragul.demo.LinkedList.DLLNode;
import com.ragul.demo.LinkedList.DoublyLinkedList;

import java.util.*;

//NOTE NEVER USE LOOP IN RECURSION

//CHECKING TREE IS BST
//	In a binary search tree, the value of all the nodes in the left sub-tree is less than or equal to the value of the root.
//  Similarly, value of all the nodes in the right sub-tree is greater than or equal to the value of the root.

//HEIGHT OF BT - Max (height(left), height(right))

//Depth of BT - 1 + Max(depth(left), depth(right))
//no. of nodes from that nodes from root in the longest path to leaf node

//Time Complexity - O(N)
//Space complexity - O(1)

//          6
//      2             8
//    1   3      7        12
//          4          11    13
//            5      10
//                  9

// GENERAL PROCEDURE FOR SOLVING TREE PROBLEMS
// func(root->current)
// if(current!=null)
//    iterate left subtree func(current.left)
//    iterate right subtree func(current.right)
//    add or process both results
public class checkBSTTree {
    static int max_left_level = -1; //used in printing LV of tree
    static int max_right_level = -1; //used in printing RV of tree

    static List<String> pathList;
    static DLLNode prevDLL = null;
    static DLLNode headDLL = null;
    static int maxSubArraySum = 0;

    public static void main(String args[]) {


        pathList = new ArrayList<>();
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(6);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.left.left = new TreeNode(1);
        binaryTree.root.left.right = new TreeNode(3);
        binaryTree.root.left.right.right = new TreeNode(4);
        binaryTree.root.left.right.right.right = new TreeNode(5);

        binaryTree.root.right = new TreeNode(8);
        binaryTree.root.right.left = new TreeNode(7);
        binaryTree.root.right.right = new TreeNode(12);
        binaryTree.root.right.right.left = new TreeNode(11);
        binaryTree.root.right.right.left.left = new TreeNode(10);
        binaryTree.root.right.right.left.left.left = new TreeNode(9);
        binaryTree.root.right.right.right = new TreeNode(13);
        //  binaryTree.root.left.left.left = new TreeNode(9); //added 2 extra levels to check balanced
        //  binaryTree.root.left.left.left.left = new TreeNode(10);
        binaryTree.printAllNodes(binaryTree.root); //print All Nodes
        System.out.println("========Level order of tree========");
        binaryTree.printAllNodesInLevelOrder();

        System.out.println("Is BST - " + isBST(binaryTree.root, true));

        System.out.println("Height of tree - " + height(binaryTree.root));
        System.out.println("Height of node 7 - " + heightOfNode(binaryTree.root, 7));
        System.out.println("Depth of tree - " + depth(binaryTree.root));
        System.out.println("Diameter of tree - " + diameter(binaryTree.root));
        System.out.println("Is Balanced - " + isBalanced(binaryTree.root));
        System.out.println("Max Sum From All levels - " + getMaxSumFromAllLevels(binaryTree.root));
        System.out.println("Max Value In Each levels - " + getMaxValueInEachPath(binaryTree.root));
        System.out.println("Sum of all the numbers that are formed from root to leaf paths: " + sumFromRootToLeft(binaryTree.root));
        maxSumSubTree(binaryTree.root);
        System.out.println("Max sum subtrees : " + maxSubArraySum);

        //421+423+465+4678+4679=10666


        System.out.println("====printLeftViewofBTIncludingElementsInSameLevel - Just for understanding===");
        printLeftViewofBTIncludingElementsInSameLevel(binaryTree.root, 0);

        System.out.println("=====Left view of binary tree=====");
        printLeftViewofBT(binaryTree.root, 0, "left");

        System.out.println("=====Right view of binary tree=====");
        printRightViewofBT(binaryTree.root, 0, "right");

        TreeNode mergedTreeRootNode = mergeTrees(binaryTree.root, binaryTree.root);
        System.out.println("Merge trees");
        binaryTree.printAllNodes(mergedTreeRootNode);

        System.out.println("Check same tree- " + checkSameTree(binaryTree.root, binaryTree.root));


        //     System.out.println("Find path - "+ findPath(binaryTree.root,5, new ArrayList<>(),false));
        System.out.println("Printpath: " + printPath(binaryTree.root, 55, pathList));
        System.out.println("Lowest Common Ancestor - " + findLCA(binaryTree.root, 7, 55));

        System.out.println("BT to DLL");
        convertBinaryTreeToDLL(binaryTree.root);
        printDLL(headDLL);



    }

    private static int maxSumSubTree(TreeNode node) {
        if (node==null){
            return 0;
        }
        int leftSum = maxSumSubTree(node.left); //in any order - we just add up root + left + right
        int rightSum = maxSumSubTree(node.right);
        int currentSum = node.data + leftSum + rightSum;
        maxSubArraySum = Math.max(currentSum,maxSubArraySum);
         return currentSum;
    }

    private static void convertBinaryTreeToDLL(TreeNode treeNode) {
        if (treeNode != null) {

            convertBinaryTreeToDLL(treeNode.left);

            //adding to DLL by In order traversal from tree
            DLLNode dllNode = new DLLNode(treeNode.data);
            if (prevDLL == null) {
                headDLL = dllNode;
            } else {
                prevDLL.setNext(dllNode);
                dllNode.setPrev(prevDLL);
            }
            prevDLL = dllNode;

            convertBinaryTreeToDLL(treeNode.right);
        }
    }

    private static void printDLL(DLLNode dllNode) {
        while (dllNode.getNext() != null) {
            System.out.println(dllNode.getData());
            dllNode = dllNode.getNext();
        }
    }

    private static int sumFromRootToLeft(TreeNode root) {
        return sumFromRootToLeft(root, 0);
    }

    private static int sumFromRootToLeft(TreeNode root, int value) {
        if (root == null) return 0;

        value = (value * 10) + root.data;
        if (root.left == null && root.right == null)
            return value;

        int leftSum = sumFromRootToLeft(root.left, value);
        int rightSum = sumFromRootToLeft(root.right, value);
        return leftSum + rightSum;
    }


    //print left element at each element
    //print only first element in each level in preorder (root->left->right)
    private static void printLeftViewofBT(TreeNode current, int level, String side) {

        if (current != null) {

            if (level > max_left_level && side.equals("left")) { //print only once and first element (left) in each level - root->left->right traversal
                System.out.println(current.data + "   Level:" + level);
                max_left_level = level; //print only when any level in that level is not printed
            }
//            else{ //else only for understanding
//                System.out.println("Element "+ current.data +" skipped since already printed element from level "+level);
//            }

            printLeftViewofBT(current.left, level + 1, "left");
            printLeftViewofBT(current.right, level + 1, "right"); //for Right tree, root->right-> left swap the two lines
        }
    }

    private static void printRightViewofBT(TreeNode current, int level, String side) {

        if (current != null) {

            if (level > max_right_level && side.equals("right")) { //print only once and first element (right) in each level - root->right->left traversal
                System.out.println(current.data + "    Level:" + level);
                max_right_level = level; //print only when any level in that level is not printed
            }

            printRightViewofBT(current.right, level + 1, "right"); //for Right tree, root->right-> left swap the two lines
            printRightViewofBT(current.left, level + 1, "left");

        }
    }

    //no use - just for understanding why above code is needed
    private static void printLeftViewofBTIncludingElementsInSameLevel(TreeNode current, int level) {

        if (current != null) {
            if (level == 0) System.out.println(current.data); //print only left eleemnts

            printLeftViewofBTIncludingElementsInSameLevel(current.left, 0);
            printLeftViewofBTIncludingElementsInSameLevel(current.right, 1); //for Right tree, root->right-> left swap the two lines


        }

    }

    private static List<String> findLCA(TreeNode root, int n1, int n2) {
        List<String> pathList1 = new ArrayList<>();
        List<String> pathList2 = new ArrayList<>();
        List<String> lcaList = new ArrayList<>();

        pathList1 = printPath(root, n1, pathList1);
        pathList2 = printPath(root, n2, pathList2);
        if (pathList1.size() == 0 && pathList1.size() == 0) {
            System.out.println("There is no LCA");
        }
        int length = pathList1.size() > pathList2.size() ? pathList1.size() : pathList2.size();
        for (int i = 0; i < length; i++) {
            if (pathList1.get(i) == pathList2.get(i))
                lcaList.add(pathList1.get(i));
        }
        return lcaList;
    }

    private static List<String> printPath(TreeNode root, int node, List<String> pathList) {
        boolean result = findPath(root, node, pathList, false);
        if (result == true) {
            return pathList;
        }
        return new ArrayList<>();
    }

    private static boolean findPath(TreeNode current, int n1, List<String> pathList1, boolean isPathFound) {

        if (current != null) {
            pathList1.add(String.valueOf(current.data));

            if (current.data == n1) {
                isPathFound = true;
            } else if (isPathFound == false) { //to avoid unnecessary execution
                isPathFound = findPath(current.left, n1, pathList1, isPathFound);
            }

            if (isPathFound == false)
                isPathFound = findPath(current.right, n1, pathList1, isPathFound);


            if (isPathFound == false) {
                pathList1.remove(String.valueOf(current.data));
            }
        }
        return isPathFound;
    }

    //    All 3 conditions has to satisifed for Balanced
//    1. The height of the left and right tree for any node does not differ by more than 1.
//    2. The left subtree of that node is also balanced.
//    3. The right subtree of that node is also balanced.
    private static boolean isBalanced(TreeNode root) {
        if (root == null) { //empty tree is balanced
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left)
                && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    //number of nodes on the longest path between com.ragul.demo.problems.two end nodes.
    private static int diameter(TreeNode root) {
        if (root == null) { //else null pointer will be thrown
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
        if (root == null) { //else null pointer will be thrown
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int heightOfNode(TreeNode root, int searchData) {
        if (root == null) { //else null pointer will be thrown
            return 0;
        }
        if (root.data == searchData) {
            return 1 + Math.max(height(root.left), height(root.right));
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int depth(TreeNode root) {
        if (root == null) { //else null pointer will be thrown
            return 0; //depth of tree without any node is 0, depth of root only tree is 1
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    private static Boolean isBST(TreeNode root, Boolean isBST) {
        if (root != null) {
            int rootData = root.data;
            if (root.left != null && root.right != null && (root.left.data > rootData || root.right.data < rootData)) {
                isBST = false;
            }
            if (isBST.equals(true)) isBST = isBST(root.left, isBST);  //to minimise unnecessary execution
            if (isBST.equals(true)) isBST = isBST(root.right, isBST);
        }
        return isBST;
    }

    private static Integer getMaxSumFromAllLevels(TreeNode root) {
        Map<Integer, Integer> sumInEachLevel = sumInEachPath(root, 0, new HashMap<>());
        return sumInEachLevel.values().stream().max(Comparator.naturalOrder()).get();
    }

    //SUB METHOD OF ABOVE
    private static Map<Integer, Integer> sumInEachPath(TreeNode root, int level, Map<Integer, Integer> sumInEachLevel) {
        if (root != null) {
            if (sumInEachLevel.containsKey(level)) {
                sumInEachLevel.put(level, sumInEachLevel.get(level) + root.data);
            } else {
                sumInEachLevel.put(level, root.data);
            }
            sumInEachLevel = sumInEachPath(root.left, level + 1, sumInEachLevel);
            sumInEachLevel = sumInEachPath(root.right, level + 1, sumInEachLevel);
        }
        return sumInEachLevel;
    }

    //SLIGHT CHANGES FROM ABOVE
    private static Map<Integer, Integer> getMaxValueInEachPath(TreeNode root) {
        return getMaxValueInEachPath(root, 0, new HashMap<>());
    }

    //SUB METHOD OF ABOVE
    private static Map<Integer, Integer> getMaxValueInEachPath(TreeNode root, int level, Map<Integer, Integer> maxValueInEachLevel) {
        if (root != null) {
            if (!(maxValueInEachLevel.containsKey(level) && maxValueInEachLevel.get(level) < root.data)) { //execute only when level data doesnt ot exist or level data > level max
                maxValueInEachLevel.put(level, root.data);
            }
            maxValueInEachLevel = getMaxValueInEachPath(root.left, level + 1, maxValueInEachLevel);
            maxValueInEachLevel = getMaxValueInEachPath(root.right, level + 1, maxValueInEachLevel);
        }
        return maxValueInEachLevel;
    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.data = root1.data + root2.data;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    //1.both structure shiuld be same- not null and non null
    //2a. both null - true
    //2b. compare data
    //and repat for entire left and right
    private static boolean checkSameTree(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 != null) || (root2 == null && root1 != null)) {
            return false;
        } else if (root1 == null && root2 == null) {

            //my understanding
//        else if(root1!=null && root2!=null){
//            if(root1.data!=root2.data){
//                return false;
//            }
//            checkSameTree(root1.left,root2.left);
//            checkSameTree(root1.right,root2.right);
//        }

            //return true;

            return (root1.data == root2.data) &&
                    checkSameTree(root1.left, root2.left) &&
                    checkSameTree(root1.right, root2.right);

        }
        return false ; //dont know why added
    }
}

