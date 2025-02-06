package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> listOfWords = new ArrayList<>();
        int choose = 0;
        
        try {
            FileReader filRdr = new FileReader("/Users/grace.shen/CS A/wordle/src/main/java/com/example/words.txt");
            Scanner Gage = new Scanner(filRdr);
            
            while (Gage.hasNext()) {
                listOfWords.add(Gage.nextLine());
            }

            choose = (int)(Math.random() * listOfWords.size());
            //listOfWords.get(choose)

        } catch(FileNotFoundException e){
            System.out.println("No File Found");
        };

        Wordle Henry = new Wordle(listOfWords.get(choose));
        Scanner Ann = new Scanner(System.in);
        String guess;

        while(!Henry.isGameOver()){
            System.out.print("\nEnter a Word: ");
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