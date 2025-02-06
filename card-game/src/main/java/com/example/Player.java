package com.example;

public class Player {

    // Instance Variables
    private Deck hand = new Deck(0);
    private int playerNumber;

    // Constructors
    public Player(Deck hand, int playerNumber){
        this.hand = hand;
        this.playerNumber = playerNumber;
    }

    // Method

    public int getPlayerNumber(){
        return playerNumber;
    }

    public Deck getHand(){
        return hand;
    }

    public void drawCards(){
        hand.splitDeck();
    }

    public void hit(){
        hand.removeCard();
    }

    public Card getCard(){
        return hand.getCard(0);
    }

    public void takePile(){
        hand.addCards();
    }

}
