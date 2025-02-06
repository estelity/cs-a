package com.example;

public class Card {

    // Instance Variables
    private String imageUrlString;
    private String cardName;

    // Constructor
    public Card (String imageUrlString, String cardName){
        this.imageUrlString = imageUrlString;
        this.cardName = cardName;
    }

    // Methods
    public String getImageUrl(){
        return imageUrlString;
    }

    public String cardName(){
        return cardName;
    }

    public String toString(){
        return "\nName: " + cardName + " Image Url: " + imageUrlString;
    }
    
}