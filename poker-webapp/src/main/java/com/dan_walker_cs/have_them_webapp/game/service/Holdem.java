package com.dan_walker_cs.have_them_webapp.game.service;

import com.dan_walker_cs.have_them_webapp.game.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Holdem implements Runnable {
    GameRules gameRules;
    ArrayList<Player> players;
    Deck deck;

    Table table;
    int activePlayers;
    int dealerSeatID;
    int smallBlindSeatID;
    int bigBlindSeatID;

    /* At the websocket server, we will wait for connections until
        connectionCount == gameRules.getNumPlayers().
        Then we create a Holdem object and start the game.
        This will act as the main thread.

        At the end of each player's turn, update the GameState from the client side. */
    Holdem(GameRules gameRules, ArrayList<Player> players) {
        this.gameRules = gameRules;
        this.players = players;
        this.table = new Table();
        this.deck = new Deck();
        this.activePlayers = players.size();

        // This won't work for 2 players
        this.dealerSeatID = 0;
        this.smallBlindSeatID = 1;
        this.bigBlindSeatID = 2;

        setupTable();
    }

    void setupTable() {
        for(int i = 0; i < Integer.parseInt(gameRules.getNumPlayers()); i++) {
            table.addSeat(new Seat(players.get(i), table.getSize()));
        }
    }

    void updateGameState() {

    }

    @Override
    public void run() {
        while(true) {
            setBlinds();
            postBlinds();
            dealCards();
            preFlop();
            flop();
            turn();
            river();
            getWinningHand();
            checkActive();
        }
    }

    // Increments the seatID of the player responsible for blinds
    void setBlinds() {
        // wraps around if array index out of bounds
        if (bigBlindSeatID >= table.getSize()) {
            bigBlindSeatID = 0;

            smallBlindSeatID++;
            dealerSeatID++;
        } else if (smallBlindSeatID >= table.getSize()) {
            smallBlindSeatID = 0;

            dealerSeatID++;
            bigBlindSeatID++;
        } else if (dealerSeatID >= table.getSize()) {
            dealerSeatID = 0;

            bigBlindSeatID++;
            smallBlindSeatID++;
        }
    }

    // remove blind amounts from players' cash and set the chipInPlay
    void postBlinds(){
        double bigBlindAmount = gameRules.getBigBlind();
        double smallBlindAmount = gameRules.getSmallBlind();

        Player bigBlindPlayer = table.getSeat(bigBlindSeatID).getPlayer();
        Player smallBlindPlayer = table.getSeat(smallBlindSeatID).getPlayer();

        double bigBlindPlayerCash = bigBlindPlayer.getCashStack();
        double smallBlindPlayerCash = smallBlindPlayer.getCashStack();

        // case for player can't cover big blind
        if(bigBlindPlayerCash < bigBlindAmount) {
            bigBlindPlayer.setChipsInPlay(bigBlindPlayerCash);
            bigBlindPlayer.setCashStack(0);
        }

        // case for player can't cover small blind
        if(smallBlindPlayerCash < smallBlindAmount) {
            smallBlindPlayer.setChipsInPlay(smallBlindPlayerCash);
            smallBlindPlayer.setCashStack(0);
        }

        // default case
        bigBlindPlayer.setChipsInPlay(bigBlindAmount);
        bigBlindPlayer.setCashStack(bigBlindPlayerCash - bigBlindAmount);

        // default case
        smallBlindPlayer.setChipsInPlay(smallBlindAmount);
        smallBlindPlayer.setCashStack(smallBlindPlayerCash - smallBlindAmount);
    }

    // shuffle up and deal, nerds
    void dealCards(){
        // shuffle deck
        deck.shuffle();

        // first card
        for(int i = 0; i < table.getSize(); i++) {
            table.getSeat(i).getPlayer().addHand(deck.deal());
        }

        // second card
        for(int i = 0; i < table.getSize(); i++) {
            table.getSeat(i).getPlayer().addHand(deck.deal());
        }
    }

    void preFlop(){
        // default case
        int startingSeatID = bigBlindSeatID + 1;

        // case for wrapping around table
        if(startingSeatID >= table.getSize())
            startingSeatID = 0;

        while(activePlayers > 1) {
            // let players take turns
            // if (fold) activePlayers--; and player.isActive = false;
        }
    }
    void flop(){}
    void turn(){}
    void river(){}
    void getWinningHand(){}
    void checkActive(){}
}
