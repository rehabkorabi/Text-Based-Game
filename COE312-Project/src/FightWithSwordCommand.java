
public class FightWithSwordCommand implements Command{
	Morty morty;
	
	public FightWithSwordCommand(Morty morty) {
		this.morty=morty;
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		morty.fightWithSword();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		//System.out.println("You dont have a weapon to fight!");
	}

}
