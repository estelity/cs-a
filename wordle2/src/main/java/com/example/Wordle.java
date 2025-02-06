package com.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Wordle {

    private String[] words = WordleDictionary.WORDS;
    private int[] result = new int[5];
    private static int tries = 0;
    private int index = 0;
    private String word;
    

    public Wordle() {
        word = "meats";
        // word = words[(int)(Math.random() * word.length())];
        
        tries = 7;
        
    }

    public boolean checkIfWord(String guess) {
        //return true if the guess is a word
        //otherwise return false
        for (String elem : words){
            if (guess.equals(elem)){
                return true;
            }
        }
        
        return false;
    }

    public void newWord(){
        word = words[(int)(Math.random() * words.length)];
    }

    public String[] getWords() {
        return words;
    }

    public String getWord() {
        return word;
    }
    
    public int[] getGuess(String guess) {
        //updates then returns result
        result = checkCorrect(guess);
        return result;
    }
    
    public int[] checkCorrect(String guess) {
        //returns a list of numbers that represent right or wrong 
        // make it do double **

        for (int i = 0; i < 5; i ++){
            if (word.charAt(i)==guess.charAt(i)){
                result[i] = 1;
            }
            else if (word.indexOf(guess.charAt(i)) >= 0){
                result[i] = 0;
            }
            else{
                result[i] = -1;
            }
            
        }

        return result;
    }


    public static int returnTries() {
        tries --;
        return tries;
    }

    public static int getTries(){
        return tries;
    }

    public static void resetTries(){
        tries = 6;
    }
}