import java.util.ArrayList;

public class PlasmaGun extends Item
{
	boolean isPlasmaGunUsed = false;
	EnemyHighTier enemy;

	public void update(Message m) 
	{
		if(isPlasmaGunUsed) 
		{
			if(m.topic.equals("Plasma Gun") && m.payload.equals("shot")) 
			{
				UI.print("\n<------  Player Attack  ------>\n\n"
						+"      Player deals: " + 20);
				enemy.health -= 25;
				if(enemy.health<=0) {enemy.health = 0; isPlasmaGunUsed = false;}
				UI.print("      Enemy health: " + enemy.health
						+ "\n\n<----------------------------->");
			}
		}
	}
	
	public PlasmaGun(EnemyHighTier enemy, ArrayList <Subject> subjects)
	{
		super("Plasma Gun", subjects);
		this.enemy = enemy;
	}

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub

		UI.print("You have collected the Plasma Gun!\n\n"
				+"               _____\r\n"
				+ "            .':::::::'.\r\n"
				+ "       ___ /:::::::::::\\____ _            _.''_\r\n"
				+ "    /||   ||`.______.-`||   | |\\_\\\\\\\\____/_ _.-'\\\\\\\\\r\n"
				+ ".|-| ||===||           ||===| ||_||||____|_| .-'|||||\r\n"
				+ "'|-| ||===||===========||===| ||_||||____|_|`-._|||||\r\n"
				+ "    \\||___||___________||___|_|/ ////       `-._////\r\n"
				+ "            )  _____  (\r\n"
				+ "           / .'| (  '. \\\r\n"
				+ "          ( (  './    ) )\r\n"
				+ "           \\ '._____.' /\r\n"
				+ "            '._______.' \r\n"
				+ "\r\n");
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		isPlasmaGunUsed = true;
	}

	
}