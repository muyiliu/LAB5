package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		

	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestRodyalFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE.getiRankNbr());
		
	}
	
	@Test
	public void TestStraightFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test //FiveOfAKind has at least one joker or wild
	public void TestFiveOfAkindWild() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		
		Card c = new Card(eSuit.DIAMONDS,eRank.EIGHT,1);
		c.setWild(true);
		
		h.AddToCardsInHand(c);
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN.getiRankNbr());
	}
	
	@Test
	public void TestFourOfAKind() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN.getiRankNbr());
	}
	
	@Test
	public void TestFourOfAKind2() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE.getiRankNbr());
	}
	
	@Test
	public void TestFullHouse1() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == eRank.TWO.getiRankNbr());
	}
	
	@Test
	public void TestFullHouse2() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TWO.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == eRank.TEN.getiRankNbr());
	}
	
	@Test
	public void TestFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE.getiRankNbr());
	}
	
	@Test
	public void TestStraight1() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.SIX,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.SIX.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == 0);
	}
	
	@Test
	public void TestStraight2() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.FIVE.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == 0);
	}
	
	@Test
	public void TestStraight3() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.SIX,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertFalse(h.getHandScore().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == 0);
	}
	
	@Test
	public void ThreeOfAKind1() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TWO.getiRankNbr());
	}

	@Test
	public void ThreeOfAKind2() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.THREE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.THREE.getiRankNbr());
	}	
	
	@Test
	public void ThreeOfAKind3() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.FOUR.getiRankNbr());
	}	
	
	@Test
	public void TwoPair1() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == eRank.THREE.getiRankNbr());
	}
	
	@Test
	public void TwoPair2() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.SIX,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == eRank.THREE.getiRankNbr());
	}
	
	@Test
	public void TwoPair3() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == eRank.THREE.getiRankNbr());
	}
	
	@Test
	public void Pair1() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == 0);
	}
		
	@Test
	public void Pair2() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == 0);
	}
	
	@Test
	public void Pair3() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.JACK.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == 0);
	}
	
	@Test
	public void Pair4() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.TWO.getiRankNbr());
		assertTrue(h.getHandScore().getLoHand() == 0);
	}
	
	@Test
	public void HighCard() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHandScore().getHiHand() == eRank.KING.getiRankNbr());
	}
}