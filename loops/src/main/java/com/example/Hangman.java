package com.example;

public class Hangman {
    
    private String word;
    private String hint;
    private int numGuesses;
    private int turn;
    private String guessed;

    public Hangman(String word) {
        this.word = word;
        hint = "";
        for (int i = 0; i < word.length(); i++) {
            hint += "_ ";
        }
        numGuesses = 6;
        turn = 1;
        System.out.println("\n" + hint);
        guessed = "";
    }

    public void play(String letter) {
        if (!isGameOver()) {
            System.out.println(guessed + "\n");
            if (word.indexOf(letter) >= 0){
                updateHint(letter);
                printBodyPart();
            }
            else {
                numGuesses--;
                guessed += " " + letter;
                printBodyPart();
            }

            System.out.println("Turn " + turn);
            System.out.println(hint);

            turn++;
        }
        else
        {
            System.out.println(winMessage());
        }
    }

    private void updateHint(String letter) {
        int spot = word.indexOf(letter);
        while (spot >= 0){
            String a = hint.substring(0, spot*2);
            String b = hint.substring(spot*2 + 1);
            String rest = "";
            hint = a + letter + b;

            rest = word.substring(spot + 1);
            
            if (rest.indexOf(letter) >= 0){
                spot = rest.indexOf(letter) + spot + 1;
            }
            else {
                spot = rest.indexOf(letter);
            }
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

    private String winMessage() {
        
        if (modifyWord().equals(hint)){
            return "good job\n";
        }
        else {
            System.out.println("""
            +---+
            |   |
            O   |
           \\|/  |
           / \\  |
                |
          ========= """
            );
            return "u failed\n";
        }
    }

    private String modifyWord(){
        String modifiedWord = word;
        int l = 1;
        for (int j = 0; j < word.length(); j++)
        {
            String a = modifiedWord.substring(0, l);
            String b = modifiedWord.substring(l);
            modifiedWord = a + " " + b;
            if (l < modifiedWord.length() - 1){
                l += 2;
            }
        }
        return modifiedWord;
    }

    private void printBodyPart(){
        if (numGuesses == 6){
            System.out.println("""
            +---+
            |   |
                |
                |
                |
                |
          ========= """
            );
        }
        else if (numGuesses == 5){
            System.out.println("""
            +---+
            |   |
            O   |
                |
                |
                |
          ========= """
            );
        }
        else if (numGuesses == 4){
            System.out.println("""
            +---+
            |   |
            O   |
            |   |
                |
                |
          ========= """
            );
        }
        else if (numGuesses == 3){
            System.out.println("""
            +---+
            |   |
            O   |
           \\|   |
                |
                |
          ========= """
            );
        }
        else if (numGuesses == 2){
            System.out.println("""
            +---+
            |   |
            O   |
           \\|/  |
                |
                |
          ========= """
            );
        }
        else if (numGuesses == 1){
            System.out.println("""
            +---+
            |   |
            O   |
           \\|/  |
           /    |
                |
          ========= """
            );
        }
    }
}
