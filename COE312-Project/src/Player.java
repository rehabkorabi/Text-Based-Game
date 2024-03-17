import java.util.ArrayList;
import java.util.Random;

public class Player extends ConcreteObserver implements Runnable
{

	private static Player instance;
	private Thread t;

	String command;
	
	boolean enteredGame;
	boolean isDoorUnlocked = false;
	boolean wonFight = false;

	LocationContext currentPlanet;
	String subLocation = "living room";

	//Inventory
	Inventory inventory;

	//Characteristics
	int health;
	int xp;
	int damage;

	//Characters
	Rick rick;
	Morty morty;
	Beth beth;
	Summer summer;
	Jerry jerry;

	Gromflomite gromflomite;
	ShrekMonster shrek;

	EnemyLowTier enemyLow;
	EnemyHighTier enemyHigh;

	//Items
	SpaceCruiser spaceCruiser;
	PortalGun portalGun;
	PortalGunFluid portalGunFluid;
	PlasmaGun plasmaGun;
	Sword sword;

	Plumbus plumbus;
	Key key;

	//Magic Box
	MagicBox magicBox;

    //TCP Client (Sensors)
	TCP_Client client;

	//command
	FightWithSwordCommand fightWithSword;
	FightWithPlasmaGunCommand fightWithPlasmaGun;

	Command[] commands;
	ControlPanel controlPanel;

	

	public Player(TCP_Client client, ArrayList<Subject> subjects) 
	{
		super(subjects);

		this.command = null;
		this.enteredGame = false;

		this.currentPlanet = new LocationContext();

		this.inventory = new Inventory();

		this.health = 100;
		this.xp = 0;
		
		this.client = client;

		ArrayList <Subject> itemSubjects = new ArrayList <Subject> ();
		itemSubjects.add(client);

		//characters
		this.rick = Rick.getInstance();
		this.morty = Morty.getInstance();
		this.beth = Beth.getInstance();
		this.summer = Summer.getInstance();
		this.jerry = Jerry.getInstance();

		this.gromflomite = new Gromflomite();

		//enemies
		this.enemyLow = new EnemyLowTier(this);
		this.enemyHigh = new EnemyHighTier(this);
		enemyLow.createEnemy();
		enemyHigh.createEnemy();

		//items
		this.spaceCruiser = SpaceCruiser.getInstance(itemSubjects);
		this.portalGun = PortalGun.getInstance(itemSubjects);
		this.portalGunFluid = new PortalGunFluid(itemSubjects);
		this.plumbus = new Plumbus(itemSubjects);
		this.plasmaGun = new PlasmaGun(enemyHigh, itemSubjects);
		this.sword = new Sword(enemyLow, itemSubjects);
		this.key = Key.getInstance(itemSubjects);
		
		this.shrek = new ShrekMonster(itemSubjects);

		this.magicBox = new MagicBox();
		magicBox.addItem(plasmaGun);
		magicBox.addItem(sword);
		magicBox.addItem(plumbus);
		
		//command
		this.fightWithSword = new FightWithSwordCommand(morty);
		this.fightWithPlasmaGun = new FightWithPlasmaGunCommand(morty);

		this.commands = new Command[2];
		this.commands[0] = (fightWithSword);
		this.commands[1] = (fightWithPlasmaGun);

		this.controlPanel = new ControlPanel(commands);

		t = new Thread (this);
		t.start();
	}

	public static synchronized Player getInstance(TCP_Client client, ArrayList <Subject> subjects)
	{
		if(instance == null) {instance = new Player(client, subjects);}
		return instance;
	}

