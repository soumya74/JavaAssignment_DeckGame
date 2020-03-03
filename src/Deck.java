import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Deck {
	private List<Card> cardDeck;
	
	void initialiseDeck() {
		cardDeck = new ArrayList<Card>();
		
		for(suit s: suit.values()) {
			for(int i=0; i<13; i++) {
				cardDeck.add(new Card(s, i));
			}
		}
	}
	
	void shuffle() {
		Random r = new Random();
		int n;
		int deckSize = cardDeck.size();
		for(int i=0; i<deckSize; i++) {
			n = i + r.nextInt(deckSize) % ( deckSize - i);
			Collections.swap(cardDeck, i, n);
			
		}
	}
	
	void showDeck() {
		System.out.println(cardDeck.toString()+"\n");
	}
	
	Optional<Card> getCard() {
		Iterator<Card> itr = cardDeck.iterator();
		
		Card c = null;
		if(itr.hasNext()) {
			c = itr.next();
			itr.remove();
		}
		return Optional.ofNullable(c);
	}
	
	void returnCard(Card c) {
		if(cardDeck.size()>=52) {
			return;
		}
		cardDeck.add(c);
	}
	
}
