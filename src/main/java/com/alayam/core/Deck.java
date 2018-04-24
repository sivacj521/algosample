package com.alayam.core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Suits {
	SPADES,
	HEARTS,
	DIAMONDS,
	CLUBS
}

enum Ranks {
	ACE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING
}

class Card {

}

class RegularCard extends Card{
	private Suits suit;
	private Ranks rank;

	public RegularCard(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "RegularCard{" +
				"suit=" + suit +
				", rank=" + rank +
				'}';
	}
}

class Joker extends Card {
	@Override
	public String toString() {
		return "Joker{" +
				"name='" + name + '\'' +
				'}';
	}

	private String name = "JOKER";
}

public class Deck {

	private List <Card> cards = new ArrayList<>();

	void initDeck() {
		for(Suits s : Suits.values()) {
			for(Ranks r: Ranks.values()) {
				cards.add(new RegularCard(s,r));
			}
		}
		cards.add(new Joker());
		cards.add(new Joker());
	}

	void display() {
		cards.stream().forEach(System.out::println);
	}

	private void shuffle() {
		Collections.shuffle(cards);
	}

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.initDeck();
		deck.shuffle();
		deck.display();
	}


}
