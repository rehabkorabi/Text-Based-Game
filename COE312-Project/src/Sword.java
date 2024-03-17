import java.util.ArrayList;

public class Sword extends Item{

	boolean isSwordUsed = false;
	EnemyLowTier enemy;

	public Sword(EnemyLowTier enemy, ArrayList <Subject> subjects){

		super("Sword", subjects);
		this.enemy = enemy;
	}

	public void update(Message m) {

		if(isSwordUsed) {
			if(m.topic.equals("Sword")) 
			{
				int damage = Integer.parseInt(m.payload)-10;
				UI.print("\n<------  Player Attack  ------>\n\n"
						+"      Player deals: " + damage);
				enemy.health -= damage;
				if(enemy.health<=0) {enemy.health = 0; isSwordUsed = false;}
				UI.print("      Enemy health: " + enemy.health
						+ "\n\n<----------------------------->");
			}
		}
	
	}

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		UI.print("                           _\r\n"
				+ "                          ( ((\r\n"
				+ "                           ) ))\r\n"
				+ "  .::.                    / /(\r\n"
				+ " '  .-;-.-.-.-.-.-.-.-.-/| ((::::::::::::::::::::::::::::::::::::::::::::::.._\r\n"
				+ "(  ( ( ( ( ( ( ( ( ( ( ( |  ))   -====================================-      _.>\r\n"
				+ " `  `-;-`-`-`-`-`-`-`-`-\\| ((::::::::::::::::::::::::::::::::::::::::::::::''\r\n"
				+ "  `::'                    \\ \\(\r\n"
				+ "                           ) ))\r\n"
				+ "                          (_((\n\n");
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		isSwordUsed = true;
	}

}