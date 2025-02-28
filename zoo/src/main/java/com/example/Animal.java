package com.example;

public class Animal {
    private String name;
    private String size;
    private int weight;
    private String species;
    private String food_type;
    private boolean nocturnal;

    public Animal(String name, String size, int weight, String species, String food_type, boolean nocturnal){
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.species = species;
        this.food_type = food_type;
        this.nocturnal = nocturnal;
    }

    public String sleep(){
        if (nocturnal){
            return "day";
        }
        return "night";
    }

    public void eat(String food){
        if (food_type.equals("herbivore") && food.equals("meat")){
            System.out.println("I don't eat this!");
        }
        else if(food_type.equals("carnivore") && food.equals("plants")){
            System.out.println("I don't eat this!");
        }
        else{
            System.out.println(name + " the " + species + " thinks " + food + " is yummy!");
        }
    }

    public String getFood(){
        if (food_type.equals("herbivore")){
            return "plants";
        }
        else if(food_type.equals("carnivore")){
            return "meat";
        }
        else{
            return "plants";
        }
    }

    public void speak(){
        System.out.println("meow");
    }

    public int getWeight(){
        return weight;
    }

    public String toString(){

        return "Name: " + name + "\nSize: " + size + "\nWeight: " + weight + "\nSpecies: " + species + "\nFood Type: " + food_type + "\nNocturnal: " + nocturnal;
    }
}
