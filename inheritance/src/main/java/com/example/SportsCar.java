package com.example;

public class SportsCar extends Car {

    private int numDoors;
    private boolean isConvertible;

    SportsCar(String  manufacture, int year, int mpg, int maxSpeed, String fuel, int numDoors, boolean isConvertible){
        super(manufacture, year, mpg, maxSpeed, fuel);
        this.numDoors = numDoors;
        this.isConvertible = isConvertible;
    }

    public boolean isConvertable(){
        return isConvertible;
    }
    
    public int getNumDoors(){
        return numDoors;
    }

    @Override
    public void honk(){
        System.out.println("big honk");;
    }
}
