import java.util.ArrayList;
public class Player {
	
	protected ArrayList<Ship> shipsControlled = new ArrayList<Ship>();
	protected String name;
	protected boolean myTurn;
	protected boolean inTheGame;
	protected boolean isAttacker = false; //default false will set one to true
	
	public Player(String name)
	{
		this.name = name;
		inTheGame = true; 
	}
	
	public void setIsAttacker(boolean i)
	{
		this.isAttacker = i;
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
