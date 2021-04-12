package edu.wctc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {

    @Test
    void isRoyalFlush() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("Jack","Heart",13));
        hand.add(new Card("Queen","Heart",12));
        hand.add(new Card("King", "Heart", 11));
        hand.add(new Card("Ace", "Heart", 10));
        hand.add(new Card("Ten", "Heart", 9));
        assertTrue(poker.isRoyalFlush(hand));
    }

    @Test
    void isStraightFlush() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("Five","Heart",4));
        hand.add(new Card("Six","Heart",5));
        hand.add(new Card("Seven", "Heart", 6));
        hand.add(new Card("Eight", "Heart", 7));
        hand.add(new Card("Nine", "Heart", 8));
        assertTrue(poker.isStraightFlush(hand));
    }

    @Test
    void isFourOfAKind() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("King","Heart",12));
        hand.add(new Card("King","Diamond",12));
        hand.add(new Card("King", "Clubs", 4));
        hand.add(new Card("King", "Spades", 4));
        assertTrue(poker.isFourOfAKind(hand));
    }

    @Test
    void isFullHouse() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("Three","Heart",4));
        hand.add(new Card("Three","Diamond",5));
        hand.add(new Card("Three", "Clubs", 6));
        hand.add(new Card("Ten", "Spades", 7));
        hand.add(new Card("Ten", "Heart", 8));
        assertTrue(poker.isFullHouse(hand));
    }

    @Test
    void isFlush() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("Five","Heart",4));
        hand.add(new Card("Six","Heart",5));
        hand.add(new Card("Seven", "Heart", 6));
        hand.add(new Card("Eight", "Heart", 7));
        hand.add(new Card("Nine", "Heart", 8));
        assertTrue(poker.isFlush(hand));
    }

    @Test
    void isStraight() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("Five","Heart",4));
        hand.add(new Card("Six","Diamond",5));
        hand.add(new Card("Seven", "Clubs", 6));
        hand.add(new Card("Eight", "Heart", 7));
        hand.add(new Card("Nine", "Heart", 8));
        assertTrue(poker.isStraight(hand));
    }

    @Test
    void isThreeOfAKind() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("King","Heart",12));
        hand.add(new Card("King","Diamond",12));
        hand.add(new Card("King", "Clubs", 4));
        hand.add(new Card("Five", "Heart", 4));
        assertTrue(poker.isThreeOfAKind(hand));
    }

    @Test
    void isTwoPair() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("King","Heart",12));
        hand.add(new Card("King","Diamond",12));
        hand.add(new Card("Five", "Diamond", 4));
        hand.add(new Card("Five", "Heart", 4));
        assertTrue(poker.isTwoPair(hand));
    }

    @Test
    void isOnePair() {
        Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("King","Heart",12));
        hand.add(new Card("King","Diamond",12));
        assertTrue(poker.isOnePair(hand));
    }
}