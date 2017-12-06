//X Wings are the only ships that can destroy the death star and that can only be done with the torpedo
public class XWing extends Ship{

	public XWing()
	{
		health = 50;
		attack = 40;
		speed = 6;
		name = "X Wing";
		range = 3;
	}
	
	@Override
	public void useAbility()
	{
		//need to come up with an ability
	}
	
	public Torpedo fireTorpedo(Ship target)
	{
		Torpedo torpedo = new Torpedo(20, target, "X Wing Torpedo"); //x wing torpedoes can destroy death star so it matters

		if (target.getName() == "Death Star")
		{
			torpedo.setRange(2); //if you are targeting the death star you gotta be closer
		}
		return torpedo; //this creates a new torpedo which is fired at a ship
	}
	
	
	
}
