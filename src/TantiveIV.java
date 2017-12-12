
public class TantiveIV extends Ship{

	public TantiveIV()
	{
		health = 120;
		attack = 60 + (int)(Math.random() * 90);
		speed = 3;
		name = "Tantive IV";
		range = 3;
		graphic = 'B';
		pointCost = 1.5;
		allignment = Ship.Allignment.Rebel;
	}
	
	public Torpedo fireTorpedo(Ship target)
	{
		Torpedo torpedo = new Torpedo(35, target, "B Wing Torpedo");
		return torpedo; 
		
	}

}
