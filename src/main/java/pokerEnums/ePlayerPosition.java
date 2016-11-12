package pokerEnums;


public enum ePlayerPosition {
	ONE(1),TWO(2),THREE(3),FOUR(4);
	
	private int iPlayerPosition;

	private ePlayerPosition(int iPlayerPosition) {
		this.iPlayerPosition = iPlayerPosition;
	}

	public int getiPlayerPosition() {
		return iPlayerPosition;
	}
}
