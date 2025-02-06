package com.example;

//and comes before or

public class SpinnerGame {
    public static void main(String[] args)
    {
        playRound();
    }
    public static int spin(int min, int max)
    {
        int result = (int)(Math.random() * (max - min + 1)) + min;
        return result;
    }
    public static void playRound()
    {
        int player1 = spin(1, 10);
        int computer1 = spin (2, 8);
        if (player1 > computer1)
        {
            int playerscore = player1 - computer1; 
            System.out.println("You win! " + playerscore + " points");
        }   
        else if (computer1 > player1)
        {
            int playerscore = computer1 - player1;
            System.out.println("You lose. -" + playerscore + " points");
        }
        else
        {
            int player2 = spin(1, 10);
            int computer2 = spin (2, 8);

            if (player1 + player2 > computer1 + computer2)
            {
                int playerscore = 1;
                System.out.println("You win! " + playerscore + " points");
            }
            else if(player1 + player2 < computer1 + computer2)
            {
                int playerscore = 1;
                System.out.println("You lose. -" + playerscore + " points");
            }
            else
            {
                System.out.println("Tie. 0 points");
            }
        }
    }
}
