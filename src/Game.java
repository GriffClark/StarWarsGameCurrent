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
			System.out.println(player1.getName() +  " is attacker \n" + player2.getName() + " is defender");
		}
		
		else
		{
			player2.setIsAttacker(true);
			System.out.println(player2.getName() +  " is attacker \n" + player1.getName() + " is defender");

		}
		
		players[0] = player1;
		players[1] = player2;
		
		Ship[][] grid = new Ship[15][7]; //this will hold the location of all the ships
		
		//initializing ships. 2 players one imperial one rebel rebel gets to choose all ships imperial gets simpler choices
		StarDestroyer destroyer1 = new StarDestroyer();
		StarDestroyer destroyer2 = new StarDestroyer();
		DeathStar deathStar = new DeathStar();

		grid[0][3] = destroyer1;
		grid[0][5] = destroyer2;
		grid[0][4] = deathStar;
		for (int i = 0; i < grid[0].length; i++)
		{
			TIEFighter tiefighter = new TIEFighter();
			grid[1][i] = tiefighter;
		} //should give 7 tiefighters
		
		for (int i = 3; i < 6; i++) //should generate 3 X-Wings
		{
			XWing x = new XWing();
			grid[14][i] = x;
		}
		
		BWing b1 = new BWing();
		BWing b2 = new BWing();
		
		grid[15][0] = b1;
		grid[15][7] = b2;
		
		//let's see what this looks like
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] == null)
				{
					System.out.print('.' + " ");
				}
				else
				{
					System.out.print(grid[i][j].getGraphic); //fix me
				}
			}
		}
		
		
		
	}

}
