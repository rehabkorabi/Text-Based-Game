
public abstract class Enemy 
{

	int health;
	
	final void createEnemy() {
		health();
		baseDamage();
		startingStrategy();
		description();
	}
	
	abstract void health();
	abstract void baseDamage();
	abstract void startingStrategy();
	abstract String description();
	
}
