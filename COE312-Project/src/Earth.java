import java.util.ArrayList;

public class Earth extends Location implements State{
	
	ArrayList <Character> characters;

	public Earth() {
		super("Earth");
		
		this.characters = new ArrayList <Character>();
		characters.add(Beth.getInstance());
		characters.add(Summer.getInstance());
	}
	
	public String toString() {
		return "";
	}

	@Override
	public void next(LocationContext context) {
		// TODO Auto-generated method stub
		context.setState(new Venzenulon());
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
	}

	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return "Earth";
	}

}
