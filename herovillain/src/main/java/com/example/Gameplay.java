package com.example;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Gameplay
{
  public static void main(String[] args)
  {
    Weapon Claws = new Weapon("Claws");
    Weapon Teeth = new Weapon("Teeth");

    Cat Claire = new Cat(Claws);
    Claire.toString();

    Mice Gage = new Mice(3, "brown", "Gage", Teeth);
    Gage.toString();
    Mice Peter = new Mice(1, "black", "Peter", Teeth);
    Mice Abdul = new Mice(2, "grey", "Abdul", Teeth);

    int choose;
    
    while(Claire.getHealth() > 0 && (Mice.getHealthAll()) > 0 )
    {
      choose = (int)(Math.random()* 3 + 1);
      if (choose == 1)
      {
        if (Gage.getHealthOne() > 0)
        {
          Gage.attackHero(Claire, Gage);
          Claire.attackVillain(Gage);
        }
      }
      else if (choose == 2)
      {
        if (Peter.getHealthOne() > 0)
        {
          Peter.attackHero(Claire, Peter);
          Claire.attackVillain(Peter);
        }
      }
      else
      {
        if (Abdul.getHealthOne() > 0)
        {
          Abdul.attackHero(Claire, Abdul);
          Claire.attackVillain(Abdul);
        }
      }

    }

    if (Claire.getHealth() > 0)
    {
      System.out.println("Cat wins :D");
    }
    else if(Mice.getHealthAll() > 0)
    {
      System.out.println("Mice win D:");
    }
    else
    {
      System.out.println("tie uueueueu");
    }
  }
}