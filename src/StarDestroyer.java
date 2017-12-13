//override methods need to be filled out
public class StarDestroyer extends Ship implements ForceField{
	
	int energy = 200;
	int pointCost = 2;
	
	public StarDestroyer()
	{
		health = 65 + ((int)(100 * Math.random()));
		attack = 70 + ((int)(70 * Math.random())); //will initialize with a random attack, unlike other ships who each time will deal a random damage
		name = "Star Destroyer";
		speed = 2;
		range = 5;
		graphic = 'S';
		pointCost = 2;
		allignment = Ship.Allignment.Imperial;
		
//		shipType = destroyer; why does this not work?
	}
	
	@Override
	public void useAbility()
	{
		//force fiel using energy
		/*
		 * If this ship takes damage, it takes 1/2 as much damage and loses that amount of energy
		 * not sure how to syntax that
		 */
		
	}

	@Override
	public void raiseShields(int energy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropShields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int shieldedDamage(boolean shieldsUp, int incomingDamage) {
		// TODO Auto-generated method stub
		return 0;
	}
	
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
	
	

}
