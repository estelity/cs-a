package com.example;

public class Land extends Animal{

    private String habitat;

    public Land(String name, String size, int weight, String species, String food_type, boolean nocturnal, String habitat){
        super(name, size, weight, species, food_type, nocturnal);
        this.habitat = habitat;
    }

    public String getHabitat(){
        return habitat;
    }
}
