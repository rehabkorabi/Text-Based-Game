import java.util.ArrayList;

public class Jerry extends Character
{

	private static Jerry instance;
	ArrayList <String> jerryDialogues;
	
	private Jerry() 
	{
		super("Jerry");
		jerryDialogues = new ArrayList <String> ();

		//0
		jerryDialogues.add("Jerry: I'm finallyyy out! I thought you would never be able to find me.\n");
	}
	
	// Singleton
	public static synchronized Jerry getInstance() 
	{
		if(instance == null) {instance = new Jerry();}
		return instance;
	}

	public void talk(int dialogueNo) 
	{
		UI.printSequentially(jerryDialogues.get(dialogueNo));
	}
	
}