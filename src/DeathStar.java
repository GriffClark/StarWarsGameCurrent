
public class DeathStar extends Ship{ //to lazy to make this right now. Also should it extend Ship?

	boolean reactorHit;
	
	//need a way to tell if the death star has been targeted yet
	int deathRayCharge;
	
	public DeathStar()
	{
		health = 99999999;
		attack = 10 + ((int)(Math.random() * 200));
		speed = 0;
		name = "Death Star";
		range = 1;
		graphic = '@'; //idk why just feels right
		reactorHit = false;
	}
	
	public void chargeDeathRay()
	{
		deathRayCharge++;
		if(deathRayCharge >= 6)
		{
			System.out.println("ready to fire");
		}
	}
	
	public void fireDeathRay(Ship ship)
	{
		if (deathRayCharge >= 6)
		{
			ship.setHealth(0); //kablooey!
		}
		else
		{
			System.out.println("not enough charge");
		}
	}
	
	public int getDeathRayCharge()
	{
		return deathRayCharge;
	}
	
	public void hitReactor()
	{
		reactorHit = true;
	}
	
	public Ship generateTIEFighter()
	{
		TIEFighter elmo = new TIEFighter();
		return elmo;
	}
	/**
	 * also need to make an ability here where if the deathRay has enough charge it can be used to blow up the planet
	 */

}
