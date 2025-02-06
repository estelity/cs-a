package com.example;

// Villains

public class Mice {
    
   // instance variables
    private static int villainsHealth;
    private int individualHealth;
    private String color;
    private int damage;
    private Weapon Teeth;
    private String name;

    /**
     * creates a mice object
     * @param damage - amount of damage the mice deals
     * @param color - the color of the fur of the mice
     * @param name - the name of the mice 
     */
    public Mice(int damage, String color, String name, Weapon Teeth)
    {
        this.damage = damage;
        this.color = color;
        villainsHealth = 30;
        individualHealth = 10;
        this.name = name;
        this.Teeth = Teeth;
    }

    /**
     * gets the amount of damage the mice deals
     * @return damage - returns the amount of damage that the mice deals
     */
    public int getDamage()
    {
        return damage;
    }

    /**
     * attacks the Cat and takes away the amount of damage that the mice deals
     * @param nameCat - the name of Cat being attacked
     * @param nameMouse - the name of the Mice attacking
     */
    public void attackHero(Cat nameCat, Mice nameMouse)
    {
        nameCat.takeDamage(nameMouse);
    }

    /**
     * the mice object takes 3 points of damage subtracted from the overall and individual health
     */
    public void takeDamage()
    {
        villainsHealth -= 3;
        individualHealth -=3;
    }

    /**
     * returns the overall health of all mice
     * @return villainsHealth - the overall health of all mice combined together
     */
    public static int getHealthAll()
    {
        return villainsHealth;
    }

    /**
     * returns the individual health of the chosen mice
     * @return individualHealth - the individual health of that Mice
     */
    public int getHealthOne()
    {
        return individualHealth;
    }

    public String toString()
    {
        return "/nOverall Health: " + villainsHealth + "/nIndividual Health: " + individualHealth + "/nColor: " +
        color + "/nDamage: " + damage + "Weapon: " + Teeth.getName() + "/nName: " + name;
    }

}
