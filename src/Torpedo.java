
public class Torpedo implements Projectile, Explosive{ //correct use of interface?
	
	
	/*
	 * need to make it so that torpedo will plot a path to target location, and if something gets in it's way it hits the something
	 */
	int range;
	int blastRadius;
	int damage;
	String name;
	int[][] target;
	char graphic = '+';
	
	//add detonation clause
	public Torpedo (int damage, int[][] target, String name, int range)
	{
		blastRadius = 2;
		this.damage = damage;
		this.target = target;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public void setBlastRadius(int radius) {
		this.blastRadius = radius;
		
	}

	@Override
	public int getBlastRadius() {
		// TODO Auto-generated method stub
		return blastRadius;
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return range;
	}
	
	public char getGraphic()
	{
		return graphic;
	}

	@Override
	public void setRange(int range) {
		// TODO Auto-generated method stub	
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public void setDamage(int damage) {
		// TODO Auto-generated method stub
		
	}

	
}
