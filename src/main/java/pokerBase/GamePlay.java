package pokerBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

import pokerEnums.eDrawCount;

public class GamePlay implements Serializable   {

	private UUID GameID;
	//private UUID PlayerID_NextToAct = null;
	private HashMap<UUID, Player> hmGamePlayers = new HashMap<UUID, Player>();
	private ArrayList<GamePlayPlayerHand> GamePlayerHand = new ArrayList<GamePlayPlayerHand>();
	
	private HashMap<UUID, Hand> hmPlayerHand = new HashMap<UUID, Hand>();
	
	private Hand GameCommonHand = new Hand();
	private Rule rle;
	private Deck GameDeck = null;
	private UUID GameDealer = null;
	private int[] iActOrder = null;
	private Player PlayerNextToAct = null;
	private eDrawCount eDrawCountLast;
	
	public GamePlay(Rule rle, UUID GameDealerID)
	{
		this.setGameID(UUID.randomUUID());
		this.setGameDealer(GameDealer);
		this.rle = rle;
	}
	
	public static void StateOfGamePlay(GamePlay g)
	{
		System.out.println("----------------------");
		System.out.println("Game : " + g.getGameID());
		
		System.out.println("Table Nbr of Players: " + g.getGamePlayers().size());
		Iterator it = g.getGamePlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player)pair.getValue();
			
			System.out.println("Player ID: " + p.getPlayerID().toString());
			System.out.println("Player Position: " + p.getiPlayerPosition());
			System.out.println("Player Name: " + p.getPlayerName());
			System.out.println("----------------------");
			
			Hand h = g.getPlayerHand(p);
			System.out.println("Hand: " + h);
			
			for (Card c: h.getCardsInHand())
			{
				System.out.println("Card : " + c.geteRank() + c.getiCardNbr());
			}
			System.out.println("----------------------");
			
			
		}
		
		System.out.println("----------------------");
		System.out.println(" ");
	}
	
	
	
	


	public UUID getGameID() {
		return GameID;
	}

	public void setGameID(UUID gameID) {
		GameID = gameID;
	}

	public Rule getRule()
	{
		return this.rle;
	}
	
	public HashMap<UUID, Player> getGamePlayers() {
		return hmGamePlayers;
	}

	public void setGamePlayers(HashMap<UUID, Player> gamePlayers) {
		this.hmGamePlayers = new HashMap<UUID, Player>(gamePlayers);
		
		Iterator it = getGamePlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player) pair.getValue();			
			addPlayerHandToGame(p);
		}
			
			
	}
	
	public void addPlayerToGame(Player p)
	{
		this.hmGamePlayers.put(p.getPlayerID(),p);
	}
	public Player getGamePlayer(UUID PlayerID)
	{
		return (Player) this.hmGamePlayers.get(PlayerID);
	}
	
	public void addPlayerHandToGame(Player p)
	{
		Hand h = new Hand();
		this.hmPlayerHand.put(p.getPlayerID(), h);
	}
	
	public Hand getPlayerHand(Player p)
	{
		return (Hand) this.hmPlayerHand.get(p.getPlayerID());
	}
	
	

	public Deck getGameDeck() {
		return GameDeck;
	}

	public void setGameDeck(Deck gameDeck) {
		GameDeck = gameDeck;
	}
	
	public UUID getGameDealer() {
		return GameDealer;
	}

	private void setGameDealer(UUID gameDealer) {
		GameDealer = gameDealer;
	}


	public int[] getiActOrder() {
		return iActOrder;
	}

	public void setiActOrder(int[] iActOrder) {
		this.iActOrder = iActOrder;
	}

	
	public Player getPlayerNextToAct() {
		return PlayerNextToAct;
	}

	public void setPlayerNextToAct(Player playerNextToAct) {
		PlayerNextToAct = playerNextToAct;
	}

	public eDrawCount geteDrawCountLast() {
		return eDrawCountLast;
	}

	public void seteDrawCountLast(eDrawCount eDrawCountLast) {
		this.eDrawCountLast = eDrawCountLast;
	}

	public static int[] GetOrder(int iStartPosition) {
		int[] iPos = null;
		switch (iStartPosition) {
		case 1:
			int[] iPositions1 = new int[] { 2, 3, 4, 1 };
			iPos = iPositions1;
			break;
		case 2:
			int[] iPositions2 = new int[] { 3, 4, 1, 2 };
			iPos = iPositions2;
			break;
		case 3:
			int[] iPositions3 = new int[] { 4, 1, 2, 3 };
			iPos = iPositions3;
			break;
		case 4:
			int[] iPositions4 = new int[] { 1, 2, 3, 4 };
			iPos = iPositions4;
			break;
		}
		return iPos;
	}

	public static int NextPosition(int iCurrentPosition, int[] iOrder) {
		int iNextPosition = -1;
		try {
			for (int i : iOrder) {
				if (iCurrentPosition == i) {
					iNextPosition = iOrder[i + 1];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// Whoops! Asking for something beyond the size of the array
			iNextPosition = iOrder[0];
		}

		return iNextPosition;
	}
	
	public Player getPlayerByPosition(int iPlayerPosition)
	{
		Player pl = null;
		
		Iterator it = getGamePlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player)pair.getValue();
			if (p.getiPlayerPosition() == iPlayerPosition)
				pl = p;
		}
		
		return pl;
	}
	/*
	public GamePlayPlayerHand FindCommonHand(GamePlay gme)
	{
		GamePlayPlayerHand GPCH = null;
		for (GamePlayPlayerHand GPPH: GameCommonHand)
		{
			if (GPPH.getGame().getGameID() == gme.getGameID())
			{
				GPCH = GPPH;
			}
		}		
		return GPCH;
	}
	*/
	
/*	public GamePlayPlayerHand FindPlayerGame(GamePlay gme, Player p)
	{
		GamePlayPlayerHand GPPHReturn = null;
		
	
		for (GamePlayPlayerHand GPPH: GamePlayerHand)
		{
			if (p.getiPlayerPosition() == GPPH.getPlayer().getiPlayerPosition())
			{
				GPPHReturn = GPPH;
			}
		}
		return GPPHReturn;
	}*/
	
	
}
