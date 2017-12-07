import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	
	/**
	 * Should the grid be it's own class??
	 * @param args
	 */
	
	
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
		int breaker = 0;
		while (breaker == 0)
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
			breaker++; //to break while loop
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
		
		Player agressor = new Player(); //I should probably change player1 and player2 to agressor and defender but just a bit to lazy rn
		Player defender = new Player();
		
		
		for (int i = 0; i < players.length; i++)
		{
			if(players[i].getIsAttacker() == true)
			{
				agressor = players[i];
			}
			
			
			else
			{
				defender = players[i];
			}
		}
		
		System.out.println("time to choose your ships. " + agressor.getName() + " will go first");
		/**
		 * right now it does not matter who is attacker or defender. player1 will always choose from the same list of ships. I want the attacker to choose from this list. 
		 * What is the best way to fix this
		 */
		
		System.out.println("your avalable options are..."); //do I just hard code this? What's a better way?
		System.out.println("'X Wing', 'B Wing'");
		
		while (agressor.getPoints() > 0) //as long as you have points you can keep buying ships
		{
			String choice = s.nextLine();
			if (choice.equals("X Wing") && agressor.getPoints() >= XWing.getCost())
			{
				XWing x = new XWing();
				agressor.shipsControlled.add(x);  //agressor can be player1 or player2
				agressor.setPoints(agressor.getPoints() - 1);
			}
			
			else if (choice.equals("B Wing") && agressor.getPoints() >= BWing.getCost())
			{
				BWing bb = new BWing();
				agressor.shipsControlled.add(bb);
				agressor.setPoints(agressor.getPoints() - 1);
			}
			
			else if (choice.equals("break"))
			{
				break;
			}
			
			else
			{
				System.out.println("invalid name. Try again or type 'break'");
			}
			System.out.println("Current points = " +agressor.getPoints());
			System.out.println("Current ships = " + agressor.shipsControlled());
			
		}
		
		System.out.println("the rebel fleet has been built \n-------------------------------------------------------");
		
		System.out.println("time for "  + defender.getName() + " to choose ships");
		System.out.println("your avalable options are..."); //do I just hard code this? What's a better way?
		System.out.println("TIE Fighter, Star Destroyer");

		
		while (defender.getPoints() > 0)
		{
			String choice = s.nextLine();
			if (choice.equals("Star Destroyer") && defender.getPoints() >= StarDestroyer.getCost())
			{
				XWing x = new XWing();
				defender.shipsControlled.add(x);
				defender.setPoints(defender.getPoints() - 1);
			}
			
			/**
			 * weird bugs here needs debugging
			 * i tried TIE Fighter it said -1 points then broke... not sure why
			 */
			else if (choice.equals("TIE Fighter") && defender.getPoints() >= TIEFighter.getCost())
			{
				BWing bb = new BWing();
				defender.shipsControlled.add(bb);
				defender.setPoints(player1.getPoints() - 1);
			}
			
			else if (choice.equals("break"))
			{
				break;
			}
			
			else
			{
				System.out.println("invalid name or cost. Try again or type 'break'");
			}
			System.out.println("Current points = " +defender.getPoints());
			System.out.println("Current ships = " + defender.shipsControlled());
		}
		System.out.println("the imperial fleet has been built. Let the game begin!");
		
		Ship[][] grid = new Ship[7][15]; //should the grid be it's own class and not just a 2d array of ships?
		
		//initializing ships. 2 players one imperial one rebel rebel gets to choose all ships imperial gets simpler choices
		StarDestroyer destroyer1 = new StarDestroyer();
		StarDestroyer destroyer2 = new StarDestroyer();
		DeathStar deathStar = new DeathStar();

		destroyer1.setLocation(2, 0);
		destroyer2.setLocation(4, 0);
		deathStar.setLocation(3,0);

		for (int i = 2; i < 5; i++) //should generate 3 X-Wings
		{
			XWing x = new XWing();
			x.setLocation(i, 13);
			xWingSpotter.add(x);
		}

		
		for (int i = 0; i < player1.shipsControlled.size(); i++) 
		{
			grid[player1.shipsControlled.get(i).getX()][player1.shipsControlled.get(i).getY()] = player1.shipsControlled.get(i);
		}
		
		/*
		 * this goes and gets the location of every ship a player controls and puts it on the grid
		 */
		
		for (int i = 0; i < player2.shipsControlled.size(); i++)
		{
			grid[player2.shipsControlled.get(i).getX()][player2.shipsControlled.get(i).getY()] = player2.shipsControlled.get(i);
		}
		
		/**
		 * this is currently not printing to grid. The grid is acting as if there is nothing here. Needs to be examined
		 * also make a print grid option in the game loop
		 */
		
		
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
			else if (players[i].getIsAttacker() == true)
			{
				for (int index = 0; index < xWingSpotter.size(); index++)
				{
					players[i].shipsControlled.add(xWingSpotter.get(i));
				}
			
			}
		}
		
		//let's see what this looks like
				for(int i = 0; i < grid.length; i++)
				{
					for(int j = 0; j < grid[0].length; j++)
					{
						
							System.out.print('.' + " ");
						
					
					}
					System.out.println();
				}
				
		
		//now to let players choose their ships
		
		
		
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
			
			if (input.equals("check turn")) //this will tell you whose turn it is.. idk in case you want to double check?
			{
				for (int melon = 0; melon < players.length; melon++)
				{
					System.out.println(players[melon].getName() + " is turn ...? " + players[melon].checkTurn());
				}
			}
			
			System.out.println ("Game is running. \n" + turnCounter + " turns taken");
			
			
			if (input.equals("get info"))
			{ //thre is probably a smoother way to do this but not sure how
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
					if (grid[yCoordinate - 1][xCoordinate - 1] != null) //IK its backwards it needs to be fixed but work
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
				//this seems to work ok
			
			//how to end turn
			
		}
			} //ends turn loop
		
	}//ends game loop

}
