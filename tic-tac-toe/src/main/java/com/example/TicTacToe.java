package com.example;

public class TicTacToe {
    
    private String turn;
    private String[][] board;

    public TicTacToe(){

        board = new String[][] {{"-","-","-"},
                                {"-","-","-"},
                                {"-","-","-"}};

        // System.out.println("  0 1 2");
        // for (int row = 0; row < 3; row++){
        //     System.out.print(row);
        //     for(int col = 0; col < 3; col++){
        //         System.out.print(" " + board[row][col]);
        //     }
        //     System.out.println();
        // }

        turn = "X";
    }

    public String getTurn(){
        return turn;
    }

    public void printBoard(){
        System.out.println("  0 1 2");
        for (int row = 0; row < 3; row++){
            System.out.print(row);
            for(int col = 0; col < 3; col++){
                System.out.print(" " + board[row][col]);
            }
            System.out.println();
        }
    }

    public boolean pickLocation(int row, int col){
        if (row > 2 || col > 2){
            return false;
        }
        if (board[row][col].equals("X") || board[row][col].equals("O")){
            return false;
        }
        return true;
    }

    public void takeTurn(int row, int col){

        board[row][col] = turn;                                                                                                                        

        if (turn.equals("X")){
            turn = "O";
        }
        else{
            turn = "X";
        }
    }

    public boolean checkWon(){

        String letter = "X";

        // check columns

        for (int i = 0; i < 2; i++){
            for (int col = 0; col < 3; col++){
                if (board[0][col].equals(letter) && board[1][col].equals(letter) && board[2][col].equals(letter)){
                    return true;
                }
            }
            letter = "O";
        }

        // check rows

        letter = "X";

        for (int i = 0; i < 2; i++){
            for (int row = 0; row < 3; row++){
                if (board[row][0].equals(letter) && board[row][1].equals(letter) && board[row][2].equals(letter)){
                    return true;
                }
            }
            letter = "O";
        }

        // check diagonals

        letter = "X";

        for (int i = 0; i < 2; i++){
            for (int row = 0; row < 3; row++){
                if (board[0][0].equals(letter) && board[1][1].equals(letter) && board[2][2].equals(letter)){
                    return true;
                }
                if (board[0][2].equals(letter) && board[1][1].equals(letter) && board[2][0].equals(letter)){
                    return true;
                }
            }
            letter = "O";
        }

        return false;
    }
}
