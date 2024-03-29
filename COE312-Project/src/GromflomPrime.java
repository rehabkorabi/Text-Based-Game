import java.util.ArrayList;

public class GromflomPrime extends Location implements State{

	ArrayList <Character> characters;
	
	public GromflomPrime() {
		super("Gromflom Prime");
		
		this.characters = new ArrayList <Character> ();
	}
	
	@Override
	public void next(LocationContext context) {
		// TODO Auto-generated method stub
		context.setState(new Earth());
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return "Gromflom Prime";
	}
	
	public String toString(){
		return "\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
				+ "██████████████████████████████████████████████▓▓                        ██▓▓██████████████████████████████████████████████████████████████\r\n"
				+ "██████████████████████████████████████████░░░░░░                        ░░░░▒▒████████████████████████████████████████████████████████████\r\n"
				+ "██████████████████████████████████████████                                  ░░  ▒▒████████████████████████████████████████████████████████\r\n"
				+ "██████████████████████████████████████████                                        ██▓▓████████████████████████████████████████████████████\r\n"
				+ "████████████████████████████████      ████                                          ██████████████████████████████████████████████████████\r\n"
				+ "██████████████████████████████        ████                                          ▒▒████████████████████████████████████████████████████\r\n"
				+ "████████████████████████████      ████▒▒▒▒▒▒▒▒▒▒▓▓      ░░░░░░░░░░░░░░░░░░          ▒▒▒▒▒▒▒▒██████████    ▒▒██████████████████████████████\r\n"
				+ "████████████████████████████  ████▒▒▒▒▓▓▓▓▒▒▒▒▒▒▓▓▓▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓████    ▒▒██████████████████████████████\r\n"
				+ "████████████████████████████████▒▒▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████████\r\n"
				+ "████████████████████████████▒▒▒▒▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░▓▓▓▓▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████\r\n"
				+ "██████████████████████▓▓██▒▒▒▒▒▒░░░░░░        ░░▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒░░░░  ▒▒░░░░████████████████████████████\r\n"
				+ "████████████████████████▒▒▒▒▒▒░░                  ▒▒▒▒▒▒▒▒▒▒▒▒          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒████████████████████████████\r\n"
				+ "██████████████████████      ░░░░                  ▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ░░▒▒▒▒        ██████████████████████████\r\n"
				+ "██████████████████        ░░░░░░                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                      ░░████████████████████████\r\n"
				+ "████████████████░░      ░░░░▒▒▒▒                  ░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░              ░░░░░░░░░░░░▒▒██████████████████████\r\n"
				+ "██████████████          ▒▒▒▒▒▒▒▒                                                            ▒▒░░░░░░░░░░░░░░░░░░░░░░██████████████████████\r\n"
				+ "██████████████          ▒▒▒▒▒▒░░                                                        ░░  ░░░░░░░░░░░░░░░░░░░░░░░░░░████████████████████\r\n"
				+ "██████████████            ▒▒▒▒░░▒▒▒▒                                                      ▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░      ▒▒████████████\r\n"
				+ "██████████████            ▒▒▒▒░░░░▒▒    ░░                                                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░      ▒▒██████▓▓████\r\n"
				+ "██████████████░░▒▒        ▒▒▒▒░░░░▒▒▓▓                                                    ░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░        ░░██████████\r\n"
				+ "████████████░░░░▒▒        ▒▒▒▒▒▒░░▒▒▒▒▓▓▓▓                                              ▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒            ██▓▓████\r\n"
				+ "████████████░░░░░░        ▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓                              ▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒            ████████\r\n"
				+ "████████████░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒            ██████\r\n"
				+ "██████      ░░░░░░░░░░▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒              ██████\r\n"
				+ "████        ▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒              ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒                  ██████\r\n"
				+ "████        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒                                  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒                  ██████\r\n"
				+ "████        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░                                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒                    ██████\r\n"
				+ "████        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░                                      ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                  ████████\r\n"
				+ "████      ░░  ▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░                                      ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                  ████████\r\n"
				+ "████▓▓        ▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░                                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░  ░░            ░░▒▒▓▓████████\r\n"
				+ "██████        ▒▒▒▒▓▓  ▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                        ▒▒▒▒░░░░░░░░░░░░▒▒▒▒▓▓░░              ▒▒▒▒▒▒████  ▒▒▓▓\r\n"
				+ "████████▒▒░░░░░░░░▒▒      ▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                ▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▓▓▓▓░░              ▒▒▒▒▒▒████  ▒▒▓▓\r\n"
				+ "████████▒▒░░░░░░░░░░      ▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░▒▒▒▒▓▓                ▒▒▒▒▒▒▒▒████  ▒▒▓▓\r\n"
				+ "████████▒▒▒▒▒▒░░░░░░▒▒    ▓▓▒▒▓▓▒▒▒▒▓▓▓▓▒▒    ░░▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▓▓            ░░░░░░░░▒▒▒▒██████████\r\n"
				+ "████████▒▒▒▒▒▒▒▒░░░░▒▒    ▓▓▓▓        ▓▓▓▓                  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒          ▒▒░░░░░░▒▒▒▒▒▒████████▓▓\r\n"
				+ "██░░████▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒        ░░▓▓▒▒▒▒░░          ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░    ▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒██████████\r\n"
				+ "██    ██▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒                ░░▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▓▓                  ▒▒▒▒▒▒░░▒▒▒▒░░    ▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒██████████\r\n"
				+ "██▓▓  ██▓▓▒▒▒▒▒▒░░░░░░░░░░▒▒                  ░░░░░░░░░░░░░░░░▓▓▓▓                  ░░▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░▒▒▓▓██████████\r\n"
				+ "██████████▒▒░░░░░░░░░░░░▒▒▒▒                                                          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒░░░░░░▒▒████████████\r\n"
				+ "██████████▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒                                                        ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒░░░░░░▓▓████████████\r\n"
				+ "████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                                          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒      ▒▒████████████\r\n"
				+ "████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                                          ▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▓▓▒▒▒▒▒▒            ▒▒████████████\r\n"
				+ "████████████▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                              ▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▒▒▒▒                ░░██████████\r\n"
				+ "████████████▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░                                      ░░▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▒▒░░                ░░██████████\r\n"
				+ "██████████████▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░                                      ▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░                  ░░██████████\r\n"
				+ "██████████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                ▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░                  ░░██████████\r\n"
				+ "██████████████▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                      ░░▒▒▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▒▒░░░░░░                      ░░██████████\r\n"
				+ "██████████████████▓▓          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒              ▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▓▓▒▒                              ▒▒████████████\r\n"
				+ "██████████████████▓▓          ░░░░▓▓▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒                              ▓▓▓▓████████████\r\n"
				+ "████████████████████                        ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                ████████████████\r\n"
				+ "████████████████████▓▓                      ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░                              ▓▓████████████████\r\n"
				+ "████████████████████████                    ░░▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░                      ██████████████████████████\r\n"
				+ "██████████████████████████▓▓              ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░                ▒▒██████████████████████████████\r\n"
				+ "████████████████████████████▓▓▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░▒▒▒▒▒▒▒▒░░░░░░██▓▓██████████████████████████████\r\n"
				+ "████████████████████████████▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓██████████████████████████████████\r\n"
				+ "██████████████████████████████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓    ██████████████████████████████████\r\n"
				+ "██████████████████████████████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒  ░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░    ██████████████████████████████████\r\n"
				+ "████████████████████████████████████████████▓▓▓▓▓▓▓▓▒▒                          ▓▓▓▓▓▓████████░░  ░░██████████████████████████████████████\r\n"
				+ "████████████████████████████████████████████████████▓▓                      ░░  ██████████████████████████████████████████████████████████\r\n"
				+ "████████████████████████████████████████████████████████                        ██████████████████████████████████████████████████████████\r\n\n"
				+ "";
	}


	
	
}
