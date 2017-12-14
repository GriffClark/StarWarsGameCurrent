//X Wings are the only ships that can destroy the death star and that can only be done with the torpedo
import java.util.Scanner;
public class XWing extends Ship{
	

	protected int torpedoesLeft;
	
	public void setTorpedoesLeft(int t)
	{
		this.torpedoesLeft = t;
	}
	
	public int getTorpedoesLeft()
	{
		return torpedoesLeft;
	}
	public XWing()
	{
		health = 50;
		attack = 40;
		speed = 6;
		name = "X Wing";
		range = 3;
		graphic = 'X';
		pointCost = 1;
		allignment = Ship.Allignment.Rebel;
		torpedoesLeft = 4;
	}
	
	
	public Torpedo fireTorpedo()
	{
		
		if (torpedoesLeft > 0)
		{
		Scanner s = new Scanner (System.in);

		System.out.println("enter target 'x''y'");
		int x = s.nextInt();
		int y = s.nextInt();
		int[][] targetLocation = new int[x][y];
		Torpedo torpedo = new Torpedo(20, targetLocation, "X Wing Torpedo", 3);
		torpedoesLeft--;
		//add clause that x wing torpedoes can destroy death star
		//fires a torpedo at target location
		return torpedo; //this creates a new torpedo which is fired at a ship
		}
		
		else
		{
			System.out.println("error no torpedoes left");
			return null;
		}
	}
	
	
	
}
