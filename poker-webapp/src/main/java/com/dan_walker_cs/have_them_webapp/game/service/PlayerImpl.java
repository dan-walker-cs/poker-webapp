package com.dan_walker_cs.have_them_webapp.game.service;

import com.dan_walker_cs.have_them_webapp.game.model.Player;

public class PlayerImpl implements Runnable {

    Player player;

    PlayerImpl(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        chooseAction();
        fold();
        check();
        bet();
        raise();
    }

    void chooseAction() {}
    void fold(){}
    void check(){}
    void bet(){}
    void raise(){}
}
