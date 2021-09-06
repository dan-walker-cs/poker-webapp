package com.dan_walker_cs.have_them_webapp.game.model;

import java.util.ArrayList;

public class Table {
    private ArrayList<Seat> seats;

    public Table() {
        this.seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public Seat getSeat(int seatID) {
        return seats.get(seatID);
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        this.seats.remove(seat);
    }

    public int getSize() {
        return seats.size();
    }
}
