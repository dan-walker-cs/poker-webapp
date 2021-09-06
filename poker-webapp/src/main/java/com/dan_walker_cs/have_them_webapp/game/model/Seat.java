package com.dan_walker_cs.have_them_webapp.game.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Seat {
    Player player;
    int seatID;

    public Seat(Player player, int seatID) {
        this.player = player;
        this.seatID = seatID;
    }

    // Seat info
    public int getSeatID() {
        return seatID;
    }

    public Player getPlayer() {
        return player;
    }

    // Player info
    public String getName() {
        return player.getName();
    }

    public double getCashStack() {
        return player.getCashStack();
    }

    public boolean isActive() {
        return player.isActive();
    }

    public double getChipsInPlay() {
        return player.getChipsInPlay();
    }
}
