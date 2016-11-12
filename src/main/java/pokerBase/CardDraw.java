package pokerBase;

import java.io.Serializable;

import pokerEnums.eCardCount;
import pokerEnums.eCardDestination;
import pokerEnums.eCardVisibility;


public class CardDraw implements Serializable {

	private eCardCount CardCount;
	private eCardDestination CardDestination;
	private eCardVisibility CardVisibility;
	public CardDraw(eCardCount cardCount, eCardDestination cardDestination, eCardVisibility cardVisiblity) {
		super();
		CardCount = cardCount;
		CardDestination = cardDestination;
		CardVisibility = CardVisibility;
	}
	public eCardCount getCardCount() {
		return CardCount;
	}
	public eCardDestination getCardDestination() {
		return CardDestination;
	}
	public eCardVisibility getCardVisibility() {
		return CardVisibility;
	}
	
	
}
