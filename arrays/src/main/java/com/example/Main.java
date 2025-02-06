package com.example;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // array lists hold objects, arrays hold primitive types
        // for each loop are always optional
        // for (type elem : arr)
        // ex: for (String i : arr)

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        System.out.println();
        System.out.println("Type a zero when you're finished");
        int number = 1; 
        while (number != 0){
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            numbers.add(number);
            System.out.println();
        }

        Collections.sort(numbers);
        numbers.remove(0);
        double median;
        if(numbers.size() % 2 == 0){
            median = numbers.get((numbers.size() / 2) - 1) + numbers.get(numbers.size() / 2);
            median /= 2;
        }
        else
        {
            median = numbers.get((numbers.size() / 2));
        }
        System.out.println("Median: " + median);
        
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }

        double mean = sum/(double)(numbers.size());
        System.out.println("Mean: " + mean);

        System.out.println(numbers.toString());

        String answer = "y";
        scanner.nextLine();
        while (answer.equals("y")){
            System.out.println("Would you like to remove a number? (y or n)");
            answer = scanner.nextLine();

            if (answer.equals("y")){
                System.out.println("What is the index of the number you'd like to remove?");
                int index = scanner.nextInt();
                numbers.remove(index);

                if(numbers.size() % 2 == 0){
                    median = numbers.get((numbers.size() / 2) - 1) + numbers.get(numbers.size() / 2);
                    median /= 2;
                }
                else
                {
                    median = numbers.get((numbers.size() / 2));
                }
                System.out.println("Median: " + median);

                sum = 0;
                for (int i = 0; i < numbers.size(); i++){
                sum += numbers.get(i);
                }

                mean = sum/(double)(numbers.size());
                System.out.println("Mean: " + mean);

                System.out.println(numbers.toString());
                scanner.nextLine();
            }
        }

    }
}