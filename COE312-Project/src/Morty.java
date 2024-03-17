import java.util.ArrayList;

public class Morty extends Character{

	private static Morty instance;
	ArrayList <String> mortyDialogues;

	private Morty() {
		super("Morty");
		mortyDialogues = new ArrayList <String> ();
		mortyDialogues.add("Ahh jeez... I'm Morty. I can't believe dad's been kidnapped! Please help me find him.");
	}

	// Singleton
	public static synchronized Morty getInstance() {
		if(instance == null) {instance = new Morty();}
		return instance;
	}

	public void talk(int dialogueNo) {
		UI.printSequentially(mortyDialogues.get(dialogueNo));
	}


	public void fightWithSword() { //command 1
		//sensor fight
		UI.print("You are fighting with a sword\n"
				+ "Hint: Swing harder for stronger attacks\n");
	}
	
	public void fightWithPlasmaGun() { //command 1
		//sensor fight
		UI.print("You are fighting with a plasma gun\n"
				+ "Hint: Shoot using your phone to deal damage\n");
	}
	
	
	
}
