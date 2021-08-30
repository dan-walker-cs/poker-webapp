package com.dan_walker_cs.have_them_webapp.game.model;

import java.util.ArrayList;

public class GameRules {
    private String numPlayers;
    private double smallBlind;
    private double bigBlind;
    private double actionTimerLength;
    private double minBuyIn;
    private double maxBuyIn;
    private String gameType;

    private static final int MIN_BUYIN_MULTIPLIER = 50;
    private static final int MAX_BUYIN_MULTIPLIER = 100;

    public GameRules() {
        this.numPlayers = "0";
        this.bigBlind = 0.10;
        this.actionTimerLength = 1.00;
        this.gameType = "holdem";
    }

    public GameRules(String numPlayers, double bigBlind, double actionTimerLength, String gameType) {
        this.numPlayers = numPlayers;
        this.bigBlind = bigBlind;
        this.actionTimerLength = actionTimerLength;
        this.gameType = gameType;
    }

    public ArrayList<String> validateRules() {
        ArrayList<String> errorList = new ArrayList<>();

        // Validate number of players
        try {
            int numPlayers_int = Integer.parseInt(numPlayers);
            if(numPlayers_int < 2 || numPlayers_int > 9)
                errorList.add("Number of players must be a number between 2 and 9.");
        } catch (Exception e) {
            e.printStackTrace();
            errorList.add("Number of players must be a number between 2 and 9.");
        }

        // Validate big blind
        if(bigBlind == -1)
            errorList.add("Please select an option for your blinds from the dropdown menu.");

        // Validate game mode
        if(gameType.equals("-1"))
            errorList.add("Please select an option for your game mode from the dropdown menu.");

        return errorList;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(String numPlayers) {
        this.numPlayers = numPlayers;
    }

    public double getSmallBlind() {
        return smallBlind;
    }

    private void setSmallBlind() {
        this.smallBlind = bigBlind / 2.0;
    }

    public double getBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(double bigBlind) {
        this.bigBlind = bigBlind;
        setSmallBlind();
        setMinBuyIn();
        setMaxBuyIn();
    }

    public double getActionTimerLength() {
        return actionTimerLength;
    }

    public void setActionTimerLength(double actionTimerLength) {
        this.actionTimerLength = actionTimerLength;
    }

    public double getMinBuyIn() {
        return minBuyIn;
    }

    public void setMinBuyIn() {
        this.minBuyIn = MIN_BUYIN_MULTIPLIER * bigBlind;
    }

    public double getMaxBuyIn() {
        return maxBuyIn;
    }

    public void setMaxBuyIn() {
        this.maxBuyIn = MAX_BUYIN_MULTIPLIER * bigBlind;
    }

    @Override
    public String toString() {
        return "GameRules{" +
                "numPlayers=" + numPlayers +
                ", smallBlind=" + smallBlind +
                ", bigBlind=" + bigBlind +
                ", actionTimerLength=" + actionTimerLength +
                ", minBuyIn=" + minBuyIn +
                ", maxBuyIn=" + maxBuyIn +
                ", gameType='" + gameType + '\'' +
                '}';
    }
}
