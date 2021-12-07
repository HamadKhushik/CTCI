package oopDesign.deckOfCards;

/*
 * Suit class to represent suits in a Deck of cards
 */
public enum Suit {

	CLUB(0), DIAMOND(1), HEARTS(2), SPADE(3);

	private int value;

	Suit(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	public Suit getSuit(int value) {
		return Suit.values()[value];
	}

}
