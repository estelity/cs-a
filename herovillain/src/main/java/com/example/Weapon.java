package com.example;

public class Weapon {
    
    // instance variables
    private int damage;
    private String name;
    private int sharpness;

    /**
     * creates a weapon with the name entered
     * @param name - name of the weapon
     */
    public Weapon(String name)
    {
        damage = 3;
        this.name = name;
        sharpness = 3;
    }

    /**
     * returns the name of the weapon
     * @return name - the name of the weapon
     */
    public String getName()
    {
        return name;
    }

    /**
     * sets a new name for the weapon
     * @param name - the name of the weapon
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return "/nDamage: " + damage + "/nName: " + name + "/nSharpness: " + sharpness;
    }
    
}
