import java.util.Scanner;

public class TIEBomber extends Ship{

	protected int torpedoesLeft;
	
	public void setTorpedoesLeft(int t)
	{
		this.torpedoesLeft = t;
	}
	
	public int getTorpedoesLeft()
	{
		return torpedoesLeft;
		
	}
	public TIEBomber()
	{
		
			health = 100 + ((int)(Math.random() * 40));
			attack = 30 + (int)(Math.random() * 70);
			speed = 3;
			name = "TIE Bomber";
			range = 2;
			graphic = 'I';
			pointCost = 1.5;
			allignment = Ship.Allignment.Imperial;
			torpedoesLeft = 5;
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
		Torpedo torpedo = new Torpedo(40, targetLocation, "TIE Bomber Torpedo", 8); 
		torpedoesLeft--;
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
