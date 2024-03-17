import java.util.ArrayList;

public class PortalGun extends Item implements Runnable{

	private Thread t;
	private static PortalGun instance;	

	boolean filled = false;
	boolean isPortalGunUsed = false;
	boolean isPortalOpened = false; 

	public PortalGun(ArrayList <Subject> subjects)
	{ 
		super("Portal Gun", subjects);
		t = new Thread(this);
	}

	public void update(Message m) {

		if(isPortalGunUsed) {
			if(m.topic.equals("Portal Gun")) 
			{
				if(m.payload.equals("open portal")) {

					isPortalOpened = true;	
				}	
			}
		}
	}

	// Singleton
	public static synchronized PortalGun getInstance(ArrayList <Subject> subjects) 
	{
		if(instance == null) {instance = new PortalGun(subjects);}
		return instance;
	}

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		UI.print("               _____\r\n"
				+ "            .':::::::'.\r\n"
				+ "       ___ /:::::::::::\\____ _            _.''_\r\n"
				+ "    /||   ||`.______.-`||   | |\\_\\\\\\\\____/_ _.-'\\\\\\\\\r\n"
				+ ".|-| ||===||           ||===| ||_||||____|_| .-'|||||\r\n"
				+ "'|-| ||===||===========||===| ||_||||____|_|`-._|||||\r\n"
				+ "    \\||___||___________||___|_|/ ////       `-._////\r\n"
				+ "     )      )  _____  (\r\n"
				+ "    /`--.._/ .'| (  '. \\\r\n"
				+ "    )     ( (  './    ) )\r\n"
				+ "   /`--.___\\ '._____.' /\r\n"
				+ "   )       /'._______.' \r\n"
				+ "  /`--..__/\r\n"
				+ "  )       )\r\n"
				+ " /`--..__/\r\n"
				+ "(        )\r\n"
				+ " `------'\r\n"
				+ "\r\n"
				);
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		isPortalGunUsed = true;
		t.start();
	}

	public void run() {

		boolean teleported = false;
		isPortalOpened = false;

		while(!teleported) 
		{

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(isPortalOpened) 
			{
				UI.print("\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠈⠉⠉⠛⠛⠷⢶⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣴⣶⣶⣿⣿⣿⣿⣷⣶⣦⣤⣄⡀⠈⠙⠻⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣾⣿⣿⠿⠿⠛⠛⠛⠛⠻⠿⠿⣿⣿⣿⣿⣿⣷⣤⡀⠀⠙⢿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⢀⣴⣾⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠻⣿⣿⣿⣿⣷⡄⠀⠙⢿⣷⡀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⢀⣴⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⣿⣿⣿⣦⠀⠈⢿⣿⡄⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⣠⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠒⠒⠤⣄⣀⠀⠀⠀⠻⣿⣿⣿⣷⡀⠀⢿⣿⡀⠀⠀⠀⠀\r\n"
						+ "⠀⣰⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⣶⣶⣶⣶⣶⣦⣤⡀⠉⠳⣦⡀⠀⠘⣿⣿⣿⣧⠀⠈⣿⣇⠀⠀⠀⠀\r\n"
						+ "⢰⠏⠀⠀⠀⠀⠀⠀⢀⠔⠀⣠⣴⣿⣿⡿⠛⠋⠉⠉⠉⠉⠙⠻⣿⣷⡀⠈⢷⡀⠀⠸⣿⣿⣿⡄⠀⢹⣿⠀⠀⠀⠀\r\n"
						+ "⠏⠀⠀⠀⠀⠀⢀⡴⠃⢀⣼⣿⣿⠟⠁⠀⠀⡀⠀⢀⣠⣤⡤⣤⡈⢻⣿⡀⠘⣇⠀⠀⣿⣿⣿⡇⠀⢸⣿⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⢠⡞⠀⢠⣿⣿⡿⠁⠀⢀⡴⠊⣠⡾⠋⠉⠀⠀⠀⡟⢈⣿⡇⢠⡟⠀⠀⣿⣿⣿⠃⠀⣸⡏⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⢠⡟⠀⢀⣿⣿⡿⠀⠀⢠⡏⢠⣾⠏⢀⡠⢲⡖⢀⡜⠁⣼⡿⠀⣼⠃⠀⢰⣿⣿⡿⠀⢀⡿⠁⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⣿⠃⠀⣼⣿⣿⡇⠀⢠⡿⠀⣾⡏⢀⡎⠀⠈⠉⠁⢀⣼⠟⢁⡼⠁⠀⢀⣾⣿⡿⠁⠀⡾⠁⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⢸⣿⠀⠀⣿⣿⣿⡇⠀⢸⡇⠀⣿⣧⠸⣧⣤⣤⣴⠾⠛⠁⠐⠁⠀⠀⣠⣾⣿⡟⠁⢀⡞⠁⠀⠀⠀⠀⠀⡄\r\n"
						+ "⠀⠀⠀⢸⣿⠀⠀⣿⣿⣿⡇⠀⠈⣷⡀⠹⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⣿⡿⠋⢀⡴⠋⠀⠀⠀⠀⠀⠀⣰⠃\r\n"
						+ "⠀⠀⠀⢸⣿⡄⠀⢹⣿⣿⣿⡀⠀⠘⢷⡄⠈⠻⢿⣿⣶⣶⣶⣶⣾⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀\r\n"
						+ "⠀⠀⠀⠈⣿⣧⠀⠈⢿⣿⣿⣷⡄⠀⠀⠙⠳⠤⣀⣈⠉⠉⠙⠋⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠃⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠘⣿⣧⠀⠈⢿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⡟⠁⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠙⣿⣧⡀⠀⠻⣿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⡿⠋⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠈⠻⣿⣆⠀⠈⠻⢿⣿⣿⣿⣿⣶⣤⣄⣀⡀⠀⠀⠀⠀⢀⣀⣀⣤⣶⣾⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣷⣦⣀⠀⠉⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠷⣦⣤⣀⠀⠈⠉⠉⠙⠛⠛⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠛⠒⠒⠒⠒⠒⠒⠒⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\n"
						+ "|-------------ENTERING THE PORTAL-------------|\n"
						+ "\nYou have teleported to Gromflom prime...\n"
						+ "Type [look around] to see whats around you\n");
				teleported = true;

			}
		}

	}
}