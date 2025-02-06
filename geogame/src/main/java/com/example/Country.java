package com.example;
public class Country {
    // add private instance variables for the name, capital, language, and image file.
    private String name;
    private String capital;
    private String language;
    private String image_name; 

    // add constructors
    public Country(){
        name = "";
        capital = "";
        language = "";
        image_name = "";
    }

    public Country(String name, String capital, String language, String image_name){
        this.name = name;
        this.capital = capital;
        this.language = language;
        this.image_name = image_name;
    }

    // Write accessor/get methods for each instance variable that returns it.
    public String getName(){
        return name;
    }

    public String getCapital(){
        return capital;
    }
    
    public String getLanguage(){
        return language;
    }

    public String getImageName(){
        return image_name;
    }

    // Write a toString() method that returns a concatenated String of 3 of the instance 
    // variables in a sentence like "..'s capital is .. and its primary language is ..."

    public String toString(){
        return name + "'s capital is " + capital + " and its primary language is " + language;
    }



}