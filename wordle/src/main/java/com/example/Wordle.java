package com.example;

public class Wordle {
    
    private String word;
    private String hint;
    private int numGuesses;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public Wordle(String word){
        
        this.word = word;
        hint = "";
        for (int i = 0; i < word.length(); i++) {
            hint += "_";
        }

        String letters = ""; 
        for (int i = 0; i < word.length(); i++) {
            letters += "_ ";
        }
        numGuesses = 6;
        System.out.println("\n" + letters);
    }

    public void play(String guess){
        
        if (!isGameOver()){
            hint = updateHint(guess);
            System.out.println(hint);
            numGuesses--;
        }
        else{
            System.out.println(winMessage());
        }
    }

    private String updateHint(String guess){
        String willReturn = "";
        String rest = word;
        char c;
        String meow;
        String cString;

        String b = "";
        int d;
    
        for (int i = 0; i < word.length(); i++){
            c = guess.charAt(i);

            meow = Character.toString(word.charAt(i));
            cString = Character.toString(c);

            d = rest.indexOf(cString);

            if (rest.indexOf(c) >= 0 && meow.equals(cString)){
                willReturn += ANSI_GREEN + c + ANSI_RESET;
                if (rest.indexOf(d) + 1 >=0){
                    b = rest.substring(d+1);
                }
                rest = rest.substring(0, d) + b;
            }

            else if (rest.indexOf(c) >= 0) {
                willReturn += ANSI_YELLOW + c + ANSI_RESET;
                if (rest.indexOf(d) + 1 >=0){
                    b = rest.substring(d+1);
                }
                rest = rest.substring(0, d) + b;
            }

            else{
                willReturn += c;
            }

        }

        return willReturn;
    }

    private String winMessage() {
        if (modifyWord().equals(hint)){
            return "good job\n";
        }
        else {
            return "u failed\n";
        }
    }


    public boolean isGameOver() {
        
        if (modifyWord().equals(hint) || numGuesses == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String modifyWord() {
        String modifiedWord = "";
        char c;
        for (int i = 0; i < word.length(); i++){
            c = word.charAt(i);
            modifiedWord += ANSI_GREEN + c + ANSI_RESET;
        }
        return modifiedWord;
    }
}
