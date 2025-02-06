package com.example;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowingCards extends JPanel implements KeyListener{
    private Deck deck, pile;
    private Player playerOne;
    private Player playerTwo;
    private Player playerThree;
    public static final int CARD_WIDTH = 100;
    public static final int CARD_HEIGHT = 145;
    public static final String IMAGE_DIR="/Users/grace.shen/CS A/card-game/src/main/java/com/example/MyCardPics/";
    private ArrayList<JLabel> lblPlayerOneCards = new ArrayList<>();
    private ArrayList<JLabel> lblPlayerTwoCards = new ArrayList<>();
    private ArrayList<JLabel> lblPlayerThreeCards = new ArrayList<>();
    private int tacoCat = -1;
    private boolean finished = false;

    private JLabel lblPlayerHandVal; 
    public static int initialCardX = 30, initialCardY = 300;
    //declare the 3 buttons needed for GUI

    private int playerOneHit = 0;
    private int playerTwoHit = 0;
    private int playerThreeHit = 0;

    private int cardOne = 0;
    private int cardTwo = 0;
    private int cardThree = 1;

    private ImageIcon centerImage;
    private JLabel testCardLabel;
    private JButton resetButton;


    public ShowingCards(){

        //Create a new deck with 64 cards
        deck = new Deck(0);
        Deck.makeDefaultDeck();
        //Create a new empty deck
        pile = new Deck(0);
        //Shuffle the deck and start the first round
        deck.shuffle();

        playerOne = new Player(new Deck(1), 1);
        playerOne.drawCards();

        playerTwo = new Player(new Deck(2), 2);
        playerTwo.drawCards();

        playerThree = new Player(new Deck(3), 3);
        playerThree.drawCards();

        setupGUI();
    
        // adds key listener
        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocusInWindow();

        centerImage = new ImageIcon(IMAGE_DIR+"");
        //resize image to fit the dimensions we want
        centerImage = new ImageIcon(centerImage.getImage().getScaledInstance(165, 225, Image.SCALE_SMOOTH));
        //make a JLabel to hold the image
        testCardLabel = new JLabel(centerImage);
        // set its bounds to position and size it
        testCardLabel.setBounds(310, 240, 165, 225);
        //add to panel
        this.add(testCardLabel);
        testCardLabel.isVisible();

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Focus gained");
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Focus lost");
                requestFocusInWindow(); // Automatically try to regain focus
            }
        });
    }
    
    private void setupGUI(){

        resetButton = new JButton("Reset Game");
        resetButton.setBounds(350, 20, 100, 30);  // Adjust position/size as needed
        this.add(resetButton);

        resetButton.addActionListener(e -> {
            resetGame();
        });

        lblPlayerHandVal = new JLabel("");
        
        lblPlayerHandVal.setBounds(365, 75, 300, 50);
        
        this.add(lblPlayerHandVal);

        //Size of JPanel
        this.setSize(400, 200);
    
        //Make Buttons for "Hit" "Stand" and "Next Round" actions.
        //setBounds is used to define their locations and sizes
        // btnHit = new JButton("Hit");
        // btnHit.setFont(new java.awt.Font("Trattatello", Font.BOLD, 14));
        // btnHit.setBounds(10, 20, 60, 30);
    
        //need this layout so we can use absolute positioning
        this.setLayout(null);
    
        //Add the buttons to the JPanel
        // this.add(btnHit);

        //btnHit.setVisible(false);


    for (int i = 0; i < 21; i++){

    lblPlayerOneCards.add(new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardBack.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH))));
    lblPlayerOneCards.get(i).setVisible(true);

    //Use setBounds to set the width/height of each card, and their positions
    lblPlayerOneCards.get(i).setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);

    //add the JLabel to the JPanel so we can see it later
    this.add(lblPlayerOneCards.get(i));

    //increment the x/y values of each card by some amount, this will make them appear "stacked" so users can see each one
    initialCardX +=  3;
    initialCardY -= 0.5;

    }

    initialCardX = 300;
    initialCardY = 550;

    for (int i = 0; i < 21; i++){
    
        //set them to new cards face down
        //done with JLabels and ImageIcons
        
        lblPlayerTwoCards.add(new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardBack.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH))));
        lblPlayerTwoCards.get(i).setVisible(true);
        //Use setBounds to set the width/height of each card, and their positions
        lblPlayerTwoCards.get(i).setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);
    
        //add the JLabel to the JPanel so we can see it later
        this.add(lblPlayerTwoCards.get(i));
    
        //increment the x/y values of each card by some amount, this will make them appear "stacked" so users can see each one
        initialCardX +=  3;
        initialCardY -= 0.5;
    }


    initialCardX = 575;
    initialCardY = 300;

    for (int i = 0; i < 22; i++){
    
        //set them to new cards face down
        //done with JLabels and ImageIcons
        lblPlayerThreeCards.add(new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardBack.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH))));
        lblPlayerThreeCards.get(i).setVisible(true);
        //Use setBounds to set the width/height of each card, and their positions
        lblPlayerThreeCards.get(i).setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);
    
        //add the JLabel to the JPanel so we can see it later
        this.add(lblPlayerThreeCards.get(i));
    
        //increment the x/y values of each card by some amount, this will make them appear "stacked" so users can see each one
        initialCardX +=  3;
        initialCardY -= 0.5;
    }
