package com.dan_walker_cs.have_them_webapp.game.model;

import java.util.ArrayList;

public class Player {
    private double cashStack;
    private ArrayList<Card> hand;
    private int seatNum;
    private boolean isActive;

    public Player(double cashStack, ArrayList<Card> hand, int seatNum) {
        this.cashStack = cashStack;
        this.hand = hand;
        this.seatNum = seatNum;
        // not active until bought in
        this.isActive = false;
    }

    public void addToCashStack(double amount) {
        this.cashStack = cashStack + amount;
    }

    public void removeFromCashStack(double amount) {
        this.cashStack = cashStack - amount;
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

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
