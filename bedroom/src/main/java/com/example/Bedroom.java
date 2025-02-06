package com.example;

public class Bedroom {
    public static void main(String[] args)
  {
    // Bed
    Bed myBed = new Bed("queen");
    for(int i = 0; i < 3; i++)
    {
      myBed.jumpOnBed();
    }
    myBed.makeBed();
    myBed.changeColors("yellow", "white");
    System.out.print(myBed);

    // Bedside Table
    BedsideTable myBedsideTable = new BedsideTable("wood");
    myBedsideTable.openDrawer();
    myBedsideTable.grabObject();
    myBedsideTable.turnLamp();
    myBedsideTable.turnLamp();
    System.out.print(myBedsideTable);

    // Door
    Door myDoor = new Door();
    myDoor.openDoor();
    myDoor.slamDoor();
    System.out.print(myDoor);

    // Fan
    Fan myFan = new Fan("brown");
    myFan.pullLight();
    System.out.print(myFan);

    // Lamp
    Lamp myLamp = new Lamp("white");
    myLamp.turnSwitch();
    System.out.print(myLamp);

    // Pillow
    Pillow myPillow = new Pillow("blue", 2, "feathers");
    myPillow.grabPillow(2);
    myPillow.changePillowcase("pink");
    System.out.print(myPillow);

    // Window
    Window myWindow = new Window(true, false, 5);
    myWindow.pullCurtains();
    myWindow.turnBlindsL();
    myWindow.turnBlindsR();
    System.out.print(myWindow);
  }

}
