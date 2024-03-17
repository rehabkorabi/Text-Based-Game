import java.util.ArrayList;
import java.util.Random;

public class SpaceCruiser extends Item implements Runnable
{

	private static SpaceCruiser instance;
	private Thread t;

	boolean turnedLeft = false;
	boolean turnedRight = false;

	private SpaceCruiser(ArrayList <Subject> subjects) {

		super("Space Cruiser", subjects);
		t = new Thread (this);

	}

	// Singleton
	public static synchronized SpaceCruiser getInstance(ArrayList <Subject> subjects) {
		if(instance == null) {instance = new SpaceCruiser(subjects);}
		return instance;
	}

	public void update(Message m) {
		
		if(m.topic.equals("Space Cruiser")) 
		{
		
			if(m.payload.equals("turned right")) {turnedRight = true;}
			
			else if (m.payload.equals("turned left")) {turnedLeft = true;}
			
		}
		
	}
	
	@Override
	public void use() {
		// TODO Auto-generated method stub
		t.start();
	}

	public void printDescription() {
		// TODO Auto-generated method stub
		UI.print( 
				"\n\n\n\n\n\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⢋⣉⣩⣤⣤⣭⣉⣉⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢁⣴⣾⣿⣿⣿⣿⡉⠦⠍⣿⣿⣶⣤⡉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠔⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⢛⣉⡉⢠⠀⣰⣶⣦⢸⣿⣿⣿⡿⠿⠿⢿⣿⣿⡿⢩⣴⣬⠁⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⠿⢛⣩⣤⣶⣾⣿⣿⡿⢠⣿⠰⣿⡿⢋⣼⣿⣿⢋⣴⣿⣿⡆⣿⣿⣷⠸⣿⣿⡇⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⡿⠋⣡⣶⡿⠋⠉⠭⠙⢿⣿⣷⡈⢿⣷⣶⣾⣿⣿⣿⣿⡘⠿⣿⠿⢃⣿⣿⣿⣷⣌⡛⠁⣰⡆⣦⣌⡙⠻⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⠋⠐⣾⣿⡟⢀⣴⣿⣿⡦⢸⣿⣿⣷⣄⡙⠿⣿⣿⣿⣿⣿⣷⣤⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⠇⣸⣿⣿⣷⣤⡉⠻⣿⣿⣿⣿\r\n"
						+ "⡏⢰⡀⢻⣿⣿⣌⡛⠛⣛⣵⣿⣿⣿⣿⡿⠿⢷⣦⣬⣙⡛⠛⠿⠿⠿⠿⠿⠿⠿⠿⠿⠟⠛⣉⣠⣾⣿⣿⠛⢛⠻⢿⣶⣄⠻⣿⣿\r\n"
						+ "⣷⡈⢿⣆⠙⢿⣿⣿⣿⣿⣿⣿⣿⠟⡥⢂⣛⣓⡈⢿⣿⣿⣿⣿⣿⣶⣶⣶⣶⣶⣶⣾⣿⣿⣿⣿⣿⣿⣇⢲⣶⣦⣄⠙⢿⣦⡈⣿\r\n"
						+ "⣿⣷⣄⠙⢷⣄⠙⢿⣿⣿⣿⣿⣿⠈⣴⣿⣿⣿⡟⣸⣿⣿⣿⣿⣿⣿⣿⡟⠡⢒⠲⣌⠻⣿⣿⣿⣿⣿⣿⣦⣙⠿⣿⡧⢸⣿⠇⢸\r\n"
						+ "⣿⣿⣿⣷⣄⠙⠿⣦⣈⠛⠿⣿⣿⡜⠿⣿⡿⢟⣱⣿⣿⣿⣿⣿⣿⣿⣿⢰⣾⣿⣿⣦⠃⢻⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⠟⣡⡆⢸\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣦⣈⠛⠿⣦⣄⡉⠛⠷⢶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡌⢿⣿⣿⣿⢃⣾⣿⣿⣿⣿⣿⣿⡿⠟⢋⣠⡾⠋⣠⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣌⣙⠛⠿⣶⣤⣄⣉⣙⠛⠻⠿⠿⠿⣿⣿⣿⣿⣦⣭⣭⣵⣿⠿⠿⠿⠛⢛⣉⣡⣴⠾⠛⣉⣴⣾⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠈⣉⡛⠛⠿⠿⢷⣶⣶⣶⣦⣤⣤⣤⣤⣤⣴⣶⣶⣶⡾⠿⠛⢋⣉⣤⣶⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡘⠿⣿⣷⣶⣶⣤⣤⣤⣬⣉⣉⣉⣉⡉⢉⣤⣤⣴⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣌⠙⠻⢿⣿⣿⣿⣿⣿⠿⠛⢉⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠂⣶⡦⢠⣤⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡧⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n\n"
						+ "|------------------DRIVING SPACE CRUISER------------------|");
	}

