package com.ragul.demo.problems;

//visit each node and save number in row, columna nd submatrix as resent (1). If value already 1, then it is invaoid sudoku
public class VALIDATESUDOKU {
        static boolean isValid(int[][] mat) {

            // Track of numbers in rows, columns, and sub-matrix
            int[][] rows = new int[10][10]; //values can be 0 to 9
            int[][] cols = new int[10][10];
            int[][] boxMatrix = new int[10][10];
int val;

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    val = mat[i][j];

                    //check for duplicates
                    if(rows[i][val]==1)  return false;
                    rows[i][val]=1; //unique and present once or we can say visited

                    if(cols[i][val]==1)  return false;
                    cols[i][val]=1;

                    int idx = (i / 3) * 3 + j / 3;
                    System.out.println(i+" "+j+"    "+idx+" "+val);
                    if(boxMatrix[idx][val]==1)  return false;
                    boxMatrix[idx][val]=1;


                }
            }

            return true;
        }

        public static void main(String[] args) {
            int[][] mat = {{7, 9, 2, 1, 5, 4, 3, 8, 6},
                    {6, 4, 3, 8, 2, 7, 1, 5, 9},
                    {8, 5, 1, 3, 9, 6, 7, 2, 4},
                    {2, 6, 5, 9, 7, 3, 8, 4, 1},
                    {4, 8, 9, 5, 6, 1, 2, 7, 3},
                    {3, 1, 7, 4, 8, 2, 9, 6, 5},
                    {1, 3, 6, 7, 4, 8, 5, 9, 2},
                    {9, 7, 4, 2, 1, 5, 6, 3, 8},
                    {5, 2, 8, 6, 3, 9, 4, 1, 7}};

            System.out.println(isValid(mat) ? "true" : "false");
        }

}
