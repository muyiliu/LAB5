package pokerEnums;

import java.util.HashMap;
import java.util.Map;

public enum eDrawCount {

	NONE(0), FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGHTH(8), NINTH(9), TENTH(10);
	
	private eDrawCount(final int DrawNo){
		this.DrawNo = DrawNo;
	}

	private int DrawNo;
	
	public int getDrawNo(){
		return DrawNo;
	}
	
	private static Map<Integer, eDrawCount> map = new HashMap<Integer, eDrawCount>();

	static {
		for (eDrawCount eDrawCount : eDrawCount.values()) {
			map.put(eDrawCount.DrawNo, eDrawCount);
		}
	}

	public static eDrawCount geteDrawCount(int DrawNo) {
		return map.get(DrawNo);
	}
}