	public void run(){

		this.printDescription();

		UI.print("\n\n\n"
				+ "	                            ▒▒████                              \r\n"
				+ "	                            ████████                            \r\n"
				+ "	                          ██████████                            \r\n"
				+ "	                          ████▒▒██████                          \r\n"
				+ "	                        ██████    ████▒▒                        \r\n"
				+ "	                        ████      ▒▒████                        \r\n"
				+ "	                      ██████        ██████                      \r\n"
				+ "	                    ▒▒████    ████    ████                      \r\n"
				+ "	                    ████▒▒  ████████  ██████                    \r\n"
				+ "	                  ██████    ████████    ████                    \r\n"
				+ "	                  ████░░    ████████    ██████                  \r\n"
				+ "	                ██████      ████████      ████▒▒                \r\n"
				+ "	              ░░████        ████████      ▒▒████                \r\n"
				+ "	              ██████        ████████        ██████              \r\n"
				+ "	            ▒▒████          ████████          ████              \r\n"
				+ "	            ████▒▒          ██████▒▒          ██████            \r\n"
				+ "	          ██████              ████              ████            \r\n"
				+ "	          ████                ████              ██████          \r\n"
				+ "	        ██████                ████                ████▒▒        \r\n"
				+ "	      ░░████                                      ▒▒████        \r\n"
				+ "	      ████▓▓                                        ██████      \r\n"
				+ "	    ▒▒████                    ████                    ████      \r\n"
				+ "	    ████▒▒                  ████████                  ██████    \r\n"
				+ "	  ██████                      ▒▒▒▒                      ████░░  \r\n"
				+ "	  ████                                                  ▒▒████  \r\n"
				+ "	██████  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░  ░░░░░░░░░░░░░░░░▒▒██████\r\n"
				+ "	████████████████████████████████████████████████████████████████\r\n"
				+ "	▓▓████████████████████████████████████████████████████████████▓▓\r\n"
				+ "\n"
				+ "	                   METEORS AHEAD WATCH OUT!					\n"
				+ "	        -TURN YOUR PHONE LEFT AND RIGHT TO DODGE-				\n\n");
		
		Random r = new Random();

		int i = 1;
		while(i<=6){

			turnedLeft = false;
			turnedRight = false;

			i++;
			int randomMeteorTime = r.nextInt(4)+3; 

			try {
				Thread.sleep(randomMeteorTime*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean direction = r.nextBoolean();

			// Left
			if(direction){
				
				UI.print("\n\n\n\n\n"
						+" 										      	 	 	         , - ~ ~ ~ - ,\r\n"
								+ "										      	 	 	     , '               ' ,\r\n"
								+ "										      	 	 	   ,                       ,\r\n"
								+ "										      	 	 	  ,                         ,\r\n"
								+ "										      	 	 	 ,                           ,\r\n"
								+ "										      	 	 	 ,                           ,\r\n"
								+ "										      	 	 	 ,                           ,\r\n"
								+ "										      	 	 	  ,                         ,\r\n"
								+ "										      	 	 	   ,                       ,\r\n"
								+ "										      	 	 	     ,                  , '\r\n"
								+ "										      	 	 	       ' - , _ _ _ ,  '\n\n"
								+ "										      	 	 	          TURN LEFT!!!\n\n");

				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(!turnedLeft){UI.print("\nDID NOT TURN LEFT IN TIME\nYOU CRASHED\n" + Text.gameOver);System.exit(0);}
				else{	
					UI.print(
							"         /\\\r\n"
						  + "        (  )\r\n"
						  + "        (  )\r\n"
						  + "       /|/\\|\\\r\n"
						  + "      /_||||_\\");
	
					for(int j=0; j<=3;j++) {
						UI.print("        ||||");
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for(int j=0; j<=2;j++) {
						UI.print("         ||");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(i<=6) {UI.print("\n Watch out for the rest!");}
					}
		
			}

			// Right
			else if(!direction){
				
				UI.print("\n\n\n\n\n"
						          +"             , - ~ ~ ~ - ,\r\n"
								+ "          , '               ' ,\r\n"
								+ "        ,                       ,\r\n"
								+ "       ,                         ,\r\n"
								+ "      ,                           ,\r\n"
								+ "      ,                           ,\r\n"
								+ "      ,                           ,\r\n"
								+ "       ,                         ,\r\n"
								+ "        ,                       ,\r\n"
								+ "          ,                  , '\r\n"
								+ "            ' - , _ _ _ ,  '\n\n"
								+ "              TURN RIGHT!!!\n\n");

				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(!turnedRight){UI.print("\nDID NOT TURN RIGHT IN TIME\nYOU CRASHED\n" + Text.gameOver);System.exit(0);}
				else{
					UI.print(
							"										      	 	 	   /\\\r\n"
						  + "										     			  (  )\r\n"
						  + "     										 			  (  )\r\n"
						  + "    									 	  	   		 /|/\\|\\\r\n"
						  + "   									  	  	  		/_||||_\\");
					
					for(int j=0; j<=3;j++) {
						UI.print("   									  	  	  		  ||||");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for(int j=0; j<=2;j++) {
						UI.print("   									  	  	  		   ||");
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(i<=6) {UI.print("\n   									  		      Watch out for the rest!");}
					}


			}

		}
		
		UI.print("\n\nYou have successfully reached Venzenulon...\n"
				+ "Type [look around] to figure out your surroundings\n");
	}

}
