import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	
	
	public static void main (String[] args)
	{
		
		ArrayList<Ship> xWingSpotter = new ArrayList<Ship>();

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
		int jot = 0;
		while (jot == 0)
		{
		System.out.println("enter player 2 name");
		barley = s.nextLine();
		//to ensure no repeats
		if (barley.equals(player1.getName()))
		{
			System.out.println("must have unique name");
		}
		else
		{
			jot++;
		}
		}
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

		for (int i = 2; i < 5; i++) //should generate 3 X-Wings
		{
			XWing x = new XWing();
			grid[i][13] = x;
			xWingSpotter.add(x);
		}

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
		
		//to give players control over their ships
		for(int i = 0; i < players.length; i++)
		{
			if(players[i].getIsAttacker() == false)
			{
				players[i].shipsControlled.add(deathStar);
				players[i].shipsControlled.add(destroyer1);
				players[i].shipsControlled.add(destroyer2);
				//default things that defender starts with
			}
			else
			{
				for (int index = 0; index < xWingSpotter.size(); index++)
				{
					players[i].shipsControlled.add(xWingSpotter.get(i));
				}
			
			}
		}
		
		//now to let players choose their ships
		System.out.println("time to choose your ships. " + player1.getName() + " will go first");
		/**
		 * right now it does not matter who is attacker or defender. player1 will always choose from the same list of ships. I want the attacker to choose from this list. 
		 * What is the best way to fix this
		 */
		
		System.out.println("your avalable options are..."); //do I just hard code this? What's a better way?
		System.out.println("'X Wing', 'B Wing'");
		
		while (player1.getPoints() > 0)
		{
			String choice = s.nextLine();
			if (choice.equals("X Wing") && player1.getPoints() >= XWing.getCost())
			{
				XWing x = new XWing();
				player1.shipsControlled.add(x);
				player1.setPoints(player1.getPoints() - 1);
			}
			
			else if (choice.equals("B Wing") && player1.getPoints() >= BWing.getCost())
			{
				BWing bb = new BWing();
				player1.shipsControlled.add(bb);
				player1.setPoints(player1.getPoints() - 1);
			}
			
			else if (choice.equals("break"))
			{
				break;
			}
			
			else
			{
				System.out.println("invalid name. Try again or type 'break'");
			}
			System.out.println("Current points = " +player1.getPoints());
			System.out.println("Current ships = " + player1.shipsControlled());
			
		}
		
		System.out.println("player 1 done choosing ships \n-------------------------------------------------------");
		
		System.out.println("time for "  + player2.getName() + " to choose ships");
		System.out.println("your avalable options are..."); //do I just hard code this? What's a better way?
		System.out.println("TIE Fighter, Star Destroyer");

		
		while (player2.getPoints() > 0)
		{
			String choice = s.nextLine();
			if (choice.equals("Star Destroyer") && player2.getPoints() >= StarDestroyer.getCost())
			{
				XWing x = new XWing();
				player1.shipsControlled.add(x);
				player1.setPoints(player1.getPoints() - 1);
			}
			
			else if (choice.equals("TIE Fighter") && player2.getPoints() >= TIEFighter.getCost())
			{
				BWing bb = new BWing();
				player1.shipsControlled.add(bb);
				player1.setPoints(player1.getPoints() - 1);
			}
			
			else if (choice.equals("break"))
			{
				break;
			}
			
			else
			{
				System.out.println("invalid name or cost. Try again or type 'break'");
			}
			System.out.println("Current points = " +player1.getPoints());
			System.out.println("Current ships = " + player1.shipsControlled());
		}
		
		
		//the game loop
		String input = null;
		int turnCounter = 0;
		while(true)
			
			while(input != "pass turn") // this doesn't work
			{
				input = s.nextLine();
		{
			if (turnCounter > 0 && turnCounter%2 == 1)
			{
				player1.takeTurn();
				player2.passTurn();
			}
			
			else if (turnCounter  == 0 || turnCounter%2 == 0)
			{
				player1.passTurn();
				player2.takeTurn();
			}
			
			if (input.equals("check turn"))
			{
				for (int melon = 0; melon < players.length; melon++)
				{
					System.out.println(players[melon].getName() + " is in the game...? " + players[melon].checkTurn());
				}
			}
			
			System.out.println ("Game is running. \n" + turnCounter + " turns taken");
			
			
			if (input.equals("get info"))
			{
				System.out.println("please enter y coordinate 1-7");
				int yCoordinate = s.nextInt();
				System.out.println("please enter x coordinate 1-15");
				int xCoordinate = s.nextInt();
				if(yCoordinate > 7 || xCoordinate > 15)
				{
					System.out.println("unhandled out of bounds error. Please do other things");
				}
				else
				{
					if (grid[yCoordinate - 1][xCoordinate - 1] != null) //IK its backwards it needs to be fixed
					{
						System.out.println(grid[yCoordinate - 1][xCoordinate - 1].toString());
					}
					else
					{
						System.out.println("spot is empty");
					}
				}
				
			}
			
			if (input.equals("display ships")) //not else if because people can do multiple things per turn
			{
				System.out.println("for which player?");
				input = s.nextLine(); //need to make another check here
				if(input.equals(player1.getName()))
				{
					System.out.println(player1.shipsControlled() + "\t");
				}
				else if (input.equals(player2.getName()))
				{
					System.out.println(player2.shipsControlled());
				}
			}
				
			
			//how to end turn
			
		}
			} //ends turn loop
		
	}//ends game loop

}
