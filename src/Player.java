import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Comparable<Player> {

	private List<Card> cardList;
	
	private String name;

	public Player(String name) {
		super();
		this.cardList = new ArrayList();
		this.name = name;
	}

	public List<Card> getCard() {
		return cardList;
	}

	public void addCard(Card c) {
		this.cardList.add(c);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [" + cardList + ", name=" + name + "]";
	}

	// Descending order of Cards
	// In case, two cards having same face value, card with higher Suit order is given higher priority
	@Override
	public int compareTo(Player p2) {
		
		if (this.cardList.size() == 0 || p2.cardList.size() == 0)
			return 0;
		
		Collections.sort(this.getCard());
		Collections.sort(p2.getCard());
		
		Card c1 = this.cardList.get(0);
		Card c2 = p2.cardList.get(0);
		
		if (c1.getV().equals(c2.getV())) {
			return c2.getS().ordinal() - c1.getS().ordinal();
		}
		
		return c2.getV() - c1.getV();
	}
	
}
