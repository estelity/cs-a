package com.example;

// Write the class Radio
public class Radio
{

    // Instance variables
    private String frequency;
    private double station;

    public Radio(String frequency)
    {

        // "this" refers to the instance variables
        this.frequency = frequency;
        station = 90;
        
        // System out and Scanner can only be in main file;

        if (frequency.equals("AM"))
        {
            station = (int)station;
        }
    }

    public String getFrequency()
    {
        return frequency;
    }

    public void setFrequency(String newFrequency)
    {
        frequency = newFrequency;

        if (frequency.equals("AM"))
        {
            station = (int)station;
        }
    }

    public double getStation()
    {

        return station;
    }  

    public void setStation(double newStation)
    {

        if (frequency.equals("AM"))
        {
            newStation = (int)newStation;
        }
        station = newStation;
    }

    public void changeBy(double increment)
    {
        if (frequency.equals("AM"))
        {
            increment = (int)increment;
        }

        station += increment;
    }

    public void nextStation()
    {
        if (frequency.equals("FM"))
        {
            station += 0.2;
        }
        else
        {
            station += 10;
        }
    }
}
