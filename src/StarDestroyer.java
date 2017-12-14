//override methods need to be filled out
public class StarDestroyer extends ForceFieldShip{
	
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
		allignment = Ship.Allignment.Imperial; //how do I use this allignment to make sure that only defender can target it
	}
}
