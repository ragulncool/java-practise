package com.ragul.demo.problems.DSA.medium.DynamicProgramming.LCA;

public class LCA {
    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "acbcf";

        System.out.println(findLCA(s1,s2));

    }

    private static int findLCA(String s1, String s2) {

        int[][] dpLCA = new int[s1.length()+1][s2.length()+1];
        for (int i=1;i<=s1.length();i++){
            for (int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dpLCA[i][j] = 1 + dpLCA [i-1][j-1];
                }else{
                    dpLCA[i][j] = Math.max(dpLCA[i-1][j],dpLCA[i][j-1]);
                }
            }
        }

        printDP(dpLCA);

        return dpLCA[s1.length()][s2.length()];
    }

    private static void printDP(int[][] dpLCA) {
        for (int i=0;i<dpLCA.length;i++){
            for (int j=0;j<dpLCA[0].length;j++){
              System.out.print(dpLCA[i][j]+" ");
            }
            System.out.println();
        }
    }
}
