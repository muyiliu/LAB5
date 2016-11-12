package pokerBase;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eRank;
import pokerEnums.eSuit;
import exceptions.DeckException;

public class Deck_Test {

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

	@Test (expected = DeckException.class)
	public void DeckOverWithdrawTest() throws DeckException{
		Deck deck = new Deck();
		for (int i=0; i < 54; i++){
			deck.Draw();
		}
	}
	
	@Test 
	public void DeckOverWithdrawAndCatchTest(){
		Deck deck = new Deck();
		for (int i=0; i < 54; i++){
			try {
				deck.Draw();
			} catch (DeckException e) {
				System.out.println(e.getD()); 
			}
		}
		
	}
	
	@Test //We check this method by looking at the cards in the deck one by one.
	public void DeckGetDeckCards(){
		Deck deck = new Deck();
		Collections.sort(deck.getDeckCards());
		System.out.println(deck.getDeckCards());
	}

	
	@Test 
	/**Check the constructor that takes in jokers. Again, print out the deck and check it 
	one by one
	**/
	public void DeckWithJoker(){
		Deck deck2 = new Deck(2);
		Collections.sort(deck2.getDeckCards());
		System.out.println(deck2.getDeckCards());
	}
	

}