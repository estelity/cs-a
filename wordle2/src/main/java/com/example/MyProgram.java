package com.example;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MyProgram {

    private JFrame frame;
    private JPanel wordpanel = new JPanel();
    private JPanel menupanel = new JPanel();
    private Word word = new Word();
    private JButton resetButton;
    private JLabel statisticsLabel;
    private JTextField inputField;
    private boolean hasWon = false;

    private Wordle engine = new Wordle();

    public MyProgram() {

        this.frame = new JFrame();

        frame.setLayout(new BorderLayout(10, 5));
        frame.setTitle("Wordle");
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wordpanel.setOpaque(true);
        wordpanel.setBackground(Color.WHITE);

    

        for (int i = 0; i < 5; i++) {
            Letter[] w = word.getWord();
            JLabel letter = w[i].getLabel();
            wordpanel.add(letter);
        }

        frame.add(wordpanel);
        renderMenu();

        resetWord();

        frame.setVisible(true);

        
    }


    public void renderMenu() {
        // onetime call

        resetButton = new JButton("Reset");
        statisticsLabel = new JLabel("Number of tries: " + Wordle.returnTries(), SwingConstants.CENTER);
        inputField = new JTextField();
        inputField.setSize(100, 10);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));

        ActionListener checkAction = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String inp = inputField.getText();
                
                hasWon = true;
                int[] check = engine.checkCorrect(inp);
                for (int elem : check){
                    if (elem != 1){
                        hasWon = false;
                    }
                }

                if (inputField.getText().length() == 5 & engine.checkIfWord(inp) & !hasWon & Wordle.getTries() > 0) {
                    renderWord(inp);
                    statisticsLabel.setText("Number of tries: " + (Wordle.returnTries()));
                    
                    inputField.setText("");
                    //Check to see if you win
                }
                

                if (hasWon){
                    statisticsLabel.setText("Number of tries: " + (Wordle.getTries()) + "\ngood job");
                    renderWord(inp);
                }
                else if (!hasWon && Wordle.getTries() == 0){
                    statisticsLabel.setText("Number of tries: " + (Wordle.getTries()) + "\nuh oh");
                }
            }
            
        };


        inputField.addActionListener(checkAction);

        ActionListener resetAction = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetWord();
                inputField.setText("");
            }
            
        };

        resetButton.addActionListener(resetAction);

        menupanel.add(resetButton);
        menupanel.add(statisticsLabel);
        menupanel.add(inputField);
        GridLayout grid = new GridLayout(0, 1);
        menupanel.setLayout(grid);
        menupanel.setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        menupanel.setBorder(border);

        frame.add(menupanel, BorderLayout.SOUTH);

    }

    public void renderWord(String input) {

        int[] result = engine.getGuess(input);
        
        for (int i = 0; i < 5; i++) {
            char c = input.charAt(i);
            int res = result[i];
            Letter[] w = word.getWord();
            w[i].setLetter(c, res);
        }
    }

    public void resetWord() {
        renderWord("_____");
        Wordle.resetTries();
        hasWon = false;
        statisticsLabel.setText("Number of tries: " + (Wordle.getTries()));
        engine.newWord();
    }
    
    public static void main(String[] args) {
        new MyProgram();
    }

}