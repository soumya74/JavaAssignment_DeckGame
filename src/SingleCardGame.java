import java.util.Optional;


// SingleCardGame extends CardGame
public class SingleCardGame extends CardGame {
	
	// StartGame logic handled single card entry to each player for singleCardGame
	public void startGame() {
		for(Player p: players) {
			Optional<Card> c = cardDeck.getCard();
			
			if(c.isPresent()) {
				p.addCard(c.get());
			} else {
				System.out.println("No more cards present in deck");
			}
		}
	}

}
