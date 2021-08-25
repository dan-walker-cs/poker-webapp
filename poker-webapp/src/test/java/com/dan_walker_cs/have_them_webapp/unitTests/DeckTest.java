package com.dan_walker_cs.have_them_webapp.unitTests;

import com.dan_walker_cs.have_them_webapp.game.Deck;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeckTest {

    Deck testDeck;
    Logger logger = LoggerFactory.getLogger(DeckTest.class);

    @BeforeAll
    static void setup() {

    }

    @BeforeEach
    void init() {
        testDeck = new Deck();
    }

    @Test
    @DisplayName("check that the deck populates with all correct cards")
    void populateDeckTest() {
        logger.info("testDeck size: " + testDeck.getCurrentSize());
        logger.info("testDeck: " + testDeck.toString());
    }

    @AfterAll
    static void tearDown() {

    }
}
