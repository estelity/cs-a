package com.example;

public class SUV extends Car{

    private int numRows;
    private int towCapacity;

    SUV(String  manufacture, int year, int mpg, int maxSpeed, String fuel, int numRows, int towCapcity){
        super(manufacture, year, mpg, maxSpeed, fuel);
        this.numRows = numRows;
        this.towCapacity = towCapacity;
    }

    public boolean hasThirdRow(){
        if (numRows > 2){
            return true;
        }

        return false;
    }

    @Override
    public void honk(){
        System.out.println("small honk");
    }
}
