package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.function.Consumer;

    // highlight background of the one you're going on
    // sends to random box if box is filled

  public class BigBoard extends JFrame {
    private final DrawingPanel drawingPanel = new DrawingPanel();

    // create private variables for player colors
    private Color xColor;
    private Color oColor;

    // boards
    private String[][] bigBoard;
    private int boxesFilled;

    private int xBox;
    private int oBox;

    private TicTacToe boardOne;
    private TicTacToe boardTwo;
    private TicTacToe boardThree;
    private TicTacToe boardFour;
    private TicTacToe boardFive;
    private TicTacToe boardSix;
    private TicTacToe boardSeven;
    private TicTacToe boardEight;
    private TicTacToe boardNine;
    
    public BigBoard() {
        super("Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(createControlPanel(), BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);
        setSize(900, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        bigBoard = new String[3][3];

        boardOne = new TicTacToe();
        boardTwo = new TicTacToe();
        boardThree = new TicTacToe();
        boardFour = new TicTacToe();
        boardFive = new TicTacToe();
        boardSix = new TicTacToe();
        boardSeven = new TicTacToe();
        boardEight = new TicTacToe();
        boardNine = new TicTacToe();

        playGame();
    }

    private void playGame(){
        while (!isGameOver() && boxesFilled < 9){
            takeTurn();
            drawingPanel.repaint();
            TicTacToe.swapTurn();
        }

        if (isGameOver()){
            if (TicTacToe.getTurn().equals("X")){
                // make a reset pop up, O should be the winner if current turn is X
            }
        }
        else{
            // tie
        }
    }

    private void takeTurn(){

    }

    private boolean isGameOver(){
        String letter = "X";

        // check columns

        for (int i = 0; i < 2; i++){
            for (int col = 0; col < 3; col++){
                if (bigBoard[0][col].equals(letter) && bigBoard[1][col].equals(letter) && bigBoard[2][col].equals(letter)){
                    return true;
                }
            }
            letter = "O";
        }

        // check rows

        letter = "X";

        for (int i = 0; i < 2; i++){
            for (int row = 0; row < 3; row++){
                if (bigBoard[row][0].equals(letter) && bigBoard[row][1].equals(letter) && bigBoard[row][2].equals(letter)){
                    return true;
                }
            }
            letter = "O";
        }

        // check diagonals

        letter = "X";

        for (int i = 0; i < 2; i++){
            for (int row = 0; row < 3; row++){
                if (bigBoard[0][0].equals(letter) && bigBoard[1][1].equals(letter) && bigBoard[2][2].equals(letter)){
                    return true;
                }
                if (bigBoard[0][2].equals(letter) && bigBoard[1][1].equals(letter) && bigBoard[2][0].equals(letter)){
                    return true;
                }
            }
            letter = "O";
        }

        return false;
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // make color button
        panel.add(createColorButton("X Color", c -> xColor = c));
        panel.add(createColorButton("O Color", c -> oColor = c));

        // add components to the left side control panel
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetSettings());
        panel.add(resetButton);

        return panel;
    }

    private JPanel createLabeledComponent(String label, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    private JButton createColorButton(String text, Consumer<Color> colorSetter) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            Color initialColor = getColorByButtonName(text);
            Color newColor = JColorChooser.showDialog(this, "Choose " + text, initialColor);
            if (newColor != null) {
                colorSetter.accept(newColor);
                drawingPanel.repaint();
            }
        });
        return button;
    }
    
    private Color getColorByButtonName(String name) {
        return Color.BLACK;
        // returns the color depending on what part they name
    }

    private void resetSettings() {

        // reset boards;
        bigBoard = new String[3][3];
        boardOne = new TicTacToe();
        boardTwo = new TicTacToe();
        boardThree = new TicTacToe();
        boardFour = new TicTacToe();
        boardFive = new TicTacToe();
        boardSix = new TicTacToe();
        boardSeven = new TicTacToe();
        boardEight = new TicTacToe();
        boardNine = new TicTacToe();

        // reset colors
        xColor = Color.BLACK;
        oColor = Color.BLACK;
        
        drawingPanel.repaint();
    }

    private JSlider createSlider(String title, int min, int max, int value) {
        JSlider slider = new JSlider(min, max, value);
        slider.setMajorTickSpacing((max - min) / 4);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> drawingPanel.repaint());
        return slider;
    }

    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setLayout(null);
            setBackground(Color.WHITE);
 
            JLabel one = new JLabel("1                  2                  3                        1                   2                3                       1                  2                  3");
            one.setBounds(70, 65, 700, 20); // position and size
            add(one); // Add to this panel

            JLabel two = new JLabel("4                  5                  6                        4                   5                6                       4                  5                  6");
            two.setBounds(70, 146, 700, 20); // position and size
            add(two); // Add to this panel

            JLabel three = new JLabel("7                  8                  9                        7                   8                9                       7                  8                  9");
            three.setBounds(70, 230, 700, 20); // position and size
            add(three); // Add to this panel

            JLabel four = new JLabel("1                  2                  3                        1                   2                3                       1                  2                  3");
            four.setBounds(70, 315, 700, 20); // position and size
            add(four); // Add to this panel

            JLabel five = new JLabel("4                  5                  6                        4                   5                6                       4                  5                  6");
            five.setBounds(70, 397, 700, 20); // position and size
            add(five); // Add to this panel

            JLabel six = new JLabel("7                  8                  9                        7                   8                9                       7                  8                  9");
            six.setBounds(70, 485, 700, 20); // position and size
            add(six); // Add to this panel

            JLabel seven = new JLabel("1                  2                  3                        1                   2                3                       1                  2                  3");
            seven.setBounds(70, 581, 700, 20); // position and size
            add(seven); // Add to this panel

            JLabel eight = new JLabel("4                  5                  6                        4                   5                6                       4                  5                  6");
            eight.setBounds(70, 662, 700, 20); // position and size
            add(eight); // Add to this panel

            JLabel nine = new JLabel("7                  8                  9                        7                   8                9                       7                  8                  9");
            nine.setBounds(70, 742, 700, 20); // position and size
            add(nine); // Add to this panel
        }
        
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
            g2d.setStroke(new BasicStroke(5.0f));
            g.drawLine(251, 35, 251, 735);
            g.drawLine(517, 35, 517, 735);
            g.drawLine(35, 251, 735, 251);
            g.drawLine(35, 517, 735, 517);
            g2d.setStroke(new BasicStroke());

            smallBoard(g, 0, 0);
            smallBoard(g, 261, 0);
            smallBoard(g, 517, 0);
            smallBoard(g, 0, 251);
            smallBoard(g, 0, 517);
            smallBoard(g, 261, 251);
            smallBoard(g, 517, 517);
            smallBoard(g, 261, 517);
            smallBoard(g, 517, 251);

            // draw little boxes
        
            // board one
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardOne.getSpot(row, col).equals("X")){
                        drawX(g,0, 0);

                    }
                    else if(boardOne.getSpot(row, col).equals("O")){

                    }
                }
            }

            // board two

            // if a box is done, changes it to a big x or a big o
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (bigBoard[row][col].equals("")){

                    }
                }
            }
            
            drawX(g, 0, 0);
            drawO(g, 83, 0);
        }

        private void smallBoard(Graphics g, int x, int y){
            g.drawLine(x+83, y+10, x+83, y+241);
            g.drawLine(x+166, y+10, x+166, y+241);
            g.drawLine(x+10, y+83, x+241, y+83);
            g.drawLine(x+10, y+166, x+241, y+166);
        }

        public void drawX(Graphics g, int x, int y){
            g.setColor(xColor);
            g.drawLine(x+20, y+20, x+60, y+60);
            g.drawLine(x+60, y+20, x+20, y+60);
            g.setColor(Color.BLACK);
        }

        public void drawO(Graphics g, int x, int y){
            g.setColor(oColor);
            g.drawOval(x+21, y+21, 40, 40);
            g.setColor(Color.BLACK);
        }
    }     
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BigBoard::new);
    }
  }
