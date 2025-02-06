package com.example;

import java.util.Scanner;

public class Magic8Ball 
{
    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args)
    {
        System.out.println("\nWelcome to the Magic 8 Ball!\n");
        System.out.print("Do you want to play? ");

        Scanner user = new Scanner(System.in);
        String answer = user.next(); 
        boolean answer1;

        if (answer.equals("yes"))
        {
            answer1 = true;
        }
        else if (answer.equals("Yes")) 
        {
            answer1 = true;
        }
        else if (answer.equals("no"))
        {
            answer1 = false;
        }
        else if (answer.equals("No"))
        {
            answer1 = false;
        }
        else
        {
            answer1 = false;
        }

        if (answer1 == true)
        {
            System.out.print("\nWhat question do you have for me? ");
            String question = user.next();
            int randomNumber = (int)(Math.random() * 6) + 1;
            String response;
            if (randomNumber == 1)
            {
                response = "Yeah... I guess so";
            }
            else if (randomNumber == 2) 
            {
                response = "Yes!";
            }
            else if (randomNumber == 3) 
            {
                response = "Don't follow your heart";
            }
            else if (randomNumber == 4) 
            {
                response = "Up to you!";
            }
            else if (randomNumber == 5) 
            {
                response = "No, you're so...";
            }
            else
            {
                response = "No... why are you even asking me that?";
            }
            System.out.println("\n" + response + "\n");
        }
        else
        {
            System.out.println("\nOh :c");
        }



 //if mathrnadom is like 1 then positive or wtvr       
    }
}
