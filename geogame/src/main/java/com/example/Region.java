package com.example;
public class Region {
    // add private instance variables for the name, capital, language, and image file.
    private String name;
    private String image_name;

    // add constructors
    public Region(String name, String image_name){
        this.name = name;
        this.image_name = image_name;
    }

    // Write accessor/get methods for each instance variable that returns it.
    public String getName(){
        return name;
    }

    public String getImageName(){
        return image_name;
    }

    // Write a toString() method that returns a concatenated String of 3 of the instance 
    // variables in a sentence like "The region is ..."
    public String toString(){
        return "The region is " + name;
    }

}