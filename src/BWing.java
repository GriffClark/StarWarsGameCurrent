
public class BWing extends Ship{
	
	public BWing()
	{
		health = 120;
		attack = 60 + (int)(Math.random() * 90);
		speed = 3;
		name = "B Wing";
		range = 3;
		graphic = 'B';
		pointCost = 1.5;
		allignment = Ship.Allignment.Rebel;
	}
	
	public Torpedo fireTorpedo(Ship target)
	{
		Torpedo torpedo = new Torpedo(35, target, "B Wing Torpedo");
		/**
		 * refer to comments in x wing class under fireTorpedo()
		 */
		return torpedo; 
		
	}
	

}
