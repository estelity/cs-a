package com.example;

public class Fan {

    // Instance variables
    private double spinningLevel;
    private Boolean lightOn;
    private String fanColor;
    private String lightOnString;

    // Constructor
    public Fan(String fanColor)
    {
        this.fanColor = fanColor;
        spinningLevel = 0;
        lightOn = false;
    }

    // Methods
    public void pullLight()
    {
        lightOn = !lightOn;
    }

    public void pullFan()
    {
        if (spinningLevel < 1)
        {
            spinningLevel += 0.1;
        }
        else
        {
            spinningLevel = 0;
        }
    }

    public String toString()
    {
        if (lightOn)
        {
            lightOnString = "on";
        }
        else
        {
            lightOnString = "off";
        }

        return "\nSpinning Level: " + spinningLevel + "\nLight: " + lightOnString + "\nFan Color: "  + 
        fanColor + "\n";
    }
}
