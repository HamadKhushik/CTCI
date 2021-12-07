package oopDesign.deckOfCards;

import java.util.ArrayList;

/*
 * BlackJack Hand class to represent a BlackJack Hand. It extends the Hand class
 */
public class BlackJackHand extends Hand<BlackJackCard> {

	public int score() {
		ArrayList<Integer> scores = possibleScores();

		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;

		for (int score : scores) {

			if (score < 21 && score < minOver) {
				score = maxUnder;
			} else if (score > 21 && score < maxUnder) {
				score = minOver;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}

	public ArrayList<Integer> possibleScores() {

		ArrayList<Integer> scores = new ArrayList<Integer>();

		if (cards.size() == 0) {
			scores.add(0);
		}

		for (BlackJackCard card : cards) {
			addCardToScoreList(card, scores);
		}

		return scores;
	}

	public void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {

		if (scores.size() == 0) {
			scores.add(0);
		}

		int length = scores.size();

		for (int i = 0; i < length; i++) {
			int score = scores.get(i);
			scores.set(i, score + card.minValue());

			if (card.minValue() != card.maxValue()) {
				scores.add(score + card.maxValue());
			}
		}
	}

	public boolean busted() {
		return score() > 21;
	}

	public boolean is21() {
		return score() == 21;
	}

	public boolean isBlackJack() {
		if (cards.size() != 2) {
			return false;
		}

		BlackJackCard first = cards.get(0);
		BlackJackCard second = cards.get(1);

		return (first.isAce() && second.isFaceCard()) || (first.isFaceCard() && second.isAce());
	}
}
