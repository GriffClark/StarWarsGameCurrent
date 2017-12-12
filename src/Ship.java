/**
 * Consider a Star Wars theme
 * @author clarkg0206
 *
 */

/**
		 * for all attacking I need to figure out how to judge distance. Not sure how to do that
		 * also gotta figure out how to move
		 * what happens when a ship dies
		 * how do I fire a torpedo at the death star?
		 */


import java.util.Scanner;
//how do I get distance like if a ship is 2 units from another ship it can do a thing??
public class Ship {
	

public enum Allignment
{
	Rebel, Imperial
}
	Scanner keyboard = new Scanner(System.in);
	protected int health;
	protected int attack;
	protected int range;
	protected int speed;
	protected boolean usedAbility;
	protected String name;
	protected Player owner;
	protected int damageDodge;
	protected char graphic;
	protected static double pointCost;
	protected int x;
	protected int y;
	protected int[][] location;
	protected Allignment allignment;
	
	/**
	 * Somewhere here I think I need to store the location of the ship
	 * do I?
	 * Also what is the best way to do that? 
	 * @param a
	 */
	
	public void setDodgeDamage(int a)
	{
		this.damageDodge = a;
	}
	
	public void setLocation(int happi, int fish)
	{
		location = new int[happi][fish];
		this.x = happi;
		this.y = fish;
	}
	
	public Allignment getAllignment()
	{
		return allignment;
	}
	
	public int[][] getLocation()
	{
		return location;
	}

	
	public int getX()
	{
		return x;
	}
	
	public String[] move()
	{
		String[] movements = new String[speed];
		int moveCounters = speed;
		for (int i = 0; i < speed; i++) {
			
			int breaker = 0;
			while (breaker == 0) {
				System.out.println("this ship can move " + moveCounters + " more time(s)");
				System.out.println ("would you like to move 'north' 'south' 'east' 'west'");
				//or should I do up down left right?
				String input = keyboard.nextLine();
				
				if (input.equals("north") || input.equals("south" )|| input.equals("east") || input.equals("west"))
				{
					System.out.println("legal move in the " + input + " direction");
					movements[i] = input;
					breaker++;
					continue;
				}
				else
				{
					System.out.println("please enter a valad direction");
					continue;
				}
			}
			
		}
		return movements;

	}
	
	public int getY()
	{
		return y;
	}
	
	
	public Ship()
	{
		
	}
	
	public void setPointCost(double pointCost)
	{
		this.pointCost = pointCost;
	}
	
	public static double getCost()
	{
		return pointCost;
	}
	
	public int getDamageDodge()
	{
		return damageDodge;
	}
	
	public static void dealDamage(Ship agressor, Ship victim)
	{
		boolean getHit;
		int dodgeInt = (int)(Math.random() * 10);
		if (victim.getSpeed() / 2 >= agressor.getSpeed())
		{
			getHit = false;
		}
		
		else if (agressor.getSpeed() / 2 >= victim.getSpeed())
		{
			getHit = true;
		}
		
		else if (agressor.getSpeed() + dodgeInt% victim.getSpeed() == 0 ) //this is kinda weird but need one more way for a ship to dodge
		{
			getHit = false;
		}
		
		else
		{
			getHit = true;
		}
		
		//now to actually deal the damage
		
		if (getHit == true)
		{
			victim.setHealth(victim.getHealth() - agressor.getAttack()); //sets the victims health decremented by agressor's attack
		}
		
		
		//could put a print statement here but I don't think that I need it
	}
	
	public void useAbility()
	{
		//things
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
		
	}
	
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	
	public char getGraphic()
	{
		return graphic;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public boolean getUsedAbility()
	{
		return usedAbility;
	}
	
	public void setUsedAbility(boolean usedAbility)
	{
		this.usedAbility = usedAbility;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	public void setRange(int range)
	{
		this.range = range;
	}
	
	public int getRange()
	{
		return range;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isAlive()
	{
		if (health > 0)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return name + "       ";
	}

}
