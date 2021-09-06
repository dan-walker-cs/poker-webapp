package com.dan_walker_cs.have_them_webapp.game.model;

import java.util.ArrayList;

public class Player {
    private String id;
    private String name;
    private double cashStack;
    private ArrayList<Card> hand;
    private boolean isActive;
    private Seat seat;
    private double chipsInPlay;

    public Player(String id, String name, double cashStack, ArrayList<Card> hand, boolean isActive) {
        this.id = id;
        this.name = name;
        this.cashStack = cashStack;
        this.hand = hand;
        this.isActive = isActive;
        this.seat = null;
        this.chipsInPlay = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCashStack() {
        return cashStack;
    }

    public void setCashStack(double cashStack) {
        this.cashStack = cashStack;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addHand(Card card) {
        this.hand.add(card);
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getChipsInPlay() {
        return chipsInPlay;
    }

    public void setChipsInPlay(double chipsInPlay) {
        this.chipsInPlay = chipsInPlay;
    }
}