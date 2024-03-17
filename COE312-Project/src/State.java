
public interface State 
{
	public void next(LocationContext context);
	public void printStatus();
	public String getLocation();
}

