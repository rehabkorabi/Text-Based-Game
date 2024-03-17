import java.util.ArrayList;

public class Rick extends Character
{
	private static Rick instance;
	ArrayList <String> rickDialogues;

	private Rick() {
		super("Rick");
		rickDialogues = new ArrayList <String> ();

		//0
		rickDialogues.add("Rick: I'm *buurrrrrpp* Rick. I can't believe that dimwit Jerry got himself kidnapped.\n"
				+ "I guess we have to go and find him before my daughter belch Beth has an emotional breakdown.\n"
				+ "Rick: Morty, go to the kitchen get me another beer.\nI don't really care about this anymore.\n"
				+ "Morty (You): Can't you get it yourself, Rick?\n\n"
				+ "You have the option to:\n"
				+ "Ignore rick and [walk to kitchen]\n"
				+ "[walk to bedroom]\n");

		//1
		rickDialogues.add("Rick: Alright Morty, time to gear up. We've got a big adventure ahead of us.\n"
				+ "We're heading to the Venzenulon Planet to get some portal fluid.\n"
				+ "We're taking the spaceship, Morty. Get the portal gun with you!\n"
				+ "Type [collect portal gun] to collect it.\n"
				+ "or [board space cruiser] to leave Earth!\n\n");

		//2
		rickDialogues.add("Rick: Listen to me very carefully Morty, we don't know what is around this abandoned house.\n"
				+ "By the looks of it this house has been destroyed by savage creatures which might still be here.\n"
				+ "You MUST remain quiet around this area!\n\n");

	}

	// Singleton
	public static synchronized Rick getInstance() {
		if(instance == null) {instance = new Rick();}
		return instance;
	}

	public void talk(int dialogueNo) {
		UI.printSequentially(rickDialogues.get(dialogueNo));
	}

}