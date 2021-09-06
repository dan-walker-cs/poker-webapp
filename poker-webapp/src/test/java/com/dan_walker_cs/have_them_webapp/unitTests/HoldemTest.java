package com.dan_walker_cs.have_them_webapp.unitTests;

import com.dan_walker_cs.have_them_webapp.game.model.Deck;
import com.dan_walker_cs.have_them_webapp.game.model.GameRules;
import com.dan_walker_cs.have_them_webapp.game.model.Player;
import com.dan_walker_cs.have_them_webapp.game.model.Table;
import com.dan_walker_cs.have_them_webapp.game.service.Holdem;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@TestInstance(Lifecycle.PER_CLASS)
public class HoldemTest {

    // test deck for manipulating, control deck to maintain default state
    Deck deck;
    GameRules gameRules;
    Table table;
    ArrayList<Player> players;
    Holdem myGame;
    Player dan;
    Player sam;
    Player michael;
    Player nanz;

    Logger logger = LoggerFactory.getLogger(HoldemTest.class);

    @BeforeAll
    void setup() {
        deck = new Deck();
        gameRules = new GameRules("3", 1.00, 1.00, "holdem");
        table = new Table();
        players = new ArrayList<>();


        logger.info("-----New Testing Session-----");
    }

    @BeforeEach
    void init() {

    }

    @AfterAll
    void tearDown() {

    }
}
