
public interface ForceField {

	public void raiseShields(int energy);
	public void dropShields(); //you will get back some of the energy you put into making your shield
	public int shieldedDamage(boolean shieldsUp, int incomingDamage);
	public String[] move();

	/**
	 * do I want to put all things force field related into the ship class and just ignore them in the other classes?
	 * Yes this should probably be it's own class that other ships extend. Would be much easier and should be taken care of soon
	 * Move things over from ship class and TantiveIV there are fragments of ForceFieldShip in each class
	 */
}
