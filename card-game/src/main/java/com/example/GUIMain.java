package com.example;
import javax.swing.*;
import java.awt.*;
public class GUIMain{
    public static void main(String[] args) {

        System.out.println("welcome to tacocatgoatcheesepizza");

        //create game window
        JFrame frame = new JFrame("Taco Cat Goat Cheese Pizza");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1000);

        // Game blackjack = new Game();
        ShowingCards simple = new ShowingCards();
        //add the blackjack jpanel
        // frame.add(blackjack);
        frame.add(simple);
        frame.setVisible(true);

        SwingUtilities.invokeLater(() -> {
          simple.requestFocusInWindow();
        });

        Font[] fonts;
    fonts =
     GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts( );
    // for (int i = 0; i < fonts.length; i++) {
    //   System.out.print(fonts[i].getFontName( ) + " : ");
    //   System.out.print(fonts[i].getFamily( ) + " : ");
    //   System.out.print(fonts[i].getName( ));
    //   System.out.println( );
    // }



    }
}