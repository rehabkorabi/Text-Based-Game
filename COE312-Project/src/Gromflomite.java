import java.util.ArrayList;

public class Gromflomite extends Character{

	private static Gromflomite instance;
	ArrayList <String> GromDialogues;

	public Gromflomite() {
		super("Gromflomite");
		GromDialogues = new ArrayList <String> ();
		GromDialogues.add("Gromflomite 1: Halt! Look who's here! We've been waiting for you Rick Sanchez.\n"
				+ "Rick: yeah, I'm Rick Sanchez, now I'm here to find that idiot son-in-law of mine and get this over with.\n"
				+ "Gromflomite 2: Not so fast, Rick Sanchez. You can't save Jerry without a key! Soldiers! Arrest them.\n\n"
				+ "Quickly you must figure out a way to save Jerry!\n"
				+ "You have the option to:\n"
				+ "[walk to prison]\n"
				+ "[walk to underground dungeon]\n");
	}

	// Singleton
	public static synchronized Gromflomite getInstance() {
		if(instance == null) {instance = new Gromflomite();}
		return instance;
	}

	public void talk(int dialogueNo) {
		UI.printSequentially(GromDialogues.get(dialogueNo));
	}
	
}