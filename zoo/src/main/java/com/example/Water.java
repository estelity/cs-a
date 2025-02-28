package com.example;

public class Water extends Animal{

    private String waterType;
    
    public Water(String name, String size, int weight, String species, String food_type, boolean nocturnal, String waterType){
        super(name, size, weight, species, food_type, nocturnal);
        this.waterType = waterType;
    }

    public String getWaterType(){
        return waterType;
    }
}
