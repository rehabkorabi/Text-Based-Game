import java.util.ArrayList;

public class Key extends Item
{
	private static Key instance;

	private Key(ArrayList <Subject> subjects)
	{
		super("Key", subjects);
	}
	
	// Singleton
	public static Key getInstance(ArrayList <Subject> subjects) 
	{
		if(instance == null) {instance = new Key(subjects);}
			return instance;
	}
			
	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		
		UI.print(
				"\n                                                                  ▒▒▒▒▓▓▒▒▒▒░░              \r\n"
				+ "                                                                ▒▒██      ░░██▒▒▒▒          \r\n"
				+ "                                                              ░░██            ██▒▒          \r\n"
				+ "                                                              ▓▓▓▓              ▓▓▒▒        \r\n"
				+ "            ▒▒▓▓▓▓▒▒▓▓▓▓░░▓▓▓▓▓▓░░▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓            ▓▓▓▓        \r\n"
				+ "            ████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓████▓▓██▓▓▓▓▓▓████▓▓▓▓▓▓▓▓            ▓▓▓▓        \r\n"
				+ "                ▓▓▓▓▓▓▓▓▓▓                                ░░▒▒████              ▒▒▓▓        \r\n"
				+ "              ▒▒▓▓▓▓▓▓▓▓▓▓▓▓                                  ▓▓▓▓            ▒▒▒▒░░        \r\n"
				+ "                ▒▒▒▒▓▓▓▓▓▓▒▒                                    ▓▓            ▒▒██          \r\n"
				+ "              ▒▒▓▓░░▓▓░░▓▓▓▓                                    ▓▓▒▒░░    ▒▒▒▒██░░          \r\n"
				+ "              ░░▒▒  ░░  ▒▒▒▒                                      ██▓▓░░░░▓▓▓▓              \r\n"
				+ "                                                                                            \r\n"
				+ "                                                                                            \r\n"
				);
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
	}

}