
import java.util.ArrayList;

public class ConcreteObserver implements Observer {

	private ArrayList <Subject> subjects;

	public ConcreteObserver(ArrayList <Subject> subjects) {
		this.subjects = subjects;
		for(int i=0;i<subjects.size();i++) {
			subjects.get(i).registerObserver(this);
		}
	}
	
	// default update function
	public void update(Message m) {}
}

