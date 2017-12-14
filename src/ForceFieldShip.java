
public abstract class ForceFieldShip extends Ship{
	/**
	 * I feel like this should be an interface and not an abstract class but not sure how to do it as an interface
	 */
	
	protected int energy;
	protected boolean shieldsUp;
	protected int shieldStrength;

	@Override
	public String[] move() //special because moves slower if shields are up
	{
		
		String[] movements = new String[speed];
		
		
		if (shieldsUp == false)
		{
			int moveCounters = speed;
			for (int i = 0; i < speed; i++) {

				while (moveCounters > 0) {
					System.out.println("this ship can move " + moveCounters + " more time(s)");
					System.out.println ("would you like to move 'north' 'south' 'east' 'west'");
					//or should I do up down left right?
					String input = keyboard.nextLine();
					
					if (input.equals("north") || input.equals("south" )|| input.equals("east") || input.equals("west"))
					{
						System.out.println("legal move in the " + input + " direction");
						movements[i] = input; //your input is stored in the string which will be read by the grid class and turned into a movement
						moveCounters--;
						continue;
					}
					else
					{
						System.out.println("please enter a valad direction");
						continue;
					}
				}
				
			}
		}
		
		else if (shieldsUp == true)
		{
			int moveCounters = speed - 1; //while shilds are up you move slower
			for (int i = 0; i < speed; i++) {

				while (moveCounters > 0) {
					System.out.println("this ship can move " + moveCounters + " more time(s)");
					System.out.println ("would you like to move 'north' 'south' 'east' 'west'");
					//or should I do up down left right?
					String input = keyboard.nextLine();
					
					if (input.equals("north") || input.equals("south" )|| input.equals("east") || input.equals("west"))
					{
						System.out.println("legal move in the " + input + " direction");
						movements[i] = input; //your input is stored in the string which will be read by the grid class and turned into a movement
						moveCounters--;
						continue;
					}
					else
					{
						System.out.println("please enter a valad direction");
						continue;
					}
				}
				
			}
		}
		
		return movements;
	}
	
	public void raiseShields(int energySpent) //for now I am putting this here because only certian ships can raise shilds...I think I should make a class ForceFieldShips
	{
		
		if (energySpent <= energy)
		{
			shieldsUp = true;
			energy -= energySpent;
			shieldStrength = (int)(energySpent * 1.5); //this way shields are worth more than 50 health
			
		}
		
		else
		{
			System.out.println("error not enough energy");
		}
	}

	public void dropShields() {
		energy += shieldStrength / 2;
		shieldStrength = 0;
		shieldsUp = false;
	}

	public int shieldedDamage(boolean shieldsUp, int incomingDamage) {
		int damageToBeTaken;
		
		if (shieldsUp = true)
			{
			if (incomingDamage /2 <= shieldStrength)
			{
				shieldStrength -= incomingDamage/2; //this way shields can absorb more than 150 damage
				damageToBeTaken = 0;
			
				if (shieldStrength < 0)
				{
					System.out.println("Error negative shield strength");
				}
			}
		
			else
			{
				damageToBeTaken =(int) (1.5 * (incomingDamage - shieldStrength)); //after breaking through the shield you take 1.5 times as much damage that turn
				shieldStrength = 0;
			
			}
		}
		else
		{
			damageToBeTaken = incomingDamage;
		}
		return damageToBeTaken;
		
	}
	public boolean getShieldsUp()
	{
		return shieldsUp;
	}
	
	public void setShieldsUp(boolean shieldsUp)
	{
		this.shieldsUp = shieldsUp;
	}
	
	public int getEnergy()
	{
		return energy;
	}
	
	public int getShieldStrength()
	{
		return shieldStrength;
	}
	

}
