package oopDesign.deckOfCards;

/*
 * Card class is an abstract class to represent cards in the deck of cards
 * it is abstract because cards can be any cards as in UNO cards, Monopoly cards
 * or standard 52 cards
 */

public abstract class Card {

	private boolean isAvailable = true;
	protected int faceValue; // facevalue of the card, 2-10 and 11-13
	protected Suit suit;

	// constructor
	public Card(int v, Suit s) {

		faceValue = v;
		suit = s;
	}

	public abstract int value();

	public boolean isAvailable() {
		return isAvailable;
	}

	public void makeUnAvailable() {
		this.isAvailable = false;
	}

	public void makeAvailable() {
		this.isAvailable = true;
	}

}
