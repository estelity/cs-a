package com.example;
import java.util.*;

public class Deck {
    
    // Instance Variables
    private static ArrayList<Card> deck = new ArrayList<>();
    public ArrayList<Card> indv = new ArrayList<>();
    public static ArrayList<Card> pile = new ArrayList<>(); 
    private int playerNumber;
    private static Card emptyCard = new Card("","");

    // Constructor

    public Deck(int playerNumber){
        this.playerNumber = playerNumber;
    }


    // Methods

    public static void makeDefaultDeck(){
        // Default Deck

        for (int i = 0; i < 8; i++){
            deck.add(new Card("TG.png", "Taco"));
            deck.add(new Card("CY.png", "Cat"));
            deck.add(new Card("GB.png", "Goat"));
            deck.add(new Card("CHP.png", "Cheese"));
            deck.add(new Card("PPi.png", "Pizza"));
        }

        deck.add(new Card("NB.png", "narwhal"));
        deck.add(new Card("NY.png", "narwhal"));
        deck.add(new Card("NG.png", "narwhal"));

        deck.add(new Card("GORP.png", "gorilla"));
        deck.add(new Card("GORPi.png", "gorilla"));
        deck.add(new Card("GORY.png", "gorilla"));

        deck.add(new Card("GRP.png", "groundhog"));
        deck.add(new Card("GRY.png", "groundhog"));
        deck.add(new Card("GRPi.png", "groundhog"));

        deck.add(new Card("TY.png", "Taco"));
        deck.add(new Card("TP.png", "Taco"));
        deck.add(new Card("TPi.png", "Taco"));

        deck.add(new Card("CG.png", "Cat"));
        deck.add(new Card("CO.png", "Cat"));
        deck.add(new Card("CB.png", "Cat"));

        deck.add(new Card("GY.png", "Goat"));
        deck.add(new Card("GP.png", "Goat"));
        deck.add(new Card("GG.png", "Goat"));

        deck.add(new Card("CHPi.png", "Cheese"));
        deck.add(new Card("CHG.png", "Cheese"));
        deck.add(new Card("CHR.png", "Cheese"));

        deck.add(new Card("PG.png", "Pizza"));
        deck.add(new Card("PP.png", "Pizza"));
        deck.add(new Card("PY.png", "Pizza"));
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void splitDeck(){
        if (playerNumber == 1){
            for (int i = 0; i < 21; i++){
                indv.add(deck.get(i));
            }
        }
        if (playerNumber == 2){
            for (int i = 21; i < 42; i++){
                indv.add(deck.get(i));
            }
        }
        if (playerNumber == 3){
            for (int i = 42; i < 64; i++){
                indv.add(deck.get(i));
            }
        }
    }

    public String getCards(){
        return indv.toString();
    }

    public void removeCard(){
        pile.add((Card) indv.get(0));
        indv.remove(0);
    }

    public void addCards(){
        for (int i = 0; i < pile.size(); i++){
            indv.add(pile.get(i));
        }
        pile.clear();
    }

    public Card getCard(int i){
        return indv.get(i);
    }

    public int getSize(){
        return indv.size();
    }

    public static Card getTopCard(){
        if (pile.isEmpty()){
            return emptyCard;
        }
        return pile.get(pile.size()-1);
    }

    public String toString(){
        return "Main Deck: " + deck.toString() + "/n Player Deck: " + indv.toString() + "\nPile: " + pile.toString() + "\nPlayer Number:" + playerNumber;
    }

}
