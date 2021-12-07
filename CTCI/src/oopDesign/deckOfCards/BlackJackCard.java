package oopDesign.deckOfCards;

/*
 * source : https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2007.%20Object-Oriented%20Design/Q7_01_Deck_of_Cards
 * 
 * Ace Card is a special card, its value can be 1 or 11. In BlackJack its value is evaluated as '11'
 */
public class BlackJackCard extends Card {

	public BlackJackCard(int v, Suit s) {
		super(v, s);
	}

	public int value() {

		if (isAce()) {
			return 1;
		} else if (isFaceCard()) {
			return 10;
		} else {
			return faceValue;
		}
	}

	public int minValue() {
		if (isAce()) { // min Value for an Ace
			return 1;
		} else {
			return faceValue;
		}
	}

	// if the card is an ace, return 11 - otherwise return faceValue
	public int maxValue() {
		if (isAce()) {
			return 11;
		} else {
			return value();
		}
	}

	public boolean isAce() {
		return faceValue == 1;
	}

	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}

}