	public void update(Message m) 
	{
		command = m.payload;

		if(command.equals("wubba lubba dub dub")) 
		{UI.print(Text.terminated);System.exit(0);}

		if(!enteredGame) 
		{
			if(command.equals("")) 
			{
				UI.print(Text.title); 
				UI.printSequentially(Text.intro);
				enteredGame = true;
			}
			else {UI.print("How hard was it to press one button??\nTry again!\n");}
		}


		if(enteredGame) {

			if (!this.subLocation.equals("abandoned alien house")) 
			{
				shrek.deactivateMonster();
			}
			
			//check inventory
			if(command.equals("check inventory")) {inventory.checkInventory();}
		
			//collect key
			if(command.equals("collect key")) 
			{
				if(this.subLocation.equals("underground dungeon"))
				{
					if(wonFight) 
					{
						inventory.addItem(key);
					}
					else
					{
						UI.print("There is no key to collect yet!\n"
								+ "Hint: Defeat the enemy to find the key\n");
					}
				}
				else
				{
					UI.print("Cannot collect any key from here!\n");
				}
			}


			//look around
			if(command.equals("look around")) 
			{
				switch(currentPlanet.getLocation()) {

				case("Earth"):{

					switch(this.subLocation) 
					{

					case("living room"):
					{
						UI.print(Text.livingRoomLookAround); 
						break;
					}

					case("kitchen"):
					{
						UI.print(Text.kitchenLookAround);
						break;
					}

					case("garage"):
					{
						UI.print(Text.garageLookAround);
						break;
					}

					case("bedroom"):
					{
						UI.print(Text.bedroomLookAround);		
						break;
					}

					default:
					{
						break;
					}

					}
				}

				case("Venzenulon"):{

					switch(this.subLocation) 
					{

					case("outside venzenulon"):
					{   
						UI.print(Text.venzenulonLookAround); 
						break;
					}

					case("pawn shop"):
					{
						UI.print(Text.shopLookAround); 
						break;
					}

					case("magic box"):
					{
						UI.print(Text.magicBoxLookAround);
						break;
					}

					case("abandoned alien house"):
					{
						UI.print(Text.abandonedHouseLookAround);
						break;
					}

					default:{break;}

					}

				}

				case("Gromflom Prime"):{

					switch(this.subLocation) 
					{

					case("outside gromflom prime"):
					{
						gromflomite.talk(0);
						break;
					}

					case("underground dungeon"):
					{

						UI.print(Text.undergroundLookAround);
						
						Random rand = new Random();
						if(rand.nextBoolean()) {UI.print(enemyLow.description());}
						else {UI.print(enemyHigh.description);}
						
						UI.print("A monster appears!!!\n"
								+ "You have the option to start a fight with your weapon of choice."
								+ "Type [use <weapon>] to choose your weapon:\n");
						
						inventory.chooseAWeapon();
						
						break;
					}

					case("prison"):
					{
						UI.print(Text.prisonLookAround);
						break;
					}
					default:{break;}
					}
				}
				default:{break;}
				}

			}

			if(command.equals("unlock door")) 
			{
				if(this.subLocation.equals("prison")) 
				{
					if(inventory.checkForItem(key)!=-1) 
					{
						UI.print("Door unlocked...\n");
						jerry.talk(0);
						UI.print(Text.win);
						System.exit(0);
					}
					else
					{
						UI.print("Cannot unlock the door without a key!\n");
					}
				}
				else
				{
					UI.print("There is no door to unlock here!\n");
				}
			}
			
			//collect
			if(command.contains("collect")) 
			{
				switch(command)
				{
				case("collect portal gun"):
				{
					if(this.subLocation.equals("garage")) 
					{
						inventory.addItem(portalGun);
						UI.print("You can now [check inventory].\n"
								+ "Type [board space cruiser] to leave Earth!\n");
					} 
					else {UI.print("Cannot collect the portal gun from the " + this.subLocation);}
					break;
				}
				case("collect plasma gun"): 
				{
					if(this.subLocation.equals("magic box"))
					{
						magicBox.dropItem(plasmaGun);
						inventory.addItem(plasmaGun); 
						UI.print("You can now [check inventory].\n"); 
					}
					else {UI.print("You cannot collect a plasma gun from here!\n");}
					break;
				}
				case("collect sword"):
				{	
					if(this.subLocation.equals("magic box"))
					{
						magicBox.dropItem(sword);
						inventory.addItem(sword);
						UI.print("You can now [check inventory].\n"); 
					}
					else {UI.print("You cannot collect a sword from here!\n");}
					break;

				}
				case("collect plumbus"):
				{
					if(this.subLocation.equals("magic box"))
					{
						magicBox.dropItem(plumbus);
						inventory.addItem(plumbus); 
						UI.print("You can now [check inventory].\n");  
					}
					else {UI.print("You cannot collect a plumbus from here!\n");}
					break;
				}


				}
			}

			//board space cruiser
			if(command.equals("board space cruiser")) {
				if(inventory.checkForItem(portalGun)!=-1) 
				{
					UI.print("You are exiting Earth!\n");
					//spaceCruiser.use();
					currentPlanet.next();
					this.subLocation = "outside venzenulon";
				}
				else
				{
					UI.print("You cannot leave Earth without collecting the portal gun first!\n");
				}
			}

			if(command.contains("walk")) 
			{

				switch(this.currentPlanet.getLocation()) {

				case("Earth"):{

					switch(command) 
					{
					case("walk to living room"):
					{
						this.subLocation = "living room";
						UI.print("You've entered the living room. You have the option to:\n[look around]\n[talk to rick]\n");
						break;
					}

					case("walk to kitchen"):
					{
						this.subLocation ="kitchen";
						UI.print("You've entered the kitchen.\n" + "You have the option to:\n[look around]\n[talk to Beth]\n[talk to Summer]\n");
						break;
					}

					case("walk to garage"):
					{
						this.subLocation="garage";
						UI.print("You've entered the garage.\nYou have the option to:\n[look around]\n[talk to rick]\n");
						break;
					}

					case("walk to bedroom"):
					{
						this.subLocation="bedroom";
						UI.print("You've entered the bedroom.\nYou have the option to [look around]\n");
						break;
					}

					default:
					{
						UI.print("You cannot walk to this location on Earth!\n");
						break;
					}

					}
					break;
				}

				case("Venzenulon"):{

					switch(command) 
					{
					case("walk to pawn shop"):
					{
						this.subLocation="pawn shop";
						UI.print("You've entered the store.\nYou have the option to:\n[look around]\n[talk to pawnshop clerk]\n");
						break;
					}

					case("walk to magic box"):
					{
						this.subLocation="magic box";
						UI.print("The box is adorned with strange, alien symbols and designs, suggesting its origins in a far-off corner of the multiverse.\n\n"
								+ "Type [open magic box] to collect items.\n");
						break;
					}

					case("walk to abandoned alien house"):
					{
						this.subLocation = "abandoned alien house";
						rick.talk(2);
						shrek.activateMonster();
						break;
					}

					default: 
					{
						UI.print("You cannot walk to this location on Venzenulon!\n");
						break;
					}

					}

					break;
				}

				case("Gromflom Prime"):{

					switch(command) 
					{
					case("walk to prison"):
					{
						this.subLocation="prison";
						UI.print("You've entered the prison. Type [look around]\n");	
						break;
					}

					case("walk to underground dungeon"):
					{
						this.subLocation="underground dungeon";
						UI.print("You've entered the underground dungeon. Type [look around].\n"); 		
						break;
					}
					case("walk outside"):
					{
						this.subLocation="outside gromflom prime";
						UI.print("You're outside. You must figure out a way to find Jerry before they feed him to savages!\n\n"
								+ "You have the option to:\n"
								+ "[walk to prison]\n"
								+ "[walk to underground dungeon]\n"); 
						break;
					}

					default:
					{
						UI.print("You cannot walk to this location on Gromflom Prime!\n");
						break;
					}

					}

				}

				break;
				}
			}

			//exit
			if(command.contains("exit")){

				switch(command) {

				case("exit pawn shop"):{ 
					if(command.equals("exit pawn shop")) {
						this.subLocation = "outside";
						UI.print("You have exited the pawn shop.\n You have the option to:\n"
								+ "[talk to alien]\n"
								+ "[walk to magic box]\n"
								+ "[walk to abandoned alien house]\n");}
					else {UI.print("You are already outisde the pawn shop.\n");}
					break;
				}

				}
			}

			//view 
			if(command.equals("view paper"))
			{
				if(subLocation.equals("bedroom")) {
					UI.print(Text.paper);
					UI.print("\nYou have the option to:\n"
							+ "[walk to kitchen]\n"
							+ "[walk to garage]\n"
							+ "[walk to living room]\n");
				}
				else {UI.print("Cannot view any paper from here!\n");}
			}

			//open
			if(command.equals("open magic box")) 
			{
				if(this.subLocation.equals("magic box")) 
				{
					magicBox.checkMagicBox();
				}
				else {UI.print("There is no magic box to open here!\n");}
			}


			// talk
			if(command.contains("talk")) 
			{

				switch(this.currentPlanet.getLocation())
				{

				case("Earth"):
				{
					switch(this.subLocation) 
					{

					case("living room"):
					{
						if(command.equals("talk to rick")) {rick.talk(0); break;}
						else{UI.print("You cannot talk to this person in the living room!\n"); break;}
					}

					case("garage"):
					{
						if(command.equals("talk to rick")) {rick.talk(1); break;}
						else{UI.print("You cannot talk to this person in the garage!\n"); break;}
					}

					case("kitchen"):
					{
						if(command.equals("talk to beth")) {beth.talk(0); break;}
						if(command.equals("talk to summer")) {summer.talk(0); break;}
						else{UI.print("You cannot talk to this person in the kitchen!\n"); break;}
					}

					default:{break;}			

					}
				}

				case("Venzenulon"):
				{
					switch(this.subLocation) 
					{
					case("outside venzenulon"):
					{ 
						if (command.equals("talk to alien")) {
							UI.print("Morty (You): H-hey buddy, we're like kinda desperate here. Uhh-- do you have\n"
									+ "some portal fluid?\n"
									+ "Alien: No.\n"
									+ "Rick: Morty, are you stupid? You think some random, homeless alien would have portal fluid??\n"
									+ "You have the option to:\n"
									+ "[walk to pawn shop]\n"
									+ "[walk to magic box]\n"
									+ "[walk to abandoned alien house]\n");
						}
						else {UI.print("You cannot talk to this person now!\n");}
						break;	
					}
					case("pawn shop"):{
						if(command.equals("talk to pawn shop clerk")) {
							if(inventory.checkForItem(plumbus)==-1) {
								UI.print("Morty (You): Hey, uh, you think maybe I could get something from this place,/n"
										+ " like a souvenir ---like, something cool, you know?\n"
										+ "Rick: Morty, we're not here for games this time. We need to get some portal fluid.\n"
										+ "Pawnshop Clerk: Portal fluid, huh? I can only trade you if you give me the Plumbus.\n"
										+ "Rick: Just give us what we need and we'll be on our way.\n"
										+ "Pawnshop Clerk: No Plumbus, no portal fluid.\n\n"
										+ "You have the option to:\n"
										+ "[exit pawn shop]\n");

							} else {UI.print("Morty (You): Hey, we have the plumbus. Can you give us the portal fluid!\n"
									+ "Pawnshop Clerk: Give me what I want, and you'll get your portal gun fluid!\n"
									+ "Type [trade plumbus] to get the portal gun fluid.\n");}

						}
						else {UI.print("You cannot talk to this person in the pawn shop!\n");}
						break;
					}
					default:
					}
				}

				case("Gromflom Prime"):{}

				}

			}

			if(command.equals("fill portal gun")) 
			{
				if(inventory.checkForItem(portalGunFluid)!=-1) 
				{
					if(!portalGun.filled) 
					{
						UI.print("Portal gun has been filled and is ready to use\n"); 
						portalGun.filled = true;
					}
					else 
					{
						UI.print("Portal gun has already been filled\n"); 
					}
				}
				else
				{
					UI.print("Cannot fill the portal gun before getting the portal gun fluid\n"); 
				}
			}


			//trade plumbus
			if(command.equals("trade plumbus")) 
			{
				if(this.subLocation.equals("pawn shop")) 
				{
					if(inventory.checkForItem(plumbus)!=-1)
					{
						inventory.dropItem(plumbus);
						inventory.addItem(portalGunFluid);
					}
					else
					{
						UI.print("Pawn Shop Clerk: Don't waste my time if you don't have the plumbus!\n");
					}
				}
			}

			if(portalGun.isPortalOpened) 
			{
				portalGun.isPortalOpened = false;
			}

			// use 
			if(command.contains("use"))
			{
				switch(command)
				{
				case("use portal gun"):{
					if(inventory.checkForItem(portalGun)==-1) 
					{
						UI.print("Cannot use portal gun without collecting it first!\n");
					}
					else
					{
						if(portalGun.filled) 
						{
							portalGun.use();
							currentPlanet.next();
							this.subLocation = "outside gromflom prime";
							
						}
						else {UI.print("Cannot use portal gun before filling it!\n");}
					}
					break;
				}

				case ("use sword"):
				{
					if(inventory.checkForItem(sword)!=-1) 
					{
						if(this.subLocation.equals("underground dungeon")) 
						{
							controlPanel.execute(0);
							sword.use();
							enemyLow.getThread().start();
						}
						else {UI.print("Cannot use the sword here!\n");}
					}
					else
					{
						UI.print("Sword is not in your inventory!\n");
					}
					
					break;
				}
					

				case ("use plasma gun"):
				{
					if(inventory.checkForItem(sword)!=-1) 
					{
						if(this.subLocation.equals("underground dungeon")) 
						{
							controlPanel.execute(1);
							plasmaGun.use();
							enemyHigh.getThread().start();
						}
						else {UI.print("Cannot use the plasma gun here!\n");}
					}
					else
					{
						UI.print("Plasma gun is not in your inventory!\n");
					}
					
					break;
				}

				default: {break;}

				}
			}	

			//unlock cell
			if(command.equals("unlock cell")) {

				if(this.subLocation.equals("prison")) 
				{
					if(inventory.checkForItem(key)!=-1) {
						jerry.talk(0);
					}
					else
					{
						UI.print("You do not have the key to unlock the cell!\n");
					}
				}
				else 
				{
					UI.print("You cannot unlock a cell from here!\n");
				}
			}
			
			//Error Handling
			if(
					!command.equals("")&&
					!command.equals("wubba lubba dub dub")&&
					!command.equals("look around")&&
					!command.equals("unlock cell")&&
					!command.equals("trade plumbus")&&
					!command.equals("fill portal gun")&&
					!command.equals("exit pawn shop")&&
					!command.equals("view paper")&&
					!command.equals("board space cruiser")&&
					!command.equals("unlock door")&&
					!command.equals("collect key")&&
					!command.equals("check inventory")&&
					!command.contains("walk")&&
					!command.contains("talk")&&
					!command.contains("collect")&&
					!command.contains("use")) 
			{
				UI.print("Invalid Command Used!\n");
			}
			
		}
	}

	public void attack(int damage) {

		UI.print("\n<------  Player Attack  ------>\n\n"
				+"      Player deals: " + damage);
		enemyLow.health -= damage;
		UI.print("      Enemy health: " + enemyLow.health
				+ "\n\n<----------------------------->");
	}


	public void run() 
	{

		UI.print("\n"
				+ ".▄▄ · ▄▄▄▄▄ ▄▄▄· ▄▄▄  ▄▄▄▄▄\n"
				+ "▐█ ▀. •██  ▐█ ▀█ ▀▄ █·•██  \n"
				+ "▄▀▀▀█▄ ▐█.▪▄█▀▀█ ▐▀▀▄  ▐█.▪\n"
				+ "▐█▄▪▐█ ▐█▌·▐█ ▪▐▌▐█•█▌ ▐█▌·\n"
				+ " ▀▀▀▀  ▀▀▀  ▀  ▀ .▀  ▀ ▀▀▀ \n"
				+ "\nPress the Enter key to begin...\n");



		while(true) {

			if(this.health<=0) {UI.print(Text.died); System.exit(0);}
			
			if(enemyLow.health<=0) 
			{
				wonFight = true;
				sword.isSwordUsed = false;
				plasmaGun.isPlasmaGunUsed = false;
			}

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
