package com.example;

// Hero

public class Cat {
    
    // instance variables
    private int heroHealth;
    private final String name;
    private Weapon Claws;

    /**
     * creates a Cat object
     */
    public Cat(Weapon Claws)
    {
        name = "Claire";
        heroHealth = 19; 
        this.Claws = Claws;
    }

    /**
     * creates a Cat object with a chosen amount of health
     * @param heroHealth - health of the hero
     */
    public Cat(int heroHealth, Weapon Claws)
    {
        name = "Claire";
        this.heroHealth = heroHealth;
        Claws.setName("Claws");
    }

    /**
     * loses health based on the damage of the chosen mouse
     * @param nameMouse - name of the mouse dealing damage
     */
    public void takeDamage(Mice nameMouse)
    {
        heroHealth -= nameMouse.getDamage();
    }

    /**
     * attacks the chosen mouse and deals three points of damage
     * @param nameMouse - name of the mouse being attacked
     */
    public void attackVillain(Mice nameMouse)
    {
        nameMouse.takeDamage();
    }

    /**
     * returns the amount of health of the hero
     * @return heroHealth - health of the hero
     */
    public int getHealth()
    {
        return heroHealth;
    }
    
    public String toString()
    {
        return "/nHealth: " + heroHealth + "/nName " + name + "/nWeapon: " +
        Claws.getName();
    }

    // private method can be used inside another method to shorten some stuff

}
