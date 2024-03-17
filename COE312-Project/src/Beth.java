import java.util.ArrayList;

public class Beth extends Character
{

	private static Beth instance;
	ArrayList <String> bethDialogues;
	
	private Beth() 
	{
		super("Beth");
		bethDialogues = new ArrayList <String> ();

		//0
		bethDialogues.add( "Beth: Jerry's been gone for hours, and we don't even know where he went.\n"
				+ "Summer: And what would you suggest we do, Mom? Go out into the wilderness and start shouting his name?\n"
				+ "Rick: He's lost again?? God, that guy can't do anything right.\n"
				+ "Morty (You): S-so what do we do now?\n"
				+ "Rick: We're going to have to go out and look for him. It's not like anyone else is going to do it.\n"
				+ "Morty (You): Oh, geez, Rick. I'll come with you\n\n"
				+ "You have the option to:\n"
				+ "[walk to garage]\n"
				+ "[walk to living room]\n"
				+ "[walk to bedroom]\n");
	}
	
	// Singleton
	public static synchronized Beth getInstance() 
	{
		if(instance == null) {instance = new Beth();}
		return instance;
	}

	public void talk(int dialogueNo) 
	{
		UI.printSequentially(bethDialogues.get(dialogueNo));
	}
	
}