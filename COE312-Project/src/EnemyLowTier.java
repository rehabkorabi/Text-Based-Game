import java.util.Random;

public class EnemyLowTier extends Enemy implements Runnable{

	private Thread t;
	private EnemyStrategy strategy;
	int health, baseDamage, damage;
	String description;
	Player player;

	public EnemyLowTier(Player player) {
		this.player = player;
		t = new Thread(this);
	}

	@Override
	void health() {
		// TODO Auto-generated method stub
		this.health = 100;
	}

	@Override
	void baseDamage() {
		// TODO Auto-generated method stub
		this.baseDamage = 2;
	}

	@Override
	void startingStrategy() {
		// TODO Auto-generated method stub
		strategy = new OffensiveStrategyWeak();
	}

	@Override
	String description() {
		// TODO Auto-generated method stub
		return("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⢯⡼⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣲⣄⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡤⠼⡄⠀⠀⠀⠀⠀⠀⠀⠀⡠⠒⠉⠉⠢⡀⠀⠀⠀⠀⠀⢸⠧⠼⡆⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⠀⡤⠚⢓⡦⠤⣤⠔⡦⠖⠻⠁⠀⠸⠆⠀⡷⣤⠤⣀⣀⢴⡛⠒⢤⣹⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢟⠀⣠⠊⠀⡰⣡⠊⠀⢀⡠⠷⠄⣀⣠⠔⠳⡈⠳⡈⢦⠀⠘⢄⢠⠏⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡟⢩⣍⢺⣷⠃⠀⢰⢃⠤⠤⢤⣀⠞⠉⠳⣄⠀⢱⡈⣦⠖⢾⡃⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⠖⠒⠢⢵⣮⣝⣻⠇⠀⢀⡼⠁⠀⠀⢰⣿⣷⡄⠀⠘⡄⠀⣿⣔⣩⢯⠷⠊⠉⠙⢦⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⢠⠤⠬⣑⣾⠀⠀⠘⣿⣄⠀⠀⢈⣿⡟⠀⠀⣠⡇⠀⢸⠗⣛⠡⠄⠐⢧⠀⠈⢆⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢀⡎⠀⠀⠀⣠⠃⠀⠀⠀⢹⠀⠀⠀⠈⠙⠛⠋⠁⠀⠘⢳⣿⠛⠀⠀⢸⠉⠀⠀⠀⠀⢸⡀⠀⠸⡄⠀\r\n"
				+ "⠀⠀⠀⠀⠀⣴⡿⠀⠀⠀⢰⣇⡀⠀⠀⠀⢸⡀⠀⠀⠀⣠⠴⡞⠉⠉⣏⢉⠏⣆⠀⠀⡜⠀⠀⠀⣀⠤⢼⠃⠀⢀⣷⠀\r\n"
				+ "⠀⠀⠀⠀⠐⡇⢀⠀⠀⠀⢈⠀⣹⠀⠀⠀⠀⣇⠀⣠⢾⡄⢰⠛⡄⢸⠹⡜⠀⢸⡄⢀⠇⠀⠀⠀⣇⠀⡄⠀⠀⠘⠛⡄\r\n"
				+ "⢀⣀⣀⣠⣤⣼⣿⣄⡆⠀⣿⡏⠁⠀⠀⠀⠀⡏⠸⣹⡾⠽⠷⠤⠼⠧⠴⠧⢤⠼⠿⣾⠀⠀⠀⠀⢹⡾⠇⠀⠀⠀⢰⠃\r\n"
				+ "⠘⣿⣝⠛⠛⣛⣿⣿⠭⣙⠉⠀⠀⠀⠀⠀⢀⣽⠋⢡⠛⠉⠉⠒⠒⠒⠛⠒⢦⠉⠒⠇⠀⠀⠀⠀⠈⠓⠒⠛⠒⠛⠋⠀\r\n"
				+ "⠀⠈⠙⠥⣀⣠⣞⠟⢀⡼⠃⠀⠀⣠⠔⠊⠁⣸⠆⡆⠀⠀⠀⠈⠙⠒⠠⠀⢀⡇⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⣠⠊⢁⡔⠋⢀⡤⠒⠉⣀⣤⡴⠚⠁⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸⠃⠈⠒⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⢻⡀⠘⠓⠚⣁⡤⠔⣋⡵⠋⠀⣀⠴⠊⠉⠑⠒⠒⠒⠒⠒⠒⠒⠋⠉⠲⢄⡀⠑⠢⢀⣀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠱⠶⠶⠭⠕⠻⡏⠀⠀⠀⣞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠟⠂⠀⠀⢨⠆⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⡗⠀⠀⢺⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠏⠀⠀⠀⢸⠋⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠀⠀⠸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠀⠀⠀⣰⠃⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢀⡤⡤⢤⡤⢼⠃⠀⠀⠀⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⠀⠀⢀⠤⣧⠤⢴⣤⡀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⣧⠃⡏⠀⠀⠁⠀⠀⠀⢈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠉⠀⣀⠁⠀⠈⡆⠀⣹⣷⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠉⠓⠛⠒⠒⠊⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀\n\n");

	}

	public void chooseStrategy() {

		if(health>=80 && health<=100) {strategy = new OffensiveStrategyWeak();}

		else if(health>=40 && health<=80) {strategy = new OffensiveStrategyModerate();}

		else if(health>=0 && health<40) {strategy = new OffensiveStrategyStrong();}	
	}

	public void attack() {
		
		UI.print("\n<------  Enemy Attack  ------->\n\n"
				+"      Enemy deals: " + damage);
		player.health -= damage;
		UI.print("      Player health: " + player.health
				+ "\n\n<----------------------------->");
	}

	public Thread getThread() {return t;}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		
		while(this.health>0) {

			try {
				Thread.sleep((rand.nextInt(2)+3)*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			chooseStrategy();
			damage = strategy.getDamage(baseDamage);
			attack();

		}
		
		UI.print("\nDefeated enemy successfully!\n"
				+ "The enemy dropped a mysterious key...\n"
				+ "Type [collect key] to add the key to your inventory\n");
		player.wonFight = true;
	}

}
