package com.ragul.demo.problems;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String args[]){
        char [][] board= new char[3][3];
        boolean gameOver = false;
        char player = 'X';
        Scanner scanner=new Scanner(System.in);


        for(int row=0;row<board.length;row++){
            for(int col=0;col<board.length;col++) {
                board[row][col]=' ';
            }
        }

        while(!gameOver){
            System.out.println("Player "+player+": Enter row and column");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(board[row][col]==' '){
                board[row] [col]=player;
                printboard(board);
                if(checkHasWon(board,player)){ //stop and print player is won
                    gameOver=true;
                    System.out.println("Player "+player+": WON");
                }else{ //swap player
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Player "+player+": Invalid Move. Please try again.");
            }
        }
    }

    private static boolean checkHasWon(char[][] board, char player) {

        //check for row
        for(int row=0;row<board.length;row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //check for column
        for(int col=0;col<board.length;col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //check for diagnals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }


        return false;
    }

    private static void printboard(char[][] board) {
        for(int row=0;row<board.length;row++){
            System.out.print("|");
            for(int col=0;col<board.length;col++) {
                System.out.print(board[row][col]+"|");
            }
            System.out.println("");
        }
    }
}
