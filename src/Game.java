import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	
	/**
	 *What is the best way to clean this up? What should be it's own class?
	 */
	
	
	public static void main (String[] args)
	{
		
		Scanner keyboard = new Scanner(System.in);
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
		String barley = keyboard.nextLine();
		Player player1 = new Player(barley);
		int breaker = 0;
		while (breaker == 0)
		{
		System.out.println("enter player 2 name");
		barley = keyboard.nextLine();
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
			
			//this is setting one player as attacker and one player as defender
			
			else
			{
				defender = players[i];
			}
		}
		
		//initializing the grid
		
		Grid grid = new Grid(7,15);
		grid.initialize();
		
		StarDestroyer destroyer1 = new StarDestroyer();
		StarDestroyer destroyer2 = new StarDestroyer();
		DeathStar deathStar = new DeathStar();
		
		grid.placeShip(destroyer1, 2, 0);
		grid.placeShip(destroyer2, 4, 0);
		grid.placeShip(deathStar, 3, 0);
		
		defender.shipsControlled.add(deathStar);
		defender.shipsControlled.add(destroyer1);
		defender.shipsControlled.add(destroyer2);
		//default things that defender starts with

		for (int i = 2; i < 5; i++) //should generate 3 X-Wings to place in the middle of the 14th column
		{
			XWing x = new XWing();
			grid.placeShip(x, i, 13); //should place a X wing along row 13 at whatever i is
			agressor.shipsControlled.add(x);
		}
		System.out.println("\nThings!\n");
		grid.printGrid();
		
		
		System.out.println("time to choose your ships. " + agressor.getName() + " will go first");
		/**
		 * right now it does not matter who is attacker or defender. player1 will always choose from the same list of ships. I want the attacker to choose from this list. 
		 * What is the best way to fix this
		 */

		while (agressor.getPoints() > 0) //as long as you have points you can keep buying ships
		{
			
			/**
			 * need to restrict where ships can be placed (only in columns 14 and 15)
			 * Also the print statements are a bit screwey but that can be dealt with later
			 */
			
			int x = 0;
			int y = 0;
			System.out.println("would you like to print screen? 'y' 'n'");
			String choice = keyboard.nextLine();
			if (choice.equals("y"))
			{
				grid.printGrid();
			}
			System.out.println("now choose a ship");
			System.out.println("your avalable options are..."); //do I just hard code this? What's a better way?
			System.out.println("'X Wing', 'B Wing' 'Tantive IV'");//there must be a better way to do this based off of ship allignments but not sure how
			choice = keyboard.nextLine();
			if (choice.equals("X Wing") && agressor.getPoints() >= XWing.getCost())
			{
				XWing xWing = new XWing();
				agressor.takeControlOf(xWing);  //agressor can be player1 or player2
				agressor.removePoints(xWing.getCost());
				System.out.println("place ship in row major order");
				x = keyboard.nextInt();
				y = keyboard.nextInt();
				
				grid.placeShip(xWing, x, y);
			}
			
			else if (choice.equals("Tantive IV") && agressor.getPoints() >=TantiveIV.getCost())
			{
				TantiveIV tiv = new TantiveIV();
				agressor.takeControlOf(tiv);
				agressor.removePoints(tiv.getCost());
				
				System.out.println("place ship in row major order");
				int row = keyboard.nextInt();
				int column = keyboard.nextInt();
				grid.placeShip(tiv, row, column);
			}
			
			else if (choice.equals("B Wing") && agressor.getPoints() >= BWing.getCost())
			{
				BWing bWing = new BWing();
				agressor.takeControlOf(bWing);
				agressor.removePoints(bWing.getCost());;
				
				System.out.println("place ship in row major order");
				x = keyboard.nextInt();
				y = keyboard.nextInt();
				
				grid.placeShip(bWing, x, y);
			
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
			System.out.println("Current ships = " + agressor.printShipsControlled());
			
		}
		
		System.out.println("the rebel fleet has been built \n-------------------------------------------------------");
		
		/**
		 * bugs persist here need someone else to look it over to see if there is a better way of doing this
		 */
		
		System.out.println("time for "  + defender.getName() + " to choose ships");
		System.out.println("your avalable options are..."); //do I just hard code this? What's a better way?
		System.out.println("TIE Fighter, Star Destroyer");
		
		while (defender.getPoints() > 0) //as long as you have points you can keep buying ships
		{
			
			/**
			 * need to restrict where ships can be placed (only in columns 14 and 15)
			 * Also the print statements are a bit screwey but that can be dealt with later
			 */
			
			int x = 0;
			int y = 0;
			System.out.println("would you like to print screen? 'y' 'n'");
			String choice = keyboard.nextLine();
			if (choice.equals("y"))
			{
				grid.printGrid();
			}
			System.out.println("now choose a ship");
			choice = keyboard.nextLine();
			if (choice.equals("TIE Fighter") && agressor.getPoints() >= XWing.getCost())
			{
				TIEFighter tie = new TIEFighter();
				defender.takeControlOf(tie);  
				defender.removePoints(tie.getCost());
				System.out.println("place ship in row major order");
				x = keyboard.nextInt();
				y = keyboard.nextInt();
				int breakable = 0;
				
				while (breakable == 0) {
				if(grid.isEmpty(x, y) == true)
				{
					grid.placeShip(tie, x, y);
					breakable++;
				}
				/**
				 * I sense there is a more efficient way to do this check here and only needing to type some of this stuff once... Gri
				 */
				else
				{
					System.out.println("location invalid ship already there");
					break;
				}
			}
			}
			/**
			 * this just flat out does not work
			 */
			
			else if (choice.equals("Star Destroyer") && agressor.getPoints() >= TIEFighter.getCost())
			{
				StarDestroyer starDestroyer = new StarDestroyer();
				defender.takeControlOf(starDestroyer);
				defender.removePoints(starDestroyer.getCost());;
				
				System.out.println("place ship in row major order");
				x = keyboard.nextInt();
				y = keyboard.nextInt();
				int tortuse = 0;
				
				while (tortuse == 0) {
				if(grid.isEmpty(x, y) == true)
				{
					grid.placeShip(starDestroyer, x, y);
					tortuse++;
				}
				else
				{
					System.out.println("location invalid ship already there");
					continue;
				}
			}
			}

			else if (choice.equals("break"))
			{
				break;
			}
			
			else
			{
				System.out.println("invalid name. Try again or type 'break'");
			}
			System.out.println("Current points = " +defender.getPoints());
			System.out.println("Current ships = " + defender.printShipsControlled());
			
			
		System.out.println("would you like to print screen? 'y' 'n'");
		String input = keyboard.nextLine();
		if (input.equals("y"))
		{
			grid.printGrid();
		}

		//initializing ships. 2 players one imperial one rebel rebel gets to choose all ships imperial gets simpler choices
		

		
		/*
		 * this goes and gets the location of every ship a player controls and puts it on the grid
		 */
		
		
		/**
		 * this is currently not printing to grid. The grid is acting as if there is nothing here. Needs to be examined
		 * also make a print grid option in the game loop
		 */
		
		
		//to give players control over their ships

		
		//let's see what this looks like
		
		/**
		 * there is some index math here that needs fixing
		 * probably the best way to fix that is to get some graph paper and just write it out
		 * need to actually take time to think this through though 
		 */
			
		/*
		 * now the players have to place all of the ships that they have  but are not already on the map
		 */
		
		
		//the game loop
		int turnCounter = 0;
		while(true)
			
			//add a statement printing a list of valid commands
			
			while(input != "pass turn") // this doesn't work
				{
					input = keyboard.nextLine();
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
			
			
			if (input.equals("get info")) //also note that this does not work and print statement should be added in here somewhere 
			{ //thre is probably a smoother way to do this but not sure how
				System.out.println("please enter x coordinate 1-15");
				int xCoordinate = keyboard.nextInt();
				
				System.out.println("please enter y coordinate 1-7");
				int yCoordinate = keyboard.nextInt();
				
				if(yCoordinate > 7 || xCoordinate > 15)
				{
					System.out.println("unhandled out of bounds error. Please do other things");
				}
				else
				{
					grid.finder(xCoordinate, yCoordinate);
				}
				
			}
			
			else if (input.equals("move a ship"))
			{
				System.out.println("would you like to see the grid first? 'y' 'n'");
				input = keyboard.nextLine();
				if (input.equals("y"))
				{
					grid.printGrid();
				}
				System.out.println("enter coordinates of the ship you would like to move 'x''y'");
				int reX = keyboard.nextInt();
				int saY = keyboard.nextInt();
				//sorry it's been a weird day
				grid.moveShip(reX, saY);
				
			}
			
			else if (input.equals("display ships")) //not else if because people can do multiple things per turn
			{
				System.out.println("for which player?");
				input = keyboard.nextLine(); //need to make another check here
				if(input.equals(player1.getName()))
				{
					System.out.println(player1.printShipsControlled() + "\t");
				}
				else if (input.equals(player2.getName()))
				{
					System.out.println(player2.printShipsControlled());
				}
			}
			
			//how to end turn
			
		}
			} //ends turn loop
		
	}//ends game loop

	}
}
