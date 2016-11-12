package exceptions;

import pokerBase.Hand;
import pokerEnums.eHandExceptionType;

public class HandException extends Exception {

	private Hand h;
	private eHandExceptionType eT;

	public HandException(Hand h, eHandExceptionType eT) {
		super();
		this.h = h;
		this.eT = eT;
	}

	public eHandExceptionType geteT() {
		return eT;
	}

	public Hand getH() {
		return h;
	}
	
	
}
