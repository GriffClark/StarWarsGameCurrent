
public class TantiveIV extends ForceFieldShip
{
	public TantiveIV()
	{
		health = 100 + ((int)(Math.random() * 70));
		attack = 40;
		speed = 6;
		name = "Tantive IV";
		range = 3;
		graphic = 'V';
		pointCost = 2;
		allignment = Ship.Allignment.Rebel;
		energy = 50;
		shieldsUp = false;
	}

}
