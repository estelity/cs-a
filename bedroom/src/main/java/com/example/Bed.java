package com.example;

public class Bed {

    // Instance variables
    private String sheetColor;
    private String size;
    private Pillow myPillow;
    private int neatness;
    
    // Constructor
    public Bed(String size)
    {
        this.size = size;
        sheetColor = "white";
        neatness = 5;
        myPillow = new Pillow("blue", 2, "feathers");
    }
    
    // Methods
    public String getSheetColor()
    {
        return sheetColor;
    }

    public void makeBed()
    {
        if (neatness < 10)
        {
            neatness ++;
        }
    }

    public void jumpOnBed()
    {
        if (neatness > 0)
        {
            neatness --;
        }
    }

    public void changeColors(String sheetColor, String pillowcase)
    {
        this.sheetColor = sheetColor;
        myPillow.changePillowcase(pillowcase);
    }

    public String toString()
    {
        return "\nSheet Color: " + sheetColor + "\nSize: " + size + "\nPillow: " + myPillow.getColor() + 
        "\nNeatness: " + neatness + "\n";
    }
}