package com.example;

import java.util.*;

public class Questions {
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);
        System.out.println("\nHello! Welcome to 20 questions. Please think of your favorite color.");
        
        System.out.println("\nIs your color a warm color?");
        String warm = user.next();
        if (warm.equals("yes") || warm.equals("Yes"))
        {
            System.out.println("\nIs it a color in ROYGBIV?");
            String roy = user.next();
            if (roy.equals("yes") || roy.equals("Yes"))
            {
                System.out.println("\nIs your color red?");
                String red = user.next();
                if (red.equals("yes") || red.equals("Yes"))
                {
                    System.out.println("\nyay i win");
                }
                else
                {
                    System.out.println("\nIs your color orange?");
                    String orange = user.next();
                    if (orange.equals("yes") || orange.equals("Yes"))
                    {
                        System.out.println("\nyay i win");
                    }
                    else
                    {
                        System.out.println("\nIs your color yellow?");
                        String yellow = user.next();
                        if (yellow.equals("yes") || yellow.equals("Yes"))
                        {
                            System.out.println("\nyay i win");
                        }
                        else
                        {
                            System.out.println("\noh i lose");
                        }
                    }
                }
            }
            else
            {
                System.out.println("\nIs your color pink?");
                String pink = user.next();
                if (pink.equals("yes") || pink.equals("Yes"))
                {
                    System.out.println("\nyay i win");
                }
                else
                {
                    System.out.println("\nIs your color brown?");
                    String brown = user.next();
                    if (brown.equals("yes") || brown.equals("Yes"))
                    {
                        System.out.println("\nyay i win");
                    }
                    else
                    {
                        System.out.println("\nIs your color magenta?");
                        String magenta = user.next();
                        if (magenta.equals("yes") || magenta.equals("Yes"))
                        {
                            System.out.println("\nyay i win");
                        }
                        else
                        {
                            System.out.println("\noh i lose");
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("\nIs it a color in ROYGBIV?");
            String roy = user.next();
            if (roy.equals("yes") || roy.equals("Yes"))
            {
                System.out.println("\nIs your color green?");
                String green = user.next();
                if (green.equals("yes") || green.equals("Yes"))
                {
                    System.out.println("\nyay i win");
                }
                else
                {
                    System.out.println("\nIs your color blue?");
                    String blue = user.next();
                    if (blue.equals("yes") || blue.equals("Yes"))
                    {
                        System.out.println("\nyay i win");
                    }
                    else
                    {
                        System.out.println("\nIs your color violet?");
                        String violet = user.next();
                        if (violet.equals("yes") || violet.equals("Yes"))
                        {
                            System.out.println("\nyay i win");
                        }
                        else
                        {
                            System.out.println("\noh i lose");
                        }
                    }
                }
            }
            else
            {
                System.out.println("\nIs your color turquoise?");
                String turq = user.next();
                if (turq.equals("yes") || turq.equals("Yes"))
                {
                    System.out.println("\nyay i win");
                }
                else
                {
                    System.out.println("\nIs your color black?");
                    String black = user.next();
                    if (black.equals("yes") || black.equals("Yes"))
                    {
                        System.out.println("\nyay i win");
                    }
                    else
                    {
                        System.out.println("\nIs your color white?");
                        String white = user.next();
                        if (white.equals("yes") || white.equals("Yes"))
                        {
                            System.out.println("\nyay i win");
                        }
                        else
                        {
                            System.out.println("\noh i lose");
                        }
                    }
                }
            }
        }
        
    }
}
