package com.example;
import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        @SuppressWarnings("resource")
        Scanner user = new Scanner(System.in);
        System.out.print("What's your name? ");
        String word = user.next();
        System.out.print("Hello " + word + "\n");

        System.out.print("What year were you born? ");
        int number = user.nextInt();
        number = 2024 - number;
        System.out.print("Awesome, so you are about " + number + " years old!\n");

        System.out.print("Enter a number greater than 1000. ");
        int thousand = user.nextInt();
        int digit = thousand % 10;
        int removed = thousand / 10;
        System.out.print("The ones digit of " + thousand + " is " + digit + "\n");
        System.out.print("If you remove the ones digit, you get " + removed + "\n");

        System.out.print("Enter a number with a decimal place.\n");
        double decimal = user.nextDouble();
        int integer = (int)decimal;
        System.out.print("The truncated version of " + decimal + " is " + integer + "\n");
    }
}