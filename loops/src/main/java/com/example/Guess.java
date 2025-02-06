package com.example;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        int x = 0;
        int guesses = 0;
        int number = 17;
        Scanner Hey = new Scanner(System.in);
        System.out.println("");

        while(x != number) {
            System.out.print("Guess a number between 0-100: ");
            x = Hey.nextInt();
            guesses ++;

            if(x > number)
            {
                System.out.println("Lower\n");
            }
            else if(x < number)
            {
                System.out.println("Higher\n");
            }
            else
            {
                System.out.println("The number is " + number + "!\n");
            }
        }
    }
}