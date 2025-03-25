package com.example;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
public class Game2048 {
    // Size of the game grid
    private static final int SIZE = 4;
    //Instance variables
    private int[][] grid;
    private Random random;
    private int score;
    private int highScore;
    private JFrame frame;
    private JPanel gridPanel;
    private JLabel[][] gridLabels;
    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private boolean winConditionReached;
    private boolean moved;

    public Game2048() {
        // Constructor code
        
        grid = new int[4][4];
        score = 0;
        highScore = 0;

        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 4; col++){
                grid[row][col] = 0;
            }
        }

        // Create the GUI components
        frame = new JFrame("meow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLayout(new BorderLayout());
        gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
        gridLabels = new JLabel[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gridLabels[i][j] = new JLabel("", JLabel.CENTER);
                gridLabels[i][j].setFont(new Font("Inconsolata", Font.BOLD, 24));
                gridLabels[i][j].setOpaque(true);
                gridLabels[i][j].setBackground(Color.LIGHT_GRAY);
                gridPanel.add(gridLabels[i][j]);
            }
        }
        // Add components to the frame
        frame.add(gridPanel, BorderLayout.CENTER);
        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        scoreLabel = new JLabel("Score: 0", JLabel.CENTER);
        highScoreLabel = new JLabel("High Score: 0", JLabel.CENTER);
        infoPanel.add(scoreLabel);
        infoPanel.add(highScoreLabel);
        frame.add(infoPanel, BorderLayout.NORTH);
        frame.addKeyListener(new KeyAdapter() {
            // Handle key events
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    moveUp();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    moveDown();
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    moveLeft();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    moveRight();
                }
                updateGridLabels();
                if (isGameOver()) {
                    showGameOverMessage();
                }
            }
        });
        // Set frame properties and initialize the grid
        frame.setFocusable(true);
        frame.requestFocus();
        frame.setVisible(true);
        initializeGrid();
        updateGridLabels();
    }
    public void initializeGrid() {
        // Grid initialization code

        // Add two new numbers to random positions
        for (int i = 0; i < 2; i++){
            addNewNumber();
        }
    }
    public void addNewNumber() {
        // New number generation code
        
        // Generate random row and column indices

        // Assign a new number (2 or 4) to the empty cell

        int twoFour = (int)(Math.random()*10);
        int randomRow = (int)(Math.random()*4);
        int randomColumn = (int)(Math.random()*4);

        if (twoFour != 9){
            twoFour = 2;
        }
        else{
            twoFour = 4;
        }
        do{
            randomRow = (int)(Math.random()*4);
            randomColumn = (int)(Math.random()*4);
        }
        while(grid[randomRow][randomColumn] != 0);
        grid[randomRow][randomColumn] = twoFour;
        score += twoFour;

        twoFour = (int)(Math.random()*10);

        updateScore();
    }
    public void updateGridLabels() {
        // Update the GUI grid labels with the current grid state
        // loop over gid
        // use .setText and .setBackground to set every gridLabel
        // use .setBorder to draw the grid lines 

        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 4; col++){
                if (grid[row][col] == 0){
                    gridLabels[row][col].setText("");
                    gridLabels[row][col].setBackground(Color.LIGHT_GRAY);
                }
                else{
                    gridLabels[row][col].setText(Integer.toString(grid[row][col]));
                    gridLabels[row][col].setBackground(getTileColor(grid[row][col]));
                }
                gridLabels[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
    }
    public Color getTileColor(int value) {
        //Maps each tile value to a specific color
        switch (value) {
            case 2:
                return new Color(238, 228, 218);
            case 4:
                return new Color(237, 224, 200);
            case 8:
                return new Color(242, 177, 121);
            case 16:
                return new Color(245, 149, 99);
            case 32:
                return new Color(246, 124, 95);
            case 64:
                return new Color(246, 94, 59);
            case 128:
                return new Color(237, 207, 114);
            case 256:
                return new Color(237, 204, 97);
            case 512:
                return new Color(237, 200, 80);
            case 1024:
                return new Color(237, 197, 63);
            case 2048:
                return new Color(237, 194, 46);
            default:
                return Color.WHITE;
        }
    }
    public void moveUp() {
        //Moves and merges the tiles upwards

        moved = false;

        // move all tiles up

        for (int col = 0; col < 4; col++){
            for (int row = 0; row < 3; row++){
                int i = 1;
                if (grid[row][col] == 0){
                    while (row + i < 4){
                        if (grid[row + i][col] != 0){
                            grid[row][col] = grid[row + i][col];
                            grid[row + i][col] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
            }
        }

        // merge

        for (int col = 0; col < 4; col++){
            for (int row = 0; row < 3; row++){
                int i = 1;
                if (grid[row][col] != 0){
                    while (row + i < 4){
                        if (grid[row + i][col] != 0){
                            if (grid[row + i][col] == grid[row + i - 1][col]){
                                grid[row + i - 1][col] *= 2;
                                grid[row + i][col] = 0;
                                moved = true;
                            }
                        }
                        i++;
                    }
                }
    
            }
        }

        // move all tiles up again

        for (int col = 0; col < 4; col++){
            for (int row = 0; row < 3; row++){
                int i = 1;
                if (grid[row][col] == 0){
                    while (row + i < 4){
                        if (grid[row + i][col] != 0){
                            grid[row][col] = grid[row + i][col];
                            grid[row + i][col] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
    
            }
        }

        if (moved == true){
            addNewNumber();
        }
    }
    public void moveDown() {
        //Moves and merges the tiles upwards

        moved = false;

        // move all tiles up

        for (int col = 0; col < 4; col++){
            for (int row = 3; row > 0; row--){
                int i = 1;
                if (grid[row][col] == 0){
                    while (row - i >= 0){
                        if (grid[row - i][col] != 0){
                            grid[row][col] = grid[row - i][col];
                            grid[row - i][col] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
            }
        }

        // merge

        for (int col = 0; col < 4; col++){
            for (int row = 3; row > 0; row--){
                int i = 1;
                if (grid[row][col] != 0){
                    while (row - i >= 0){
                        if (grid[row - i][col] != 0){
                            if (grid[row - i][col] == grid[row - i + 1][col]){
                                grid[row - i + 1][col] *= 2;
                                grid[row - i][col] = 0;
                                moved = true;
                            }
                        }
                        i++;
                    }
                }
    
            }
        }

        // move all tiles up again

        for (int col = 0; col < 4; col++){
            for (int row = 3; row > 0; row--){
                int i = 1;
                if (grid[row][col] == 0){
                    while (row - i >= 0){
                        if (grid[row - i][col] != 0){
                            grid[row][col] = grid[row - i][col];
                            grid[row - i][col] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
            }
        }

        if (moved == true){
            addNewNumber();
        }
    }
    public void moveLeft() {
        //Moves and merges the tiles upwards

        moved = false;

        // move all tiles up

        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 3; col++){
                int i = 1;
                if (grid[row][col] == 0){
                    while (col + i < 4){
                        if (grid[row][col + i] != 0){
                            grid[row][col] = grid[row][col + i];
                            grid[row][col + i] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
            }
        }

        // merge

        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 3; col++){
                int i = 1;
                if (grid[row][col] != 0){
                    while (col + i < 4){
                        if (grid[row][col + i] != 0){
                            if (grid[row][col + i] == grid[row][col + i - 1]){
                                grid[row][col + i - 1] *= 2;
                                grid[row][col + i] = 0;
                                moved = true;
                            }
                        }
                        i++;
                    }
                }
    
            }
        }

        // move all tiles up again

        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 3; col++){
                int i = 1;
                if (grid[row][col] == 0){
                    while (col + i < 4){
                        if (grid[row][col + i] != 0){
                            grid[row][col] = grid[row][col + i];
                            grid[row][col + i] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
            }
        }

        if (moved == true){
            addNewNumber();
        }
    }

    public void moveRight() {
        //Moves and merges the tiles upwards

        moved = false;

        // move all tiles up

        for (int row = 0; row < 4; row++){
            for (int col = 3; col > 0; col--){
                int i = 1;
                if (grid[row][col] == 0){
                    while (col - i >= 0){
                        if (grid[row][col - i] != 0){
                            grid[row][col] = grid[row][col - i];
                            grid[row][col - i] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
            }
        }

        // merge

        for (int row = 0; row < 4; row++){
            for (int col = 3; col > 0; col--){
                int i = 1;
                if (grid[row][col] != 0){
                    while (col - i >= 0){
                        if (grid[row][col - i] != 0){
                            if (grid[row][col - i] == grid[row][col - i + 1]){
                                grid[row][col - i + 1] *= 2;
                                grid[row][col - i] = 0;
                                moved = true;
                            }
                        }
                        i++;
                    }
                }
    
            }
        }

        // move all tiles up again

        for (int row = 0; row < 4; row++){
            for (int col = 3; col > 0; col--){
                int i = 1;
                if (grid[row][col] == 0){
                    while (col - i >= 0){
                        if (grid[row][col - i] != 0){
                            grid[row][col] = grid[row][col - i];
                            grid[row][col - i] = 0;
                            i = 100;
                            moved = true;
                        }
                        i++;
                    }
                }
            }
        }

        if (moved == true){
            addNewNumber();
        }
    }

    public boolean colIsEmpty(int col){
        for (int row = 0; row < 4; row++){
            if (grid[row][col] != 0){
                return false;
            }
        }

        return true;
    }
    public boolean isGameOver() {
        //Game-over condition
        boolean over = true;

        for (int col = 0; col < 4; col++){
            for (int row = 0; row < 4; row++){
                if (grid[row][col] == 0){
                    over = false;
                }
                if (grid[row][col] == 2048){
                    winConditionReached = true;
                    return true;
                }
            }
        }

        if (over){
            return !findAdjacent();
        }

        return over;
    }
    public void showGameOverMessage() {
        //Displays game-over message
        String message;
        if (winConditionReached) {
            message = "Congratulations! You reached the 2048 tile!\nDo you want to play again?";
        } else {
            message = "Game over! Do you want to play again?";
        }
        int choice = JOptionPane.showConfirmDialog(frame, message, "Game Over", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            restartGame();
            initializeGrid();
            updateGridLabels();
        } else {
            System.exit(0);
        }
    }
    public void restartGame() {
        //Restarts the game
        for(int row = 0; row < 4; row++){
            for (int col = 0; col < 4; col++){
                grid[row][col] = 0;
            }
        }
        score = 0;
    }
    public void updateScore() {
        //Updates the score
        if (moved = true){
            if (score > highScore){
                highScore = score;
                highScoreLabel.setText("Highscore: " + Integer.toString(highScore));
            }

            scoreLabel.setText("Score: " + Integer.toString(score));
        }
    }
    public boolean findAdjacent(){
        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 3; col++){
                if (grid[row][col] == grid[row][col + 1]){
                    return true;
                }
            }
        }

        for (int col = 0; col < 4; col++){
            for (int row = 0; row < 3; row++){
                if (grid[row + 1][col] == grid[row][col]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Main method
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game2048();
            }
        });
    }
}