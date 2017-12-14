import java.util.Scanner;
public class BWing extends Ship{
	int torpedoesLeft; //would like to createa  torpedo class or interface but not sure if that is the right thing to do
	public BWing()
	{
		health = 120;
		attack = 60 + (int)(Math.random() * 90);
		speed = 3;
		name = "B Wing";
		range = 3;
		graphic = 'B';
		pointCost = 1.5;
		torpedoesLeft = 4;
		allignment = Ship.Allignment.Rebel;
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
