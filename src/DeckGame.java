import java.util.Optional;
import java.util.Scanner;

public class DeckGame {

	public static void main(String []args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Select Game Mode");
		System.out.println("1. Single Card Game");
		System.out.println("2. Double Card Game");
		System.out.println("10. Exit");
        int a = in.nextInt();
        
        CardGame game = null;
		
		while(a!=10) {
	        switch(a) {
	        case 1:
	    		game = new SingleCardGame();
	    		playCardGame(in, game);
	        	break;
	        case 2:
	        	game = new DoubleCardGame();
	        	playCardGame(in, game);
	        	break;
	        default:
	        	System.out.println("wrong input");
	        }	
	        a = in.nextInt();
		}
	}
	
	public static void playCardGame(Scanner in, CardGame game) {
		System.out.println("1. Print Deck Cards");
		System.out.println("2. Shuffle Deck");
		System.out.println("3. Add Player");
		System.out.println("4. Remove Player");
		System.out.println("5. Start Game");
		System.out.println("6. Show Player Cards");
		System.out.println("7. Declare Winner");
		System.out.println("8. End Game");
		System.out.println("10. Return to Main Menu");
		
		int count = 0;
		
		int a = in.nextInt();
		while(a!=10) {
	        switch(a) {
	        case 1:
	        	System.out.println("Deck Cards : ");
	        	game.showDeck();
	        	break;
	        case 2:
	        	System.out.println("Shuffling Deck ...");
	        	game.shuffleDeck();
	        	break;
	        case 3:
	        	String name = "Player_" + count;
	        	System.out.println("Player added : " + name);
	        	game.addPlayer(name);
	        	count++;
	        	break;
	        case 4:
	        	System.out.println("Enter Player index to remove : ");
	        	a = in.nextInt();
	        	String pName = "Player_" + a;
	        	System.out.println("Removing Player " + pName);
	        	game.removePlayer(pName);;
	        	break;
	        case 5:
	        	System.out.println("Game Started ...");
	        	game.startGame();
	        	break;
	        case 6:
	        	System.out.println("Card of Players");
	        	game.showPlayerCards();
	        	break;
	        case 7:
	        	System.out.println("Winner of this Round ...");
	        	Optional<Player> p = game.declareWinner();
	        	
	        	if(p.isPresent()) {
	        		System.out.println(p.toString());
	        	} else {
	        		System.out.println("No winner");
	        	}
	        	break;
	        case 8:
	        	System.out.println("Game Ended");
	        	game.endGame();
	        	break;
	        default:
	        	System.out.println("wrong input");
	        }
	        a = in.nextInt();
		}
		
		System.out.println("RETURNING TO MAIN MENU");
	}
	
}
