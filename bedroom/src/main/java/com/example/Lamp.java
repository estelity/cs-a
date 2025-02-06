package com.example;

public class Lamp {

    // Instance variables
    private String lampshadeColor;
    private Boolean onOff;
    private String lampshadeShape;
    private String lightColor;
    private String onOffString;

    // Constructor
    public Lamp(String lampshadeColor)
    {
        this.lampshadeColor= lampshadeColor;
        onOff = false;
        lampshadeShape = "square";
        lightColor = "yellow";
    }

    // Methods
    public void turnSwitch()
    {
        onOff = !onOff;
    }

    public String getShape()
    {
        return lampshadeShape;
    }

    public Boolean getOnOff()
    {
        return onOff;
    }

    public String toString()
    {
        if (onOff)
        {
            onOffString = "on";
        }
        else
        {
            onOffString = "off";
        }
        return "\nLampshade Color: " + lampshadeColor + "\nLamp: " + onOffString + "\nLampshade Shape: " + 
        lampshadeShape + "\nLight Color: " + lightColor + "\n";
    }
}
