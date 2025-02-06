package com.example;

public class Pizza 
{
    public static void main(String[] args)
    {
        int numStudents = 5;
        int slicesPerPerson = 7;
        int slices = numStudents * slicesPerPerson;
        double mod = ((double)(slices % 8) / 10) + 0.9;
        int extra = (int) mod;
        int pizzas = (slices / 8) + extra;
        System.out.println(pizzas);
    }
}
