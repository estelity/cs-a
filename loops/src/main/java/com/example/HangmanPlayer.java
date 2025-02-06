package com.example;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanPlayer {
    public static void main(String[] args){

        // ignore the other text file, i made it for my friend

        ArrayList<String> listOfWords = new ArrayList<>();
        int choose = 0;

        try {
            FileReader filRdr = new FileReader("/Users/grace.shen/CS A/loops/src/main/java/com/example/genshin.txt");
            Scanner Gage = new Scanner(filRdr);
            
            while (Gage.hasNext()) {
                listOfWords.add(Gage.nextLine());
            }

            choose = (int)(Math.random() * listOfWords.size());

        } catch(FileNotFoundException e){
            System.out.println("No File Found");
        };

        Hangman Henry = new Hangman(listOfWords.get(choose));
        Scanner Ann = new Scanner(System.in);
        String guess;
        
        while (!Henry.isGameOver()) {
            System.out.print("\nEnter a Letter: ");
            guess = Ann.next();
            System.out.println();
            Henry.play(guess);
        }

        System.out.println();
        Henry.play("A");
        System.out.println(listOfWords.get(choose));
        System.out.println();
    }
}

