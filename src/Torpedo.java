
public class Torpedo implements Projectile, Explosive{ //correct use of interface?
	
	int range;
	int blastRadius;
	int damage;
	String name;
	Ship target;
	
	public Torpedo (int damage, Ship target, String name)
	{
		range = 6;
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
		// TODO Auto-generated method stub
		
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
