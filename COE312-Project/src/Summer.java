import java.util.ArrayList;

public class Summer extends Character
{

	private static Summer instance;
	ArrayList <String> summerDialogues;
	
	private Summer() 
	{
		super("Summer");
		summerDialogues = new ArrayList <String> ();
		//add all summer dialogues to the arraylist
		summerDialogues.add("Summer: I don't understand why you're so worried about Dad. Who cares, he'll find his way back.\n"
				+ "Morty: You know Dad. He can barely find his way to the bathroom.\n"
				+ "Rick: Morty, you know how I feel about Jerry. He's a bit of a bumbling idiot.\n"
				+ "But if it makes you feel better, we'll look for him. Happy?\n\n"
				+ "You have the option to:\n"
				+ "[walk to garage]\n"
				+ "[walk to living room]\n"
				+ "[walk to bedroom]\n");
	}
	
	// Singleton
	public static synchronized Summer getInstance() 
	{
		if(instance == null) {instance = new Summer();}
		return instance;
	}

	public void talk(int dialogueNo) 
	{
		UI.print(summerDialogues.get(dialogueNo));
	}

}