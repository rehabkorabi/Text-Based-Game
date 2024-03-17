
public class FightWithPlasmaGunCommand implements Command{
	Morty morty;
	
	public FightWithPlasmaGunCommand(Morty morty) {
		this.morty=morty;
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		morty.fightWithPlasmaGun();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		//System.out.println("You dont have a weapon to fight!");
	}

}
