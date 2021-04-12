package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Deck deck = new Deck();
	    Poker poker = new Poker();
        List<Card> hand = new ArrayList<>();

        hand.add(deck.getCard(2));
        hand.add(deck.getCard(3));
        hand.add(deck.getCard(4));
        hand.add(deck.getCard(5));
        hand.add(deck.getCard(6));

        for (Card card : hand) {
            System.out.println(hand.toString());
        }

    }
}
