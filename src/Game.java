import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	
	
	public static void main (String[] args)
	{
		ArrayList<Ship> p1Ships = new ArrayList<Ship>();
		ArrayList<Ship> p2Ships = new ArrayList<Ship>();
		Scanner s = new Scanner(System.in);
		Player[] players = new Player[2];
		/**
		 * initialize board
		 * initialize players
		 * determine who is going first
		 * have players pick their ships
		 * place ships and initialize ships
		 * take turns and do things
		 * determine winner
		 */
		
		System.out.println("enter player 1 name");
		String barley = s.nextLine();
		Player player1 = new Player(barley);
		System.out.println("enter player 2 name");
		barley = s.nextLine();
		Player player2 = new Player(barley);
		
		//now to determine who is attacker and who is defender
		
		int coin = (int)(Math.random() * 10);
		if (coin % 2 == 0)
		{
			player1.setIsAttacker(true);
			//player has isAttacker default to false so I don't need to set twice
			System.out.println("Player 1 is attacker \nPlayer 2 is defender");
		}
		
		else
		{
			player2.setIsAttacker(true);
			System.out.println("Player 2 is attacker \nPlayer 1 is defender");

		}
		
		players[0] = player1;
		players[1] = player2;
		
		Ship[][] grid = new Ship[7][15]; //this will hold the location of all the ships
		
		//initializing ships. 2 players one imperial one rebel rebel gets to choose all ships imperial gets simpler choices
		StarDestroyer destroyer1 = new StarDestroyer();
		StarDestroyer destroyer2 = new StarDestroyer();
		
		for (int i = 0; i < players.length; i++)
		{
			if(player[0][i]) 
		}
		
		
		
		grid[0][3] = destroyer1;
		grid[0][5] = destroyer2;
		
		
		
	}

}
