
public abstract class Character {

	String name;
	
	public Character(String name) 
	{
		this.name = name;
	}
		
	public abstract void talk(int dialogueNo);
}