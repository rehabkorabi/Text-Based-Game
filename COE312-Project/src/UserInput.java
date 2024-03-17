
import java.util.Scanner; 

public class UserInput {

	String command; 
	Scanner in; 

	public UserInput() { 
		this.command=""; 
		this.in = new Scanner(System.in); 
	} 

	public String read() 
	{ 
		System.out.print(">> ");
		command = in.nextLine(); 
		command = command.toLowerCase(); 
		System.out.print("\n");
		return command; 
	} 

}