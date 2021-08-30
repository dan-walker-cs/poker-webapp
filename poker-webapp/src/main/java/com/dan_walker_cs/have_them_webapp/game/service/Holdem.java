package com.dan_walker_cs.have_them_webapp.game.service;

import com.dan_walker_cs.have_them_webapp.game.model.GameRules;
import com.dan_walker_cs.have_them_webapp.game.model.Player;
import com.dan_walker_cs.have_them_webapp.game.model.Table;

import java.util.ArrayList;


public class Holdem implements Runnable {
    ArrayList<Player> players;
    GameRules gameRules;
    Table table;

    Holdem(ArrayList<Player> players, GameRules gameRules) {
        this.players = players;
        this.gameRules = gameRules;
        this.table = new Table();
    }

    // sit the players down at the table
    void setupTable() {
        for(int i = 0; i < Integer.parseInt(gameRules.getNumPlayers()); i++) {
            table.addPlayer(players.get(i), i);
        }
    }

    void setupPlayers() {

    }

    @Override
    public void run() {
        while(true) {
            postBlinds();
            //dealCards();
            //preflop();
            //flop();
            //turn();
            //river();
            //getWinningHand();
        }
    }

    void postBlinds() {

    }
}
