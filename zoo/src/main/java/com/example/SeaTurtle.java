package com.example;

public class SeaTurtle extends Water{

    public SeaTurtle(String name, String size, int weight, String species, String food_type, boolean nocturnal, String waterType){
        super(name, size, weight, species, food_type, nocturnal, waterType);
        size = "medium";
        food_type = "omnivore";
        nocturnal = false;
        waterType = "salt";
    }

    @Override
    public void speak(){
        System.out.println("snap blub snapsnap");
    }
}
