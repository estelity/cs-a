package com.example;

public class Main {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[8];
        addAnimalsToZoo(zoo, "Panda", "Gage", 305, 0);
        addAnimalsToZoo(zoo, "Penguin", "Abdul", 51, 1);
        addAnimalsToZoo(zoo, "Panda", "Raya", 310, 2);
        addAnimalsToZoo(zoo, "Penguin", "Peter", 50, 3);
        addAnimalsToZoo(zoo, "Sea Turtle", "Saahil", 350, 4);
        addAnimalsToZoo(zoo, "Shark", "Ann", 200, 5);
        addAnimalsToZoo(zoo, "Shark", "Henry", 250, 6);
        addAnimalsToZoo(zoo, "Panda", "Ms. Sheridan", 300, 7);

        feed_animals(zoo, "night");
        sortByWeight(zoo);

        for (int i = 0; i < zoo.length; i++){
            System.out.print(zoo[i].toString());
        }
    }
        
    public static void addAnimalsToZoo(Animal[] zoo, String animal_type, String name, int weight, int cage){
        if (animal_type.equals("Panda")){
            zoo[cage] = new Panda(name, "large", weight, "Giant Panda", "herbivore", false, "Bamboo Forest");
        }

        if (animal_type.equals("Penguin")){
            zoo[cage] = new Penguin(name, "small", weight, "Emperor Penguin", "carnivore", true, "Ocean Coast");
        }

        if (animal_type.equals("Sea Turtle")){
            zoo[cage] = new SeaTurtle(name, "medium", weight, "Leatherback Sea Turtle", "omnivore", false, "salt");
        }

        if (animal_type.equals("Shark")){
            zoo[cage] = new Shark(name, "large", weight, "Great White Shark", "carnivore", false, "salt");
        }
    }

    public static void feed_animals(Animal[] zoo, String time){
        if (!time.equals("day") && !time.equals("night")){
            time = "day";
        }
        for (int i = 0; i < zoo.length; i++){
            String food = zoo[i].getFood();
            if(!zoo[i].sleep().equals(time)){
                zoo[i].eat(food);
            }
        }
    }

    public static void sortByWeight(Animal[] zoo){
        int n = zoo.length;

        for (int i = 0; i < n - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (zoo[j].getWeight() < zoo[minIndex].getWeight()){
                    minIndex = j;
                }
            }

                Animal temp = zoo[minIndex];
                zoo[minIndex] = zoo[i];
                zoo[i] = temp;
        }
    }
}