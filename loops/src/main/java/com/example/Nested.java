package com.example;

public class Nested {
    public static void main(String[] args){

        int spaces = 5;
        int stars = 1;

        for(int i = 0; i < 5; i++){

            for(int j = 0; j < spaces; j++){

                System.out.print(" ");
            }

            for(int k = 0; k < stars; k++){

                System.out.print("* ");
            }

            for(int j = 0; j < spaces; j++){

                System.out.print(" ");
            }
            spaces--;
            stars ++;
            System.out.println();
        }
    }
}
