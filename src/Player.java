import java.util.ArrayList;
public class Player {
	protected ArrayList<Ship> shipsControlled = new ArrayList<Ship>();
	protected String name;
	protected boolean myTurn;
	protected boolean inTheGame;
	protected boolean isAttacker = false; //default false will set one to true
	protected double points;
	
	public Player(String name)
	{
		this.name = name;
		inTheGame = true; 
		points = 13;
	}
	
	public Player()
	{
		
	}
	
	public void setIsAttacker(boolean i)
	{
		this.isAttacker = i;
	}
	
	public void takeControlOf( Ship ship)
	{
		for (int i = 0; i < shipsControlled.size(); i++)
		{
			//need to find duplicates in the ArrayList and if there are more than 4 get rid of them
		}
		shipsControlled.add(ship);
	}
	
	public String printShipsControlled()
	{
		String printMe = " ";
		for (int i = 0; i < shipsControlled.size(); i++)
		{
			printMe += shipsControlled.get(i).toString() + " ";
		}
		
		return printMe;
	}
	
	public boolean checkTurn()
	{
		return myTurn;
	}
	
	public void setPoints (double points)
	{
		this.points = points;
	}
	
	public void removePoints(double points)
	{
		this.points -= points;
	}
	
	public double getPoints()
	{
		return points;
	}
	
	public boolean getIsAttacker()
	{
		return isAttacker;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void passTurn()
	{
		myTurn = false;
	}
	
	public void takeTurn()
	{
		myTurn = true;
	}
	
	public boolean getMyTurn()
	{
		return myTurn;
	}
	
	public boolean getInTheGame()
	{
		return inTheGame;
	}
	
	public void lose()
	{
		inTheGame = false;
	}
	
	public void reserect()
	{
		inTheGame = true;
	}
	
	public String toString()
	{
		String shipList = "";
		for (int i = 0; i < shipsControlled.size(); i++)
		{
			shipList += shipsControlled.get(i).toString() + " ";
		}
		
		return name + " " + shipList + "in the game?" + inTheGame;
	}

	

}
