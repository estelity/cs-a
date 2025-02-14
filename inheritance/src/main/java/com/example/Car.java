package com.example;

public class Car extends Vehicle{
    private int mpg;
    private boolean locked;
    private int maxSpeed;
 
    public Car(String  manufacture, int year, int mpg, int maxSpeed, String fuel) {
        super(manufacture, year, fuel);
        this.mpg = mpg;
        locked = false;
        this.maxSpeed = maxSpeed;
    }
    public int getMPG() {
        return mpg;
    }
       public boolean isLocked() {
        return locked;
    }
    public int getMaxSpeed(){
        return maxSpeed;
    }
    @Override
    public void honk() {
        System.out.println("hong honk");
    }
 
}
