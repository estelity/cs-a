package com.example;

public class Penguin extends Land{
  
    public Penguin(String name, String size, int weight, String species, String food_type, boolean nocturnal, String habitat){
        super(name, size, weight, species, food_type, nocturnal, habitat);
    }

    @Override
    public void speak(){
        System.out.println("roawr roaw");
    }
}