// lblPlayerHandVal = new JLabel("Player's Hand Value:");
// lblPlayerHandVal.setBounds(20, 530, 300, 50);
// this.add(lblPlayerHandVal);

//make all labels white
// lblPlayerHandVal.setForeground(Color.WHITE);

// btnHit.addActionListener(new ActionListener() {
//     @Override
//     public void actionPerformed(ActionEvent e) {
//         //make the player hit the deck
//         // playerOne.hit();
//         // //update screen with their new card, and their score
//         // updateScreen();
//     }
// });

    
    }

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.decode("#FFFFFF"));
    g.fillRect(0,0,1000,1000);
}

private void updateScreen(){

    // lblPlayerHandVal.setText("Player's Hand Value: " + player.getHand().calculatedValue());
    // player.printHand(lblPlayerCards);
}

@Override
public void keyTyped(KeyEvent e) {

}

@Override
public void keyPressed(KeyEvent e) {

    if (!this.isFocusOwner()) {
        System.out.println("Panel lost focus!");
        this.requestFocusInWindow();
    }

    // Main Playing Keys

    if (e.getKeyCode() == KeyEvent.VK_A && finished == false && TCGCP() == false) {

        if(cardThree == 1){
            tacoCat++;
            
            lblPlayerOneCards.get(0).setVisible(false);
            lblPlayerOneCards.remove(0);

            testCardLabel.setIcon((new ImageIcon(new ImageIcon(IMAGE_DIR + playerOne.getHand().getCard(0).getImageUrl()).getImage().getScaledInstance(165, 225, Image.SCALE_SMOOTH))));
            testCardLabel.setVisible(true);

            playerOne.hit();

            updateScreenText(TacoCat());
            
            if (tacoCat == 4){
                tacoCat = 0;
            }

            if (checkFinished(lblPlayerOneCards)){
                lblPlayerHandVal.setText("Yay");
                resetGame();
            }
            else {
                cardThree --;
                cardOne ++;
            }
        }
        else{
            takePile(playerOne, lblPlayerOneCards);
            cardOne = 0;
            cardTwo = 0;
            cardThree = 1;
        }
    }
    if (e.getKeyCode() == KeyEvent.VK_B && finished == false && TCGCP() == false) {
        if (cardOne == 1){
            tacoCat++;

            lblPlayerTwoCards.get(0).setVisible(false);
            lblPlayerTwoCards.remove(0);

            testCardLabel.setIcon((new ImageIcon(new ImageIcon(IMAGE_DIR + playerTwo.getHand().getCard(0).getImageUrl()).getImage().getScaledInstance(165, 225, Image.SCALE_SMOOTH))));
            testCardLabel.setVisible(true);

            playerTwo.hit();

            updateScreenText(TacoCat());
            
            if (tacoCat == 4){
                tacoCat = 0;
            }

            if (checkFinished(lblPlayerTwoCards)){
                lblPlayerHandVal.setText("Yay");
                resetGame();
            }
            else {
                cardOne --;
                cardTwo ++;
            }
        }
        else{
            takePile(playerTwo, lblPlayerTwoCards);
            cardOne = 1;
            cardTwo = 0;
            cardThree = 0;
        }
    }
    if (e.getKeyCode() == KeyEvent.VK_P && finished == false && TCGCP() == false) {
        if (cardTwo == 1){
            tacoCat++;

            lblPlayerThreeCards.get(0).setVisible(false);
            lblPlayerThreeCards.remove(0);

            testCardLabel.setIcon((new ImageIcon(new ImageIcon(IMAGE_DIR + playerThree.getHand().getCard(0).getImageUrl()).getImage().getScaledInstance(165, 225, Image.SCALE_SMOOTH))));
            testCardLabel.setVisible(true);

            playerThree.hit();

            updateScreenText(TacoCat());

            if (tacoCat == 4){
                tacoCat = 0;
            }

            if (checkFinished(lblPlayerThreeCards)){
                lblPlayerHandVal.setText("Yay");
                resetGame();
            }
            else {
                cardTwo --;
                cardThree ++;
            }
        }
        else{
            takePile(playerThree, lblPlayerThreeCards);
            cardOne = 0;
            cardTwo = 1;
            cardThree = 0;
        }
    }

    // Testing Keys

    if (e.getKeyCode() == KeyEvent.VK_1) {
        System.out.println(playerOne.getHand());
        System.out.println(playerOne.getHand().getSize());
    }

    if (e.getKeyCode() == KeyEvent.VK_2) {
        System.out.println(playerTwo.getHand());
    }

    if (e.getKeyCode() == KeyEvent.VK_3) {
        System.out.println(playerThree.getHand());
    }

    if (e.getKeyCode() == KeyEvent.VK_4) {
        System.out.println(Deck.pile);
    }

    // Slap Keys
    if (TCGCP() == true){
        
        if (e.getKeyCode() == KeyEvent.VK_Q){

            if (playerOneHit < 1 && playerTwoHit >= 1 && playerThreeHit >= 1){
                takePile(playerOne, lblPlayerOneCards);
                cardOne = 0;
                cardTwo = 0;
                cardThree = 1;
            }
            else {
                playerOneHit ++;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_V){

            if (playerOneHit >= 1 && playerTwoHit < 1 && playerThreeHit >= 1){
                takePile(playerTwo, lblPlayerTwoCards);
                cardOne = 1;
                cardTwo = 0;
                cardThree = 0;
            }
            else {
                playerTwoHit ++;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_L){
            
            if (playerOneHit >= 1 && playerTwoHit >= 1 && playerThreeHit < 1){
                takePile(playerThree, lblPlayerThreeCards);
                cardOne = 0;
                cardTwo = 1;
                cardThree = 0;
            }
            else {
                playerThreeHit ++;
            }
        }
        if (Deck.getTopCard().cardName().equals("narwhal")){

            if (e.getKeyCode() == KeyEvent.VK_W){
                if (playerOneHit < 1 && playerTwoHit >= 1 && playerThreeHit >= 1){
                    takePile(playerOne, lblPlayerOneCards);
                    cardOne = 0;
                    cardTwo = 0;
                    cardThree = 1;
                }
                else {
                   playerOneHit ++;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_G){
                if (playerOneHit >= 1 && playerTwoHit < 1 && playerThreeHit >= 1){
                    takePile(playerTwo, lblPlayerTwoCards);
                    cardOne = 1;
                    cardTwo = 0;
                    cardThree = 0;
                }
                else {
                    playerTwoHit ++;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_O){
                if (playerOneHit >= 1 && playerTwoHit >= 1 && playerThreeHit < 1){
                    takePile(playerThree, lblPlayerThreeCards);
                    cardOne = 0;
                    cardTwo = 1;
                    cardThree = 0;
                }
                else {
                    playerThreeHit ++;
                }
            }
        }

        if (Deck.getTopCard().cardName().equals("gorilla")){

            if (e.getKeyCode() == KeyEvent.VK_W){
                if (playerOneHit < 2 && playerTwoHit >= 2 && playerThreeHit >= 2){
                    takePile(playerOne, lblPlayerOneCards);
                    cardOne = 0;
                    cardTwo = 0;
                    cardThree = 1;
                }
                else {
                   playerOneHit ++;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_G){
                if (playerOneHit >= 2 && playerTwoHit < 2 && playerThreeHit >= 2){
                    takePile(playerTwo, lblPlayerTwoCards);
                    cardOne = 1;
                    cardTwo = 0;
                    cardThree = 0;
                }
                else {
                    playerTwoHit ++;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_O){
                if (playerOneHit >= 2 && playerTwoHit >= 2 && playerThreeHit < 2){
                    takePile(playerThree, lblPlayerThreeCards);
                    cardOne = 0;
                    cardTwo = 1;
                    cardThree = 0;
                }
                else {
                    playerThreeHit ++;
                }
            }
        }
        
        if (Deck.getTopCard().cardName().equals("groundhog")){
            if (e.getKeyCode() == KeyEvent.VK_W){
                if (playerOneHit < 3 && playerTwoHit >= 3 && playerThreeHit >= 3){
                    takePile(playerOne, lblPlayerOneCards);
                    cardOne = 0;
                    cardTwo = 0;
                    cardThree = 1;
                }
                else {
                   playerOneHit ++;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_G){
                if (playerOneHit >= 3 && playerTwoHit < 3 && playerThreeHit >= 3){
                    takePile(playerTwo, lblPlayerTwoCards);
                    cardOne = 1;
                    cardTwo = 0;
                    cardThree = 0;
                }
                else {
                    playerTwoHit ++;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_O){
                if (playerOneHit >= 3 && playerTwoHit >= 3 && playerThreeHit < 3){
                    takePile(playerThree, lblPlayerThreeCards);
                    cardOne = 0;
                    cardTwo = 1;
                    cardThree = 0;
                }
                else {
                    playerThreeHit ++;
                }
            }
        }
    }
}

@Override
public void keyReleased(KeyEvent e) {

}

public String TacoCat(){
    
    if (tacoCat == 0){
        return "Taco";
    }
    else if (tacoCat == 1){
        return "Cat";
    }
    else if (tacoCat == 2){
        return "Goat";
    }
    else if (tacoCat == 3){
        return "Cheese";
    }
    else if (tacoCat == 4){
        return "Pizza";
    }
    return "";
}

public boolean checkFinished(ArrayList player){
    if (player.size() == 0){
        finished = true;
        return true;
    }
    return false;
}

public void takePile(Player player, ArrayList<JLabel> playerDeck){

    testCardLabel.setVisible(false);

    // Ensure player takes all cards from the pile
    player.takePile();

    if (player.getPlayerNumber() == 1){
        initialCardX = 30;
        initialCardY = 300;
    }
    else if (player.getPlayerNumber() == 2){
        initialCardX = 300;
        initialCardY = 550;
    }
    else if (player.getPlayerNumber() == 3){
        initialCardX = 575;
        initialCardY = 300;
    }

    for (JLabel cardLabel : playerDeck) {
        this.remove(cardLabel);
    }
    playerDeck.clear();

    for (int i = 0; i < player.getHand().getSize(); i++){

        playerDeck.add(new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardBack.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH))));
        playerDeck.get(i).setVisible(true);
    
        //Use setBounds to set the width/height of each card, and their positions
        playerDeck.get(i).setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);
    
        //add the JLabel to the JPanel so we can see it later
        this.add(playerDeck.get(i));
    
        //increment the x/y values of each card by some amount, this will make them appear "stacked" so users can see each one
        initialCardX +=  3;
        initialCardY -= 0.5;
    }

    this.revalidate();
    this.repaint();
    this.requestFocusInWindow();

    lblPlayerHandVal.setText("Player " + player.getPlayerNumber() +"'s Turn");
    tacoCat = -1;
    resetHits();
}



public boolean TCGCP(){
    if(!(Deck.getTopCard().cardName()).equals("")){
        if (TacoCat().equals(Deck.getTopCard().cardName()) || Deck.getTopCard().cardName().equals("narwhal") || Deck.getTopCard().cardName().equals("gorilla") || Deck.getTopCard().cardName().equals("groundhog")){
            return true;
        }
    }
    return false;
}

public void updateScreenText(String text) {
    lblPlayerHandVal.setText(text);
    lblPlayerHandVal.repaint();
    this.revalidate();
    this.requestFocusInWindow();
}

public void resetGame() {
    // Reset deck
    deck = new Deck(0);
    Deck.makeDefaultDeck();
    deck.shuffle();
    
    // Reset players
    playerOne = new Player(new Deck(1), 1);
    playerOne.drawCards();
    playerTwo = new Player(new Deck(2), 2);
    playerTwo.drawCards();
    playerThree = new Player(new Deck(3), 3);
    playerThree.drawCards();
    
    // Reset game state variables
    tacoCat = -1;
    finished = false;
    cardOne = 0;
    cardTwo = 0;
    cardThree = 1;
    
    // Reset hits
    resetHits();
    
    // Clear and reset the center card
    testCardLabel.setIcon(new ImageIcon(IMAGE_DIR + ""));
    testCardLabel.setVisible(false);
    
    // Clear all player card displays
    clearPlayerCards();
    
    // Reset player card displays
    setupPlayerCards();
    
    // Update UI
    lblPlayerHandVal.setText("Game Reset - Player 1's Turn");
    this.revalidate();
    this.repaint();
    this.requestFocusInWindow();
}

// Helper method to clear all player cards
private void clearPlayerCards() {
    for (JLabel label : lblPlayerOneCards) {
        this.remove(label);
    }
    for (JLabel label : lblPlayerTwoCards) {
        this.remove(label);
    }
    for (JLabel label : lblPlayerThreeCards) {
        this.remove(label);
    }
    
    lblPlayerOneCards.clear();
    lblPlayerTwoCards.clear();
    lblPlayerThreeCards.clear();
}

// Helper method to set up player cards
private void setupPlayerCards() {
    // Reset initial positions
    initialCardX = 30;
    initialCardY = 300;
    
    // Setup Player One cards
    for (int i = 0; i < 21; i++) {
        lblPlayerOneCards.add(new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardBack.png")
            .getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH))));
        lblPlayerOneCards.get(i).setVisible(true);
        lblPlayerOneCards.get(i).setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);
        this.add(lblPlayerOneCards.get(i));
        initialCardX += 3;
        initialCardY -= 0.5;
    }
    
    // Reset positions for Player Two
    initialCardX = 300;
    initialCardY = 550;
    
    // Setup Player Two cards
    for (int i = 0; i < 21; i++) {
        lblPlayerTwoCards.add(new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardBack.png")
            .getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH))));
        lblPlayerTwoCards.get(i).setVisible(true);
        lblPlayerTwoCards.get(i).setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);
        this.add(lblPlayerTwoCards.get(i));
        initialCardX += 3;
        initialCardY -= 0.5;
    }
    
    // Reset positions for Player Three
    initialCardX = 575;
    initialCardY = 300;
    
    // Setup Player Three cards 
    for (int i = 0; i < 22; i++) {
        lblPlayerThreeCards.add(new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardBack.png")
            .getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH))));
        lblPlayerThreeCards.get(i).setVisible(true);
        lblPlayerThreeCards.get(i).setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);
        this.add(lblPlayerThreeCards.get(i));
        initialCardX += 3;
        initialCardY -= 0.5;
    }
}

public void resetHits(){
    playerOneHit = 0;
    playerTwoHit = 0;
    playerThreeHit = 0;
}

}
