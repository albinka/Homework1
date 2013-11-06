import java.net.Socket;


public class Game {

	Player [] players;
	
	public Game(Player [] players) {
		
		this.players = players;
		
		while (true) {
		
			//Checks if all players have made a choice
			boolean allChosen = true;
			for (int i = 0; i < players.length; i++) {				
				if (players[i].getChoice() == null)	
					allChosen = false;			
			}
			
			//When all players have made a choice
			if (allChosen) {
				System.out.println("DO STUFF");
				for (int i = 0; i < players.length; i++) {
					players[i].clearChoice();
				}
			}
			
		}
								
	}
}
