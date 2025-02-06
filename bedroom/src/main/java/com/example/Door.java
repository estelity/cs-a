package com.example;

public class Door {
    
    // Instance variables
    private Boolean openClosed;
    private String openClosedString;
    private String doorColor;
    private String doorknobColor;

    // Constructor
    public Door()
    {
        openClosed = false;
        doorColor = "brown";
        doorknobColor = "gold";
    }

    // Methods
    public void openDoor()
    {
        openClosed = true;
    }

    public void slamDoor()
    {
        openClosed = false;
    }

    public String toString()
    {
        if(openClosed)
        {
            openClosedString = "open";
        }
        else
        {
            openClosedString = "closed";
        }
        return "\nDoor: " + openClosedString + "\nDoor Color: " + doorColor + "\nDoorknob Color: " +
        doorknobColor + "\n";
    }
}
