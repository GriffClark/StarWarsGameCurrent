
public class TIEFighter extends Ship{
	
	public TIEFighter()
	{
		
			health = 30;
			attack = 10 + (int)(Math.random() * 35);
			speed = 4;
			name = "TIE Fighter";
			range = 2;
			graphic = 'T';
			pointCost = 0.5;
			allignment = Ship.Allignment.Imperial;
		
	}

}
