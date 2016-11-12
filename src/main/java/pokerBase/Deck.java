package pokerBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.DeckException;
import pokerEnums.eDeckExceptionType;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

/**
 * 
 * @author Bert.Gibbons
 *
 */
public class Deck implements Serializable  {

	/**
	 * 
	 */
	private ArrayList<Card> deckCards = new ArrayList<Card>();

	/**
	 * No arg constructor for deck, will return shuffled deck of 52 cards
	 */
	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if ((eRank != eRank.JOKER) && (eSuit != eSuit.JOKER))
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
			}
		}
		Collections.shuffle(deckCards);
	}

	public Deck(int iNbrOfJokers) {
		this();

		for (int i = 0; i < iNbrOfJokers; i++) {
			deckCards.add(new Card(eSuit.JOKER, eRank.JOKER, 53));
		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers, ArrayList<Card> wilds) {
		this(NbrOfJokers);

		for (Card c : deckCards) {
			for (Card Wild : wilds) {
				if ((c.geteRank() == Wild.geteRank()) && (c.geteSuit() == Wild.geteSuit())) {
					c.setWild(true);
				}
			}

		}

		// Work to do! Make the existing Deck cards Wild...

	}

	 Deck(eSuit suit) {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if ((eRank != eRank.JOKER) && (eSuit != eSuit.JOKER))
					if (suit == eSuit) {
						deckCards.add(new Card(eSuit, eRank, iCardNbr));
					}
				iCardNbr++;
			}
		}
		Collections.shuffle(deckCards);
	}

	ArrayList<Card> getDeckCards() {
		return deckCards;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pokerBase.iDeck#Draw()
	 */
	public Card Draw() throws DeckException {
		if (deckCards.size() == 0) {
			throw new DeckException(this, eDeckExceptionType.OverDraw);
		}
		return deckCards.remove(0);
	}

	/**
	 * Returns the number of cards left in the deck
	 * 
	 * @return
	 */
	private int GetDeckSize() {
		return deckCards.size();
	}
}
