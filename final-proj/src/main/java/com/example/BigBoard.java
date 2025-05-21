package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.function.Consumer;

  public class BigBoard extends JFrame {
    private final DrawingPanel drawingPanel = new DrawingPanel();

    // create private variables for player colors
    private Color xColor = Color.BLACK;
    private Color oColor = Color.BLACK;

    // boards
    private static String[][] bigBoard;
    private static int boxesFilled;

    private static int xBox = 5;
    private static int oBox = 5;

    private static TicTacToe boardOne;
    private static TicTacToe boardTwo;
    private static TicTacToe boardThree;
    private static TicTacToe boardFour;
    private static TicTacToe boardFive;
    private static TicTacToe boardSix;
    private static TicTacToe boardSeven;
    private static TicTacToe boardEight;
    private static TicTacToe boardNine;
    
    public BigBoard() {
        super("Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(createControlPanel(), BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);
        setSize(900, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        drawingPanel.requestFocusInWindow();

        bigBoard = new String[][] {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
        };

        boardOne = new TicTacToe();
        boardTwo = new TicTacToe();
        boardThree = new TicTacToe();
        boardFour = new TicTacToe();
        boardFive = new TicTacToe();
        boardSix = new TicTacToe();
        boardSeven = new TicTacToe();
        boardEight = new TicTacToe();
        boardNine = new TicTacToe();

        drawingPanel.repaint();
    }

    private void endingScreen(){
        //Displays game-over message
        String message = "";
        
        if (isGameOver()){
            if (TicTacToe.getTurn().equals("X")){
                // make a reset pop up, O should be the winner if current turn is X
                message = "yay yippee o has won";
            }
            else{
                message = "yay yippee x has won";
            }
        }
        else if(!isGameOver() && boxesFilled == 9){
            message = "wuh woh it's a tie";
        }

        int choice = JOptionPane.showConfirmDialog(drawingPanel, message, "Game Over", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            resetSettings();
        } else {
            System.exit(0);
        }
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
                drawingPanel.requestFocusInWindow();
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
        bigBoard = new String[][] {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
        };

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

        xBox = 5;
        oBox = 5;
        
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

    private class DrawingPanel extends JPanel implements KeyListener{
        public DrawingPanel() {
            setLayout(null);
            setBackground(Color.WHITE);
            setFocusable(true);
            requestFocusInWindow();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    requestFocusInWindow();
                    int x = e.getX();
                    int y = e.getY();

                    if (TicTacToe.getTurn().equals("X")){
                        if (xBox == 1 && (!boardOne.hasEmpty() || !bigBoard[0][0].equals(""))){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 2 && (!boardTwo.hasEmpty() || !bigBoard[0][1].equals(""))){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 3 && !boardThree.hasEmpty()){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 4 && !boardFour.hasEmpty()){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 5 && !boardFive.hasEmpty()){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 6 && !boardSix.hasEmpty()){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 7 && !boardSeven.hasEmpty()){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 8 && !boardEight.hasEmpty()){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                        if (xBox == 9 && !boardNine.hasEmpty()){
                            xBox = boxClick(xBox, x, y);
                            repaint();
                        }
                    }

                    if (TicTacToe.getTurn().equals("O")){
                        if (oBox == 1 && !boardOne.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (xBox == 2 && !boardTwo.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (oBox == 3 && !boardThree.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (oBox == 4 && !boardFour.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (oBox == 5 && !boardFive.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (oBox == 6 && !boardSix.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (oBox == 7 && !boardSeven.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (oBox == 8 && !boardEight.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                        if (oBox == 9 && !boardNine.hasEmpty()){
                            oBox = boxClick(oBox, x, y);
                            repaint();
                        }
                    }
                }
            });
 
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

            addKeyListener(this);
        }

        private int boxClick(int xOrY, int x, int y){
            if (x <= 251 && y <= 251) {
                xOrY = 1;
            }
            if (x > 251 && x<= 517 && y <= 251) {
                xOrY = 2;
            }
            if (x > 517 && x <=800 && y <= 251) {
                xOrY = 3;
            }
            if (x <= 251 && y > 251 && y <= 517) {
                xOrY = 4;
            }
            if (x > 251 && x<= 517 && y > 251 && y <= 517) {
                xOrY = 5;
            }
            if (x > 517 && x <=800 && y > 251 && y <= 517) {
                xOrY = 6;
            }
            if (x <= 251 && y > 517 && y <= 800) {
                xOrY = 7;
            }
            if (x > 251 && x<= 517 && y > 517 && y <= 800) {
                xOrY = 8;
            }
            if (x > 517 && x <=800 && y > 517 && y <= 800) {
                xOrY = 9;
            }

            return xOrY;
        }
        
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
            // highlight box

            Color myColor = Color.decode("#fcffab");

            if (TicTacToe.getTurn().equals("X")){
                if (xBox == 1){
                    g.setColor(myColor);
                    g.fillRect(0, 0, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 2){
                    g.setColor(myColor);
                    g.fillRect(251, 0, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 3){
                    g.setColor(myColor);
                    g.fillRect(517, 0, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 4){
                    g.setColor(myColor);
                    g.fillRect(0, 251, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 5){
                    g.setColor(myColor);
                    g.fillRect(251, 251, 260, 260);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 6){
                    g.setColor(myColor);
                    g.fillRect(517, 251, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 7){
                    g.setColor(myColor);
                    g.fillRect(0, 517, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 8){
                    g.setColor(myColor);
                    g.fillRect(251, 517, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (xBox == 9){
                    g.setColor(myColor);
                    g.fillRect(517, 517, 251, 251);
                    g.setColor(Color.BLACK);
                }

            }
            else{
                if (oBox == 1){
                    g.setColor(myColor);
                    g.fillRect(0, 0, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 2){
                    g.setColor(myColor);
                    g.fillRect(251, 0, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 3){
                    g.setColor(myColor);
                    g.fillRect(517, 0, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 4){
                    g.setColor(myColor);
                    g.fillRect(0, 251, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 5){
                    g.setColor(myColor);
                    g.fillRect(251, 251, 260, 260);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 6){
                    g.setColor(myColor);
                    g.fillRect(517, 251, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 7){
                    g.setColor(myColor);
                    g.fillRect(0, 517, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 8){
                    g.setColor(myColor);
                    g.fillRect(251, 517, 251, 251);
                    g.setColor(Color.BLACK);
                }
                if (oBox == 9){
                    g.setColor(myColor);
                    g.fillRect(517, 517, 251, 251);
                    g.setColor(Color.BLACK);
                }
            }

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
                        drawX(g,col*83, row*83);
                    }
                    else if(boardOne.getSpot(row, col).equals("O")){
                        drawO(g, col*83, row*83);
                    }
                }
            }

            // board two
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardTwo.getSpot(row, col).equals("X")){
                        drawX(g,(col+3)*83, (row)*83);
                    }
                    else if(boardTwo.getSpot(row, col).equals("O")){
                        drawO(g, (col+3)*83, (row)*83);
                    }
                }
            }

            // board three
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardThree.getSpot(row, col).equals("X")){
                        drawX(g,(col+6)*85, (row)*83);
                    }
                    else if(boardThree.getSpot(row, col).equals("O")){
                        drawO(g, (col+6)*85, (row)*83);
                    }
                }
            }

            // board four
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardFour.getSpot(row, col).equals("X")){
                        drawX(g,col*83, (row+3)*83);
                    }
                    else if(boardFour.getSpot(row, col).equals("O")){
                        drawO(g, col*83, (row+3)*83);
                    }
                }
            }

            // board five
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardFive.getSpot(row, col).equals("X")){
                        drawX(g,(col+3)*83, (row+3)*83);
                    }
                    else if(boardFive.getSpot(row, col).equals("O")){
                        drawO(g, (col+3)*83, (row+3)*83);
                    }
                }
            }

            // board six
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardSix.getSpot(row, col).equals("X")){
                        drawX(g,(col+6)*85, (row+3)*83);
                    }
                    else if(boardSix.getSpot(row, col).equals("O")){
                        drawO(g, (col+6)*85, (row+3)*83);
                    }
                }
            }

            // board seven
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardSeven.getSpot(row, col).equals("X")){
                        drawX(g,(col)*83, (row+6)*85);
                    }
                    else if(boardSeven.getSpot(row, col).equals("O")){
                        drawO(g, (col)*83, (row+6)*85);
                    }
                }
            }

            // board eight
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardEight.getSpot(row, col).equals("X")){
                        drawX(g,(col+3)*83, (row+6)*85);
                    }
                    else if(boardEight.getSpot(row, col).equals("O")){
                        drawO(g, (col+3)*83, (row+6)*85);
                    }
                }
            }

            // board nine
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (boardNine.getSpot(row, col).equals("X")){
                        drawX(g,(col+6)*85, (row+6)*85);
                    }
                    else if(boardNine.getSpot(row, col).equals("O")){
                        drawO(g, (col+6)*85, (row+6)*85);
                    }
                }
            }

            // if a box is done, changes it to a big x or a big o
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if (bigBoard[row][col].equals("")){
                        if (row == 0 && col == 0 && boardOne.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 0, 0, g2d);
                                bigBoard[0][0] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 0, 0, g2d);
                                bigBoard[0][0] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 0 && col == 1 && boardTwo.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 251, 0, g2d);
                                bigBoard[0][1] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 251, 0, g2d);
                                bigBoard[0][1] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 0 && col == 2 && boardThree.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 517, 0, g2d);
                                bigBoard[0][2] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 517, 0, g2d);
                                bigBoard[0][2] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 1 && col == 0 && boardFour.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 0, 251, g2d);
                                bigBoard[1][0] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 0, 251, g2d);
                                bigBoard[1][0] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 1 && col == 1 && boardFive.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 251, 251, g2d);
                                bigBoard[1][1] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 251, 251, g2d);
                                bigBoard[1][1] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 1 && col == 2 && boardSix.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 517, 251, g2d);
                                bigBoard[1][2] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 517, 251, g2d);
                                bigBoard[1][2] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 2 && col == 0 && boardSeven.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 0, 517, g2d);
                                bigBoard[2][0] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 0, 517, g2d);
                                bigBoard[2][0] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 2 && col == 1 && boardEight.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 251, 517, g2d);
                                bigBoard[2][1] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 251, 517, g2d);
                                bigBoard[2][1] = "X";
                                boxesFilled++;
                            }
                        }
                        if (row == 2 && col == 2 && boardNine.checkWon()){
                            if (TicTacToe.getTurn().equals("X")){
                                // drawBigO(g, 517, 517, g2d);
                                bigBoard[2][2] = "O";
                                boxesFilled++;
                            }
                            else{
                                // drawBigX(g, 517, 517, g2d);
                                bigBoard[2][2] = "X";
                                boxesFilled++;
                            }
                        }
                    }
                }
            }

            // Always draw big O/X\
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (bigBoard[row][col].equals("O")) {
                        drawBigO(g, col*251, row*251, g2d);
                    } else if (bigBoard[row][col].equals("X")) {
                        drawBigX(g, col*251, row*251, g2d);
                    }
                }
}

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

        public void drawBigX(Graphics g, int x, int y, Graphics2D g2d){
            g.setColor(xColor);
            g2d.setStroke(new BasicStroke(5.0f));
            g.drawLine(x+20, y+20, x+230, y+230);
            g.drawLine(x+230, y+20, x+20, y+230);
            g2d.setStroke(new BasicStroke());
            g.setColor(Color.BLACK);
        }

        public void drawBigO(Graphics g, int x, int y, Graphics2D g2d){
            g.setColor(oColor);
            g2d.setStroke(new BasicStroke(5.0f));
            g.drawOval(x+25, y+25, 200, 200);
            g.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke());
        }

        @Override public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_1) {
                System.out.println("Number 1 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(0, 0);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(0, 0);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(0, 0);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(0, 0);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(0, 0);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(0, 0);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(0, 0);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(0, 0);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(0, 0);
                    }

                    oBox = 1;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(0, 0);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(0, 0);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(0, 0);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(0, 0);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(0, 0);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(0, 0);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(0, 0);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(0, 0);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(0, 0);
                    }

                    xBox = 1;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_2) {
                System.out.println("Number 2 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(0, 1);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(0, 1);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(0, 1);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(0, 1);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(0, 1);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(0, 1);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(0, 1);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(0, 1);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(0, 1);
                    }

                    oBox = 2;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(0, 1);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(0, 1);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(0, 1);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(0, 1);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(0, 1);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(0, 1);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(0, 1);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(0, 1);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(0, 1);
                    }

                    xBox = 2;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_3) {
                System.out.println("Number 3 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(0, 2);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(0, 2);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(0, 2);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(0, 2);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(0, 2);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(0, 2);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(0, 2);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(0, 2);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(0, 2);
                    }

                    oBox = 3;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(0, 2);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(0, 2);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(0, 2);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(0, 2);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(0, 2);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(0, 2);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(0, 2);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(0, 2);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(0, 2);
                    }

                    xBox = 3;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_4) {
                System.out.println("Number 4 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(1, 0);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(1, 0);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(1, 0);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(1, 0);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(1, 0);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(1, 0);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(1, 0);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(1, 0);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(1, 0);
                    }

                    oBox = 4;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(1, 0);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(1, 0);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(1, 0);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(1, 0);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(1, 0);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(1, 0);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(1, 0);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(1, 0);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(1, 0);
                    }

                    xBox = 4;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_5) {
                System.out.println("Number 5 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(1, 1);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(1, 1);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(1, 1);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(1, 1);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(1, 1);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(1, 1);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(1, 1);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(1, 1);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(1, 1);
                    }

                    oBox = 5;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(1, 1);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(1, 1);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(1, 1);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(1, 1);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(1, 1);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(1, 1);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(1, 1);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(1, 1);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(1, 1);
                    }

                    xBox = 5;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_6) {
                System.out.println("Number 6 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(1, 2);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(1, 2);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(1, 2);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(1, 2);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(1, 2);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(1, 2);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(1, 2);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(1, 2);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(1, 2);
                    }

                    oBox = 6;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(1, 2);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(1, 2);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(1, 2);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(1, 2);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(1, 2);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(1, 2);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(1, 2);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(1, 2);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(1, 2);
                    }

                    xBox = 6;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_7) {
                System.out.println("Number 7 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(2, 0);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(2, 0);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(2, 0);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(2, 0);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(2, 0);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(2, 0);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(2, 0);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(2, 0);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(2, 0);
                    }

                    oBox = 7;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(2, 0);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(2, 0);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(2, 0);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(2, 0);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(2, 0);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(2, 0);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(2, 0);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(2, 0);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(2, 0);
                    }

                    xBox = 7;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_8) {
                System.out.println("Number 8 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(2, 1);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(2, 1);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(2, 1);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(2, 1);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(2, 1);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(2, 1);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(2, 1);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(2, 1);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(2, 1);
                    }

                    oBox = 8;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(2, 1);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(2, 1);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(2, 1);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(2, 1);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(2, 1);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(2, 1);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(2, 1);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(2, 1);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(2, 1);
                    }

                    xBox = 8;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_9) {
                System.out.println("Number 9 pressed!");

                if (TicTacToe.getTurn().equals("X")){
                    if (xBox == 1){
                        boardOne.pickLocation(2, 2);
                    }
                    if (xBox == 2){
                        boardTwo.pickLocation(2, 2);
                    }
                    if (xBox == 3){
                        boardThree.pickLocation(2, 2);
                    }
                    if (xBox == 4){
                        boardFour.pickLocation(2, 2);
                    }
                    if (xBox == 5){
                        boardFive.pickLocation(2, 2);
                    }
                    if (xBox == 6){
                        boardSix.pickLocation(2, 2);
                    }
                    if (xBox == 7){
                        boardSeven.pickLocation(2, 2);
                    }
                    if (xBox == 8){
                        boardEight.pickLocation(2, 2);
                    }
                    if (xBox == 9){
                        boardNine.pickLocation(2, 2);
                    }

                    oBox = 9;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }
                else{
                    if (oBox == 1){
                        boardOne.pickLocation(2, 2);
                    }
                    if (oBox == 2){
                        boardTwo.pickLocation(2, 2);
                    }
                    if (oBox == 3){
                        boardThree.pickLocation(2, 2);
                    }
                    if (oBox == 4){
                        boardFour.pickLocation(2, 2);
                    }
                    if (oBox == 5){
                        boardFive.pickLocation(2, 2);
                    }
                    if (oBox == 6){
                        boardSix.pickLocation(2, 2);
                    }
                    if (oBox == 7){
                        boardSeven.pickLocation(2, 2);
                    }
                    if (oBox == 8){
                        boardEight.pickLocation(2, 2);
                    }
                    if (oBox == 9){
                        boardNine.pickLocation(2, 2);
                    }

                    xBox = 9;
                    TicTacToe.swapTurn();
                    drawingPanel.repaint();
                }

                if (isGameOver() || boxesFilled == 9){
                    endingScreen();
                }
            }
        }  
        
        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }     
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BigBoard::new);
    }
  }
