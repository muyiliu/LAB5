package pokerEnums;



public enum eDeckExceptionType {

	OverDraw {
		@Override
		public String toString() {
			return "Deck is empty,  you can't draw another card";
		}
	}
}
