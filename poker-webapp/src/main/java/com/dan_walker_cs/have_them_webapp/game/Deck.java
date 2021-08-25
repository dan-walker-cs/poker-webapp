package com.dan_walker_cs.have_them_webapp.game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    // private Image deckGraphic;

    public Deck() {
        this.deck = new ArrayList<>();
        populateDeck();
    }

    private void populateDeck() {
        for (String suit : Card.validSuits) {
            for (String value : Card.validValues) {
                deck.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card deal() {
        return null;
    }

    public int getCurrentSize() {
        return deck.size();
    }

    public String toString() {
        return deck.toString();
    }
}
