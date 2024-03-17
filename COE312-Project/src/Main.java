
import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
	 {
				
		ArrayList <Subject> playerSubjects = new ArrayList<Subject>();
		
		//UI for synchronizing printing and controlling reading
		UI ui = new UI();
		playerSubjects.add(ui);
		
		//TCP_Client
		TCP_Client phone = new TCP_Client("10.24.148.219", 54824);

		new Player(phone, playerSubjects);
		
	}

}
