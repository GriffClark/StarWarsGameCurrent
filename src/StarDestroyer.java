
public class StarDestroyer extends Ship{
	
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
	
	

}
