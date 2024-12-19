package com.ragul.demo.Tree;


import java.util.*;

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

    public void printAllNodesInLevelOrder(){
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        printAllNodesInLevelOrder(root,1, levelMap);

        for(Integer key:levelMap.keySet()){
            List<Integer> dataList = levelMap.get(key);
            System.out.print("Level "+key+": ");
            for (Integer data:dataList){
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }

    public Map<Integer, List<Integer>> printAllNodesInLevelOrder(TreeNode node, int level, Map<Integer, List<Integer>> levelMap){
        if(node!=null){
            List<Integer> levelList = new ArrayList<>();
            if(levelMap.containsKey(level)){
                levelList = levelMap.get(level);
            }
            levelList.add(node.data);
            levelMap.put(level,levelList);
            level = level+1;
            levelMap = printAllNodesInLevelOrder(node.left, level, levelMap);
            levelMap = printAllNodesInLevelOrder(node.right, level, levelMap);
        }
        return levelMap;
    }
}
