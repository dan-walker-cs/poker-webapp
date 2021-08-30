package com.dan_walker_cs.have_them_webapp.game.model;

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
                deck.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card deal() throws IndexOutOfBoundsException {
        Card dealt = null;

        dealt = deck.get(0);
        deck.remove(0);

        return dealt;
    }

    public int getCurrentSize() {
        return deck.size();
    }

    public String toString() {
        return deck.toString();
    }
}
