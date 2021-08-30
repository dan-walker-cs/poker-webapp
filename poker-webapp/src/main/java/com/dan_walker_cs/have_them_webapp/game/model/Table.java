package com.dan_walker_cs.have_them_webapp.game.model;

public class Table {
    private Player[] seats;

    public Table() {
        this.seats = new Player[9];
    }

    public void addPlayer(Player player, int seatNum) {
        seats[seatNum] = player;
    }

    public void removePlayer(Player player) {
        seats[player.getSeatNum()] = null;
    }

    public Player[] getSeats() {
        return seats;
    }
}
