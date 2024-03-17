
public class LocationContext {

	private State state;

	public LocationContext() {
		state = new Earth();
	}

	public void next()
	{
		state.next(this);
		//depending on the context "this", the state decides what to do
	}

	public void printStatus() 
	{
		state.printStatus();
	}

	public void setState(State state) 
	{
		this.state = state;
	}

	public String getLocation() 
	{
		return state.getLocation();
	}

}
