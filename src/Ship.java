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


//how do I get distance like if a ship is 2 units from another ship it can do a thing??
public class Ship {
	
	protected int health;
	protected int attack;
	protected int range;
	protected int speed;
	protected boolean usedAbility;
	protected String name;
	protected String owner; //the name of the player, which they will set 
	protected ShipType shipType;
	protected int damageDodge;
	protected char graphic;
	
	public void setDodgeDamage(int a)
	{
		this.damageDodge = a;
	}
	
	public Ship()
	{
		
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
	
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	public char getGraphic()
	{
		return graphic;
	}
	
	public String getOwner()
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
	
//	public ShipType getShipType() eclipse doesn't like this part not sure why but moving on and will come back to it later
//	{
//		switch (ShipType)
//		{
//		Shiptype happy;
//		case Flagship: happy = Flagship; break;
//		case Scout: happy = Scout; break ;
//		case Destroyer: happy = Destroyer; break;
//		case Cruiser: happy = Cruiser; break;
//		case Special: happy = Special; break;
//		default: happy = null;
//		
//		}
//		return happy;
//	}
	
	public void setShipType(ShipType shipType)
	{
		this.shipType = shipType;
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
		return shipType + " " + name;
	}

}
