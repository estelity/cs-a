package com.example;

public class Window {

    // Instance variables
    private Boolean curtainOpen;
    private String curtainString;
    private Boolean windowOpen;
    private String windowString;
    private int lightLevel;

    // Constructor
    public Window(Boolean curtainOpen, Boolean windowOpen, int lightLevel)
    {
        this.curtainOpen = curtainOpen;
        this.windowOpen = windowOpen;
        this.lightLevel = lightLevel;
        
    }

    // Methods
    public void turnBlindsL()
    {
        if (lightLevel < 10)
        {
            lightLevel ++;
        }
    }

    public void turnBlindsR()
    {
        if (lightLevel > 0)
        {
            lightLevel --;
        }
    }

    public String windowState()
    {
        String state = "open";
        if (windowOpen == true)
        {
            state = "open";
        }
        else
        {
            state = "closed";
        }
        return state;
    }

    public void pullCurtains()
    {
        curtainOpen = !curtainOpen;
    }

    public String toString()
    {
        if(curtainOpen)
        {
            curtainString = "open";
        }
        else
        {
            curtainString = "closed";
        }

        if(windowOpen)
        {
            windowString = "open";
        }
        else
        {
            windowString = "closed";
        }

        return "\nCurtains: " + curtainString + "\nWindows: " + windowString + "\nLight Level: " + lightLevel + "\n";
    }
}
