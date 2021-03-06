package com.dan_walker_cs.have_them_webapp.game.model;

public class Card {
    private String value;
    private String suit;
    //private Image image;
    public static final String[] validSuits = {"clubs","diamonds","hearts","spades"};
    public static final String[] validValues ={"2","3","4","5","6","7","8","9","10","j","q","k","a"};

    public Card(String value, String suit) {
        setValue(value);
        setSuit(suit);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String toString() {
        return value + " of " + suit;
    }
}
