package com.example;

public class Pillow {
    
    // Instance variables
    private String pillowcaseColor;
    private int numberPillows;
    private String stuffingType;

    // Constructor
    public Pillow(String pillowcaseColor, int numberPillows, String stuffingType)
    {
        this.pillowcaseColor = pillowcaseColor;
        this.numberPillows = numberPillows;
        this.stuffingType = stuffingType;
    }

    // Methods
    public String getColor()
    {
        return pillowcaseColor;
    }

    public void changePillowcase(String color)
    {
        pillowcaseColor = color;
    }

    public void grabPillow(int pillows)
    {
        for (int i = 0; i < pillows; i++)
        {
            numberPillows ++;
        }
        
    }

    public String toString()
    {
        return "\nPillowcase Color: " + pillowcaseColor + "\nNumber of Pillows: " + numberPillows + 
        "\nStuffing Type: " + stuffingType + "\n";
    }
}
