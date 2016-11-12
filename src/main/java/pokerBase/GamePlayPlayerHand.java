package pokerBase;

public class GamePlayPlayerHand {

	private GamePlay game = null;
	private Player player = null;
	private Hand hand = null;
	private Hand BestHand = null;

	private Player WinningPlayer = null;

	public GamePlayPlayerHand(GamePlay gme, Player p) {

		this.game = gme;
		this.player = p;
	}

	public GamePlay getGame() {
		return game;
	}

	public void setGame(GamePlay game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

/*	public void addCardToHand(Card c) {
		getHand().AddToCardsInHand(c);
	}*/

	public Player getWinningPlayer() {
		return WinningPlayer;
	}

	public void setWinningPlayer(Player winningPlayer) {
		WinningPlayer = winningPlayer;
	}

	public Hand getBestHand() {
		return BestHand;
	}

	public void setBestHand(Hand bestHand) {
		BestHand = bestHand;
	}

}
