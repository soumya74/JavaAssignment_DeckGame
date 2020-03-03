import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

abstract class CardGame {
	
	List<Player> players;
	Deck cardDeck;
	
	public CardGame() {
		players = new ArrayList<Player>();
		cardDeck = new Deck();
		cardDeck.initialiseDeck();
	}
	
	void addPlayer(String name) {
		Player p = new Player(name);
		players.add(p);
	}
	
	void removePlayer(String name) {
		Iterator itr = players.iterator();
		
		while(itr.hasNext()) {
			Player p = (Player) itr.next();
			if(p.getName().equals(name)) {
				
				for(Card c: p.getCard()) {
					cardDeck.returnCard(c);
				}
				
				itr.remove();
				return;
			}
		}
		
		System.out.println("Player with given Name not present");
	}
	
	void showPlayerCards() {
		for(Player p : players) {
			System.out.println(p.toString());
		}
	}
	
	void shuffleDeck() {
		cardDeck.shuffle();
	}
	
	// Can make this Winner calculation logic separate for SingleCard, DoubleCard games
	Optional<Player> declareWinner(){
		Player p = null;
		
		if(players.size() == 0) {
			return Optional.ofNullable(p);
		}
		
		// Players are sorted using logic implemented in Players class
		Collections.sort(players);
		
		return Optional.ofNullable(players.get(0));
	}
	
	void endGame() {
		for(Player p : players) {
			Iterator itr = p.getCard().iterator();
			
			while(itr.hasNext()) {
				cardDeck.returnCard((Card) itr.next());
				itr.remove();
			}
			
		}
	}
	
	void showDeck() {
		cardDeck.showDeck();
	}
	
	public abstract void startGame();
	
}
