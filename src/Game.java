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
		
		Ship[][] grid = new Ship[7][15]; //this will hold the location of all the ships
		
		//initializing ships. 2 players one imperial one rebel rebel gets to choose all ships imperial gets simpler choices
		StarDestroyer destroyer1 = new StarDestroyer();
		StarDestroyer destroyer2 = new StarDestroyer();
		DeathStar deathStar = new DeathStar();

		grid[2][0] = destroyer1;
		grid[4][0] = destroyer2;
		grid[3][0] = deathStar;
		for (int i = 0; i < grid.length; i++)
		{
			TIEFighter tiefighter = new TIEFighter();
			grid[i][1] = tiefighter;
		} //should give 7 tiefighters
		
		for (int i = 2; i < 5; i++) //should generate 3 X-Wings
		{
			XWing x = new XWing();
			grid[i][13] = x;
		}
		
		BWing b1 = new BWing();
		BWing b2 = new BWing();
		
		grid[0][14] = b1;
		grid[6][14] = b2;
		
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
					System.out.print(grid[i][j].getGraphic() + " "); 
				}
			}
			System.out.println();
		}
		//the game loop
		int turnCounter = 0;
		while(true)
		{
			if (turnCounter > 0 && turnCounter%2 == 1)
			{
				player1.takeTurn();
				player2.passTurn();
				System.out.println("Player 1 turn");
			}
			
			else
			{
				player1.passTurn();
				player2.takeTurn();
				System.out.println("Player 2 turn");
			}
			turnCounter ++;
			
			System.out.println ("Game is running. " + turnCounter + " turns taken");
			String input = s.nextLine();
			if (input.equals("get info"))
			{
				System.out.println("please enter x coordinate 1-7");
				int xCord = s.nextInt();
				System.out.println("please enter y coordinate 1-15");
				int yCord = s.nextInt();
				if(xCord > 7 || yCord > 15)
				{
					System.out.println("unhandled out of bounds error. Please do other things");
				}
				else
				{
					if (grid[xCord - 1][yCord - 1] != null)
					{
						System.out.println(grid[xCord - 1][yCord - 1].toString());
					}
					else
					{
						System.out.println("spot is empty");
					}
				}
			}
			
			//how to end turn
			
		}
		
	}

}
