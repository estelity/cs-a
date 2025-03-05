package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe Meow = new TicTacToe();

        int numTurns = 0;

        Scanner scanner = new Scanner(System.in);

        while(!Meow.checkWon() && numTurns < 9){

            System.out.println();
            System.out.println(Meow.getTurn() + "'s Turn");

            System.out.println();
            Meow.printBoard();

            System.out.println();
            System.out.print("Row: ");
            int rowEntered = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Column: ");
            int colEntered = scanner.nextInt();
            scanner.nextLine();

            while (!Meow.pickLocation(rowEntered, colEntered)){

                System.out.println();
                System.out.println("Invalid spot");
                System.out.print("Row: ");
                rowEntered = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Column: ");
                colEntered = scanner.nextInt();
                scanner.nextLine();

            }

            Meow.takeTurn(rowEntered, colEntered);
            numTurns++;
        }

        Meow.printBoard();
        System.out.println();

        if (Meow.checkWon()){
            if (Meow.getTurn().equals("X")){
                System.out.println("O Wins!");
            }
            else{
                System.out.println("X Wins!");
            }
        }

        if (numTurns == 9 && !Meow.checkWon()){
            System.out.println("tie");
        }
        System.out.println();
    }
}