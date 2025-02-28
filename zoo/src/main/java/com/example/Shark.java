package com.example;

public class Shark extends Water{

    public Shark(String name, String size, int weight, String species, String food_type, boolean nocturnal, String waterType){
        super(name, size, weight, species, food_type, nocturnal, waterType);
        size = "large";
        food_type = "carnivore";
        nocturnal = true;
        waterType = "salt";
    }

    @Override
    public void speak(){
        System.out.println("roawr roaw");
    }
}
