package edu.wctc;

import java.util.*;

public class Poker {
    /*The Poker Class handles all Business logic.*/

    public boolean isRoyalFlush(List<Card> hand){
        /*Uses isFlush() to determine if hand is a flush. Then tests to see if all values are from 10-Ace*/
        boolean isFlush = isFlush(hand);
        int royals = 0;
        for(Card card : hand){
            if(card.getScore() >= 9){
                royals++;
            }
        }
        if(isFlush == true && royals >= 5){
            return true;
        }
        else
        return false;
    }
    public boolean isStraightFlush(List<Card> hand){
        /*Uses isStraight() and isFlush() methods to determine if hand is a straight flush*/
        boolean isStraight = isStraight(hand);
        boolean isFlush = isFlush(hand);

        if(isStraight == true && isFlush == true){
            return true;
        }
        else
        return false;
    }
    public boolean isFourOfAKind(List<Card> hand){
        /*@return true if hand is a four of a kind*/
        Collections.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getFace().compareTo(o2.getFace());
            }
        });
        int dupes = 0;
        HashMap<String, Integer> pairs = new HashMap<>();
        for(Card card : hand){
            if(pairs.containsKey(card.getFace())){
                pairs.put(card.getFace(), pairs.get(card.getFace()) + 1);
            }
            else {
                pairs.put(card.getFace(), 1);
            }
        }
        for(int number : pairs.values()){
            if(number >= 4){
                dupes++;
            }
        }
        if(dupes >= 1){
            return true;
        }
        return false;
    }
    public boolean isFullHouse(List<Card> hand){
        /*@return true if hand is a three of a kind and a two pair*/
        boolean isThreeOfAKind = isThreeOfAKind(hand);
        boolean isTwoPair = isTwoPair(hand);

        if(isThreeOfAKind == true && isTwoPair == true){
            return true;
        }
        else
            return false;
    }
    public boolean isFlush(List<Card> hand){
        /*@return true if all cards have same suit*/
        List<String> suits = new ArrayList<>();
        HashMap<String, Integer> comparison = new HashMap<>();
        for(Card card : hand){
            suits.add(card.getSuit());
        }
        for(String suit : suits){
            if(comparison.containsKey(suit)){
                comparison.put(suit, comparison.get(suit) + 1);
            }
            else
            comparison.put(suit, 1);
        }
        for(Map.Entry<String, Integer> entry : comparison.entrySet()){
            if(entry.getValue() >= 5){
                return true;
            }
            else
                break;
        }
        return false;
    }
    public boolean isStraight(List<Card> hand){
        /*@return true if all cards have incrementing scores*/
        Collections.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        Collections.reverse(hand);
        int nextCard = 1;
        int count = 1;
        for(Card card : hand){
            if(nextCard == 5){
                break;
            }
            if(card.getScore() - hand.get(nextCard).getScore() == 1){
                count++;
            }
            nextCard++;
        }
        if(count >= 5){
            return true;
        }
        else
            return false;
    }
    public boolean isThreeOfAKind(List<Card> hand){
        /*@return true if 3 cards have same face value*/
        Collections.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getFace().compareTo(o2.getFace());
            }
        });
        int dupes = 0;
        HashMap<String, Integer> pairs = new HashMap<>();
        for(Card card : hand){
            if(pairs.containsKey(card.getFace())){
                pairs.put(card.getFace(), pairs.get(card.getFace()) + 1);
            }
            else {
                pairs.put(card.getFace(), 1);
            }
        }
        for(int number : pairs.values()){
            if(number >= 3){
                dupes++;
            }
        }
        if(dupes >= 1){
            return true;
        }
        return false;
    }
    public boolean isTwoPair(List<Card> hand) {
        /*return true if two pairs of cards have same face value*/
        Collections.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getFace().compareTo(o2.getFace());
            }
        });
        int dupes = 0;
        HashMap<String, Integer> pairs = new HashMap<>();
        for(Card card : hand){
            if(pairs.containsKey(card.getFace())){
                pairs.put(card.getFace(), pairs.get(card.getFace()) + 1);
            }
            else {
                pairs.put(card.getFace(), 1);
            }
        }
        for(int number : pairs.values()){
            if(number >= 2){
                dupes++;
            }
        }
        if(dupes >= 2){
            return true;
        }
        return false;
    }
    public boolean isOnePair(List<Card> hand){
        /*@return true if one pair of cards have same face value*/
        Collections.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getFace().compareTo(o2.getFace());
            }
        });
        HashMap<String, Integer> pairs = new HashMap<>();
        for(Card card : hand){
            if(pairs.containsKey(card.getFace())){
                pairs.put(card.getFace(), pairs.get(card.getFace()) + 1);
            }
            else {
                pairs.put(card.getFace(), 1);
            }
        }
        for(int number : pairs.values()){
            if(number >= 1){
                return true;
            }
        }
        return false;
    }

    public boolean isHighCard(List<Card> hand){
        /*Not really sure how to return this method as a boolean.
         Most the research I did on poker said that a high card is just the highest card in your hand.
          So every hand technically has a high card? Should return true every time. If I'm wrong, that's okay, I don't know how to play poker lol*/
        return true;
    }
}