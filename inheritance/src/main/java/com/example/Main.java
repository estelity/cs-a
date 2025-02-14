package com.example;

public class Main {
    public static void main(String[] args) {
        SportsCar shelby = new SportsCar("manufacture", 2020, 10, 80, "gas", 4, true);
        SUV explorer = new SUV("manufacture", 2021, 10, 75, "gas", 2, 4);


        Car a = new Car("manufacture", 2024, 20, 80, "electric");
        SportsCar b = new SportsCar("manufacture", 2023, 20, 90, "gas", 4, false);
        SUV c = new SUV("manufacture", 2021, 10, 75, "gas", 2, 4);
        Car d = new SportsCar("manufacture", 2020, 10, 80, "gas", 4, true);
        Car e = new SUV("manufacture", 2021, 10, 75, "gas", 2, 4);

        a.honk();
        b.honk();
        c.honk();
        d.honk();
        e.honk();

        // Car a = new SUV()
        // can only call Car methods, but starts looking from SUV,
        // so if something overriden in SUV, uses SUV
        
        // SUV b = new SUV();
        // HERE you can call SUV moethods
    }
}