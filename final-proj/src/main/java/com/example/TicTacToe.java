package com.example;

public class TicTacToe {
    
    private static String turn;
    private String[][] board;
    private static boolean madeLegalMove = false;

    public TicTacToe(){

        board = new String[][] {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
            };

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

    public static String getTurn(){
        return turn;
    }

    public static void swapTurn(){
        if (madeLegalMove){
            madeLegalMove = false;
            if (turn.equals("X")){
                turn = "O";
            }
            else{
                turn = "X";
            }
        }
    }


    public String getSpot(int row, int col){
        return board[row][col];
    }

    public String getBoard(){

        String fullBoard = "";
        fullBoard = "  0 1 2\n";
        for (int row = 0; row < 3; row++){
            System.out.print(row);
            fullBoard += row;
            for(int col = 0; col < 3; col++){
                fullBoard += " " + board[row][col];
            }
            fullBoard += "\n";
        }

        return fullBoard;
    }

    public void pickLocation(int row, int col){
        if (board[row][col].equals("")){
            board[row][col] = turn;
            madeLegalMove = true;
        }
    }

    public void takeTurn(int row, int col){
        if (board[row][col].equals("")){
            board[row][col] = turn;                                                                                                                        
            madeLegalMove = true;
            if (turn.equals("X")){
                turn = "O";
            }
            else{
                turn = "X";
            }
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

    public boolean hasEmpty(){
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (!(board[row][col].equals(""))){
                    return false;
                }
            }
        }
        return true;
    }
}

