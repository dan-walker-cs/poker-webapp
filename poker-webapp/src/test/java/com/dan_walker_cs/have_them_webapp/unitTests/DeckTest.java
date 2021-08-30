package com.dan_walker_cs.have_them_webapp.unitTests;

import com.dan_walker_cs.have_them_webapp.game.model.Card;
import com.dan_walker_cs.have_them_webapp.game.model.Deck;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;

@TestInstance(Lifecycle.PER_CLASS)
public class DeckTest {

    // test deck for manipulating, control deck to maintain default state
    Deck testDeck, controlDeck;
    Logger logger = LoggerFactory.getLogger(DeckTest.class);

    @BeforeAll
    void setup() {
        controlDeck = new Deck();
        logger.info("-----New Testing Session-----");
    }

    @BeforeEach
    void init() {
        testDeck = new Deck();
    }

    @Test
    @DisplayName("deck populates with all correct cards")
    void populateDeckTest() {
        logger.info("-----populateDeckTest-----");
        logger.info("testDeck size: " + testDeck.getCurrentSize());
        logger.info("testDeck: " + testDeck.toString());

        Assertions.assertEquals(52, testDeck.getCurrentSize());
    }

    @Test
    @DisplayName("a shuffled deck isn't the same as the default deck")
    void shuffleTest() {
        logger.info("-----shuffleTest-----");
        testDeck.shuffle();

        logger.info("shuffled deck: " + testDeck.toString());
        logger.info("testDeck size after shuffle: " + testDeck.getCurrentSize());

        Assertions.assertNotEquals(controlDeck, testDeck);
    }

    @Test
    @DisplayName("single card dealt and reflected in deck size")
    void dealOnceTest() {
        Card testCard = testDeck.deal();
        logger.info("-----dealOnceTest-----");
        logger.info("card dealt: " + testCard.toString());
        logger.info("deck size: " + testDeck.getCurrentSize());

        Assertions.assertAll(
                () -> Assertions.assertEquals("2 of clubs", testCard.toString()),
                () -> Assertions.assertEquals(51, testDeck.getCurrentSize())
        );
    }

    @Test
    @DisplayName("all cards dealt and reflected in deck size")
    void dealAllTest() {
        ArrayList<Card> testCards = new ArrayList<>();
        Card currentCard = null;
        logger.info("-----dealAllTest-----");

        while(testDeck.getCurrentSize() > 0) {
            currentCard = testDeck.deal();
            logger.info("card dealt: " + currentCard.toString());
            logger.info("deck size: " + testDeck.getCurrentSize());
            testCards.add(currentCard);
        }

        Assertions.assertAll(
                () -> Assertions.assertEquals(0, testDeck.getCurrentSize()),
                () -> Assertions.assertEquals(testCards, testCards)
        );
    }

    @Test
    @DisplayName("running out of cards")
    void dealTooManyTest() {
        logger.info("-----dealTooManyTest-----");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            while(true) {
                testDeck.deal();
            }
        });
    }

    @AfterAll
    static void tearDown() {

    }
}
