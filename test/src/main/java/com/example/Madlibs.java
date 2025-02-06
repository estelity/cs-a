package com.example;

import java.util.Scanner;

// Madlib template: https://assets.readbrightly.com/wp-content/uploads/2020/08/Snoopy-Mad-Libs.pdf

public class Madlibs 
{
    public static void main(String[] args) 
    {
        // Generates question prompts to get input from the user
        System.out.print("\nWelcome to Madlibs! Please begin by answering these 10 questions in all lowercase:\n\n");
        @SuppressWarnings("resource")
        Scanner user = new Scanner(System.in);

        System.out.print("What's your favorite animal? ");
        String animal = user.next();
 
        System.out.print("\nDescribe your best friend in one word: ");
        String adjective1 = user.next();

        System.out.print("\nDescribe Ms. Sheridan in one word: ");
        String adjective2 = user.next();

        System.out.print("\nSomething you can't live without (singular): ");
        String noun1 = user.next();

        System.out.print("\nFavorite object: ");
        String noun2 = user.next();

        System.out.print("\nWhat are you craving right now? ");
        String food = user.next();

        // Creates another Scanner because it glitched out and skipped an input
        @SuppressWarnings({ "\nresource", "resource" })
        Scanner user1 = new Scanner(System.in);

        System.out.print("\nWhat's the best spot for a first date? ");
        String place1 = user1.next();

        System.out.print("\nLeast favorite place: ");
        String place2 = user1.next();

        System.out.print("\nHow many hours did you sleep last night? ");
        int number1 = user1.nextInt();

        System.out.print("\nHow many classes are you taking this year? ");
        int number2 = user1.nextInt();

        System.out.print("\nWhat day of the month is your birthday on? ");
        int number3 = user1.nextInt();

        System.out.print("\nWhat's your lucky number (that is greater than 1)? ");
        int number4 = user1.nextInt();

        // Outputs the completed story
        String completedStory = "\nA Peanut and his Pooch \n\n" +
        "If you've ever met my " + animal + ", Snoopy, then you know he's not\n" +
        "your average canine companion. Some kids might find it " + adjective1 + "\n" +
        "that their beagle has such a/an " + adjective2 + " imagination, but not\n" + 
        "me! All I've ever wanted was a normal, " + adjective1 + " dog. Why can't\n" + 
        "I have a/an " + noun1 + " just like everyone else? Instead, I've got a \n" + 
        "part-time pet, part time World War " + number1 + " pilot, part time " + noun2 + "\n" + 
        "and a full-time pain! Good grief! Sometimes he looks at me\n" +
        "like I'm chopped " + food + "- good for nothing except bringing\n" + 
        "his dinner out to (the) " + place1 + ". Still, it sure is nice to have\n" + 
        "someone with " + number2 + " ears around. And after " + number3 + " hours\n" +
        "at (the) " + place2 + ", there's nothing better than coming home to " + number4 + "\n" + 
        "wet kisses on the cheek. Aw who am I kidding? I'm really\n" + 
        "lucky to have a/an " + animal + " like Snoopy. They don't call dogs\n" + 
        "man's best " + noun2 + " for nothing!\n";
        System.out.print(completedStory);
    }
}
