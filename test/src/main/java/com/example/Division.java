package com.example;

import java.util.*;

public class Division {
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);

        System.out.print("\nEnter the dividend: ");
        int dividend = user.nextInt();

        System.out.print("Enter the divsor: ");
        int divisor = user.nextInt();

        if (divisor != 0 && dividend % divisor > 0)
        {
            System.out.println(dividend + " is not divisible by " + divisor + "!");
        }
        else
        {
            System.out.println(dividend + " is divisible by " + divisor + "!");
        }
    }
}
