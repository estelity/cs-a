package com.example;

public class BedsideTable {

    // Instance variables
    private String materialType;
    private int objectsOnTable;
    private Boolean drawerOpen;
    private String drawerOpenString;
    private Lamp myLamp;
    private String myLampString;

    // Constructor
    public BedsideTable(String materialType)
    {
        this.materialType = materialType;
        objectsOnTable = 4;
        drawerOpen = false;
        myLamp = new Lamp("white");
    }

    public BedsideTable(int objectsOnTable, Boolean drawerOpen)
    {
        this.drawerOpen = drawerOpen;
        this.objectsOnTable = objectsOnTable;
        drawerOpen = false;
        myLamp = new Lamp("white");
    }

    // Methods
    public void openDrawer()
    {
        drawerOpen = true;
    }

    public void closeDrawer()
    {
        drawerOpen = false;
    }

    public void grabObject()
    {
        objectsOnTable --;
    }

    public void dropObject()
    {
        objectsOnTable ++;
    }

    public void turnLamp()
    {
        myLamp.turnSwitch();
    }

    public String toString()
    {
        if (drawerOpen)
        {
            drawerOpenString = "open";
        }
        else
        {
            drawerOpenString = "closed";
        }

        if (myLamp.getOnOff())
        {
            myLampString = "on";
        }
        else
        {
            myLampString = "off";
        }

        return "\nMaterial Type: " + materialType + "\nNumber of Objects on Table: " + objectsOnTable + 
        "\nDrawer: " + drawerOpenString + "\nLamp: " + myLampString + "\n";
    }
}
