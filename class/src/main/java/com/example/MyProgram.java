package com.example;

import javax.swing.*;

public class MyProgram {
    public static void main(String[] args) {
        // Create a Turtle object
        
        Turtle Ann = new Turtle();

        //draw your first initial

        Ann.up();
        Ann.backward(175);
        Ann.left(90);
        Ann.forward(200);
        Ann.right(90);
        Ann.down();
        Ann.backward(30);
        Ann.right(90);
        Ann.forward(50);
        Ann.left(90);
        Ann.forward(30);
        Ann.left(90);
        Ann.forward(25);
        Ann.left(90);
        Ann.forward(15);

        //draw a 5 pointed star

        Ann.up();
        Ann.right(180);
        Ann.forward(80);
        Ann.down();
        
        for (int i = 0; i < 5; i++)
        {
            Ann.forward(100);
            Ann.right(144);
        }

        //draw a flower

        Ann.up();
        Ann.forward(250);
        Ann.down();
        Ann.left(90);
        for(int i = 0; i < 5; i++)
        {
            Ann.forward(25);
            Ann.right(90);
            for(int j = 0; j < 3; j++)
            {
                Ann.forward(50);
                Ann.right(90);
            }
            Ann.forward(25);
            Ann.right(144);

        }

        //Create something colorful

        Ann.up();
        Ann.left(180);
        Ann.forward(200);
        Ann.left(90);
        Ann.backward(200);
        Ann.left(90);
        Ann.down();
        int rand;
        String color;
        for(int i = 0; i < 5; i++)
        {
            color = "coral";
            rand = (int)(Math.random()* 5);
            if (rand == 0)
            {
                color = "coral";
            }
            if (rand == 1)
            {
                color = "red";
            }
            if (rand == 2)
            {
                color = "blueviolet";
            }
            if (rand == 3)
            {
                color = "crimson";
            }
            if (rand == 4)
            {
                color = "pink";
            }
            if (rand == 5)
            {
                color = "purple";
            }
            Ann.penColor(color);
            Ann.forward(25);
            Ann.right(90);
            for(int j = 0; j < 3; j++)
            {
                Ann.forward(50);
                Ann.right(90);
            }
            Ann.forward(25);
            Ann.right(144);

        }

        }
    }